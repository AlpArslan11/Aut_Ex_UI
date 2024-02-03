package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='slider-carousel']")
    public WebElement adsOfHomepage;

    @FindBy(xpath="//li[3]/a[@href='/view_cart']")
    public WebElement cart_Button;

    @FindBy(xpath= "//*[@class='fa fa-lock']")
    public WebElement signUpLogin_Button;

}
