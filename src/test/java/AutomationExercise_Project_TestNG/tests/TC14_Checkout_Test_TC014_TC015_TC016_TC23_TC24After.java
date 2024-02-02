package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.CheckoutPage;
import AutomationExercise_Project_TestNG.pages.LoginPage;
import AutomationExercise_Project_TestNG.pages.ProductsPage;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;
import static org.apache.commons.lang3.RandomStringUtils.random;

public class TC14_Checkout_Test_TC014_TC015_TC016_TC23_TC24After extends TestBaseBeforeAfterMethod {

    Actions actions;
    CheckoutPage checkoutPage;
    Random rnd;
    Select select;
    Faker faker;
    String name;
    String email;
    String actualText;
    String expectedText;


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
            12.Click 'Cart' button
            13. Click 'Proceed To Checkout' button
            14. Verify Address Details and Review Your Order
            15. Enter description in comment text area and click 'Place Order'
            16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            17. Click 'Pay and Confirm Order' button
            18. Verify success message 'Your order has been placed successfully!'
            19. Click 'Delete Account' button
            20. Verify 'ACCOUNT DELETED!' and click 'Continue' button """)
    @Test(priority = 0, description = "Test Case 14: Place Order: Register while Checkout")
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
        Assert.assertTrue(checkoutPage.addressDetails_Text.isDisplayed(), "Address Details title isn't displayed");

        //15. Enter description in comment text area and click 'Place Order'
        checkoutPage.comment_TextBox.sendKeys(randomParagraph(50));
        checkoutPage.placeOrder_Button.click();
        handleGoogleVignette(() -> checkoutPage.placeOrder_Button.click());

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        enterPaymentDetails();

        //17. Click 'Pay and Confirm Order' button
        checkoutPage.payAndConfirmOrder_Button.click();

        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(checkoutPage.successMsg_Text.isDisplayed()
                , "Congratulations! Your order has been confirmed! texti goruntulenmiyor");

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
    @Test(priority = 1, description = "Test Case 15: Place Order: Register before Checkout")
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
        checkoutPage.signUpLogin_Button.click();

        //5. Fill all details in Signup and create account
        name = randomName(5);
        email = randomEmail(5);
        System.out.println("name --> " + name);
        System.out.println("mail --> " + email);
        checkoutPage.name_TextBox.sendKeys(name);
        checkoutPage.emailAddress_TextBox.sendKeys(email);
        checkoutPage.signUp_Button.click();
        checkoutPage.genderMr_RadioButton.click();

        String password = randomPassWord(5);
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(password).build().perform();

        select = new Select(checkoutPage.day_Ddm);
        select.selectByValue(String.valueOf(rnd.nextInt(1, 32)));

        select = new Select(checkoutPage.months_Ddm);
        select.selectByValue(String.valueOf(rnd.nextInt(1, 13)));

        select = new Select(checkoutPage.years_Ddm);
        select.selectByValue(String.valueOf(rnd.nextInt(1900, 2021)));

        checkoutPage.newsletter_RadioButton.click();
        checkoutPage.specialOffer_RadioButton.click();

        actions.sendKeys(Keys.TAB)
                .sendKeys(name)
                .sendKeys(Keys.TAB, random(7, true, false))
                .sendKeys(Keys.TAB, random(4, true, false) + " " + random(3, true, false))
                .sendKeys(Keys.TAB, faker.address().fullAddress())
                .sendKeys(Keys.TAB, faker.address().city(), Keys.TAB)
                .build().perform();

        select = new Select(checkoutPage.country_Ddm);
        select.selectByIndex(rnd.nextInt(0, 7));

        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .build().perform();

        checkoutPage.createAccount_Button.click();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        actualText = checkoutPage.accountCreated_text.getText().toLowerCase();
        expectedText = "ACCOUNT CREATED";
        System.out.println("-----Account Created------");
        Assert.assertTrue(actualText.contains(expectedText.toLowerCase()), "ACCOUNT CREATED yazısı goruntulenmedi");

        checkoutPage.continue_button.click();

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            checkoutPage.continue_button.click();
        }

        //7. Verify ' Logged in as username' at top
        System.out.println(checkoutPage.loggedIn_Text.getText());
        Assert.assertTrue(checkoutPage.loggedIn_Text.isDisplayed(), "Logged in as Username yazısı görüntülenmedi");
        Assert.assertTrue(checkoutPage.loggedIn_Text.getText().contains(name)
                , "' Logged in as username' text is not displayed or doesnt contain the registered name");

        //8. Add products to cart
        checkoutPage.firstProductAddToCart_Button.click();
        checkoutPage.continueShopping_Button.click();

        checkoutPage.secondProductAddToCart_Button.click();
        checkoutPage.continueShopping_Button.click();

        //9. Click 'Cart' button

        clickCartButton();

        //10. Verify that cart page is displayed
        Assert.assertTrue(checkoutPage.shoppingCart_text.getText().toLowerCase().contains("shopping cart"), "Cart Page isnt displayed");

        //11. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //12. Verify Address Details and Review Your Order
        Assert.assertTrue(checkoutPage.addressDetails_Text.isDisplayed(), "Address Details title isn't displayed");

        //13. Enter description in comment text area and click 'Place Order'
        checkoutPage.comment_TextBox.sendKeys(randomParagraph(50));
        checkoutPage.placeOrder_Button.click();

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        checkoutPage.nameOnCard_TextBox.sendKeys(name);
        checkoutPage.cardNumber_TextBox.sendKeys(faker.business().creditCardNumber());
        checkoutPage.cvc_TextBox.sendKeys(faker.number().digits(3));
        checkoutPage.expiration_TextBox.sendKeys(dateMonth());
        checkoutPage.expirationYear_TextBox.sendKeys(dateYear());

        //15. Click 'Pay and Confirm Order' button
        checkoutPage.payAndConfirmOrder_Button.click();

        //16. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(checkoutPage.successMsg_Text.isDisplayed()
                , "Congratulations! Your order has been confirmed! texti goruntulenmiyor");

        //17. Click 'Delete Account' button
        checkoutPage.deleteAccount_Button.click();

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        actualText = checkoutPage.accountDeleted_text.getText();
        System.out.println(actualText);
        expectedText = "ACCOUNT DELETED";
        Assert.assertTrue(actualText.contains(expectedText), "Delete Account yazısı goruntulenmedi");

        checkoutPage.continueafterDeleted_Button.click();

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            checkoutPage.continueafterDeleted_Button.click();
        }


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
    @Test(priority = 2, description = "Test Case 16: Place Order: Login before Checkout")
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
        checkoutPage.signUpLogin_Button.click();

        //5. Fill email, password and click 'Login' button
        name = randomName(5);
        email = randomEmail(5);
        System.out.println("name --> " + name);
        System.out.println("mail --> " + email);
        checkoutPage.name_TextBox.sendKeys(name);
        checkoutPage.emailAddress_TextBox.sendKeys(email);
        checkoutPage.signUp_Button.click();
        checkoutPage.genderMr_RadioButton.click();

        String password = randomPassWord(5);
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(password).build().perform();

        select = new Select(checkoutPage.day_Ddm);
        select.selectByValue(String.valueOf(rnd.nextInt(1, 32)));

        select = new Select(checkoutPage.months_Ddm);
        select.selectByValue(String.valueOf(rnd.nextInt(1, 13)));

        select = new Select(checkoutPage.years_Ddm);
        select.selectByValue(String.valueOf(rnd.nextInt(1900, 2021)));

        checkoutPage.newsletter_RadioButton.click();
        checkoutPage.specialOffer_RadioButton.click();

        actions.sendKeys(Keys.TAB)
                .sendKeys(name)
                .sendKeys(Keys.TAB, random(7, true, false))
                .sendKeys(Keys.TAB, random(4, true, false) + " " + random(3, true, false))
                .sendKeys(Keys.TAB, faker.address().fullAddress())
                .sendKeys(Keys.TAB, faker.address().city(), Keys.TAB)
                .build().perform();

        select = new Select(checkoutPage.country_Ddm);
        select.selectByIndex(rnd.nextInt(0, 7));

        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .build().perform();

        checkoutPage.createAccount_Button.click();

        checkoutPage.continue_button.click();

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            checkoutPage.continue_button.click();
        }

        //6. Verify 'Logged in as username' at top
        System.out.println(checkoutPage.loggedIn_Text.getText());
        Assert.assertTrue(checkoutPage.loggedIn_Text.isDisplayed(), "Logged in as Username yazısı görüntülenmedi");
        Assert.assertTrue(checkoutPage.loggedIn_Text.getText().contains(name)
                , "' Logged in as username' text is not displayed or doesnt contain the registered name");


        //7. Add products to cart
        checkoutPage.firstProductAddToCart_Button.click();
        checkoutPage.continueShopping_Button.click();

        checkoutPage.secondProductAddToCart_Button.click();
        checkoutPage.continueShopping_Button.click();

        //8. Click 'Cart' button
        clickCartButton();

        //9. Verify that cart page is displayed
        Assert.assertTrue(checkoutPage.shoppingCart_text.getText().toLowerCase().contains("shopping cart"), "Cart Page isnt displayed");

        //10. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //11. Verify Address Details and Review Your Order
        Assert.assertTrue(checkoutPage.addressDetails_Text.isDisplayed(), "Address Details title isn't displayed");

        //12. Enter description in comment text area and click 'Place Order'
        checkoutPage.comment_TextBox.sendKeys(randomParagraph(50));
        checkoutPage.placeOrder_Button.click();

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        checkoutPage.nameOnCard_TextBox.sendKeys(name);
        checkoutPage.cardNumber_TextBox.sendKeys(faker.business().creditCardNumber());
        checkoutPage.cvc_TextBox.sendKeys(faker.number().digits(3));
        checkoutPage.expiration_TextBox.sendKeys(dateMonth());
        checkoutPage.expirationYear_TextBox.sendKeys(dateYear());

        //14. Click 'Pay and Confirm Order' button
        checkoutPage.payAndConfirmOrder_Button.click();

        //15. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(checkoutPage.successMsg_Text.isDisplayed()
                , "Congratulations! Your order has been confirmed! texti goruntulenmiyor");

        //16. Click 'Delete Account' button
        checkoutPage.deleteAccount_Button.click();

        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        actualText = checkoutPage.accountDeleted_text.getText();
        System.out.println(actualText);
        expectedText = "ACCOUNT DELETED";
        Assert.assertTrue(actualText.contains(expectedText), "Delete Account yazısı goruntulenmedi");

        checkoutPage.continueafterDeleted_Button.click();

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            checkoutPage.continueafterDeleted_Button.click();
        }


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
    @Test(priority = 3, description = "Test Case 23: Verify address details in checkout page")
    public void verifyAddressDetailsInCheckoutPage_TC23() {
        checkoutPage = new CheckoutPage();
        //Test Case 23: Verify address details in checkout page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Click 'Signup / Login' button
        checkoutPage.signUpLogin_Button.click();

        //5. Fill all details in Signup and create account
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Map<String, String> infoRegister = register_fromLoginPage();
        name = infoRegister.get("name");

        //7. Verify ' Logged in as username' at top
        Assert.assertEquals(name, checkoutPage.loggedInUserName_Text.getText().trim(), "Logged username is not verified");

        //8. Add products to cart
        //9. Click 'Cart' button
        clickCartButton();
        List<WebElement> addToCartButtonList = checkoutPage.addToCart_ButtonList;
        rndNumber = new Random();
        for (int i = 0; i < 3; i++) {
            addToCartButtonList.get(rndNumber.nextInt(0, addToCartButtonList.size())).click();
            waitForVisibility(checkoutPage.viewCartOnPopUp_Button, 1000);
            if (i < 2) {
                checkoutPage.continueShoppingOnPopUp_Button.click();
            } else checkoutPage.viewCartOnPopUp_Button.click();
        }

        //10. Verify that cart page is displayed
        Assert.assertTrue(checkoutPage.shoppingCart_text.getText().toLowerCase().contains("shopping cart"), "Cart Page isnt displayed");

        //11. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //12. Verify that the delivery address is same address filled at the time registration of account


        List<String> addressInfoList = new ArrayList<>();
        addressInfoList.add(infoRegister.get("randomfirstName"));
        addressInfoList.add(infoRegister.get("randomLastName"));
        addressInfoList.add(infoRegister.get("fakerAdress"));
        addressInfoList.add(infoRegister.get("fakerAdressSecond"));
        addressInfoList.add(infoRegister.get("fakerCity"));
        addressInfoList.add(infoRegister.get("fakerState"));
        addressInfoList.add(infoRegister.get("fakerZipCode"));
        addressInfoList.add(infoRegister.get("ddmCountry"));
        addressInfoList.add(infoRegister.get("randomMobileNumber"));

        String deliveryAddress = checkoutPage.deliveryAddress_Text.getText();
        for (String s : addressInfoList
        ) {
            Assert.assertTrue(deliveryAddress.toLowerCase().contains(s.toLowerCase()), s + "info is not verified in delivery address");
        }

        //13. Verify that the billing address is same address filled at the time registration of account
        String billingAddress = checkoutPage.billingAddress_Text.getText();

        for (String s : addressInfoList
        ) {
            Assert.assertTrue(billingAddress.toLowerCase().contains(s.toLowerCase()), s + "info is not verified in billing address");
        }

        //14. Click 'Delete Account' button
        checkoutPage.deleteAccount_Button.click();

        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(checkoutPage.accountDeleted_text.isDisplayed(), "ACCOUNT DELETED! text is not verified.");
        checkoutPage.continue_button.click();

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
    @Test(priority = 4, description = "Test Case 24: Download Invoice after purchase order")
    public void downloadInvoiceAfterPurchaseOrder() {
        checkoutPage = new CheckoutPage();
        faker = new Faker();
        //Test Case 24: Download Invoice after purchase order
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Add products to cart
        //5. Click 'Cart' button
        clickCartButton();
        List<WebElement> addToCartButtonList = checkoutPage.addToCart_ButtonList;
        rndNumber = new Random();
        for (int i = 0; i < 3; i++) {
            addToCartButtonList.get(rndNumber.nextInt(0, addToCartButtonList.size())).click();
            waitForVisibility(checkoutPage.viewCartOnPopUp_Button, 1000);
            if (i < 2) {
                checkoutPage.continueShoppingOnPopUp_Button.click();
            } else checkoutPage.viewCartOnPopUp_Button.click();
        }

        //6. Verify that cart page is displayed
        Assert.assertTrue(checkoutPage.shoppingCart_text.getText().toLowerCase().contains("shopping cart"), "Cart Page isnt displayed");

        //7. Click Proceed To Checkout
        checkoutPage.proceedToCheckout_Button.click();

        //8. Click 'Register / Login' button
        checkoutPage.registerLoginOnPopUp_Button.click();

        //9. Fill all details in Signup and create account
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Map<String, String> infoRegister = register_fromLoginPage();
        name = infoRegister.get("name");

        //11. Verify ' Logged in as username' at top
        Assert.assertEquals(name, checkoutPage.loggedInUserName_Text.getText().trim(), "Logged username is not verified");

        //12.Click 'Cart' button
        checkoutPage.cart_Button.click();

        //13. Click 'Proceed To Checkout' button
        checkoutPage.proceedToCheckout_Button.click();

        //14. Verify Address Details and Review Your Order
        Assert.assertTrue(checkoutPage.addressDetails_Text.isDisplayed(), "Address Details title isn't displayed");
        Assert.assertTrue(checkoutPage.productNamesInOrderPage_text.size() > 0, "Ordered products are not visible");

        //15. Enter description in comment text area and click 'Place Order'
        checkoutPage.comment_TextBox.sendKeys(randomParagraph(40));
        checkoutPage.placeOrder_Button.click();

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            checkoutPage.comment_TextBox.sendKeys(randomParagraph(40));
            checkoutPage.placeOrder_Button.click();
        }

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        checkoutPage.nameOnCard_TextBox.sendKeys(name);
        checkoutPage.cardNumber_TextBox.sendKeys(faker.business().creditCardNumber());
        checkoutPage.cvc_TextBox.sendKeys(faker.number().digits(3));
        checkoutPage.expiration_TextBox.sendKeys(dateMonth());
        checkoutPage.expirationYear_TextBox.sendKeys(dateYear());


        //17. Click 'Pay and Confirm Order' button
        checkoutPage.payAndConfirmOrder_Button.click();

        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(checkoutPage.successMsg_Text.isDisplayed()
                , "Congratulations! Your order has been confirmed! texti goruntulenmiyor");

        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        checkoutPage.downloadInvoice_Button.click();

        // Files.exists()
        String filePath = System.getProperty("user.home") + "/Downloads/invoice.txt"; //String filePath =System.getProperty("user.home")+"/Downloads/invoice.txt";
        Assert.assertTrue(Files.exists(Path.of(filePath)), "Downloaded file is not in it's place.");

        //20. Click 'Continue' button
        checkoutPage.continue_button.click();

        //21. Click 'Delete Account' button
        checkoutPage.deleteAccount_Button.click();

        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(checkoutPage.accountDeleted_text.isDisplayed(), "ACCOUNT DELETED! text is not verified.");
        checkoutPage.continue_button.click();

    }


}
