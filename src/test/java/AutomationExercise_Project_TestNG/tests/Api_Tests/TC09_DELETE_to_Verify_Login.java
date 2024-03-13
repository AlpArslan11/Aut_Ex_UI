package AutomationExercise_Project_TestNG.tests.Api_Tests;

import AutomationExercise_Project_TestNG.base_Urls.AutomationExerciseBaseUrl;
import AutomationExercise_Project_TestNG.testDataDeposu.AutExercise_testData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class TC09_DELETE_to_Verify_Login extends AutomationExerciseBaseUrl {

    @Test
    public void delete_to_verify_login_TC09(){

        //API URL: https://automationexercise.com/api/verifyLogin
        //Request Method: DELETE
        //Response Code: 405
        //Response Message: This request method is not supported


        //1-Set the url and the request body
        specAut_Exercise.pathParam("first","verifyLogin");

        //2- Set the expected Data
        AutExercise_testData autExerciseTestData = new AutExercise_testData();
        JSONObject expectedData = autExerciseTestData.createdExpectedData_tc09();


        //3- Send the request and get the response
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .and()
                .accept(ContentType.JSON)
                .when()
                .delete("{first}");


        response.prettyPrint();

        // Do assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);


        JsonPath responseBody = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseBody.get("responseCode"),expectedData.get("responseCode"));
        softAssert.assertEquals(responseBody.get("message"),expectedData.get("message"));

        softAssert.assertAll();




    }




}



