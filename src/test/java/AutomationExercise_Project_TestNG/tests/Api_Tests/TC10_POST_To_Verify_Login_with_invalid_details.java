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

public class TC10_POST_To_Verify_Login_with_invalid_details extends Aut_Ex_BaseUrl {


    @Test
    public void post_to_Verify_Login_with_invalid_details_TC10(){
        //API URL: https://automationexercise.com/api/verifyLogin
        //Request Parameters: email, password (invalid values)

        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        //----------------------
        // responseCode should be 404
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 404
        // Response Message: User not found!

        // 1- Set the Url and the request body
        specAut_Exercise.pathParam("pathparam","verifyLogin");

        // 2- Set the expected data
        AutExercise_testData autExerciseTestData= new AutExercise_testData();
        JSONObject expectedData = autExerciseTestData.createExpectedData(404,"User not found!");

        // 3- send the request and get the response
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.MULTIPART)
                .accept(ContentType.JSON)
                .multiPart("email","asdasd123@gmal.com")
                .and()
                .multiPart("password","548weq")
                .when()
                .post("{pathparam}");

        response.jsonPath().prettyPrint();


        // 4- do assertion
        // responseCode should be 404
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 404
        // Response Message: User not found!

        JsonPath responseBody= response.jsonPath();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseBody.getInt("responseCode"),expectedData.get("responseCode"));
        softAssert.assertEquals(responseBody.get("message"),expectedData.get("message"));

        softAssert.assertAll();
    }
}
