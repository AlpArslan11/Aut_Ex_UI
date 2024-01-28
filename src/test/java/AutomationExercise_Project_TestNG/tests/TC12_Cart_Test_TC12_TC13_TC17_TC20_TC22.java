package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.CartPage;
import AutomationExercise_Project_TestNG.utilities.ConfigReader;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.*;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;

public class TC12_Cart_Test_TC12_TC13_TC17_TC20_TC22 extends TestBaseBeforeAfterMethod {
    CartPage cartPage;
    Actions actions;

    @Description("""
            Test Case 12: Add Products in Cart
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'Products' button
            5. Hover over first product and click 'Add to cart'
            6. Click 'Continue Shopping' button
            7. Hover over second product and click 'Add to cart'
            8. Click 'View Cart' button
            9. Verify both products are added to Cart
            10. Verify their prices, quantity and total price
            """)
    @Test(description = "Test Case-12 VERIFIES ADDED PRODUCTS TO CART")
    public void addProductsInCart_Test_TC12() {
        cartPage = new CartPage();
        actions = new Actions(Driver.getDriver());
        //Test Case 12: Add Products in Cart
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click 'Products' button
        cartPage.products_Button.click();
        handleGoogleVignette(() -> cartPage.products_Button.click());

        //5. Hover over first product and click 'Add to cart'
        actions.moveToElement(cartPage.first_product);
        waitFor(1);
        cartPage.addToCart_firstProduct_Button.click();

        //6. Click 'Continue Shopping' button
        cartPage.continueShopping_Button.click();

        //7. Hover over second product and click 'Add to cart'
        actions.moveToElement(cartPage.second_product);
        waitFor(1);
        cartPage.addToCart_secondProduct_Button.click();
        cartPage.continueShopping_Button.click();

        //getting product names
        Map<String, List<String>> productsMap = getTwoProductsNameAndPriceBeforeCart();

        //8. Click 'View Cart' button
        actions.moveToElement(cartPage.second_product);
        waitFor(1);
        cartPage.addToCart_secondProduct_Button.click();
        cartPage.viewCart_Button.click();

        //9. Verify both products are added to Cart
        List<WebElement> inCartProducts = new ArrayList<>(cartPage.addedProductsToCart);
        for (int i = 0; i < inCartProducts.size(); i++) {
            Assert.assertTrue(inCartProducts.get(i).getText().toLowerCase()
                            .contains(productsMap.get("productsName").get(i).toLowerCase())
                    , "Both of the products are not found ");
        }

        //10. Verify their prices, quantity and total price
        validateTwoProductsNamePriceQuantity(productsMap);
    }


    Random rnd;
    List<WebElement> viewProductsButtons_list;

    @Description("""
            Test Case 13: Verify Product quantity in Cart
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'View Product' for any product on home page
            5. Verify product detail is opened
            6. Increase quantity to 4
            7. Click 'Add to cart' button
            8. Click 'View Cart' button
            9. Verify that product is displayed in cart page with exact quantity
             """)
    @Test(description = "Test Case-13 VERIFIES ADDED PRODUCTS QUANTITY TO CART")
    public void verifyProductQuantityInCart_Test_TC13() {
        cartPage = new CartPage();
        //Test Case 13: Verify Product quantity in Cart
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click 'View Product' for any product on home page
        rnd = new Random();
        viewProductsButtons_list = new ArrayList<>(cartPage.viewProduct_Buttons);
        scrollIntoViewAndClickByJavaScript(viewProductsButtons_list.get(rnd.nextInt(0, viewProductsButtons_list.size())));

        //5. Verify product detail is opened
        scrollIntoViewAndClickByJavaScript(viewProductsButtons_list.get(rnd.nextInt(0, viewProductsButtons_list.size() + 1)));
        handleGoogleVignette(() -> scrollIntoViewAndClickByJavaScript(
                viewProductsButtons_list.get(rnd.nextInt(0, viewProductsButtons_list.size() + 1))));

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("details"), "product details' Url is wrong");
        Assert.assertFalse(cartPage.productsAllInfo_Text.getText().isEmpty(), "The product details are not loaded or displayed");

