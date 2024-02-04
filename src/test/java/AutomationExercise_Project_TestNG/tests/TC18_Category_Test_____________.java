package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.Category_Pages;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import jdk.jfr.Description;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Random;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;

public class TC18_Category_Test_____________ extends TestBaseBeforeAfterMethod {


    Category_Pages category_pages;
    Random rnd;
    Actions actions;
    String selectedProduct;

    @Description("""
            Test Case 18: View Category Products
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that categories are visible on left side bar
            4. Click on 'Women' category
            5. Click on any category link under 'Women' category, for example: Dress
            6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
            7. On left side bar, click on any sub-category link of 'Men' category
            8. Verify that user is navigated to that category page""")
    @Test(description = "Test Case 18: View Category Products")
    public void viewCategoryProducts_TC18() {
        category_pages = new Category_Pages();
        rnd = new Random();
        actions = new Actions(Driver.getDriver());
        //Test Case 18: View Category Products
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that categories are visible on left sidebar
        verifyCategoryTitlesIsDisplayed("Men","Women","Kıds");

        //4. Click on 'Women' category
        //5. Click on any category link under 'Women' category, for example: Dress--------------------------------
        selectedProduct = clickAnyCategoryLinkUnderWomen();

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS' ------------------------------
        verifyCategoryPageIsDisplayed(selectedProduct);

        //7. On left sidebar, click on any sub-category link of 'Men' category----------------------------------------
         selectedProduct = clickAnyCategoryLinkUnderMen();

        //8. Verify that user is navigated to that category page---------------------------------------
        verifyCategoryPageIsDisplayed(selectedProduct);
    }
}
