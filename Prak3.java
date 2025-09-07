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

class Pratikum3WrapperEnum {

    public static void main(String[] args) {
        enum Hari {
        SENIN, SELASA, RABU, KAMIS, JUMAT, SABTU, MINGGU
    }

        System.out.println("=== Contoh Class Wrapper ===");

        // Autoboxing (primitif -> objek)
        int angka = 10;
        Integer objAngka = angka;
        System.out.println("Autoboxing: int -> Integer = " + objAngka);

        // Unboxing (objek -> primitif)
        Integer obj = 20;
        int nilai = obj;
        System.out.println("Unboxing: Integer -> int = " + nilai);

        // String ke Integer
        String teks = "123";
        int hasil = Integer.parseInt(teks);
        System.out.println("String \"123\" -> int = " + hasil);

        // Integer ke String
        Integer angkaObj = 45;
        String teksBaru = angkaObj.toString();
        System.out.println("Integer 45 -> String = " + teksBaru);

        // ====== Bagian Enum ======
        System.out.println("\n=== Contoh Enumerasi (Enum) ===");

        // Menampilkan salah satu nilai enum
        Hari h = Hari.SENIN;
        System.out.println("Hari ini adalah: " + h);

        // Menampilkan semua nilai enum
        System.out.println("Daftar hari:");
        for (Hari hari : Hari.values()) {
            System.out.println(hari);
        }
    }
}