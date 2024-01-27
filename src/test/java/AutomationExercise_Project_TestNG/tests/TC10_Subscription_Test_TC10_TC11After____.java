package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.SubscriptionPage;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.randomEmail;
import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.scrollIntoViewByJavaScript;

public class TC10_Subscription_Test_TC10_TC11After____ extends TestBaseBeforeAfterMethod {

    //Test Case 10: Verify Subscription in home page
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible
    SubscriptionPage subscriptionPage;

    @Test(priority = 0)
    public void verifySubscriptionInHomePage_TC10(){
        //Test Case-10 VERIFYING SUBSCRIPTION ON FOOTER IN HOMEPAGE
        subscriptionPage = new SubscriptionPage();

        //Test Case 10: Verify Subscription in home page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Scroll down to footer
        scrollIntoViewByJavaScript(subscriptionPage.footer_subscription);

        //5. Verify text 'SUBSCRIPTION'
        Assert.assertEquals(subscriptionPage.subscription_text.getText().toLowerCase()
                ,"SUBSCRIPTION".toLowerCase(),
                "SUBSCRIPTION text is not displayed");

        //6. Enter email address in input and click arrow button
        subscriptionPage.subscriptionMail_TextBox.sendKeys(randomEmail(5));
        subscriptionPage.subscribe_button.click();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(subscriptionPage.subscribedMsg_text.isDisplayed()
                ,"You have been successfully subscribed! message is not displayed");
    }


    //Test Case 11: Verify Subscription in Cart page
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'Cart' button
    //5. Scroll down to footer
    //6. Verify text 'SUBSCRIPTION'
    //7. Enter email address in input and click arrow button
    //8. Verify success message 'You have been successfully subscribed!' is visible

    @Test(priority = 1)
    public void verifySubscriptionInCartPage_TC11(){
        //Test Case-11  VERIFYING SUBSCRIPTION ON FOOTER IN CART PAGE
        subscriptionPage = new SubscriptionPage();

        //Test Case 11: Verify Subscription in Cart page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Click 'Cart' button
        subscriptionPage.cart_Button.click();
        //5. Scroll down to footer
        scrollIntoViewByJavaScript(subscriptionPage.footer_subscription);

        //6. Verify text 'SUBSCRIPTION'
        Assert.assertEquals(subscriptionPage.subscription_text.getText().toLowerCase()
                ,"SUBSCRIPTION".toLowerCase(),
                "SUBSCRIPTION text is not displayed");

        //7. Enter email address in input and click arrow button
        subscriptionPage.subscriptionMail_TextBox.sendKeys(randomEmail(5));
        subscriptionPage.subscribe_button.click();

        //8. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(subscriptionPage.subscribedMsg_text.isDisplayed()
                ,"You have been successfully subscribed! message is not displayed");
    }
}
