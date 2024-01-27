package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage {

    public SubscriptionPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id='slider-carousel']")
    public WebElement adsOfHomepage;


    @FindBy(css = ".single-widget")
    public WebElement footer_subscription;

    @FindBy(xpath = "//div[@class='single-widget']//*[contains(.,'ubscription')]")
    public WebElement subscription_text;

    @FindBy(xpath = "//*[@id='susbscribe_email']")
    public WebElement subscriptionMail_TextBox;

    @FindBy(xpath = "//button[@type='submit' and contains(@id,'subscribe')]")
    public WebElement subscribe_button;
    @FindBy(id = "success-subscribe")
    public WebElement subscribedMsg_text;


    @FindBy(xpath="//li[3]/a[@href='/view_cart']")
    public WebElement cart_Button;











}
