package AutomationExercise_Project_TestNG.tests.denemeCalismalar;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class System_home {

    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));



        String filePath =System.getProperty("user.home")+"/Downloads/invoice.txt"; //String filePath =System.getProperty("user.home")+"/Downloads/invoice.txt";
        System.out.println(Files.exists(Path.of(filePath)));
        Assert.assertTrue(Files.exists(Path.of(filePath)));
    }
}
