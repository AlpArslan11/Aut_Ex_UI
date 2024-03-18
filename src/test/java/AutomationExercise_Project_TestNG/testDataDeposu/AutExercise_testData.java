package AutomationExercise_Project_TestNG.testDataDeposu;

import AutomationExercise_Project_TestNG.utilities.ConfigReader;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.randomEmail;

public class AutExercise_testData {

    public JSONObject createExpectedData() {


        JSONObject expectedData = new JSONObject();

        expectedData.put("responseCode", 200);
        expectedData.put("id", 1);
        expectedData.put("name", "Blue Top");
        expectedData.put("price", "Rs. 500");
        expectedData.put("brand", "Polo");
        expectedData.put("category.userstype.usertype", "Women");
        expectedData.put("category.category", "Tops");

        return expectedData;


    }



    public JSONObject createExpectedData_tc02(){
        JSONObject expectedData = new JSONObject();
        expectedData.put("responseCode", 405);
        expectedData.put("message" , "This request method is not supported.");
        return expectedData;
    }


    public JSONObject createExpectedData_tc03(){

        /*
        {
    "responseCode": 200,
    "brands": [
        {
            "id": 1,
            "brand": "Polo"
        }
        }
         */
        JSONObject expectedData = new JSONObject();
        expectedData.put("responseCode",200);
        expectedData.put("brands[0].id",1);
        expectedData.put("brands[0].brand","Polo");

        return expectedData;
    }


    public JSONObject createdExpectedData_tc04(){
        //{
        //    "responseCode": 405,
        //    "message": "This request method is not supported."
        //}


        JSONObject expectedData= new JSONObject();
        expectedData.put("responseCode",405);
        expectedData.put("message","This request method is not supported.");

        return expectedData;
    }



    public JSONObject createdExpectedData_tc06(){
        /*
        {
    "responseCode": 400,
    "message": "Bad request, search_product parameter is missing in POST request."
            }
         */

        JSONObject expectedData= new JSONObject();
        expectedData.put("responseCode",400);
        expectedData.put("message","Bad request, search_product parameter is missing in POST request.");



        return expectedData;
    }


    public JSONObject createdExpectedData_tc07(){

        /*
        {
    "responseCode": 200,
    "message": "User exists!"
}
         */

        JSONObject expectedData = new JSONObject();
        expectedData.put("responseCode",200);
        expectedData.put("message","User exists!");


        return expectedData;
    }


    public JSONObject createdExpectedData_tc08(){

        /*
            {
    "responseCode": 400,
    "message": "Bad request, email or password parameter is missing in POST request."
            }
         */

        JSONObject expectedData = new JSONObject();
        expectedData.put("responseCode",400);
        expectedData.put("message","Bad request, email or password parameter is missing in POST request.");
        return expectedData;
    }


    public JSONObject createdExpectedData_tc09(){

        /*
            {
    "responseCode": 405,
    "message": "This request method is not supported."
            }
         */

        JSONObject expectedData = new JSONObject();
        expectedData.put("responseCode",405);
        expectedData.put("message","This request method is not supported.");
        return expectedData;
    }

    public JSONObject createExpectedData(int responseCode,String message ){

        JSONObject expectedData = new JSONObject();
        expectedData.put("responseCode",responseCode);
        expectedData.put("message",message);
        return expectedData;
    }


    public JSONObject userInfoToRegister_tc08(){
        String randomMail = randomEmail(8);
        ConfigReader.setProperty("randomMail",randomMail);
        //Map<String, String> userRegistrationInfo = new HashMap<>();
        JSONObject userRegistrationInfo = new JSONObject();
        userRegistrationInfo.put("name","asdaAlparslan");
        userRegistrationInfo.put("email",randomMail);
        userRegistrationInfo.put("password","asd12345");
        userRegistrationInfo.put("title","Mr");
        userRegistrationInfo.put("birth_date","04");
        userRegistrationInfo.put("birth_month", "11");
        userRegistrationInfo.put("birth_year","1983");
        userRegistrationInfo.put("firstname","Alparslan");
        userRegistrationInfo.put("lastname","Asd");
        userRegistrationInfo.put("company","techno");
        userRegistrationInfo.put("address1","Orasi Burasi");
        userRegistrationInfo.put("address2","NY");
        userRegistrationInfo.put("country","Canada");
        userRegistrationInfo.put("zipcode","45987");
        userRegistrationInfo.put("state","Ottowa");
        userRegistrationInfo.put("city","Toronto");
        userRegistrationInfo.put("mobile_number","569889999");
        return userRegistrationInfo;
    }




}
