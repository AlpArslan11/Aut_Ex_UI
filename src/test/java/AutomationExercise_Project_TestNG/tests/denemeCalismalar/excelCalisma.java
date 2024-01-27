package AutomationExercise_Project_TestNG.tests.denemeCalismalar;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class excelCalisma {




       @Test
       public void testt(){
            String excelPath = "resources/test_data.xlsx";
            FileInputStream fis;
            Workbook workbook;
            Sheet sheet = null;
            Cell cell = null;
            try {
                fis = new FileInputStream(excelPath);
                workbook = WorkbookFactory.create(fis);
                sheet = workbook.getSheet("test_data");

            } catch (IOException e) {
                System.out.println("Can not read the excel file");
            }

            String searchTerms;
            List<String> testData_list = new ArrayList<>();

           System.out.println(sheet.getRow(1).getCell(1));


            assert sheet != null;

            int cellIndex = 1;

            /*
            int rowCount=0;
           for (int i = 0; i < 10; i++) {
               try{
                   if (sheet.getRow(i).getCell(cellIndex)!=null)rowCount++;
               }catch (Exception e){

               }
           }
*/


            for (int i = 1; i < sheet.getLastRowNum() ; i++) {
              try {
                  searchTerms = sheet.getRow(i).getCell(cellIndex).toString();
                  testData_list.add(searchTerms);
                  System.out.println("searchTerms-> " + searchTerms);
              }catch (Exception e){
              }
            }

            int count = 0;
            for (String str : testData_list
            ) {
                count++;
                System.out.println(count + ".inci element --> " + str);
            }
        }
}
