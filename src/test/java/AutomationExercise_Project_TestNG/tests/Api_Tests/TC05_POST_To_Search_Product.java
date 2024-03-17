package AutomationExercise_Project_TestNG.tests.Api_Tests;

import AutomationExercise_Project_TestNG.base_Url.Aut_Ex_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TC05_POST_To_Search_Product extends Aut_Ex_BaseUrl {



    @Test
    public void post_To_Search_Product_TC05(){
        // API URL: https://automationexercise.com/api/searchProduct
        // Set The Url and Request Body
        // Set the Expected Data
        // Get the Response after sending request
        // Do Assertion

        //----------------------
        // responseCode should be 200
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 200  Response JSON: Searched products list



        // 1- Set the url and request body
        specAut_Exercise.pathParam("pathparam","searchProduct");

        //2- set the expected data
        int products_ThsirtCount = 6;

        //3-Send the request and get the response
        Response response = given()
                .spec(specAut_Exercise)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .accept(ContentType.JSON)
                .and()
                .multiPart("search_product","tshirt")
                .when()
                .post("{pathparam}");
        response.prettyPrint();

        //4- Do the assertion
        // responseCode should be 200
        // HTTP Status Code should be 200
        // Content Type should be text/html
        // body asssertion  Response Code: 200  Response JSON: Searched products list
        response
                .then()
                .assertThat()
                .contentType(ContentType.HTML)
                .statusCode(200);

        JsonPath responseBody = response.jsonPath();
        List<Map> tshirtProductsMapsList= responseBody.getList("products");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseBody.getInt("responseCode"),200);
        softAssert.assertEquals(tshirtProductsMapsList.size(),6);

        softAssert.assertAll();

    }

}
