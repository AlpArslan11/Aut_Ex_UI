package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.Functions_Page;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;


public class TC25_Functionality_Tests_TC25_TC26 extends TestBaseBeforeAfterMethod {

    Functions_Page functionsPage;

    @Test
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality_TC25(){

        functionsPage = new Functions_Page();
        //Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Scroll down page to bottom
        scrollIntoViewByJavaScript(functionsPage.footer_subscription);
       // scrollToTheBottomwithActions();

        //5. Verify 'SUBSCRIPTION' is visible
        Assert.assertEquals(functionsPage.subscription_text.getText().toLowerCase()
                ,"SUBSCRIPTION".toLowerCase(),
                "SUBSCRIPTION texti goruntulenemedi");

        //6. Click on arrow at bottom right side to move upward
        functionsPage.scroolUp_Button.click();

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        Assert.assertTrue(functionsPage.homepageLogo.isDisplayed(),"HomePage logo is not displayed");

        Assert.assertTrue(functionsPage.fullFledgedPractice_Text.isDisplayed()
                ,"HomePage text -Full-Fledged practice website for Automation Engineers- is not visible");



    }





    @Test
    public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionality_TC26() throws InterruptedException {

        functionsPage = new Functions_Page();
        //Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Scroll down page to bottom
        scrollToTheBottomWithActions();

        //5. Verify 'SUBSCRIPTION' is visible
        Assert.assertEquals(functionsPage.subscription_text.getText().toLowerCase()
                ,"SUBSCRIPTION".toLowerCase(),
                "SUBSCRIPTION texti goruntulenemedi");


       //6. Scroll up page to top
        scrollToTheTopOfThePage();
        //scrollUpByJavaScript(25);


        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

        Assert.assertTrue(functionsPage.homepageLogo.isDisplayed(),"HomePage logo is not displayed");

        Assert.assertTrue(functionsPage.fullFledgedPractice_Text.isDisplayed()
                ,"HomePage text -Full-Fledged practice website for Automation Engineers- is not visible");

    }








}