        //6. Increase quantity to 4 - any quantity
        cartPage.quantityNumber.clear();
        String expectedQuantity = String.valueOf(rnd.nextInt(0, 10));
        cartPage.quantityNumber.sendKeys(expectedQuantity);

        //7. Click 'Add to cart' button
        cartPage.addToCart_Button.click();

        //8. Click 'View Cart' button
        cartPage.viewCart_Button.click();

        //9. Verify that product is displayed in cart page with exact quantity
        Assert.assertEquals(cartPage.firstProductInCart_quantity.getText(), expectedQuantity
                , "The actual quantity of the product is not same with expected quantity");
        Assert.assertTrue(Integer.parseInt(cartPage.firstProductInCart_quantity.getText()) > 0
                , "The actual quantity of the product is zero");
    }

    @Description("""
            Test Case 17: Remove Products From Cart
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Add products to cart
            5. Click 'Cart' button
            6. Verify that cart page is displayed
            7. Click 'X' button corresponding to particular product
            8. Verify that product is removed from the cart
            """)
    @Test(description = "Test Case-17 VERIFIES REMOVING ITEMS IN CART PAGE")
    public void removeProductsFromCart_TC17() {
        cartPage = new CartPage();
        rnd = new Random();
        //Test Case 17: Remove Products From Cart
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //4. Add products to cart
        cartPage.addToCart_firstProduct_Button.click();
        cartPage.continueShopping_Button.click();

        cartPage.addToCart_secondProduct_Button.click();
        cartPage.continueShopping_Button.click();

        //5. Click 'Cart' button
        cartPage.cart_Button.click();

        //6. Verify that cart page is displayed
        Assert.assertTrue(cartPage.shoppingCart_text.getText().toLowerCase()
                .contains("shopping cart"), "Cart Page is not displayed");

        //7. Click 'X' button corresponding to particular product
        //8. Verify that product is removed from the cart
        deleteProductAndVerifyDeletedItemInCartPage();
    }

    @Description("""
                    
            Test Case 20: Search Products and Verify Cart After Login
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify user is navigated to ALL PRODUCTS page successfully
            5. Enter product name in search input and click search button
            6. Verify 'SEARCHED PRODUCTS' is visible
            7. Verify all the products related to search are visible
            8. Add those products to cart
            9. Click 'Cart' button and verify that products are visible in cart
            10. Click 'Signup / Login' button and submit login details
            11. Again, go to Cart page
            12. Verify that those products are visible in cart after login as well
            """)

    @DataProvider(name = "searchItems")
    public static Object[][] searchItems() {

        List<String> items = getTestDataFromExcel("src/test/resources/test_data.xlsx", "test_data", 1);
        Object[][] searchItems = new Object[items.size()][1];
        for (int i = 0; i < items.size(); i++) {
            searchItems[i][0] = items.get(i);
        }
        return searchItems;
    }


    @Test(dataProvider = "searchItems", description = "Test Case-20 SEARCH PRODUCTS AND VERIFIES CART")
    public void searchProductsAndVerifyCartAfterLogin_Test_TC20(String searchTerm) throws InterruptedException {

        cartPage = new CartPage();
        rnd = new Random();
        //Test Case 20: Search Products and Verify Cart After Login
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        //3. Click on 'Products' button
        cartPage.products_Button.click();
        handleGoogleVignette(() -> cartPage.products_Button.click());

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(cartPage.titleInTheCenterOfPage_Text.getText().toLowerCase()
                .contains("all products"), "ALL PRODUCTS page is not verified");

        //5. Enter product name in search input and click search button
        cartPage.searchProduct_TextBox.sendKeys(searchTerm);
        cartPage.searchSubmit_Button.click();

        //6. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(cartPage.titleInTheCenterOfPage_Text.getText().toLowerCase()
                .contains("searched products"), "SEARCHED PRODUCTS txt is not visible");

        //7. Verify all the products related to search are visible

        List<String> productAddedToCart_NamesList = new ArrayList<>();
        for (WebElement e : cartPage.productsNameInSearchPage_List
        ) {
            productAddedToCart_NamesList.add(e.getText());
        }
        verifyAllProductsRelatedToSearch(searchTerm);

        //----
