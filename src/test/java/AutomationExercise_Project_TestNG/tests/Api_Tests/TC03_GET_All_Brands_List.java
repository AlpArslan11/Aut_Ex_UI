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

public class TC03_GET_All_Brands_List extends Aut_Ex_BaseUrl {


    @Test
    public void get_All_Brands_List_TC03(){
        //API URL: https://automationexercise.com/api/brandsList
        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        //----------------------
        // responseCode should be 200
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion



        // Set The Url and Request Body
        specAut_Exercise.pathParam("pathparam","brandsList");

        // Set the Expected Data
        AutExercise_testData autExerciseTestData = new AutExercise_testData();
        JSONObject expectedData = autExerciseTestData.createExpectedData_tc03();


        // Get the Response after sending request
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("{pathparam}");
        JsonPath responseBody = response.jsonPath();
        //responseBody.prettyPrint();

        // Do Assertion
        // responseCode should be 200
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.HTML);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseBody.getInt("responseCode"),expectedData.get("responseCode"));
        softAssert.assertEquals(responseBody.getInt("brands[0].id"),expectedData.get("brands[0].id"));
        softAssert.assertEquals(responseBody.get("brands[0].brand"),expectedData.get("brands[0].brand") );
        softAssert.assertAll();
    }



}
