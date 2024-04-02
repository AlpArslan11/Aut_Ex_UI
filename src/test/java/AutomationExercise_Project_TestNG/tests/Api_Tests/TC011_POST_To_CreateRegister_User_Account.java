package AutomationExercise_Project_TestNG.tests.Api_Tests;

import AutomationExercise_Project_TestNG.base_Url.Aut_Ex_BaseUrl;
import AutomationExercise_Project_TestNG.testDataDeposu.AutExercise_testData;
import AutomationExercise_Project_TestNG.utilities.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.randomEmail;
import static io.restassured.RestAssured.given;

public class TC011_POST_To_CreateRegister_User_Account extends Aut_Ex_BaseUrl {

    @Test
    public void post_to_CreateRegister_User_Account_TC11(){
        //API URL: https://automationexercise.com/api/createAccount
        //Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss),
        // birth_date, birth_month, birth_year, firstname, lastname, company,
        // address1, address2, country, zipcode, state, city, mobile_number

        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        //----------------------
        // responseCode should be 201
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 201
        // Response Message: User created!



        // 1- Set the url and the request body
        specAut_Exercise.pathParam("pathparam","createAccount");

        // 2- Set the expected Data
        AutExercise_testData autExercise_testData = new AutExercise_testData();
        JSONObject userRegistrationInfo= autExercise_testData.userInfoToRegister_tc08();

        // 3- Send the request and get the response
        Response response = given().spec(specAut_Exercise)
                .contentType(ContentType.MULTIPART)
                .accept(ContentType.JSON)
                .multiPart("name",userRegistrationInfo.get("name"))
                .multiPart("email",userRegistrationInfo.get("email"))
                .multiPart("password",userRegistrationInfo.get("password"))
                .multiPart("title",userRegistrationInfo.get("title"))
                .multiPart("birth_date",userRegistrationInfo.get("birth_date"))
                .multiPart("birth_month",userRegistrationInfo.get("birth_month"))
                .multiPart("birth_year",userRegistrationInfo.get("birth_year"))
                .multiPart("firstname",userRegistrationInfo.get("firstname"))
                .multiPart("lastname",userRegistrationInfo.get("lastname"))
                .multiPart("company",userRegistrationInfo.get("company"))
                .multiPart("address1",userRegistrationInfo.get("address1"))
                .multiPart("address2",userRegistrationInfo.get("address2"))
                .multiPart("country",userRegistrationInfo.get("country"))
                .multiPart("zipcode",userRegistrationInfo.get("zipcode"))
                .multiPart("state",userRegistrationInfo.get("state"))
                .multiPart("city",userRegistrationInfo.get("city"))
                .multiPart("mobile_number",userRegistrationInfo.get("mobile_number"))
                .when()
                .post("{pathparam}");

        response.jsonPath().prettyPrint();

        // 4- Do Assertion
        // responseCode should be 201
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 201
        // Response Message: User created!

       JSONObject expectedData = autExercise_testData.createExpectedData(201,"User created!");

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.jsonPath().getInt("responseCode"),expectedData.get("responseCode"));
        softAssert.assertEquals(response.jsonPath().get("message"),expectedData.get("message"));

        softAssert.assertAll();

   }
   //    JSONObject expectedData = autExercise_testData.createExpectedData(201,"User created!");
   // TUM TESTLERDE BU BODY VARSA KONTROL ET BUNA UYGUN OALRAK TASARLA
    //unutma

}
