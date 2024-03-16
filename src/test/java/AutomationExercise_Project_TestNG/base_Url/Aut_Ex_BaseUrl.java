package AutomationExercise_Project_TestNG.base_Url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Aut_Ex_BaseUrl {

    protected RequestSpecification specAut_Exercise;

    @BeforeMethod
    public void setUp(){



        specAut_Exercise= new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api")
                .build();



    }
}
