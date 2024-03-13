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

public class TC07_POST_To_Verify_Login_with_valid_details extends AutomationExerciseBaseUrl {


    @Test
    public void post_To_Verify_Login_with_valid_details_TC07(){

        //API URL: https://automationexercise.com/api/verifyLogin
        //Request Method: POST
        //Request Parameters: email, password
        //Response Code: 200
        //Response Message: User exists!

        //1- Set the url and the request body
        specAut_Exercise.pathParam("pathparam","verifyLogin");

        //2- Set the expected data
        AutExercise_testData autExerciseTestData= new AutExercise_testData();
        JSONObject expectedData = autExerciseTestData.createdExpectedData_tc07();

        //3- Send the request and get the response

        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.MULTIPART)
                .accept(ContentType.JSON)
                .and()
                .multiPart("email","alparslan@gmail.com")
                .multiPart("password", "asd12345")
                .when()
                .post("{pathparam}");

        response.prettyPrint();

        //4- Do assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);

        JsonPath responseBody= response.jsonPath();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseBody.getInt("responseCode"),expectedData.get("responseCode"));
        softAssert.assertEquals(responseBody.get("message"),expectedData.get("message"));

        softAssert.assertAll();














    }
}
