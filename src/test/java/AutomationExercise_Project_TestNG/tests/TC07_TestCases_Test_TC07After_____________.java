package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.TestCasesPage;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_TestCases_Test_TC07After_____________ extends TestBaseBeforeAfterMethod {

    TestCasesPage testCasesPage;

    @Test(description = """
            Test Case 7: Verify Test Cases Page
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Test Cases' button
            5. Verify user is navigated to test cases page successfully""")
    public void testCases_test_TC07(){
        testCasesPage = new TestCasesPage();
        //Test Case 7: Verify Test Cases Page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
         //3. Verify that home page is visible successfully
        //4. Click on 'Test Cases' button
        testCasesPage.testCases_button.click();

        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(testCasesPage.testCases_text.isDisplayed());






    }
}
