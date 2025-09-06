import java.util.Scanner;

public class Prak3 
{
    public static void main(String[] args) 
    {
       int a;
       int b;
       Scanner input = new Scanner(System.in);
         System.out.print("Masukkan nilai a: ");
         a = input.nextInt();
         System.out.print("Masukkan nilai b: ");
         b = input.nextInt();

        System.out.println();    //Operator Aritmatika//
        System.out.println("###############################################################");
        System.out.println("Hasil dari penjumlahan a + b = " + (a + b));
        System.out.println("Hasil dari pengurangan a - b = " + (a - b));
        System.out.println("Hasil dari perkalian a * b = " + (a * b));
        System.out.println("Hasil dari pembagian a / b = " + (a / b));
        System.out.println("Hasil dari modulus a % b = " + (a % b));
        System.out.println();

        System.out.println("Hasil dari ++a = " + (++a));
        System.out.println("Hasil dari --b = " + (--b));
        System.out.println();

        //Operator Perbandingan//
        System.out.println("perbandingan antara a == b adalah " + (a == b));
        System.out.println("perbandingan antara a != b adalah " + (a != b));
        System.out.println("perbandingan antara a > b adalah " + (a > b));
        System.out.println("perbandingan antara a < b adalah " + (a < b ));
        System.out.println("perbandingan antara a >= b adalah " + (a >= b));
        System.out.println("perbandingan antara a <= b adalah " + (a <= b));
        System.out.println("###############################################################");
        
        
    }
}