//        actions = new Actions(Driver.getDriver());
//        List<WebElement> products_list = cartPage.viewProduct_Buttons;
//        String parentWindow = Driver.getDriver().getWindowHandle();
//        List<String> windowsHandles;
//        List<String> productAddedToCart_NamesList = new ArrayList<>();
//        //   System.out.println("asd");
//        for (int i = 0; i < products_list.size(); i++) {
//
//            actions.moveToElement(products_list.get(i))
//                    .keyDown(Keys.CONTROL)
//                    .click().keyUp(Keys.CONTROL).build().perform();
//            if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
//                Driver.getDriver().navigate().refresh();
//                actions.moveToElement(products_list.get(i))
//                        .keyDown(Keys.CONTROL)
//                        .click().keyUp(Keys.CONTROL).build().perform();
//            }
//
//            waitFor(1);
//            windowsHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
//
//
//            Driver.getDriver().switchTo().window(windowsHandles.get(1));
//            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//            productAddedToCart_NamesList.add(cartPage.productName_Text.getText());
////            System.out.println("Product name -->>>>>>> " + cartPage.productName_Text.getText());
////            System.out.println("category bilgisi -->>>>>>> " + cartPage.categoryOfTheProduct.getText());
//            //waitFor(2);
//            Assert.assertTrue(cartPage.productsAllInfo_Text.getText().toLowerCase().replaceAll("\\W", "")
//                    .contains(searchTerm.toLowerCase().replaceAll("\\W", "")));
//            //     System.out.println("product " + (i + 1) + " checked");
//            // System.out.println("products all ınfo--> \n " + cartPage.productsAllInfo_Text.getText());
//            Driver.getDriver().close();
//            Driver.getDriver().switchTo().window(parentWindow);
//
//            windowsHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
//            if (windowsHandles.size() > 1) {
//                Driver.getDriver().switchTo().window(windowsHandles.get(1));
//                Driver.getDriver().close();
//                Driver.getDriver().switchTo().window(parentWindow);
//            }
//        } // loop ends

//        windowsHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
//        if (windowsHandles.size() > 1) {
//            for (int i = 1; i <= windowsHandles.size(); i++) {
//                Driver.getDriver().switchTo().window(windowsHandles.get(1));
//                Driver.closeDriver();
//                Driver.getDriver().switchTo().window(parentWindow);
//            }
//        }

        //8. Add those products to cart ---------------------------------------------------------------------------------------
        addAllProductsToCart();


//        List<WebElement> addProductsList = cartPage.addProductsButtons_List;
//        for (WebElement w : addProductsList
//        ) {
//            w.click();
//            cartPage.continueShopping_Button.click();
//        }
//        System.out.println(productAddedToCart_NamesList.size() + "  products are added to cart");

        //9. Click 'Cart' button and verify that products are visible in cart
        cartPage.cart_Button.click();
        List<WebElement> productsDescriptionInCartPageList = cartPage.product_description;


        int checkCount = 0;
        for (String str : productAddedToCart_NamesList) {
            str = str.toLowerCase().replaceAll("\\W", "");
            for (WebElement w : productsDescriptionInCartPageList) {
                if (w.getText().toLowerCase().replaceAll("\\W", "").contains(str)) checkCount++;
            }

        }
        Assert.assertEquals(productAddedToCart_NamesList.size(), checkCount,
                "Some elements or an element is not present in the cart page");

        //10. Click 'Signup / Login' button and submit login details ---------------------------------------------------------------------------------------
        cartPage.signUpLoginButton.click();
        login_fromLoginPage(ConfigReader.getProperty("aut_Ex_MailAddress"),ConfigReader.getProperty("aut_Ex_PassWord"));

