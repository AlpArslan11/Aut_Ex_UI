package AutomationExercise_Project_TestNG.tests.UI_Tests;

import AutomationExercise_Project_TestNG.pages.Functions_Page;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;


public class TC25_Functionality_Tests_TC25_TC26___________ extends TestBaseBeforeAfterMethod {

    @Description("""
            Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Scroll down page to bottom
            5. Verify 'SUBSCRIPTION' is visible
            6. Click on arrow at bottom right side to move upward
            7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen""")
    Functions_Page functionsPage;
    @Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality_TC25() {

        functionsPage = new Functions_Page();
        //Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Scroll down page to bottom
        scrollIntoViewByJavaScript(functionsPage.footer_subscription);
        // scrollToTheBottomwithActions();

        //5. Verify 'SUBSCRIPTION' is visible
        verifySubscriptionIsVisible();

        //6. Click on arrow at bottom right side to move upward
        clickOnArrowToMoveUpward();

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        verifyFullFLedgedADSIsVisible();
    }
    @Description("""
            Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Scroll down page to bottom
            5. Verify 'SUBSCRIPTION' is visible
            6. Scroll up page to top
            7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen""")

    @Test(description = "Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionality_TC26() throws InterruptedException {
        //Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Scroll down page to bottom
        scrollToTheBottomWithActions();

        //5. Verify 'SUBSCRIPTION' is visible
        verifySubscriptionIsVisible();

        //6. Scroll up page to top
        scrollToTheTopOfThePage();

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        verifyFullFLedgedADSIsVisible();
    }


}
