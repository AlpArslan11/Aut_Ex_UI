package AutomationExercise_Project_TestNG.tests.UI_Tests;

import AutomationExercise_Project_TestNG.pages.ContactUsPage;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;


public class TC06_ContactUs_Test_TC06After________ extends TestBaseBeforeAfterMethod {


    @Description("""
            Test Case 6: Contact Us Form
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Contact Us' button
            5. Verify 'GET IN TOUCH' is visible
            6. Enter name, email, subject and message
            7. Upload file
            8. Click 'Submit' button
            9. Click OK button
            10. Verify success message 'Success! Your details have been submitted successfully.' is visible
            11. Click 'Home' button and verify that landed to home page successfully""")
    ContactUsPage contactUsPage;

    @Test(description = "Test Case 6: Contact Us Form")
    public void contactUs_Test_TC06() {
        contactUsPage = new ContactUsPage();
        //Test Case-6 SUBMITTING CONTACT US FORM

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Contact Us' button
        contactUsPage.containsUs_button.click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(contactUsPage.getInTouch_text.isDisplayed(), "Get in Touch yazisi goruntulenmiyor");

        //6. Enter name, email, subject and message
        contactUsPage.name_textbox.sendKeys(randomName(8));
        contactUsPage.email_textbox.sendKeys(randomEmail(5));

        contactUsPage.subject_textbox.sendKeys(randomParagraph(3));
        contactUsPage.message_textbox.sendKeys(randomParagraph(65));

        //7. Upload file
        String path = System.getProperty("user.home") + "\\Desktop\\com.aut_ex.ui\\src\\test\\resources\\letter.txt";
        contactUsPage.uploadFile_button.sendKeys(path);
        waitFor(3);
        //8. Click 'Submit' button
        contactUsPage.submit_button.click();

        //9. Click OK button
        Driver.getDriver().switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(contactUsPage.alertStatus_text.getText()
                        .contains("Success! Your details have been submitted successfully")
                , "alert başarılı metni goruntulenmiyor");

        //11. Click 'Home' button and verify that landed to home page successfully
        contactUsPage.home_button.click();
        handleGoogleVignette(() -> contactUsPage.home_button.click());
        verifyLandedToHomePage();


    }

}
