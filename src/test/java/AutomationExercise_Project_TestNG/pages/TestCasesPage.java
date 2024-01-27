package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

    public TestCasesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[text()=' Test Cases' and @href=\"/test_cases\"]")
    public WebElement testCases_button;

    @FindBy (xpath = "//*[@id='slider-carousel']")
    public WebElement adsOfHomepage;

    @FindBy (xpath ="//*[text()='Test Cases']")
    public WebElement testCases_text;




}
