package AutomationExercise_Project_TestNG.testDataDeposu;

import org.json.JSONObject;

public class JsonPlaceHolder_testData {

    public int basariliStatusKod = 200;


    public JSONObject createExptectedData() {
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");

        return expectedData;

    }
}
