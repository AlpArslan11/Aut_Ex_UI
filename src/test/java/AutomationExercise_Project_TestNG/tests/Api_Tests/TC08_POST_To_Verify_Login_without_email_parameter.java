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

public class TC08_POST_To_Verify_Login_without_email_parameter extends Aut_Ex_BaseUrl {

    @Test
    public void post_To_Verify_Login_without_email_parameter_TC08(){
        //API URL: https://automationexercise.com/api/verifyLogin
        //Request Parameter: password

        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        //----------------------
        // responseCode should be 400
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 400
        //Response Message: Bad request, email or password parameter is missing in POST request.

        //1- Set the URL and the request body
        specAut_Exercise.pathParam("pathparam","verifyLogin");

        //2- Set the expected Data
        AutExercise_testData autExerciseTestData = new AutExercise_testData();
        JSONObject expectedData= autExerciseTestData.createdExpectedData_tc08();

        //3- Send the request and get the response
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.MULTIPART)
                .accept(ContentType.JSON)
                .and()
                .multiPart("password","asd12345")
                .when()
                .post("{pathparam}");


        //4- Do assertion
        // responseCode should be 400
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 400
        //Response Message: Bad request, email or password parameter is missing in POST request.

        JsonPath responseBody = response.jsonPath();

        response.then()
                .assertThat()
                .contentType(ContentType.HTML)
                .statusCode(200);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseBody.getInt("responseCode"),expectedData.get("responseCode"));
        softAssert.assertEquals(responseBody.get("message"),expectedData.get("message"));

        softAssert.assertAll();
    }



}
