package AutomationExercise_Project_TestNG.tests.UI_Tests;

import AutomationExercise_Project_TestNG.pages.LoginPage;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;


//Test Case 2, Test Case 3, Test Case 4


public class TC02_Login_Test_TC02_TC03_TC04After__________ extends TestBaseBeforeAfterMethod {
     @Description("""
            Test Case 2: Login User with correct email and password
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter correct email address and password
            7. Click 'login' button
            8. Verify that 'Logged in as username' is visible
            9. Click 'Delete Account' button
            10. Verify that 'ACCOUNT DELETED!' is visible
            """)
    Map<String, String> registerInfo;
    LoginPage loginpage;

    @Test(priority = 3, dependsOnMethods = "registerAndLogout", description = "Test Case 2: Login User with correct email and password")
    public void positive_loginTest_TC02() {
        //Test Case-2 LOGIN WITH VALID CREDENTIALS AND DELETES USER
        loginpage = new LoginPage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Signup / Login' button
        clickSignUpLoginButton();
     //   loginpage.signUp_button.click();
        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        //7. Click 'login' button
        login_fromLoginPage(registerInfo.get("email"), registerInfo.get("password"));


        //9. Click 'Delete Account' button
        deleteUserAndVerifyAccDeleted();
    }





      @Description("""
            Test Case 3: Login User with incorrect email and password
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter incorrect email address and password
            7. Click 'login' button
            8. Verify error 'Your email or password is incorrect!' is visible""")

    @Test(priority = 2, dependsOnMethods = "registerAndLogout", description = "Test Case 3: Login User with incorrect email and password")
    public void negative_loginTest_TC03() {
        // Test Case-3 LOGIN WITH INVALID CREDENTIALS
        //Test Case 3: Login User with incorrect email and password

        loginpage = new LoginPage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Click on 'Signup / Login' button
          clickSignUpLoginButton();

//          loginpage.signUp_button.click();

        //5. Verify 'Login to your account' is visible
        String expected_text = "Login to your account";
        Assert.assertTrue(loginpage.login_text.getText().toLowerCase().contains(expected_text.toLowerCase()));

        //6. Enter incorrect email address and password
        loginpage.login_email.sendKeys(registerInfo.get("email") + "asd",
                Keys.TAB,
                registerInfo.get("password") + "asd");

        //7. Click 'login' button
        loginpage.login_button.click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue((loginpage.wrongCredentialsWarning_text.getText().toLowerCase())
                        .contains("Your email or password is incorrect".toLowerCase())
                , "With Invalid Credentials 'Your email or password is incorrect' - text is not displayed");


        // DELETING THE CREATED USER ACCOUNT
        loginpage.signUp_button.click();
        login_fromLoginPage(registerInfo.get("email"), registerInfo.get("password"));
        deleteUserAndVerifyAccDeleted();


    }


    @Description("""
            Test Case 4: Logout User
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter correct email address and password
            7. Click 'login' button
            8. Verify that 'Logged in as username' is visible
            9. Click 'Logout' button
            10. Verify that user is navigated to login pag""")

    @Test(priority = 1, dependsOnMethods = "registerAndLogout", description = " Test Case 4: Logout User")
    public void logout_test_TC04()  {
        //Test Case 4 LOGIN WITH VALID CREDENTIALS AND LOGOUT USER
        loginpage = new LoginPage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Click on 'Signup / Login' button
        clickSignUpLoginButton();

     //   loginpage.signUp_button.click();

        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible
        login_fromLoginPage(registerInfo.get("email"), registerInfo.get("password"));


        //9. Click 'Logout' button
        logoutUser();

        //10. Verify that user is navigated to login page
        Assert.assertEquals(Driver.getDriver().getCurrentUrl()
                , "https://automationexercise.com/login",
                "The url is not as expected");
        Assert.assertTrue(loginpage.login_text.isDisplayed(), "Login to your account - text is not displayed");

//         wait(2);
        // DELETING THE CREATED USER ACCOUNT
     //   loginpage.signUp_button.click();
        login_fromLoginPage(registerInfo.get("email"), registerInfo.get("password"));
        deleteUserAndVerifyAccDeleted();

    }


    @Test()
    public void registerAndLogout() {
        loginpage = new LoginPage();
        loginpage.signUp_button.click();
        registerInfo = register_fromLoginPage();
        logoutUser();

    }


}
