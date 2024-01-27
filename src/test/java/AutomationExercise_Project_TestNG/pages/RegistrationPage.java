package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//*[@id='slider-carousel']")
    public WebElement adsOfHomepage;

    @FindBy (xpath = "//li[4]")
    public WebElement signUpLoginButton;

    @FindBy(xpath = "//*[.='New User Signup!']")
    public WebElement signUpText;

    //-----------------------------------------


    @FindBy (css = "#first_name")
    public WebElement signingFirstName;

    @FindBy(xpath = "//*[@type='text' and @data-qa='signup-name']")
    public WebElement userName_NameTextbox;
//---------------------------------------
    @FindBy (xpath = "//*[@data-qa='signup-email']")
    public WebElement signUpEmailAddress_textbox;

    @FindBy (xpath ="//*[@type='submit' and text()='Signup']")
    public WebElement signUpButton;

    @FindBy(xpath = "//*[contains(text(),'Account Information')]")
    public WebElement enterAccInfoText;

    @FindBy (css = "#id_gender1")
    public WebElement mr_radioButton;

    @FindBy (css = "#name")
    public WebElement name_textbox;

    @FindBy (css = "#email")
    public WebElement email_textBox;

    @FindBy (css = "#password")
    public WebElement password_textBox;

    @FindBy(css = "#days")
    public WebElement day_ddm;

    @FindBy(css = "#months")
    public WebElement month_ddm;

    @FindBy(css = "#years")
    public WebElement years_ddm;

    @FindBy(xpath = "//label[@for='newsletter']")
    public WebElement newsletter_checkbox;

    @FindBy(xpath = "//label[@for='optin']")
    public WebElement specialOffers_checkbox;

    @FindBy(css = "#first_name")
    public WebElement firstName_textBox;

    @FindBy(css = "#last_name")
    public WebElement lastName_textBox;

    @FindBy(css = "#company")
    public WebElement company_textBox;

    @FindBy(css = "#address1")
    public WebElement address1_textBox;

    @FindBy(css = "#address2")
    public WebElement address2_textBox;

    @FindBy(css = "#country")
    public WebElement country_ddm;

    @FindBy(css ="#state")
    public WebElement state_textBox;

    @FindBy(css ="#city")
    public WebElement city_textBox;

    @FindBy(css ="#zipcode")
    public WebElement zipcode_textBox;

    @FindBy(css ="#mobile_number")
    public WebElement mobileNumber_textBox;

    @FindBy(xpath = "//*[@type='submit' and .='Create Account']")
    public WebElement createAccount_button;

    @FindBy(xpath = "//h2[.='Account Created!']")
    public WebElement accCreated_text;

    @FindBy(xpath = "//a[@href='/' and .='Continue']")
    public WebElement continue_button;

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedIn_text;

    @FindBy(xpath = "//*[contains(text(),' Delete Account')]")
    public WebElement deleteAcc_button;

    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    public WebElement accDeleted_text;

    @FindBy(xpath ="//li[10]/a" )
    public WebElement loggedInAsUsername_text;

    @FindBy(xpath ="//*[@data-qa='continue-button']" )
    public WebElement continueButton;

    @FindBy(xpath = "//*[contains(.,'Logout') and @href='/logout' ]")
    public WebElement logout_button;


    @FindBy(xpath = "//*[contains(text(),'Email Address already exist')]")
    public WebElement emailAlreadyExists_text;













}
