package AutomationExercise_Project_TestNG.pages;

import AutomationExercise_Project_TestNG.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {
    public AmazonPage(){ //Constructor oluşturup public yapmamız gerekir

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy (xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucWE;

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramakutusu;


    @FindBy (xpath="(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")
    public WebElement ilkUrun;

    @FindBy (xpath="(//div[@class='a-section a-spacing-base'])[1]")
    public WebElement ilkUrunDetay;

    @FindBy (xpath = "(//li[@class=\"nav_first\"])[1]")
    public WebElement careers;

    @FindBy (xpath = "//table/tbody/tr")
    public List<WebElement> tableRows;

    @FindBy (xpath ="//table//tr[1]/td")
    public List<WebElement>  tableCells;

    @FindBy (xpath = "//tr[1]/td/a")
    public List<WebElement> tableCellsDolu;

    @FindBy (xpath = "//tbody//td")
    public List<WebElement> tumHucrelerList;

}
