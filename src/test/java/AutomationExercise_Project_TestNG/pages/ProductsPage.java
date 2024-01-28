package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
      public ProductsPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@id='slider-carousel']")
    public WebElement adsOfHomepage;

    @FindBy (xpath = "//li[2]/*[text()=' Products']")
    public WebElement products_button;

    @FindBy (xpath = "//*[@href='/products' and contains(.,'Products') ]")
    public WebElement products_Button;

    @FindBy(xpath = "//*[text()='All Products']")
    public WebElement allProducts_text;

    @FindBy(xpath = "//*[@class='productinfo text-center']")
    public List<WebElement> products_list;

    @FindBy(xpath = "//*[@href='/product_details/1']")
    public WebElement viewFirstProduct;

    @FindBy(xpath = "//*[@class='productinfo text-center']")
    public List<WebElement> allProducts_list;

    @FindBy(xpath = "//*[@class='col-sm-7']")
    public WebElement firstProductInfo_text;

    @FindBy(xpath = "//p[contains(.,':')]")
    public List<WebElement> detailsOfProducts_list;

    @FindBy(xpath = "//*[@id='search_product']")
    public WebElement searchProduct_Textbox;

    @FindBy(xpath = "//*[@id='submit_search']")
    public WebElement searchProduct_Button;

    @FindBy(xpath = "//*[text()='View Product']")
    public List<WebElement> viewProduct_Buttons;

    @FindBy (xpath = "//p[contains(.,'Category:')]")
    public WebElement categoryOfTheProduct;

    @FindBy (xpath = "//div[@class='col-sm-4']//div[@class='productinfo text-center']")
    public List<WebElement> searchedProducts_list;

    @FindBy (xpath = "//*[@class='title text-center']")
    public WebElement searchedProducts_text;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productName_Text;

    @FindBy (id = "review")
    public WebElement review_TextBox;

    @FindBy (id = "name")
    public WebElement name_TextBox;

    @FindBy (id = "email")
    public WebElement emailAddress_TextBox;

    @FindBy (id = "button-review")
    public WebElement reviewSubmit_Button;

    @FindBy(xpath = "//*[text()='Thank you for your review.']")
    public WebElement successMsg;

    @FindBy(id = "review-section")
    public WebElement successMsg_text;

    @FindBy(xpath = "//*[@class='product-information']")
    public WebElement productsAllInfo_Text;

















}
