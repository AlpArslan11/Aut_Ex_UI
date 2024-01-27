package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Category_Pages {

    public Category_Pages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//*[@href='#Women']//*[@class='badge pull-right']")
    public WebElement womenCategory_Button;

    @FindBy(xpath = "//*[@id='Women']//li/a")
    public List<WebElement> categoriesUnderWomen_List;

    @FindBy(xpath = "//*[@class='title text-center']")
    public WebElement titleInTheCenterOfPage_Text;

    @FindBy(xpath = "//*[@id='Men']//li/a")
    public List<WebElement> categoriesUnderMen_List;


    @FindBy(xpath = "//*[@href='#Men']//*[@class='badge pull-right']")
    public WebElement menCategory_Button;














}
