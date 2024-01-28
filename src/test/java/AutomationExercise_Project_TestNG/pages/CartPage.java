package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath="//li[3]/a[@href='/view_cart']")
    public WebElement cart_Button;

    @FindBy(xpath="//img[@src='/get_product_picture/1']")
    public WebElement first_product;

    @FindBy(xpath="//img[@src='/get_product_picture/2']")
    public WebElement second_product;

    @FindBy(xpath="(//a[@data-product-id='1'])[1]")
    public WebElement addToCart_firstProduct_Button;

    @FindBy(xpath="(//a[@data-product-id='2'])[1]")
    public WebElement addToCart_secondProduct_Button;

    @FindBy(xpath="//button[contains(.,'Continue Shopping')]")
    public WebElement continueShopping_Button;

    @FindBy(xpath="//*[@href='/view_cart' and contains(.,'iew Cart')]")
    public WebElement viewCart_Button;

    @FindBy(xpath="//*[@id='cart_info']")
    public List<WebElement> addedProductsToCart;


    @FindBy(xpath = "//*[text()='View Product']")
    public List<WebElement> viewProduct_Buttons;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productName_Text;

    @FindBy(xpath = "//li[2]")
    public WebElement products_Button;

    @FindBy(xpath = "//*[@class='product-information']")
    public WebElement productsAllInfo_Text;

    @FindBy(xpath = "//*[@href='/product_details/1']")
    public WebElement firstProductInCart_name;

    @FindBy(xpath = "//tbody/tr[1]/td[@class='cart_price']")
    public WebElement firstProductInCart_price;

    @FindBy(xpath = "//tbody/tr[1]/td[@class='cart_quantity']")
    public WebElement firstProductInCart_quantity;

    @FindBy(xpath = "//tbody/tr[1]/td[@class='cart_total']")
    public WebElement firstProductInCart_totalPrice;


    @FindBy(xpath = "//*[@href='/product_details/2']")
    public WebElement secondProductInCart_name;

    @FindBy(xpath = "//tbody/tr[2]/td[@class='cart_price']")
    public WebElement secondProductInCart_price;

    @FindBy(xpath = "//tbody/tr[2]/td[@class='cart_quantity']")
    public WebElement secondProductInCart_quantity;

    @FindBy(xpath = "//tbody/tr[2]/td[@class='cart_total']")
    public WebElement secondProductInCart_totalPrice;


    @FindBy(id = "quantity")
    public WebElement quantityNumber;

    @FindBy(xpath = "//*[@class='btn btn-default cart']")
    public WebElement addToCart_Button;

    @FindBy(xpath="//ol[@class='breadcrumb']")
    public WebElement shoppingCart_text;

    @FindBy(xpath="//*[@class='cart_quantity_delete']")
    public List<WebElement> xButton_List;

    @FindBy(xpath="//*[@class='cart_description']")
    public List<WebElement> product_description;

    @FindBy (xpath = "//*[@class='col-sm-4']/*[@class='product-image-wrapper']")
    public List<WebElement> allProductsInProductsPage_list;

    @FindBy(xpath = "//*[@class='title text-center']")
    public WebElement titleInTheCenterOfPage_Text;

      @FindBy(id = "search_product")
    public WebElement searchProduct_TextBox;

    @FindBy(id = "submit_search")
    public WebElement searchSubmit_Button;

    @FindBy (xpath = "//p[contains(.,'Category:')]")
    public WebElement categoryOfTheProduct;

    @FindBy(xpath = "//div[@class='productinfo text-center']//*[@class='btn btn-default add-to-cart']")
    public List<WebElement> addProductsButtons_List;

    @FindBy (xpath = "//div[@class='product-information']")
    public WebElement ProductsAllInfo;

    @FindBy (xpath = "//li[4]")
    public WebElement signUpLoginButton;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement emailAdress_LoginPage_TextBox;

    @FindBy(xpath = "//*[@data-qa='login-password']")
    public WebElement password_LoginPage_TextBox;


    @FindBy(xpath = "//*[@data-qa='login-button']")
    public WebElement login_button;

    @FindBy(xpath = "//*[@href='/logout']")
    public WebElement logout_button;

    @FindBy(xpath = "//*[@class='title text-center' and contains(.,'recommended items')]")
    public WebElement recommendedItems_Text;

    @FindBy(xpath = "//div[@class='recommended_items']//a[@class='btn btn-default add-to-cart']")
    public List<WebElement> addToCart_inRecommendedItems_Button;

    @FindBy (xpath = "//div[@class='recommended_items']//p")
    public List<WebElement> productNamesInRecommendedItems_List;
//css ile
    //  .recommended_items p

    @FindBy (xpath = "//*[@class='cart_description']//a")
    public List<WebElement> productNamesInCart_List;

    @FindBy (xpath = "//div[@class='productinfo text-center']/p")
    public List<WebElement> productsNameInSearchPage_List;


}
