package AutomationExercise_Project_TestNG.utilities;

import AutomationExercise_Project_TestNG.pages.*;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.random;

public class ReusableMethods {

    public static String randomName(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomEmail(int length) {
        String randomName = RandomStringUtils.randomAlphabetic(length)
                + "@"
                + RandomStringUtils.randomAlphabetic(1)
                + "mail.com";
        return randomName;
    }

    public static String randomParagraph(int numberOfWords) {

        Random rnd = new Random();
        //int []arr = {3,4,8,6,5,4,3,6};
        String randomParagraph = "";
        for (int i = 0; i <= numberOfWords; i++) {

            randomParagraph += RandomStringUtils.randomAlphabetic(rnd.nextInt(1, 8)) + " ";

        }
        return randomParagraph;
    }

    public static String randomPassWord(int length) {
        String randomPassword = random(6, true, true);

        return randomPassword;
    }


    public static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }


    public static void scrollIntoViewByJavaScript(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();//Casting
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static void clickByJavaScript(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", webElement);

    }

    public static void scrollToTheBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTheTopOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }


    public static void scrollUpByJavaScript(int value) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,-" + value + ")");

    }


    public static void scrollToTheBottomWithActions() {
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();

    }


    public static void scrollIntoViewAndClickByJavaScript(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
        jse.executeScript("arguments[0].click();", webElement);

    }


    public static String dateMonth() {
        String month;
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");

        return month = dateTime.format(formatter);
    }

    public static String dateYear() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY");
        return dateTime.format(formatter);
    }


    public static List<String> getTestDataFromExcel(String excelPath, String sheetName, int cellIndex) {
        FileInputStream fis;
        Workbook workbook;
        Sheet sheet = null;

        try {
            fis = new FileInputStream(excelPath);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("Can not read the excel file");
        }

        String searchTerms;
        List<String> testData_list = new ArrayList<>();

        assert sheet != null;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            try {
                searchTerms = sheet.getRow(i).getCell(cellIndex).toString();
                testData_list.add(searchTerms);
            } catch (NullPointerException nullE) {
                break;
            }
        }

        return testData_list;
    }


    //File Upload Robot Class
    public static void uploadFile(String dosyaYolu) {
        try {

            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        } catch (Exception ignored) {
        }
    }


    /**
     * Explicit wait yapar
     * bu metot ile bir element gorulene kadar kodlar bekletilir
     *
     * @param element girilmesi gereken locate dir
     * @param timeout girilmesi gereken saniyedir
     */
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitFor(int secs) {

        try {
            Thread.sleep(1000L * secs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void verifyHomePage() {
        RegistrationPage registrationPage = new RegistrationPage();
        Assert.assertTrue(registrationPage.adsOfHomepage.isDisplayed());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("automationexercise"));
    }

    ;


    public static Map<String, String> navigateUrlFirstAndRegisterAndGetInfo() {
        RegistrationPage registrationPage = new RegistrationPage();
        Faker faker = new Faker();
        Random rnd = new Random();
        Select select;

        String randomName;
        String randomEmail;
        String randomPassword;
        String randomLastName;


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //4. Click on 'Signup / Login' button
        registrationPage.signUpLoginButton.click();


        //6. Enter name and email address
        randomName = random(5, true, false) + rnd.nextInt(0, 11);
        System.out.println("random userName --> " + randomName);
        registrationPage.userName_NameTextbox.sendKeys(randomName);


        randomEmail = random(5, true, false) + "@bmail.com";
        System.out.println("randomEmail ---> " + randomEmail);
        registrationPage.signUpEmailAddress_textbox.sendKeys(randomEmail);

        //7. Click 'Signup' button
        registrationPage.signUpButton.click();

        //9. Fill details: Title, Name, Email, Password, Date of birth
        registrationPage.mr_radioButton.click();

        //password
        randomPassword = random(6, true, true);
        System.out.println("randomPassword ---> " + randomPassword);
        registrationPage.password_textBox.sendKeys(randomPassword);

        //day,month,year
        select = new Select(registrationPage.day_ddm);
        select.selectByVisibleText(String.valueOf(rnd.nextInt(1, 32)));

        select = new Select(registrationPage.month_ddm);
        select.selectByValue(String.valueOf(rnd.nextInt(1, 13)));

        select = new Select(registrationPage.years_ddm);
        select.selectByVisibleText(String.valueOf(rnd.nextInt(1900, 2022)));

        //10. Select checkbox 'Sign up for our newsletter!'
        registrationPage.newsletter_checkbox.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        registrationPage.specialOffers_checkbox.click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //First name,
        String firstName = random(6, true, false);
        System.out.println("random firstName  --> " + firstName);
        registrationPage.firstName_textBox.sendKeys(firstName);

        // Last name,
        randomLastName = random(7, true, false);
        System.out.println("random randomLastName -->  " + randomLastName);
        registrationPage.lastName_textBox.sendKeys(randomLastName);

        // Company,
        registrationPage.company_textBox.sendKeys(random(5, true, false) + " " + random(3, true, false));

        // Address1,
        registrationPage.address1_textBox.sendKeys(faker.address().fullAddress());

        // Address2,
        registrationPage.address2_textBox.sendKeys(faker.address().cityName());

        // Country,
        select = new Select(registrationPage.country_ddm);
        select.selectByIndex(rnd.nextInt(0, 7));

        // State,
        registrationPage.state_textBox.sendKeys(faker.address().state());

        // City,
        registrationPage.city_textBox.sendKeys(faker.address().city());

        // Zipcode,
        registrationPage.zipcode_textBox.sendKeys(faker.address().zipCode());

        // Mobile Number
        registrationPage.mobileNumber_textBox.sendKeys(random(11, false, true));

        //13. Click 'Create Account button'
        registrationPage.createAccount_button.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        String actualText = registrationPage.accCreated_text.getText();
        String expectedText = "ACCOUNT CREATED";
        System.out.println("-----Account Created------");
        Assert.assertTrue(actualText.contains(expectedText), "ACCOUNT CREATED yazısı goruntulenmedi");

        registrationPage.continue_button.click();

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            registrationPage.continue_button.click();
        }


        registrationPage.logout_button.click();


        Map<String, String> registerInfoMap = new HashMap<>();
        registerInfoMap.put("name", randomName);
        registerInfoMap.put("email", randomEmail);
        registerInfoMap.put("password", randomPassword);
        registerInfoMap.put("lastName", randomLastName);


        Driver.getDriver().findElement(By.xpath("//a[@href='/']//*[@class='fa fa-home']")).click();

        return registerInfoMap;
    }


    public static Map<String, String> register_fromLoginPage() {
        // url should be https://automationexercise.com/login
        RegistrationPage registrationPage = new RegistrationPage();
        Faker faker = new Faker();
        Random rnd = new Random();
        Select select;
        String randomName;
        String randomEmail;
        String randomPassword;
        String randomfirstName;
        String randomLastName;
        String randomCompany;
        String fakerAdress;
        String fakerAdressSecond;
        String ddmCountry;
        String fakerState;
        String fakerCity;
        String randomMobileNumber;
        String fakerZipCode;


        //6. Enter name and email address
        randomName = random(5, true, false) + rnd.nextInt(0, 11);
        //   System.out.println("random userName --> " + randomName);
        registrationPage.userName_NameTextbox.sendKeys(randomName);


        randomEmail = random(5, true, false) + "@bmail.com";
        // System.out.println("randomEmail ---> " + randomEmail);
        registrationPage.signUpEmailAddress_textbox.sendKeys(randomEmail);

        //7. Click 'Signup' button
        registrationPage.signUpButton.click();

        //9. Fill details: Title, Name, Email, Password, Date of birth
        registrationPage.mr_radioButton.click();

        //password
        randomPassword = random(6, true, true);
        // System.out.println("randomPassword ---> " + randomPassword);
        registrationPage.password_textBox.sendKeys(randomPassword);

        //day,month,year
        select = new Select(registrationPage.day_ddm);
        select.selectByVisibleText(String.valueOf(rnd.nextInt(1, 32)));

        select = new Select(registrationPage.month_ddm);
        select.selectByValue(String.valueOf(rnd.nextInt(1, 13)));

        select = new Select(registrationPage.years_ddm);
        select.selectByVisibleText(String.valueOf(rnd.nextInt(1900, 2022)));

        //10. Select checkbox 'Sign up for our newsletter!'
        registrationPage.newsletter_checkbox.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        registrationPage.specialOffers_checkbox.click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //First name,
        randomfirstName = random(6, true, false);
        // System.out.println("random firstName  --> " + randomfirstName);
        registrationPage.firstName_textBox.sendKeys(randomfirstName);
        //  wait(3);

        // Last name,
        randomLastName = random(7, true, false);
        // System.out.println("random randomLastName -->  " + randomLastName);
        registrationPage.lastName_textBox.sendKeys(randomLastName);

        // Company,
        randomCompany = random(5, true, false) + " " + random(3, true, false);
        registrationPage.company_textBox.sendKeys(randomCompany);

        // Address1,
        fakerAdress = faker.address().fullAddress();
        registrationPage.address1_textBox.sendKeys(fakerAdress);

        // Address2,
        fakerAdressSecond = faker.address().cityName();
        registrationPage.address2_textBox.sendKeys(fakerAdressSecond);

        // Country,
        select = new Select(registrationPage.country_ddm);
        select.selectByIndex(rnd.nextInt(0, 7));
        ddmCountry = select.getFirstSelectedOption().getText();

        // State,
        fakerState = faker.address().state();
        registrationPage.state_textBox.sendKeys(fakerState);

        // City,
        fakerCity = faker.address().city();
        registrationPage.city_textBox.sendKeys(fakerCity);

        // Zipcode,
        fakerZipCode = faker.address().zipCode();
        registrationPage.zipcode_textBox.sendKeys(fakerZipCode);

        // Mobile Number
        randomMobileNumber = random(11, false, true);
        registrationPage.mobileNumber_textBox.sendKeys(randomMobileNumber);

        //13. Click 'Create Account button'
        registrationPage.createAccount_button.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        String actualText = registrationPage.accCreated_text.getText();
        String expectedText = "ACCOUNT CREATED";
        System.out.println("-----Account Created------");
        Assert.assertTrue(actualText.contains(expectedText), "ACCOUNT CREATED yazısı goruntulenmedi");

        registrationPage.continue_button.click();

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            registrationPage.continue_button.click();
        }


        Map<String, String> registerInfoMap = new HashMap<>();
        registerInfoMap.put("userName", randomName);
        registerInfoMap.put("email", randomEmail);
        registerInfoMap.put("password", randomPassword);
        registerInfoMap.put("lastName", randomLastName);
        registerInfoMap.put("randomfirstName", randomfirstName);
        registerInfoMap.put("randomLastName", randomLastName);
        registerInfoMap.put("randomCompany", randomCompany);
        registerInfoMap.put("fakerAdress", fakerAdress);
        registerInfoMap.put("fakerAdressSecond", fakerAdressSecond);
        registerInfoMap.put("ddmCountry", ddmCountry);
        registerInfoMap.put("fakerState", fakerState);
        registerInfoMap.put("fakerCity", fakerCity);
        registerInfoMap.put("randomMobileNumber", randomMobileNumber);
        registerInfoMap.put("fakerZipCode", fakerZipCode);

        return registerInfoMap;


    }


    public static void deleteUserAndVerifyAccDeleted() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.deleteAcc_button.click();

        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
        }
        String actualText = registrationPage.accDeleted_text.getText();
        String expectedText = "ACCOUNT DELETED";
        Assert.assertTrue(actualText.contains(expectedText), "ACCOUNT DELETED! - text is not visible");
        registrationPage.continue_button.click();
        waitFor(1);

        //register_test_TC01()

    }


    public static String getRandomUserName() {
        Random rnd = new Random();
        return random(5, true, false) + rnd.nextInt(0, 11);
    }


    public static void login_fromLoginPage(String email, String passWord) {
        LoginPage loginpage = new LoginPage();
        //Verify 'Login to your account' is visible
        String expected_text = "Login to your account";
        Assert.assertTrue(loginpage.login_text.getText().toLowerCase().contains(expected_text.toLowerCase()));

        // Enter correct email address and password
        loginpage.login_email.sendKeys(email, Keys.TAB, passWord);

        // Click 'login' button
        loginpage.login_button.click();
        System.out.println("logged in using email --> " + email + "\n and password as --> " + passWord);
        waitFor(2);

        //Verify that 'Logged in as username' is visible
        System.out.println(loginpage.loggedIn_Text.getText());
        Assert.assertTrue(loginpage.loggedIn_Text.isDisplayed(), "Logged in as Username yazısı görüntülenmedi");
    }


    public static void logoutUser() {
        LoginPage loginpage = new LoginPage();
        loginpage.logout_button.click();
    }

    public static void verifyLandedToHomePage() {
        HomePage homePage = new HomePage();
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "anasayda url dogru degil");
        Assert.assertTrue(homePage.adsOfHomepage.isDisplayed(), "Anasayfa Reklamları goruntulenmiyor");
    }

    public static void handleGoogleVignette(Runnable block) {
        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().navigate().refresh();
            block.run();
            // scrollIntoViewAndClickByJavaScript(contactUsPage.home_button);
            waitFor(1);
        }
        /*
        --> to call the method use new Runnable() as parameter
         handleGoogleVignette(new Runnable() {
            @Override
            public void run() {
                contactUsPage.home_button.click();
            }
        });

        --> make it easier with using lambda
        handleGoogleVignette(() -> contactUsPage.home_button.click());
         */
    }


    public static void verifyProductDetails(String productDetails) {
        ProductsPage productsPage = new ProductsPage();
        Assert.assertTrue(productsPage.firstProductInfo_text.getText()
                        .contains(productDetails)
                , "There is not Product name in Product Details");

        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(productsPage.firstProductInfo_text.getText().toLowerCase()
                .contains("category"), "Category detail is not visible");

        // softassert.assertTrue(productsPage.firstProductInfo_text.getText().toLowerCase()
        //       .contains("price"), "Price detail is not visible");

        softassert.assertTrue(productsPage.firstProductInfo_text.getText().toLowerCase()
                .contains("availability"), "Availability detail is not visible");

        softassert.assertTrue(productsPage.firstProductInfo_text.getText().toLowerCase()
                .contains("condition"), "Condition detail is not visible");

        softassert.assertTrue(productsPage.firstProductInfo_text.getText().toLowerCase()
                .contains("brand"), "Brand detail is not visible");
        softassert.assertAll();
    }

    public static String getFirstProduct() {
        ProductsPage productsPage = new ProductsPage();
        String firstProduct = productsPage.allProducts_list.get(0).getText();
        firstProduct = firstProduct.replace("Add to cart", "")
                .replaceAll("\\d", "*");
        firstProduct = firstProduct.substring(firstProduct.lastIndexOf("*") + 1)
                .trim();
        return firstProduct;
    }

    public static void verifyAllProductsRelatedToSearch(String wordToBeSearched) throws InterruptedException {
        ProductsPage productsPage = new ProductsPage();
        Actions actions = new Actions(Driver.getDriver());
        List<WebElement> products_list = productsPage.viewProduct_Buttons;
        String parentWindow = Driver.getDriver().getWindowHandle();
        List<String> windowsHandles;

        // handleGoogleVignette(()->Driver.getDriver().navigate().refresh());
        for (int i = 0; i < products_list.size(); i++) {
            actions.keyDown(Keys.CONTROL)
                    .moveToElement(
                            products_list.get(i))
                    .click().keyUp(Keys.CONTROL).build().perform();

            windowsHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
            Driver.getDriver().switchTo().window(windowsHandles.get(1));
            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            System.out.println("Product name  - " + productsPage.productName_Text.getText());
            System.out.println("category bilgisi" + productsPage.categoryOfTheProduct.getText());
            Assert.assertTrue(productsPage.categoryOfTheProduct.getText().toLowerCase()
                    .contains(wordToBeSearched.toLowerCase()));
            System.out.println("ürün " + (i + 1) + " kontrol edildi");
            Driver.getDriver().close();
            Driver.getDriver().switchTo().window(parentWindow);
        }
    }

    public static Map<String, List<String>> getTwoProductsNameAndPriceBeforeCart() {
        CartPage cartPage = new CartPage();
        Actions actions = new Actions(Driver.getDriver());
        Map<String, List<String>> twoProductsInfo = new HashMap<>();
        List<WebElement> products_List = cartPage.viewProduct_Buttons;
        String windowHandle = Driver.getDriver().getWindowHandle();
        List<String> windowHandles;
        List<String> productNames_list = new ArrayList<>();
        List<String> productPrice_list = new ArrayList<>();


        for (int i = 0; i < 2; i++) {
            actions.keyDown(Keys.CONTROL)
                    .moveToElement(
                            products_List.get(i))
                    .click().keyUp(Keys.CONTROL).build().perform();
            waitFor(1);


            handleGoogleVignette(() -> Driver.getDriver().navigate().refresh());

            windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());

            if (windowHandles.size()==1){ actions.keyDown(Keys.CONTROL).moveToElement(products_List.get(i))
                    .click().keyUp(Keys.CONTROL).build().perform();
                windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());}
            Driver.getDriver().switchTo().window(windowHandles.get(1));
            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
           // waitFor(1);

            System.out.println("Product name  -> " + cartPage.productName_Text.getText());
            productNames_list.add(cartPage.productName_Text.getText());


            String price = cartPage.productsAllInfo_Text.getText();
            price = price.substring(price.indexOf("Rs."), price.indexOf("Quantity")).trim();
            productPrice_list.add(price);

            Driver.getDriver().close();
            Driver.getDriver().switchTo().window(windowHandle);
            twoProductsInfo.put("productsName", productNames_list);
            twoProductsInfo.put("productsPrice", productPrice_list);

        }


        return twoProductsInfo;
    }


    public static void validateTwoProductsNamePriceQuantity(Map<String,List<String>> map) {
        CartPage cartPage = new CartPage();
        String expectedTotalPriceInCart_firstProduct = String.valueOf(Integer.parseInt(map.get("productsPrice").get(0).replaceAll("\\D", ""))
                * Integer.parseInt(cartPage.firstProductInCart_quantity.getText()));

        String expectedTotalPriceInCart_secondProduct = String.valueOf(Integer.parseInt(map.get("productsPrice").get(1).replaceAll("\\D", ""))
                * Integer.parseInt(cartPage.secondProductInCart_quantity.getText()));

       SoftAssert softAssert = new SoftAssert();
        // 1 ürün kontrol ,name, prices, quantity and total price

        softAssert.assertEquals(cartPage.firstProductInCart_name.getText().toLowerCase()
                , map.get("productsName").get(0).toLowerCase()
                , "the name of the first product in cart is not the same with the product name added to cart");

        softAssert.assertEquals(cartPage.firstProductInCart_price.getText().toLowerCase()
                , map.get("productsPrice").get(0).toLowerCase()
                , "Price of the First products in cart isn't same the actual price");

        softAssert.assertEquals(cartPage.firstProductInCart_quantity.getText().toLowerCase()
                , "1"
                , "Quantity of the First product in cart isn't same with the expected quantity");

        softAssert.assertTrue(cartPage.firstProductInCart_totalPrice.getText()
                        .contains(expectedTotalPriceInCart_firstProduct)
                , "the Total Price of the first product is not correct as expected");

        // 2. ürün kontrol ,name, prices, quantity and total price
        softAssert.assertEquals(cartPage.secondProductInCart_name.getText().toLowerCase()
                , map.get("productsName").get(1).toLowerCase()
                , "the name of the second product in cart is not the same with the product name added to cart");
        softAssert.assertEquals(cartPage.secondProductInCart_price.getText().toLowerCase()
                , map.get("productsPrice").get(1).toLowerCase()
                , "Price of the Second products in cart isn't same the actual price");
        softAssert.assertEquals(cartPage.secondProductInCart_quantity.getText().toLowerCase()
                , "2"
                , "Quantity of the Second product in cart isn't same with the expected quantity");
        softAssert.assertTrue(cartPage.secondProductInCart_totalPrice.getText()
                        .contains(expectedTotalPriceInCart_secondProduct)
                , "the Total Price of the Second product is not correct as expected");
        softAssert.assertAll();
    }

    public static void deleteProductAndVerifyDeletedItemInCartPage(){
        CartPage cartPage=new CartPage();
        Random rnd= new Random();
        int xButtonFirstCount = cartPage.xButton_List.size();

        List<WebElement> productDescription_List = cartPage.product_description;
        int productsDescriptionCount = productDescription_List.size();

        int xButtonToBeDeleted_index = rnd.nextInt(0, xButtonFirstCount);
        String xButtonToBeDeleted_Text = productDescription_List.get(xButtonToBeDeleted_index).getText().toLowerCase();
        cartPage.xButton_List.get(xButtonToBeDeleted_index).click();  //clicked random X button

        Assert.assertEquals(xButtonFirstCount, productDescription_List.size()
                , "X button number and items' number in cart page  is not equal");

        //8. Verify that product is removed from the cart
        waitFor(1);
        int xButtonSecondCount = cartPage.xButton_List.size();
        Assert.assertTrue(productsDescriptionCount > xButtonSecondCount
                , "items in cart's number is not bigger than X button number. " +
                        "Expected; items in cart's number should be more than X button number.");

        productDescription_List = cartPage.product_description;
        for (WebElement e: productDescription_List
        ) {
            Assert.assertFalse(e.getText().toLowerCase().contains(xButtonToBeDeleted_Text));
        }
    }

}


















