package AutomationExercise_Project_TestNG.tests.Api_Tests;

import AutomationExercise_Project_TestNG.base_Url.Aut_Ex_BaseUrl;
import AutomationExercise_Project_TestNG.testDataDeposu.AutExercise_testData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class TC04_PUT_To_All_Brands_List extends Aut_Ex_BaseUrl {


    @Test
    public void put_To_All_Brands_List_TC04() {


        // 1- Set the url and request body
        // 2- Set the expected Data
        // 3- Get the response after sending request
        // 4- Do Assertion

        //API URL: https://automationexercise.com/api/brandsList
        //Request Method: PUT
        //Response Code: 405
        //Response Message: This request method is not supported.


        // 1- Set the url and request body
        specAut_Exercise.pathParam("pathparam","brandsList");

        JSONObject requestBody = new JSONObject();
        requestBody.put("id",1);
        requestBody.put("brand","Polo_cuk");

        // 2- Set the expected Data
        AutExercise_testData autExerciseTestData = new AutExercise_testData();
        JSONObject expectedData = autExerciseTestData.createdExpectedData_tc04();



        // 3- Get the response after sending request
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post("{pathparam}");



        // 4- Do Assertion

        response.then().statusCode(200)
                .contentType(ContentType.HTML);

        JsonPath responseBody = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseBody.getInt("responseCode")
                ,expectedData.get("responseCode"));

        softAssert.assertEquals(responseBody.get("message")
                ,expectedData.get("message"));

        softAssert.assertAll();

    }


}
