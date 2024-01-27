package AutomationExercise_Project_TestNG.tests.denemeCalismalar;

import org.testng.annotations.Test;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.random;

public class asd {

    @Test
    public void denemeTahtası(){



        random(4);
        Random rand = new Random();
        System.out.println(random(5));
        System.out.println(random(3));
        System.out.println("asddsadsasad " +random(8,true,false));
        System.out.println("random(6, true, false)  "+random(6, true, true));



        //       System.out.println(random(1,2,9,true,true));

      /*
        for (int i = 0; i < 50; i++) {
          //  System.out.println(random(2,false,true));
            random(8,true,false);
            System.out.println(" rand.nextInt(   -->   " +rand.nextInt(9,32));
        }
*/


       /*
        String []alphabet = new String[26];
        int sayac=0;
        for(char karakter= 'a'; karakter <= 'z'; ++karakter){

            alphabet[sayac] += karakter;
            sayac=+1;
        }
        System.out.println("harfler = " + Arrays.toString(alphabet)  );

        */

      //  System.out.println("data turunu ogrenmek icin   -->    "+"abd".getClass().getTypeName());
   //  System.out.println("rastgele rakam -->  " + random(2,0,32,false,true));
   //  System.out.println("data duru-getclass ---> " + (random
          //   (1,1,32,false,true).getClass().getTypeName()));



        System.out.println(" rand.nextInt -->   " +rand.nextInt(32));



    }
}
