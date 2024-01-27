package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Functions_Page {

    public Functions_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".single-widget")
    public WebElement footer_subscription;

    @FindBy(xpath = "//div[@class='single-widget']//*[contains(.,'ubscription')]")
    public WebElement subscription_text;

    @FindBy (id="scrollUp")
    public WebElement scroolUp_Button;

    @FindBy (xpath = "//*[@src='/static/images/home/logo.png']")
    public WebElement homepageLogo;

    @FindBy (xpath="//h2[contains(.,'practice website for Automation Engineers')]")
    public WebElement fullFledgedPractice_Text;



}
