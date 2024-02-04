package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.ProductsPage;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;


public class TC08_Products_Test_TC08_TC09_TC21____________ extends TestBaseBeforeAfterMethod {


    ProductsPage productsPage;
    String firstProduct;
    Random rnd;

    @Test(description = """
            Test Case 8: Verify All Products and product detail page
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Products' button
            5. Verify user is navigated to ALL PRODUCTS page successfully
            6. The products list is visible
            7. Click on 'View Product' of first product
            8. User is landed to product detail page
            9. Verify that detail detail is visible: product name, category, price, availability, condition, brand""")
    public void products_tests_TC08() throws InterruptedException {
        //Test Case-8 LISTING THE PRODUCTS AND PRODUCT DETAILS
        productsPage = new ProductsPage();

        //1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully
        //4. Click on 'Products' button
        productsPage.products_button.click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        handleGoogleVignette(() -> productsPage.products_button.click());
        Assert.assertTrue(productsPage.allProducts_text.isDisplayed(),
                "ALL PRODUCTS text is not visible, is not navigated to ALL PRODUCTS page");

        //6. The products list is visible
        Assert.assertTrue(productsPage.products_list.size() >= 34, "Products are not listed,there are not 34 products");

        //7. Click on 'View Product' of first product
        firstProduct = getFirstProduct();
        productsPage.viewFirstProduct.click();

        //8. User is landed to product detail page
        Assert.assertTrue(productsPage.firstProductInfo_text.getText()
                        .contains(firstProduct)
                , "product details/info are not correct / as expected ");

        Assert.assertEquals(Driver.getDriver().getCurrentUrl()
                , "https://automationexercise.com/product_details/1"
                , "The selected Product's URL is not as expected");

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        verifyProductDetails(firstProduct);
    }


    @Description("""
            Test Case 9: Search Product
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Products' button
            5. Verify user is navigated to ALL PRODUCTS page successfully
            6. Enter product name in search input and click search button
            7. Verify 'SEARCHED PRODUCTS' is visible
            8. Verify all the products related to search are visible
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

    @Test(dataProvider = "searchItems", description = "Test Case-9 SEARCHING THE PRODUCTS AND VERIFIES ALL THE PRODUCTS ARE RELATED TO THE SEARCHED ITEM")
    public void search_product_TC09(String searchTerm) throws InterruptedException {
        productsPage = new ProductsPage();

        //Test Case 9: Search Product
        //1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully
        //4. Click on 'Products' button
        productsPage.products_Button.click();
        handleGoogleVignette(() -> productsPage.products_Button.click());

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(productsPage.allProducts_text.isDisplayed(),
                "ALL PRODUCTS text is not visible, is not navigated to ALL PRODUCTS page");
        Assert.assertTrue(productsPage.products_list.size() >= 34,
                "Products are not listed,there are not 34 products");

        //6. Enter product name in search input and click search button
//        String wordToBeSearched = "dress";
        productsPage.searchProduct_Textbox.sendKeys(searchTerm);
        productsPage.searchProduct_Button.click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(productsPage.searchedProducts_text.isDisplayed(),
                "SEARCHED PRODUCTS yazısı goruntulenmedi");

        //8. Verify all the products related to search are visible
        verifyAllProductsRelatedToSearch(searchTerm);
    }
    List<WebElement> viewProducts;

    @Test(description = """
            Test Case 21: Add review on product
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify user is navigated to ALL PRODUCTS page successfully
            5. Click on 'View Product' button
            6. Verify 'Write Your Review' is visible
            7. Enter name, email and review
            8. Click 'Submit' button
            9. Verify success message 'Thank you for your review.'""")
    public void addReviewOnProduct_TC21_Test() throws InterruptedException {
        //Test Case-21 REVIEWING ON A PRODUCT
        productsPage = new ProductsPage();
        rnd = new Random();

        //Test Case 21: Add review on product
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Click on 'Products' button
        productsPage.products_button.click();
        handleGoogleVignette(() -> productsPage.products_button.click());

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(productsPage.allProducts_text.isDisplayed(),
                "All products page is not verified");

        //5. Click on 'View Product' button
        viewProducts = productsPage.viewProduct_Buttons;
//        int randomIndex = rnd.nextInt(0, viewProducts.size());
        viewProducts.get(rnd.nextInt(0, viewProducts.size())).click();

        //6. Verify 'Write Your Review' is visible
        Assert.assertTrue(productsPage.review_TextBox.isDisplayed(),
                "Review textbox is not displayed");

        //7. Enter name, email and review
        productsPage.name_TextBox.sendKeys(randomName(7));
        productsPage.emailAddress_TextBox.sendKeys(randomEmail(8));
        productsPage.review_TextBox.sendKeys(randomParagraph(50));

        //8. Click 'Submit' button
        productsPage.reviewSubmit_Button.click();

        //9. Verify success message 'Thank you for your review.'
        Assert.assertTrue(productsPage.successMsg.isDisplayed(),
                "Success Msg after reviewing product is not displayed");
    }


}
