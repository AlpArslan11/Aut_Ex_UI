package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.BrandPage;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.*;

public class TC19_Brand_Test extends TestBaseBeforeAfterMethod {
    //Test Case 19: View & Cart Brand Products
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Click on 'Products' button
    //4. Verify that Brands are visible on left side bar
    //5. Click on any brand name
    //6. Verify that user is navigated to brand page and brand products are displayed
    //7. On left side bar, click on any other brand link
    //8. Verify that user is navigated to that brand page and can see products

    @Description("""
            Test Case 19: View & Cart Brand Products
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify that Brands are visible on left side bar
            5. Click on any brand name
            6. Verify that user is navigated to brand page and brand products are displayed
            7. On left side bar, click on any other brand link
            8. Verify that user is navigated to that brand page and can see products
            """)

    @Test
    public void view_CartBrandProductsTC19_Test() throws InterruptedException {
        //Test Case 19: View & Cart Brand Products
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Click on 'Products' button
        clickProductsButton();

        //4. Verify that Brands are visible on left sidebar
        verifyBrandsTitleTextIsDisplayed();
        verifyBrandNamesAreDisplayed();

        //5. Click on any brand name
        int randomIndex = clickOnAnyBrandTitleAndReturnIndex();
        //6. Verify that user is navigated to brand page and brand products are displayed
        verifyNavigatedToBrandPage(randomIndex);
        verifyBrandProductsAreDisplayed();

        //7. On left sidebar, click on any other brand link
        randomIndex = clickOnAnyBrandTitleAndReturnIndex();

        //8. Verify that user is navigated to that brand page and can see products
        verifyNavigatedToBrandPage(randomIndex);
        verifyBrandProductsAreDisplayed();
    }


}