//        cartPage.emailAdress_LoginPage_TextBox.sendKeys(ConfigReader.getProperty("aut_Ex_MailAddress"));
//        cartPage.password_LoginPage_TextBox.sendKeys(ConfigReader.getProperty("aut_Ex_PassWord"));
//        cartPage.login_button.click();
        //       System.out.println("Logged in the site");
        Assert.assertTrue(cartPage.logout_button.isDisplayed(), "can't verify that user logged in ");


        //11. Again, go to Cart page
        cartPage.cart_Button.click();

        //12. Verify that those products are visible in cart after login as well
        productsDescriptionInCartPageList = cartPage.product_description;

        checkCount = 0;
        for (String str : productAddedToCart_NamesList) {
            str = str.toLowerCase().replaceAll("\\W", "");
            for (WebElement w : productsDescriptionInCartPageList) {
                if (w.getText().toLowerCase().replaceAll("\\W", "").contains(str)) checkCount++;
            }
        }

        Assert.assertEquals(productAddedToCart_NamesList.size(), checkCount, "Some elements or an element is not present in the cart page");

        List<WebElement> xButtonList = cartPage.xButton_List;
        while (xButtonList.size() > 0) {

            xButtonList.get(xButtonList.size() - 1).click();
            waitFor(1);
            xButtonList = cartPage.xButton_List;
            // System.out.println("xButtonList.size()"+ cartPage.xButton_List.size());
        }

        logoutUser();


    }


    int rndIndex;

    @Test
    public void addToCartFromRecommendedItemsTC22_Test() {

        cartPage = new CartPage();
        rnd = new Random();
        //Test Case 22: Add to cart from Recommended items
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Scroll to bottom of page
        //4. Verify 'RECOMMENDED ITEMS' are visible
        //5. Click on 'Add To Cart' on Recommended product
        //6. Click on 'View Cart' button
        //7. Verify that product is displayed in cart page


        //Test Case 22: Add to cart from Recommended items
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        //3. Scroll to bottom of page
        scrollToTheBottomWithActions();

        //4. Verify 'RECOMMENDED ITEMS' are visible
        scrollIntoViewByJavaScript(cartPage.recommendedItems_Text);

        List<WebElement> recommendedProducts_AddToCartButtonList = cartPage.addToCart_inRecommendedItems_Button;
        List<WebElement> productNamesInRecommendedItems = cartPage.productNamesInRecommendedItems_List;
        System.out.println("RECOMMENDED ITEMS DAKİ URUNLER-----------");
        productNamesInRecommendedItems.forEach(t -> System.out.println(t.getText()));

        Assert.assertEquals(productNamesInRecommendedItems.size(), 6,
                "products in RECOMMENDED ITEMS are not verified");


        //5. Click on 'Add To Cart' on Recommended product
        //  rndIndex = rnd.nextInt(0, recommendedProducts_AddToCartButtonList.size());
        rndIndex = 9;
        String addedProductName = "";
        try {
            recommendedProducts_AddToCartButtonList.get(rndIndex).click();
        } catch (Exception e) {
            for (int i = 0; i < recommendedProducts_AddToCartButtonList.size(); i++) {
                rndIndex = rnd.nextInt(0, recommendedProducts_AddToCartButtonList.size());
                try {
                    addedProductName = recommendedProducts_AddToCartButtonList.get(rndIndex).getText();
                    recommendedProducts_AddToCartButtonList.get(rndIndex).click();
                } catch (Exception b) {
                }
            }
        }

        System.out.println("carta eklenen product " + addedProductName);

        //6. Click on 'View Cart' button

        cartPage.viewCart_Button.click();
        // clickByJavaScript(cartPage.viewCart_Button);


        //7. Verify that product is displayed in cart page

        List<WebElement> productNamesListInCart = cartPage.productNamesInCart_List;

        System.out.println("CART   TAKI ITEMLER-------------");
        productNamesListInCart.forEach(t -> System.out.println(t.getText()));
        Assert.assertTrue(productNamesListInCart.size() >= 1, "Added product is not visible in cart page");
    }


}