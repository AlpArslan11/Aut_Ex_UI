package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrandPage {
    public BrandPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy( xpath= "//li[2]/a[@href='/products']")
    public WebElement products_Button;

    @FindBy(xpath = "//div[@class='brands_products']//*[text()='Brands']")
    public WebElement brandsTitle_text;

    @FindBy(xpath = "//div[@class='brands_products']//li")
    public List<WebElement> brands_list;

    @FindBy(xpath = "//*[@class='title text-center']")
    public WebElement titleInTheCenterOfPage_Text;

    @FindBy (xpath = "//div[@class='col-sm-4']//div[@class='productinfo text-center']")
    public List<WebElement> brandProducts_List;











}
