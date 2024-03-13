package AutomationExercise_Project_TestNG.base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class AutomationExerciseBaseUrl {

    protected RequestSpecification specAut_Exercise;

    @BeforeMethod
    public void setUp(){



        specAut_Exercise= new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api")
                .build();



    }
}
