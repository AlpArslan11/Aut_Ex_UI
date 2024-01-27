package AutomationExercise_Project_TestNG.tests.denemeCalismalar;

import org.testng.annotations.Test;

public class asd1 {

    @Test
    public void asd(){

        String pageTExt = "brand-mast&harbourproducts";
        String brandName ="mast&harbour";

        System.out.println(pageTExt.toLowerCase().contains(brandName.toLowerCase()));


    }
}
