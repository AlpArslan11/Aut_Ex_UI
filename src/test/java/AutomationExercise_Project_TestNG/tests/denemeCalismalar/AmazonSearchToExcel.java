package AutomationExercise_Project_TestNG.tests.denemeCalismalar;

import AutomationExercise_Project_TestNG.pages.AmazonPage;
import AutomationExercise_Project_TestNG.utilities.ConfigReader;
import AutomationExercise_Project_TestNG.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AmazonSearchToExcel {

    //excel dosyasindaki aranacak kelimeleri amazonda aratin.
    // arama sonuclarini excele ekleyin
    //  resmi dosya adinı excele ekleyin
    //Screen Shotlari alin ve excelde ilgili yere insert (yapıştırın) yapın.
    // exceli kaydedin ve kapatin


    @Test
    public void amazonSearchResultToExcelWithScreenShot() throws IOException {


        //1---->excel dosyasindaki aranacak kelimeleri amazonda aratin.
        String dosyaYolu = "resources/amazonsearch.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        XSSFWorkbook workbook = new XSSFWorkbook(fis); //2. yontem
        XSSFSheet sheet = workbook.getSheet("Sayfa1");
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        Driver.getDriver().navigate().refresh();

        AmazonPage amazonPage = new AmazonPage();
        int satırSayisi = sheet.getLastRowNum();

        //--------

        String aranacakKelime;
        String aramaSonucu;
        String ssResimAdı;
        TakesScreenshot ts;
        File file;
        Path pathYol;
        byte[] ımageContentImajIcerigi;
        int pictureIndex;
        XSSFClientAnchor anchorKonum;
        XSSFDrawing drawingPatriarchCizimTahtasi;

        for (int i = 1; i < satırSayisi; i++) {
            aranacakKelime = sheet.getRow(i).getCell(0).toString();
            amazonPage.aramakutusu.sendKeys(aranacakKelime, Keys.ENTER);

            //2-----> arama sonuclarini excele ekleyin

            aramaSonucu = amazonPage.aramaSonucWE.getText();
            sheet.getRow(i).createCell(1).setCellValue(aramaSonucu);

            // 3---->  resim dosya adinı excele ekleyin
            ssResimAdı = aranacakKelime + "-ScreenShots";
            sheet.getRow(i).createCell(2).setCellValue(ssResimAdı);

            //4-----> Screen Shotlari alin ve excelde ilgili yere insert (yapıştırın) yapın.

            ts = (TakesScreenshot) Driver.getDriver();
            file = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("target/Screenshots/Amazon/" + ssResimAdı + ".jepg"));

            // 5-->ve excelde ilgili yere insert (yapıştırın) yapın.
            // oku-kopyala-konteynr
            pathYol = Path.of("target/Screenshots/Amazon/" + ssResimAdı + ".jepg");
            ımageContentImajIcerigi = Files.readAllBytes(pathYol);

            //resim verilernii excele getir, taşı, ekle
            pictureIndex = workbook.addPicture(ımageContentImajIcerigi, Workbook.PICTURE_TYPE_JPEG);

            //konum belirle
            anchorKonum = new XSSFClientAnchor(0, 0, 0, 0, 3, i, 5, i + 1);
            // anchorKonum.setRow1(i);
            //  anchorKonum.setCol1(3);
            // anchorKonum.setRow2(i+1);
            // anchorKonum.setCol2(5);

            //gorsel olarak çiz, getir.

            drawingPatriarchCizimTahtasi = sheet.createDrawingPatriarch();
            drawingPatriarchCizimTahtasi.createPicture(anchorKonum, pictureIndex);


            amazonPage.aramakutusu.clear();
        }
        // exceli kaydedin ve kapatin
        FileOutputStream fos = new FileOutputStream(dosyaYolu);

        workbook.write(fos);
        workbook.close();
        fos.close();
        fis.close();
        Driver.closeDriver();


    }
}

