package AutomationExercise_Project_TestNG.tests.denemeCalismalar;

import org.testng.annotations.Test;

public class substring {


    @Test
    public void test() {
            /*
    String firstProduct= Rs. 500 Blue Top

    firstProduct=firstProduct.replace("Add to cart","");
        System.out.println("firstProduct-->" + firstProduct);
*/
        String firtsProduct = "Rs. 500 Blue Top";
        int lastSpace = firtsProduct.lastIndexOf(' ');
        String result = firtsProduct.substring(lastSpace + 1); // son boşluktan sonraki tüm karakterleri alır
        System.out.println(result);
    }


    @Test
    public void test01(){
        String firtsProduct = "Rs. 500 Blue Top";
        int lastSpace = firtsProduct.lastIndexOf(' '); // son boşluğun indeksini bulur
        int secondLastSpace = firtsProduct.lastIndexOf(' ', lastSpace - 1); // son boşluktan önceki boşluğun indeksini bulur
        String result = firtsProduct.substring(secondLastSpace + 1); // son iki kelimeyi alır
        System.out.println(result);
    }

    @Test
    public void test000001(){
        String firstProduct = "Rs. 500 Blue Top";
        int lastSpace = firstProduct.lastIndexOf(' '); // son boşluğun indeksini bulur



        int secondLastSpace = firstProduct.lastIndexOf(' ', lastSpace - 1); // son boşluktan önceki boşluğun indeksini bulur
        String result = firstProduct.substring(secondLastSpace + 1); // son iki kelimeyi alır
        System.out.println(result);
    }





}
