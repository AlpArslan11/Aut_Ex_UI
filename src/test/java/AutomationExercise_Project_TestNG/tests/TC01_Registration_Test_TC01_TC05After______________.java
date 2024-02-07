package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.RegistrationPage;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;
import static org.apache.commons.lang3.RandomStringUtils.random;

public class TC01_Registration_Test_TC01_TC05After______________ extends TestBaseBeforeAfterMethod {
    @Description("""
                Test Case 1: Register User
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'New User Signup!' is visible
            6. Enter name and email address
            7. Click 'Signup' button
            8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            9. Fill details: Title, Name, Email, Password, Date of birth
            10. Select checkbox 'Sign up for our newsletter!'
            11. Select checkbox 'Receive special offers from our partners!'
            12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            13. Click 'Create Account button'
            14. Verify that 'ACCOUNT CREATED!' is visible
            15. Click 'Continue' button
            16. Verify that 'Logged in as username' is visible
            17. Click 'Delete Account' button
            18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
            """)
    RegistrationPage registrationPage;
    String actualText, expectedText;
    Map<String, String> registerInfo;

    @Test(priority = 1, description = "Test Case-1 REGISTERING AND DELETING THE REGISTERED USER")
    public void register_test_TC01() {
        registrationPage = new RegistrationPage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Signup / Login' button
        registrationPage.signUpLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(registrationPage.signUpText.isDisplayed(), "New User Signup! - text is not visible");
        Map<String, String> registerInfo = register_fromLoginPage();

        //16. Verify that 'Logged in as username' is visible
        actualText = registrationPage.loggedInAsUsername_text.getText();
        expectedText = registerInfo.get("userName");
        System.out.println(expectedText);
        Assert.assertTrue(actualText.contains(expectedText));

        //17. Click 'Delete Account' button
        deleteUserAndVerifyAccDeleted();
    }


    @Description("""
            Test Case 5: Register User with existing email
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'New User Signup!' is visible
            6. Enter name and already registered email address
            7. Click 'Signup' button
            8. Verify error 'Email Address already exist!' is visible
            """)
    @Test(priority = 2, dependsOnMethods = "registerAndLogout", description = "Test Case 5: Register User with existing email")
    public void registerWithExistingEmail_test_TC05() {
        //Test Case-5: REGISTERING WITH EXISTING USER INFO
        registrationPage = new RegistrationPage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Signup / Login' button
        registrationPage.signUpLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(registrationPage.signUpText.isDisplayed(), "New User Signup! - text is not visible");

        //6. Enter name and already registered email address (username)
        //   Map<String, String> registerInfo = register_fromLoginPage();//registers an account to get registered email
        //   registrationPage.logout_button.click();
        registrationPage.userName_NameTextbox.sendKeys(registerInfo.get("userName"));
        registrationPage.signUpEmailAddress_textbox.sendKeys(registerInfo.get("email"));

        //7. Click 'Signup' button
        registrationPage.signUpButton.click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(registrationPage.emailAlreadyExists_text.isDisplayed(),
                "Email Address already exist! - text is not displayed");

        // ---->USER DELETES THE REGISTERED ACCOUNT
        login_fromLoginPage(registerInfo.get("email"), registerInfo.get("password"));
        deleteUserAndVerifyAccDeleted();
    }


    @Test()
    public void registerAndLogout() {
        registrationPage = new RegistrationPage();
        registrationPage.signUpLoginButton.click();
        registerInfo = register_fromLoginPage();
        logoutUser();
    }


}
