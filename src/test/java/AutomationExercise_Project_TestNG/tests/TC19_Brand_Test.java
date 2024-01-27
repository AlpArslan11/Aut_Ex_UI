package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.BrandPage;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.getTestDataFromExcel;

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


    BrandPage brandPage;
    Random rnd;
    int randomIndx;
    int rndIndx;
    int randomIndex;

    @Test
    public void view_CartBrandProductsTC19_Test() throws InterruptedException {

        brandPage = new BrandPage();
        rnd = new Random();
        //Test Case 19: View & Cart Brand Products
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        //3. Click on 'Products' button
        brandPage.products_Button.click();

        //4. Verify that Brands are visible on left sidebar
        Assert.assertEquals(brandPage.brandsTitle_text.getText().toLowerCase(), "brands");

        List<WebElement> brandNamesWE_List = brandPage.brands_list;
        //  brandNamesWE_List.forEach(t -> System.out.println("brand ->  " + t.getText()));
        List<String> testData_list =
                getTestDataFromExcel("resources/test_data.xlsx", "test_data", 0);
        //  testData_list.forEach(t-> System.out.println("excelden -> "+t));

        int checkCount = 0;
        String s;
        for (String value : testData_list) {
            s = value.toLowerCase();
            for (WebElement w : brandNamesWE_List) {
                if (w.getText().toLowerCase().contains(s)) checkCount++;
            }
        }
        Assert.assertEquals(checkCount, brandNamesWE_List.size()
                , "Some brands' names are not equal with the expected brand names");
        //5. Click on any brand name
        randomIndex = rnd.nextInt(0, brandNamesWE_List.size());
        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            Thread.sleep(1000);
            brandNamesWE_List.get(randomIndex).click();
        }

        //6. Verify that user is navigated to brand page and brand products are displayed

        String brandPageTitle = brandPage.titleInTheCenterOfPage_Text.getText().toLowerCase()
                .replaceAll("\\W", " ").replaceAll("\\d", "").replaceAll(" ", "");
        if (brandPageTitle.equals("allproducts")) {
            brandNamesWE_List.get(randomIndex).click();
            brandPageTitle = brandPage.titleInTheCenterOfPage_Text.getText().toLowerCase()
                    .replaceAll("\\W", " ").replaceAll("\\d", "").replaceAll(" ", "");
        }

        String selectedBrand = brandNamesWE_List.get(randomIndex).getText().toLowerCase()
                .replaceAll("\\W", " ").replaceAll("\\d", "").replaceAll(" ", "");

        System.out.println("1-" + brandPageTitle);
        System.out.println("1-" + selectedBrand);

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            Thread.sleep(1000);
            brandNamesWE_List.get(randomIndex).click();
        }


        Assert.assertTrue(brandPageTitle.contains(selectedBrand)
                , "brand Page is not verified. the brand which is clicked is not the same with the opening page");

        Assert.assertFalse(brandPage.brandProducts_List.isEmpty() //brand products are displayed
                , "Brand products are not displayed");

        //7. On left sidebar, click on any other brand link
        rndIndx = rnd.nextInt(0, brandNamesWE_List.size());
        brandNamesWE_List.get(rndIndx).click();


        String brandPageTitle_text = brandPage.titleInTheCenterOfPage_Text.getText().toLowerCase()
                .replaceAll("\\W", " ").replaceAll("\\d", "").replaceAll(" ", "");

        String selectedBrand_text = brandNamesWE_List.get(rndIndx).getText().toLowerCase()
                .replaceAll("\\W", " ").replaceAll("\\d", "").replaceAll(" ", "");


        System.out.println("2-" + brandPageTitle_text);
        System.out.println("2-" + selectedBrand_text);
        //8. Verify that user is navigated to that brand page and can see products


        Assert.assertTrue(brandPageTitle_text.contains(selectedBrand_text)
                , "brand Page is not verified. the brand which is clicked is not the same with the opening page");

        Assert.assertFalse(brandPage.brandProducts_List.isEmpty() //brand products are displayed
                , "Brand products are not displayed");


    }


}
