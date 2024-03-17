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

public class TC06_POST_To_Search_Product_without_search_product_parameter extends Aut_Ex_BaseUrl {


    @Test
    public void post_To_Search_Product_without_search_product_parameter_TC06(){

        //API URL: https://automationexercise.com/api/searchProduct
        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        //----------------------
        // responseCode should be 400
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 400
        // Response Message: Bad request, search_product parameter is missing in POST request

        //1- Set the Url and request body
        specAut_Exercise.pathParam("pathparam","searchProduct");

        //2- Set the Expected Data
        AutExercise_testData autExerciseTestData= new AutExercise_testData();
        JSONObject expectedData = autExerciseTestData.createdExpectedData_tc06();

        // 3- Send the request and get the response
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post("{pathparam}");

        response.prettyPrint();

        // 4- Do Assertion
        // responseCode should be 400
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 400
        // Response Message: Bad request, search_product parameter is missing in POST request

        response
                .then()
                .contentType(ContentType.HTML)
                .statusCode(200);
        JsonPath responseBody = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseBody.getInt("responseCode"),expectedData.get("responseCode"));
        softAssert.assertEquals(responseBody.get("message"),expectedData.get("message"));
        softAssert.assertAll();










    }





}
