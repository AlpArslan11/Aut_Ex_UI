package AutomationExercise_Project_TestNG.tests.Api_Tests;


import AutomationExercise_Project_TestNG.base_Urls.AutomationExerciseBaseUrl;
import AutomationExercise_Project_TestNG.testDataDeposu.AutExercise_testData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;


public class TC01_GET_All_Products_List extends AutomationExerciseBaseUrl {


    @Test
    public void get_All_Products_List_TC03_testDataSpecKullanimi() {
        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion


        // Set The Url and Request Body
        specAut_Exercise.pathParam("pathparam", "productsList");

        // Set the Expected Data
        AutExercise_testData autExerciseTestData = new AutExercise_testData();
        JSONObject expectedData= autExerciseTestData.createExpectedData();

        // Get the Response after sending request
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("{pathparam}");

        JsonPath responseBody= response.jsonPath();


        // Do Assertion

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedData.getInt("responseCode"),responseBody.getInt("responseCode"));

        softAssert.assertEquals(responseBody.getInt("products[0].id"),expectedData.get("id"));
        softAssert.assertEquals(responseBody.get("products[0].name"),expectedData.get("name"));
        softAssert.assertEquals(responseBody.get("products[0].price"),expectedData.get("price"));
        softAssert.assertEquals(responseBody.get("products[0].brand"),expectedData.get("brand"));
        softAssert.assertEquals(responseBody.get("products[0].category.usertype.usertype"),expectedData.get("category.userstype.usertype"));
        softAssert.assertEquals(responseBody.get("products[0].category.category"),expectedData.get("category.category"));

        softAssert.assertAll();
    }


       /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


        /*
        --> Bu şekilde çözersek yani her bir basamağı ayri ayri çözersek bu hard assertion olur. Yani eger ilk assertte doğrulayamazsa
        orda kalir. expception firlatir.
         response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.email",equalTo("janet.weaver@reqres.in"),
                        "data.first_name",equalTo("Janet"),
                        "data.last_name",equalTo("Weaver"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }           --> Bu sekilde yazarsak bize ilk assert hata doğrulamasa bile diğerlerinide çalıştırır. en fail verir ve hangisinde hata var gösterir.

         */


    @Test
    public void get_All_Products_List_TC01() {

        //          Given  https://reqres.in/api/users/3
        //          When   User sends a GET Request to the url
        //          Then   HTTP Status Code should be 200
        //          And    Content Type should be text/html
        //          Given  https://reqres.in/api/users/3
        //          When   User sends a GET Request to the url


        //  specAut_Exercise.

        Response response = given().when().get("https://automationexercise.com/api/productsList");

        //          Then   responseCode should be 200
        //          Then   HTTP Status Code should be 200
        //          And    Content Type should be text/html


        Assert.assertEquals(response.jsonPath().get("products[0].id").toString(), "1");
        Assert.assertEquals(response.jsonPath().get("products[0].name").toString(), "Blue Top");
        Assert.assertEquals(response.jsonPath().get("products[0].price").toString(), "Rs. 500");
        Assert.assertEquals(response.jsonPath().get("products[0].brand").toString(), "Polo");
        Assert.assertEquals(response.jsonPath().get("products[0].category.usertype.usertype").toString(), "Women");
        Assert.assertEquals(response.jsonPath().get("products[0].category.category").toString(), "Tops");
        Assert.assertEquals(response.jsonPath().get("responseCode").toString(), "200");


        response.then()
                .statusCode(200)
                .contentType(ContentType.HTML);


    }


    @Test
    public void get_All_Products_List_TC01_2() {
        // Request Url ve Body oluştur
        // Expected Data Oluştur

/*
"responseCode": 200,
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
        },
 */

        // 1- Request Url ve Body oluştur
        String url = "https://automationexercise.com/api/productsList";

        // 2- Expected Data Oluştur
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("id", "1");
        expectedBody.put("name", "Blue Top");
        expectedBody.put("price", "Rs. 500");
        expectedBody.put("brand", "Polo");
        expectedBody.put("category_usertype", "Women");
        expectedBody.put("category_category", "Tops");
        expectedBody.put("responseCode", "200");


        //3-  Response Kaydet
        Response response = given()
                .when()
                .get(url);
        // response.jsonPath().prettyPrint();


        //4- Assertion
        SoftAssert softAssert = new SoftAssert();


        //          Then   HTTP Status Code should be 200
        //          And    Content Type should be text/html
        response
                .then()
                .assertThat()
                .contentType(ContentType.HTML)
                .statusCode(200);

        JsonPath actBody = response.jsonPath(); // dönen response'u jsonPath formatına donusturmemiz gerekiyor.

        softAssert.assertEquals(expectedBody.get("id"), actBody.get("products[0].id").toString());
        softAssert.assertEquals(expectedBody.get("name"), actBody.get("products[0].name").toString());
        softAssert.assertEquals(expectedBody.get("price"), actBody.get("products[0].price").toString());
        softAssert.assertEquals(expectedBody.get("brand"), actBody.get("products[0].brand").toString());
        softAssert.assertEquals(expectedBody.get("category_usertype"), actBody.get("products[0].category.usertype.usertype").toString());
        softAssert.assertEquals(expectedBody.get("category_category"), actBody.get("products[0].category.category").toString());
        //          Then   responseCode should be 200
        softAssert.assertEquals(expectedBody.get("responseCode"), actBody.get("responseCode").toString());

        softAssert.assertAll();


    }


}
