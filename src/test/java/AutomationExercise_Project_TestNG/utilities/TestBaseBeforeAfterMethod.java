package AutomationExercise_Project_TestNG.utilities;

import AutomationExercise_Project_TestNG.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBaseBeforeAfterMethod {

    HomePage homepage;
    @BeforeMethod(alwaysRun = true)
    public void testEntry(){
    homepage = new HomePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/");
        Assert.assertTrue(homepage.adsOfHomepage.isDisplayed(),"Homepage reklamları yok");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
   //   Driver.closeDriver();

    }
}

//google_vignette
