package AutomationExercise_Project_TestNG.tests;

import AutomationExercise_Project_TestNG.pages.Category_Pages;
import AutomationExercise_Project_TestNG.utilities.Driver;
import AutomationExercise_Project_TestNG.utilities.TestBaseBeforeAfterMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static AutomationExercise_Project_TestNG.utilities.ReusableMethods.scrollIntoViewAndClickByJavaScript;

public class TC18_Category_Test extends TestBaseBeforeAfterMethod {


    Category_Pages category_pages;
    Random rnd;
    Actions actions;


    @Test
    public void viewCategoryProducts_TC18() throws InterruptedException {
        category_pages = new Category_Pages();
        rnd = new Random();
        actions= new Actions(Driver.getDriver());



        //Test Case 18: View Category Products
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that categories are visible on left sidebar
        //4. Click on 'Women' category
        //5. Click on any category link under 'Women' category, for example: Dress
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        //7. On left sidebar, click on any sub-category link of 'Men' category
        //8. Verify that user is navigated to that category page



        //Test Case 18: View Category Products
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that categories are visible on left sidebar

        Thread.sleep(3000);
        //4. Click on 'Women' category
        scrollIntoViewAndClickByJavaScript(category_pages.womenCategory_Button);

        //5. Click on any category link under 'Women' category, for example: Dress

        if(Driver.getDriver().getCurrentUrl().contains("google_vignette")){
            scrollIntoViewAndClickByJavaScript(category_pages.womenCategory_Button);

        }

        List<WebElement> womenCategory_list = category_pages.categoriesUnderWomen_List;
        int randomElementIndex = rnd.nextInt(0,womenCategory_list.size());
        String secilenUrunTexti=womenCategory_list.get(randomElementIndex).getText();
        Thread.sleep(2000);

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")){
            Driver.getDriver().navigate().refresh();
            category_pages.womenCategory_Button.click();
            category_pages.categoriesUnderWomen_List.get(randomElementIndex).click();
        }

        category_pages.categoriesUnderWomen_List.get(randomElementIndex).click();


        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")){
            Driver.getDriver().navigate().refresh();
            category_pages.womenCategory_Button.click();
            category_pages.categoriesUnderWomen_List.get(randomElementIndex).click();
        }


        Assert.assertTrue(category_pages.titleInTheCenterOfPage_Text.getText().toLowerCase()
              .contains(secilenUrunTexti.toLowerCase()));


        //7. On left sidebar, click on any sub-category link of 'Men' category
            category_pages.menCategory_Button.click();


        List<WebElement> menCategoryList = category_pages.categoriesUnderMen_List;
        randomElementIndex = rnd.nextInt(0,menCategoryList.size());


        menCategoryList.get(randomElementIndex).click();
        secilenUrunTexti = menCategoryList.get(randomElementIndex).getText().toLowerCase();


        //8. Verify that user is navigated to that category page

        Assert.assertTrue(category_pages.titleInTheCenterOfPage_Text.getText().toLowerCase()
                .contains(secilenUrunTexti));


    }

}
