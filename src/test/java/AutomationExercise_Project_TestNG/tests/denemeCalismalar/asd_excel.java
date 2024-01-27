package AutomationExercise_Project_TestNG.tests.denemeCalismalar;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;


public class asd_excel {

    @Test
    public void test() throws IOException {
        String path = "resources/Aut_Exercise.xlsx";
        FileInputStream fis = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Credentials");


        int satirSayisi = sheet.getLastRowNum();



        String date_time = LocalDateTime.now().toString();
        String username= "userName1";
        String email="email@email.com";
        String password ="password1";



        sheet.createRow(satirSayisi+1)
                .createCell(0).
                setCellValue(date_time);

        sheet.getRow(satirSayisi+1)
                .createCell(1).
                setCellValue(username);

        sheet.getRow(satirSayisi+1)
                .createCell(2).
                setCellValue(email);

        sheet.getRow(satirSayisi+1)
                .createCell(3).
                setCellValue(password);




        // exceli kaydedin ve kapatin
        FileOutputStream fos = new FileOutputStream(path);

        workbook.write(fos);
        workbook.close();
        fos.close();
        fis.close();



    }
    public void beforeTestCase(Method method) {
        String testName = method.getName(); // this will return the test method name
        System.out.println(testName);
    }


}
