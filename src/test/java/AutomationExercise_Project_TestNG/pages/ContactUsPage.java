package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    public ContactUsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//*[@id='slider-carousel']")
    public WebElement adsOfHomepage;

    @FindBy(xpath = "//*[contains(text(),'Contact us')]")
    public WebElement containsUs_button;

    @FindBy (xpath = "//*[text()='Get In Touch']")
    public WebElement getInTouch_text;

    @FindBy (xpath = "//*[@name='name' or @placeholder='Name']")
    public WebElement name_textbox;

    @FindBy (xpath = "//*[@name='email' or @placeholder='Email']")
    public WebElement email_textbox;

    @FindBy (xpath = "//*[@name='subject' or @placeholder='Subject']")
    public WebElement subject_textbox;

    @FindBy (xpath = "//*[@id='message' or @placeholder='Your Message Here']")
    public WebElement message_textbox;

    @FindBy (xpath = "//*[@type='file' or name='upload_file']")
    public WebElement uploadFile_button;

    @FindBy (xpath = "//*[@class='btn btn-primary pull-left submit_form' or type='submit' ]")
    public WebElement submit_button;

    @FindBy (xpath = "//*[@class='status alert alert-success']")
    public WebElement alertStatus_text;

    @FindBy (xpath = "//a[@href='/']//*[@class='fa fa-home']")
    public WebElement home_button;

}
