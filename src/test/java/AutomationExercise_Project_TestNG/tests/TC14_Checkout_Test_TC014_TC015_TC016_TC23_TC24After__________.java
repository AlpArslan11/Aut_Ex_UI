package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.*;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;
import static org.apache.commons.lang3.RandomStringUtils.random;

public class TC14_Checkout_Test_TC014_TC015_TC016_TC23_TC24After__________ extends TestBaseBeforeAfterMethod {

    Actions actions;
    CheckoutPage checkoutPage;
    Random rnd;
    Faker faker;
    Map<String, String> registerInfo;


    @Description("""
            Test Case 14: Place Order: Register while Checkout
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Add products to cart
            5. Click 'Cart' button
            6. Verify that cart page is displayed
            7. Click Proceed To Checkout
            8. Click 'Register / Login' button
            9. Fill all details in Signup and create account
            10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            11. Verify ' Logged in as username' at top
            12. Click 'Cart' button
            13. Click 'Proceed To Checkout' button
            14. Verify Address Details and Review Your Order
            15. Enter description in comment text area and click 'Place Order'
            16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            17. Click 'Pay and Confirm Order' button
            18. Verify success message 'Your order has been placed successfully!'
            19. Click 'Delete Account' button
            20. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
    @Test(priority = 1, description = "Test Case 14: Place Order: Register while Checkout")
    public void RegisterWhileCheckout_Test_TC14() {

        checkoutPage = new CheckoutPage();
        actions = new Actions(Driver.getDriver());
        rnd = new Random();
        faker = new Faker();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Add products to cart
        addSomeProductsToCart(2);

        //5. Click 'Cart' button
        clickCartButton();

        //6. Verify that cart page is displayed
        Assert.assertTrue(checkoutPage.shoppingCart_text.getText().toLowerCase().contains("shopping cart"), "Cart Page isnt displayed");

        //7. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //8. Click 'Register / Login' button
        checkoutPage.registerLoginOnPopUp_Button.click();
        Map<String, String> registerInfo = register_fromLoginPage();
        handleGoogleVignette(() -> Driver.getDriver().navigate().refresh());

        //11. Verify ' Logged in as username' at top
        verifyLoggedInAsUsername(registerInfo.get("userName"));

        //12.Click 'Cart' button
        checkoutPage.cart_Button.click();

        //13. Click 'Proceed To Checkout' button
        checkoutPage.proceedToCheckout_Button.click();

        //14. Verify Address Details and Review Your Order
        verifyAdressDetailsAndReviewOrder();

        //15. Enter description in comment text area and click 'Place Order'
        checkoutPage.comment_TextBox.sendKeys(randomParagraph(50));
        checkoutPage.placeOrder_Button.click();
        handleGoogleVignette(() -> checkoutPage.placeOrder_Button.click());

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        enterPaymentDetails();

        //17. Click 'Pay and Confirm Order' button
        checkoutPage.payAndConfirmOrder_Button.click();

        //18. Verify success message 'Your order has been placed successfully!'
        verifySuccessMsgOrderPlacedSuccessfully();
        waitFor(1);
        handleGoogleVignette(() -> Driver.getDriver().navigate().refresh());

        //19. Click 'Delete Account' button
        deleteUserAndVerifyAccDeleted();
    }

    @Description("""
            Test Case 15: Place Order: Register before Checkout
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'Signup / Login' button
            5. Fill all details in Signup and create account
            6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            7. Verify ' Logged in as username' at top
            8. Add products to cart
            9. Click 'Cart' button
            10. Verify that cart page is displayed
            11. Click Proceed To Checkout
            12. Verify Address Details and Review Your Order
            13. Enter description in comment text area and click 'Place Order'
            14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            15. Click 'Pay and Confirm Order' button
            16. Verify success message 'Your order has been placed successfully!'
            17. Click 'Delete Account' button
            18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
            """)
    @Test(priority = 2, description = "Test Case 15: Place Order: Register before Checkout")
    public void RegisterBeforeCheckout_Test_TC15() {
        actions = new Actions(Driver.getDriver());
        rnd = new Random();
        faker = new Faker();
        checkoutPage = new CheckoutPage();
        //Test Case 15: Place Order: Register before Checkout
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Click 'Signup / Login' button
        clickSignUpLoginButton();

        //5. Fill all details in Signup and create account
        Map<String, String> registerInfo = register_fromLoginPage();
        handleGoogleVignette(() -> Driver.getDriver().navigate().refresh());

        //7. Verify ' Logged in as username' at top
        verifyLoggedInAsUsername(registerInfo.get("userName"));

        //8. Add products to cart
        addSomeProductsToCart(2);

        //9. Click 'Cart' button
        clickCartButton();

        //10. Verify that cart page is displayed
        verifyCartPageIsDisplayed();

        //11. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //12. Verify Address Details and Review Your Order
        verifyAdressDetailsAndReviewOrder();

        //13. Enter description in comment text area and click 'Place Order'
        checkoutPage.comment_TextBox.sendKeys(randomParagraph(50));
        checkoutPage.placeOrder_Button.click();
        handleGoogleVignette(() -> checkoutPage.placeOrder_Button.click());

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        enterPaymentDetails();

        //15. Click 'Pay and Confirm Order' button
        checkoutPage.payAndConfirmOrder_Button.click();

        //16. Verify success message 'Your order has been placed successfully!'
        verifySuccessMsgOrderPlacedSuccessfully();

        //17. Click 'Delete Account' button
        deleteUserAndVerifyAccDeleted();

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        handleGoogleVignette(() -> checkoutPage.continueafterDeleted_Button.click());
    }

    @Description("""
            Test Case 16: Place Order: Login before Checkout
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'Signup / Login' button
            5. Fill email, password and click 'Login' button
            6. Verify 'Logged in as username' at top
            7. Add products to cart
            8. Click 'Cart' button
            9. Verify that cart page is displayed
            10. Click Proceed To Checkout
            11. Verify Address Details and Review Your Order
            12. Enter description in comment text area and click 'Place Order'
            13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            14. Click 'Pay and Confirm Order' button
            15. Verify success message 'Your order has been placed successfully!'
            16. Click 'Delete Account' button
            17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
            """)
    @Test(priority = 3, dependsOnMethods = "registerAndLogout", description = "Test Case 16: Place Order: Login before Checkout")
    public void LoginBeforeCheckout_Test_TC16() {

        actions = new Actions(Driver.getDriver());
        rnd = new Random();
        faker = new Faker();
        checkoutPage = new CheckoutPage();
        //Test Case 16: Place Order: Login before Checkout
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click 'Signup / Login' button
        clickSignUpLoginButton();
        //5. Fill email, password and click 'Login' button
        login_fromLoginPage(registerInfo.get("email"), registerInfo.get("password"));

        //6. Verify 'Logged in as username' at top
        verifyLoggedInAsUsername(registerInfo.get("userName"));

        //7. Add products to cart
        addSomeProductsToCart(2);

        //8. Click 'Cart' button
        clickCartButton();

        //9. Verify that cart page is displayed
        verifyCartPageIsDisplayed();

        //10. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //11. Verify Address Details and Review Your Order
        verifyAdressDetailsAndReviewOrder();

        //12. Enter description in comment text area and click 'Place Order'
        checkoutPage.comment_TextBox.sendKeys(randomParagraph(50));
        checkoutPage.placeOrder_Button.click();
        handleGoogleVignette(() -> checkoutPage.placeOrder_Button.click());

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        enterPaymentDetails();

        //14. Click 'Pay and Confirm Order' button
        checkoutPage.payAndConfirmOrder_Button.click();

        //15. Verify success message 'Your order has been placed successfully!'
        verifySuccessMsgOrderPlacedSuccessfully();

        //16. Click 'Delete Account' button
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        deleteUserAndVerifyAccDeleted();
        handleGoogleVignette(() -> checkoutPage.continueafterDeleted_Button.click());
    }

    Random rndNumber;

    @Description("""
            Test Case 23: Verify address details in checkout page
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'Signup / Login' button
            5. Fill all details in Signup and create account
            6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            7. Verify ' Logged in as username' at top
            8. Add products to cart
            9. Click 'Cart' button
            10. Verify that cart page is displayed
            11. Click Proceed To Checkout
            12. Verify that the delivery address is same address filled at the time registration of account
            13. Verify that the billing address is same address filled at the time registration of account
            14. Click 'Delete Account' button
            15. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
    @Test(priority = 4, description = "Test Case 23: Verify address details in checkout page")
    public void verifyAddressDetailsInCheckoutPage_TC23() {
        checkoutPage = new CheckoutPage();
        //Test Case 23: Verify address details in checkout page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Click 'Signup / Login' button
        clickSignUpLoginButton();

        //5. Fill all details in Signup and create account
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Map<String, String> infoRegister = register_fromLoginPage();

        //7. Verify ' Logged in as username' at top
        verifyLoggedInAsUsername(infoRegister.get("userName"));

        //8. Add products to cart
        addSomeProductsToCart(1);
        //9. Click 'Cart' button
        clickCartButton();

        //10. Verify that cart page is displayed
        verifyCartPageIsDisplayed();

        //11. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //12. Verify that the delivery address is same address filled at the time registration of account
        verifyDeliveryAdressSameWithRegistrationOfAccount(infoRegister);

        //13. Verify that the billing address is same address filled at the time registration of account
        verifyBillingAdressSameWithRegistrationOfAccount(infoRegister);

        //14. Click 'Delete Account' button
        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        deleteUserAndVerifyAccDeleted();
    }

    @Description("""
            Test Case 24: Download Invoice after purchase order
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Add products to cart
            5. Click 'Cart' button
            6. Verify that cart page is displayed
            7. Click Proceed To Checkout
            8. Click 'Register / Login' button
            9. Fill all details in Signup and create account
            10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            11. Verify ' Logged in as username' at top
            12.Click 'Cart' button
            13. Click 'Proceed To Checkout' button
            14. Verify Address Details and Review Your Order
            15. Enter description in comment text area and click 'Place Order'
            16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            17. Click 'Pay and Confirm Order' button
            18. Verify success message 'Your order has been placed successfully!'
            19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
            20. Click 'Continue' button
            21. Click 'Delete Account' button
            22. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
    @Test(priority = 5, description = "Test Case 24: Download Invoice after purchase order")
    public void downloadInvoiceAfterPurchaseOrder() throws IOException {
        checkoutPage = new CheckoutPage();
        faker = new Faker();
        //Test Case 24: Download Invoice after purchase order
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Add products to cart
        addSomeProductsToCart(1);
        //5. Click 'Cart' button
        clickCartButton();

        //6. Verify that cart page is displayed
        verifyCartPageIsDisplayed();

        //7. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //8. Click 'Register / Login' button
        checkoutPage.registerLoginOnPopUp_Button.click();

        //9. Fill all details in Signup and create account
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Map<String, String> infoRegister = register_fromLoginPage();

        //11. Verify ' Logged in as username' at top
        verifyLoggedInAsUsername(infoRegister.get("userName"));

        //12.Click 'Cart' button
        clickCartButton();

        //13. Click 'Proceed To Checkout' button
        checkoutPage.proceedToCheckout_Button.click();

        //14. Verify Address Details and Review Your Order
        verifyAdressDetailsAndReviewOrder();

        //15. Enter description in comment text area and click 'Place Order'
        checkoutPage.comment_TextBox.sendKeys(randomParagraph(40));
        checkoutPage.placeOrder_Button.click();

        handleGoogleVignette(new Runnable() {
            @Override
            public void run() {
                checkoutPage.comment_TextBox.sendKeys(randomParagraph(40));
                checkoutPage.placeOrder_Button.click();
            }
        });

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        enterPaymentDetails();

        //17. Click 'Pay and Confirm Order' button
        checkoutPage.payAndConfirmOrder_Button.click();

        //18. Verify success message 'Your order has been placed successfully!'
        verifySuccessMsgOrderPlacedSuccessfully();

        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        checkoutPage.downloadInvoice_Button.click();
        verifyInvoiceIsDownloaded();

        //20. Click 'Continue' button
        checkoutPage.continue_button.click();

        //21. Click 'Delete Account' button
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        deleteUserAndVerifyAccDeleted();
    }

    @Test()
    public void registerAndLogout() {
        clickSignUpLoginButton();
        registerInfo = register_fromLoginPage();
        logoutUser();
    }
}
