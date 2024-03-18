package AutomationExercise_Project_TestNG.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    //    Bu sinif configuration.properties file i okumak icin kullanilir
        //    property file i okumak icin properti objecsi kullanilir


    private static Properties properties;

    static{  // burda alttaki getProperty methodu çalışmadan önce configuration.properties dosyasını properties objesine yukledik.
            // static blok herseyden önce calisir.

        //        data cekmek istedigim dosyaninin path i
        String path = "configuration.properties";


        try {  //  properties.load(fis) ve FileInputStream    fis = new FileInputStream(path); exception fırlattığı icin try catch yaptık
            FileInputStream    fis = new FileInputStream(path);
            // fis olarak yolunu tanımladiğimiz configuration.properties dosyasını okuttuk.

            properties = new Properties(); // yukarıda deklare edilen Properties objesini initialize, değer ataması yaptık
                                            // properties objesini instantiate ediyoruz

            properties.load(fis);  // olusturduğumuz properties objesine fis'deki dosyayı ya da fis'i yukledik
                                    // configuration.property dosyasindaki datalari yukler

           // file input steam i kapatilir
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static String getProperty(String key){
         /*
          test method'undan yolladigimiz string key degerini alip
          Properties class'indan getProperty( ) method'unu kullanarak
          bu key'e ait value'u bize getirdi
         */
        return properties.getProperty(key); // value dondurur.

    }


    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
        String path = "configuration.properties";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            properties.store(fos, null);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
