package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }






    @FindBy(xpath = "//*[@class='col-sm-12']")
    public WebElement homepage_ads;

    @FindBy(xpath = "//*[.=' Signup / Login']")
    public WebElement signUp_button;

    @FindBy(xpath = "//*[.='Login to your account']")
    public WebElement login_text;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement login_email;

    @FindBy (xpath = "//*[data-qa='login-password']")
    public WebElement login_password;

    @FindBy(xpath = "//*[.='Login']")
    public WebElement login_button;

    @FindBy (xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedIn_Text;

    @FindBy(xpath = "//*[.=' Delete Account' and @href='/delete_account']")
    public WebElement deleteAcc_button;

    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    public WebElement accDeleted_text;

    @FindBy(xpath ="//*[@data-qa='continue-button']" )
    public WebElement continue_Button;

    @FindBy(xpath ="//*[contains(.,'Your email or password is incorrect')]")
    public WebElement wrongCredentialsWarning_text;

    @FindBy(xpath = "//*[contains(.,'Logout') and @href='/logout']")
    public  WebElement logout_button;



}
