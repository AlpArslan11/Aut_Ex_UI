package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }





    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
    public WebElement firstProductAddToCart_Button;

    @FindBy(xpath = "(//a[@data-product-id='2'])[1]")
    public WebElement secondProductAddToCart_Button;




    @FindBy(xpath = "//*[text()='View Product']")
    public List<WebElement> addToCartButtons_List;

    @FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")
    public List<WebElement> featured_products;


    @FindBy(xpath = "(//div[@class='features_items']/div[@class='col-sm-4']//a[@data-product-id='5'])[2]")
    public List<WebElement> addToCart;

    @FindBy(xpath="//button[contains(.,'Continue Shopping')]")
    public WebElement continueShopping_Button;

    @FindBy(xpath="//li[3]")
    public WebElement cart_Button;

    @FindBy(xpath="//ol[@class='breadcrumb']")
    public WebElement shoppingCart_text;

    @FindBy(xpath="//*[@class='btn btn-default check_out']")
    public WebElement proceedToCheckout_Button;

    @FindBy(xpath="//*[text()='Register / Login']")
    public WebElement registerLoginOnPopUp_Button;

    @FindBy(xpath="//*[@data-qa='signup-name']")
    public WebElement name_TextBox;

    @FindBy(xpath="//*[@data-qa='signup-email']")
    public WebElement emailAddress_TextBox;

    @FindBy(xpath="//*[@data-qa='signup-button']")
    public WebElement signUp_Button;
    @FindBy(id="id_gender1")
    public WebElement genderMr_RadioButton;

    @FindBy(id="id_gender2")
    public WebElement genderMrs_RadioButton;

    @FindBy(id="days")
    public WebElement day_Ddm;

    @FindBy(id="months")
    public WebElement months_Ddm;

    @FindBy(id="years")
    public WebElement years_Ddm;

    @FindBy(id = "newsletter")
    public WebElement newsletter_RadioButton;

    @FindBy(id = "optin")
    public WebElement specialOffer_RadioButton;

    @FindBy(id = "country")
    public WebElement country_Ddm;

    @FindBy(xpath = "//*[@data-qa='create-account']")
    public WebElement createAccount_Button;

    @FindBy(xpath = "//h2[.='Account Created!']")
    public WebElement accountCreated_text;

    @FindBy(xpath = "//a[@href='/' and .='Continue']")
    public WebElement continue_button;

    @FindBy (xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedIn_Text;

    @FindBy (xpath = "//*[text()='Address Details']")
    public WebElement addressDetails_Text;

    @FindBy (xpath = "//*[@name='message']")
    public WebElement comment_TextBox;

    @FindBy (xpath = "//*[@class='btn btn-default check_out']")
    public WebElement placeOrder_Button;

    @FindBy (xpath = "//*[@name='name_on_card']")
    public WebElement nameOnCard_TextBox;

    @FindBy (xpath = "//*[@name='card_number']")
    public WebElement cardNumber_TextBox;

    @FindBy (xpath = "//*[@name='cvc']")
    public WebElement cvc_TextBox;

    @FindBy (xpath = "//*[@class='form-control card-expiry-month']")
    public WebElement expiration_TextBox;

    @FindBy (xpath = "//*[@name='expiry_year']")
    public WebElement expirationYear_TextBox;

    @FindBy (css = "#submit")
    public WebElement payAndConfirmOrder_Button;

    @FindBy (xpath = "//*[text()='Congratulations! Your order has been confirmed!']")
    public WebElement successMsg_Text;

    @FindBy(xpath = "//*[contains(text(),' Delete Account')]")
    public WebElement deleteAccount_Button;

    @FindBy(xpath = "//a[@href='/' and .='Continue']")
    public WebElement continueafterDeleted_Button;

    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    public WebElement accountDeleted_text;

    @FindBy(xpath= "//*[@class='fa fa-lock']")
    public WebElement signUpLogin_Button;

    @FindBy(xpath= "//*[text()=' Logged in as ']/b")
    public WebElement loggedInUserName_Text;

    @FindBy(xpath= "//div[@class='features_items']//div[@class='productinfo text-center']/a[@class='btn btn-default add-to-cart']")
    public List<WebElement> addToCart_ButtonList;

    @FindBy(xpath= "//*[@href='/view_cart']/*[.='View Cart']")
    public WebElement viewCartOnPopUp_Button;

    @FindBy(xpath= "//*[text()='Continue Shopping']")
    public WebElement continueShoppingOnPopUp_Button;

    @FindBy(id= "address_delivery")
    public WebElement deliveryAddress_Text;

    @FindBy(id= "address_invoice")
    public WebElement billingAddress_Text;

    @FindBy(xpath= "//*[@class='cart_description']//a")
    public List<WebElement> productNamesInOrderPage_text;

    @FindBy(xpath= "//a[contains(.,'ownload')]")
    public WebElement downloadInvoice_Button;









}
