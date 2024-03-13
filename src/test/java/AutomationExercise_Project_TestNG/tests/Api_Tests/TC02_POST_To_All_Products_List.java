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

public class TC02_POST_To_All_Products_List extends AutomationExerciseBaseUrl {


    @Test
    public void post_To_All_Products_List_TC002() {

        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        // Set The Url and Request Body
        specAut_Exercise.pathParam("pathparam", "productsList");

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("name", "Blue Top");
        requestBody.put("brand", "Polo");
        requestBody.put("category.usertype.usertype", "Women");
        requestBody.put("category.category", "Tops");

        // Set the Expected Data
        AutExercise_testData autExerciseTestData= new AutExercise_testData();
        JSONObject expectedData= autExerciseTestData.createExpectedData02();
        System.out.println("expectedData = " + expectedData);

        // Get the Response after sending request
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post("{pathparam}");

        JsonPath responseBody= response.jsonPath();

        // Do Assertion do assertion

        response.then()
                .statusCode(200)
                .contentType(ContentType.HTML);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseBody.getInt("responseCode"),expectedData.get("responseCode"));
        softAssert.assertEquals(responseBody.get("message"),expectedData.get("message"));

        softAssert.assertAll();




    }














        @Test
    public void post_To_All_Products_List_TC02() {

        // 1- Create Resuest url and response body.
/*
{
"products": [
        {
            "id": 1,
            "name": "Blue Top",
            "price": "Rs. 500",
            "brand": "Polo",
            "category": {
                "usertype": {
                    "usertype": "Women"
                },
                "category": "Tops"
            }
]
}
 */
        // 1- Set Resuest url and request body.
        String url = "https://automationexercise.com/api/productsList";

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("name", "Blue Top");
        requestBody.put("brand", "Polo");
        requestBody.put("category.usertype.usertype", "Women");
        requestBody.put("category.category", "Tops");

        // 2- Set Expected Body

        /*  RESPONSE BODY   STATUS CODE 200  CONTENT TYPE HTML / TEXT
        {
        "responseCode": 405,
        "message": "This request method is not supported."
        }

         */

        JSONObject expectedBody = new JSONObject();
        expectedBody.put("responseCode", 405);
        expectedBody.put("message", "This request method is not supported.");

        // 3- Get the Response
        Response response =given()
                .contentType(ContentType.HTML) // bu content type da kabul et.
                .when()
                .body(requestBody.toString()) // body bu ve string olarak oku. string belirtmezsek java direk obje gonderir.
                .post(url);


        JsonPath actualBody = response.jsonPath();  // bana dönen body actualBody olarak kaydedildi.

        // 4- Assertion

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedBody.get("responseCode"), actualBody.get("responseCode"));
        softAssert.assertEquals(expectedBody.get("message"),actualBody.get("message"));

        softAssert.assertAll();

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);
    }


}
