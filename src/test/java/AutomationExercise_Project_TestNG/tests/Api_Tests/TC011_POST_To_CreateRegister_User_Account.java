package AutomationExercise_Project_TestNG.tests.Api_Tests;

import AutomationExercise_Project_TestNG.base_Urls.AutomationExerciseBaseUrl;
import AutomationExercise_Project_TestNG.testDataDeposu.AutExercise_testData;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TC011_POST_To_CreateRegister_User_Account extends AutomationExerciseBaseUrl {

    @Test
    public void post_to_CreateRegister_User_Account_TC11(){
        //API URL: https://automationexercise.com/api/createAccount
        //Request Method: POST
        //Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss),
        // birth_date, birth_month, birth_year, firstname, lastname, company,
        // address1, address2, country, zipcode, state, city, mobile_number

        //Response Code: 201
        //Response Message: User created!

        // 1- Set the url and the request body
        specAut_Exercise.pathParam("pathparam","createAccount");

        // 2- Set the expected Data
        AutExercise_testData autExerciseTestData = new AutExercise_testData();
        JSONObject expectedData= autExerciseTestData.createExpectedData(201,"User created!");

        // 3- Send the request and get the response
/*
        Map<String, String> userRegistrationInfo = new HashMap<>();
        userRegistrationInfo.put("name","asdaAlparslan");
        userRegistrationInfo.put("email","asdAlparslan@gmail.com");
        userRegistrationInfo.put("password","asd12345");
        userRegistrationInfo.put("title","Mr");
        userRegistrationInfo.put("birth_date",04);
        userRegistrationInfo.put("birth_month", 11);
        userRegistrationInfo.put("birth_year",);
        userRegistrationInfo.put("firstname");
        userRegistrationInfo.put("lastname");
        userRegistrationInfo.put("company");
        userRegistrationInfo.put("address1");
        userRegistrationInfo.put("address2");
        userRegistrationInfo.put("country");
        userRegistrationInfo.put("zipcode");
        userRegistrationInfo.put("state");
        userRegistrationInfo.put("city");
        userRegistrationInfo.put("mobile_number");




        Response response = given().spec(specAut_Exercise)
                .contentType(ContentType.MULTIPART)
                .accept(ContentType.JSON)
                .multiPart("name","asdaAlparslan")
                .multiPart("email", "asdAlparslan@gmail.com")
                .multiPart(userRegistrationInfo.forEach(t-> t)

 */

              /*
                .multiPart()
                .multiPart()
                .multiPart()
                .multiPart()
                .multiPart()
                .multiPart()
                .multiPart()
                .multiPart()
                .multiPart()
                .multiPart()



                .multiPart()
*/
        // 4- Do Assertion







    }
}
