package AutomationExercise_Project_TestNG.testDataDeposu;

import org.json.JSONObject;

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



    public JSONObject createExpectedData02(){
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


}
