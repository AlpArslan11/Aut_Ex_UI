package AutomationExercise_Project_TestNG.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {


    /*
    POM'de Driver için TestBase classina extends etmek yerine
    Driver classından static methodlar kullanarak driver oluşturup
    ilgili ayarların yapılması ve en son da driver'in kapatılması tercih edilmiştir.


    POM'de Driver class'indaki getDriver()'nin obje olusturularak kullanilmasini
    engellemek icin
    Singleton pattern kullanimi benimsenmistir.

    Singleton Pattern : tekli kullanim, bir class'in farkli class'lardan
    obje olusturularak kullanimini engellemek icin kullanilir.

    Bunu saglamak icin yapmamiz gereken sey oldukca basit
    obje olusturmak icin kullanilan constructor'i private yaptiginizda
    bsaka class'larda Driver class'indan obje olusturulmasi mumkun OLAMAZ

     */


    private Driver() {
    }



    private static WebDriver driver;

    public static WebDriver getDriver() {

      //  ChromeOptions opt = new ChromeOptions();
     //   opt.addExtensions(new File("resources/addBlocker.crx"));

/*
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.javascript",2);
        options.setExperimentalOption("prefs",prefs);
        // https://community.lambdatest.com/t/remove-ads-in-automated-tests/6431/2
        //--> driver = new ChromeDriver(options); chromeDriver içine parametre olarak "options" kullan
*/

        /*
        // CHATGPT VERDİ --> Chrome seçenekleri oluştur
        ChromeOptions options = new ChromeOptions ();
        // Çerezleri devre dışı bırakmak için tercihleri ayarla
        Map<String, Object> prefs = new HashMap<String, Object> ();
        prefs.put ("profile.default_content_setting_values.cookies", 2);
        options.setExperimentalOption ("prefs", prefs);
        // Chrome sürücüsünü seçeneklerle başlat
   //     WebDriver driver = new ChromeDriver (options);
*/

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                 //   WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    //  WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "chrome-headless":
                    //   WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                    break;

                case "edge":
                    // WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    // WebDriverManager.SafariDriver.setup();
                    driver = new SafariDriver();
                    break;

                default:
                    //   WebDriverManager.chromedriver().setup();

                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;

    }


    public static void closeDriver() {
        if (driver != null) {  // drivera değer atanmışsa kapat demek için. yani driver aciksa kapat
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {  // drivera değer atanmışsa kapat demek için. yani driver aciksa kapat
            driver.quit();
            driver = null;
        }
    }

}