package AutomationExercise_Project_TestNG.tests.Api_Tests;


import AutomationExercise_Project_TestNG.base_Url.Aut_Ex_BaseUrl;
import AutomationExercise_Project_TestNG.testDataDeposu.AutExercise_testData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;


public class TC01_GET_All_Products_List extends Aut_Ex_BaseUrl {


    @Test
    public void get_All_Products_List_TC01_1_testDataSpecKullanimi() {
        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        // responseCode should be 200
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion

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
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(expectedData.getInt("responseCode"),responseBody.getInt("responseCode"));

        softAssert.assertEquals(responseBody.getInt("products[0].id"),expectedData.get("id"));
        softAssert.assertEquals(responseBody.get("products[0].name"),expectedData.get("name"));
        softAssert.assertEquals(responseBody.get("products[0].price"),expectedData.get("price"));
        softAssert.assertEquals(responseBody.get("products[0].brand"),expectedData.get("brand"));
        softAssert.assertEquals(responseBody.get("products[0].category.usertype.usertype"),expectedData.get("category.userstype.usertype"));
        softAssert.assertEquals(responseBody.get("products[0].category.category"),expectedData.get("category.category"));

        softAssert.assertAll();
    }

    @Test
    public void get_All_Products_List_TC01_2() {

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
        specAut_Exercise.pathParam("pathparam", "productsList");

        // Get the Response after sending request
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("{pathparam}");


        //-------- Do Assertion -----------
        // responseCode should be 200
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.HTML);


//        Assert.assertEquals(response.statusCode(),200);
//        Assert.assertEquals(response.jsonPath().get("responseCode").toString(),"200");

        Assert.assertEquals(response.jsonPath().get("products[0].id").toString(), "1");
        Assert.assertEquals(response.jsonPath().get("products[0].name").toString(), "Blue Top");
        Assert.assertEquals(response.jsonPath().get("products[0].price").toString(), "Rs. 500");
        Assert.assertEquals(response.jsonPath().get("products[0].brand").toString(), "Polo");
        Assert.assertEquals(response.jsonPath().get("products[0].category.usertype.usertype").toString(), "Women");
        Assert.assertEquals(response.jsonPath().get("products[0].category.category").toString(), "Tops");
    }


    @Test
    public void get_All_Products_List_TC01_3() {
        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        //----------------------
        // responseCode should be 200
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion

        // 1- Set The Url and Request Body
        specAut_Exercise.pathParam("pathparam", "productsList");

        // 2- Set the Expected Data
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("id", "1");
        expectedBody.put("name", "Blue Top");
        expectedBody.put("price", "Rs. 500");
        expectedBody.put("brand", "Polo");
        expectedBody.put("category_usertype", "Women");
        expectedBody.put("category_category", "Tops");
        expectedBody.put("responseCode", "200");


        //3-  Get the Response after sending request
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("{pathparam}");


        //4. -------- Do Assertion -----------
        // responseCode should be 200
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion
        SoftAssert softAssert = new SoftAssert();


        response
                .then()
                .assertThat()
                .contentType(ContentType.HTML)
                .statusCode(200);

        JsonPath actBody = response.jsonPath();

        softAssert.assertEquals(expectedBody.get("id"), actBody.get("products[0].id").toString());
        softAssert.assertEquals(expectedBody.get("name"), actBody.get("products[0].name").toString());
        softAssert.assertEquals(expectedBody.get("price"), actBody.get("products[0].price").toString());
        softAssert.assertEquals(expectedBody.get("brand"), actBody.get("products[0].brand").toString());
        softAssert.assertEquals(expectedBody.get("category_usertype"), actBody.get("products[0].category.usertype.usertype").toString());
        softAssert.assertEquals(expectedBody.get("category_category"), actBody.get("products[0].category.category").toString());
        softAssert.assertEquals(expectedBody.get("responseCode"), actBody.get("responseCode").toString());
        softAssert.assertAll();
    }
}
