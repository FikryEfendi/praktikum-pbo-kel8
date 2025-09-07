package com.mycompany.projectbab3hasilpraktikum;
import java.util.Scanner;

public class Projectbab3hasilpraktikum {

    public static void main(String[] args) {
        operator(args);
        inputOutput(args);
        wrapper(args);
        enumerasi(args);
    }
    
    public static void operator(String[] args) {
        //Operator Aritmatika
        System.out.println("Operator Aritmatika");
        int a = 10, b = 5;
        System.out.println("a = 10, b = 5");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
        System.out.println("++a = " + (++a));
        System.out.println("b-- = " + (b--));
        System.out.println("");
        
        //Operator Perbandingan
        System.out.println("Operator Perbandingan");
        int x = 10, y = 5;
        System.out.println("x == y: " + (x == y)); 
        System.out.println("x != y: " + (x != y)); 
        System.out.println("x > y: " + (x > y));  
        System.out.println("x < y: " + (x < y)); 
        System.out.println("x >= y: " + (x >= y)); 
        System.out.println("x <= y: " + (x <= y));
        System.out.println(""); 
        
        //Operator Logika 
        System.out.println("Operator Logika");
        boolean p = true, q = false;
        System.out.println("p && q: " + (p && q)); 
        System.out.println("p || q: " + (p || q)); 
        System.out.println("!p: " + (!p));
        System.out.println(""); 
        
        //Operator Assignment
        System.out.println("Operator Assignment");
        int num = 10;
        num += 5;   // num = num + 5;   // 15
        num -= 3;   // num = num - 3;   // 12
        num *= 2;   // num = num * 2;   // 24
        num /= 4;   // num = num / 4;   // 6
        num %= 4;   // num = num % 4;   // 2
        System.out.print("Hasil Akhir num = "+ num);
        System.out.println(""); 
        
        //Operator Ternary
        System.out.println("Operator Ternary");
        int score = 85;
        String grade = (score >= 80) ? "A" : (score >= 70) ? "B" : "C";
        System.out.println("Nilai: " + grade);
        int max = (10 > 5) ? 10 : 5;          //mencari nilai max
        System.out.println("Maximum: " + max);
        System.out.println(""); 
        
        //Operator Bitwise
        System.out.println("Operator Bitwise");
        int i = 12;  // 1100 dalam biner
        int j = 10;  // 1010 dalam biner
        System.out.println("i & j = " + (i & j));   // AND: 8 (1000)
        System.out.println("i | j = " + (i | j));   // OR: 14 (1110)
        System.out.println("i ^ j = " + (i ^ j));   // XOR: 6 (0110)
        System.out.println("~i = " + (~i));         // NOT: -13
        System.out.println("i << 2 = " + (i << 2)); // Left shift: 48
        System.out.println("i >> 2 = " + (i >> 2)); // Right shift: 3
        System.out.println("#########################################"); 
    }
    
    public static void inputOutput(String[] args) {
        System.out.println("Input/Output");
        //Input
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nama Matakuliah: ");
        String mataKuliah = input.nextLine();   //Input String
        System.out.print("Masukkan Angkatan: ");
        int angkatan = input.nextInt();         //Input Integer
        System.out.print("Masukkan IPK: ");
        double ipk = input.nextDouble();        //Input Double
        
        //Output
        System.out.print("matakuliah: "+ mataKuliah);         //print()
        System.out.print(" angkatan: "+ angkatan);
        System.out.println(" ipk: "+ ipk);
        System.out.println("matakuliah: "+ mataKuliah);         //println()
        System.out.println("angkatan: "+ angkatan);
        System.out.println("ipk: "+ ipk);
        System.out.printf("matakuliah: %s, angkatan: %d, ipk; "
                + "%.1f %n", mataKuliah, angkatan, ipk);    //printf
        System.out.println("#########################################"); 
    }
    
    public static void wrapper(String[] args) {
        System.out.println("Class Wrapper");
        //Autoboxing
        int a = 10;
        Integer WrapperA = a; //primitif ke object
        System.out.println("Autoboxing: " + WrapperA);

        //Unboxing
        Integer b = 20;
        int nilaiB = b; //object ke primitif
        System.out.println("Unboxing: " + nilaiB);

        //Konversi String ke Wrapper
        String str = "100";
        Integer objInt = Integer.valueOf(str);
        System.out.println("Konversi String ke Wrapper: " + objInt);

        //Konversi Wrapper ke String
        String str2 = objInt.toString();
        System.out.println("Konversi Wrapper ke String: " + str2);

        //Method-method pada Wrapper Class
        System.out.println("Integer MAX: " + Integer.MAX_VALUE);
        System.out.println("Integer MIN: " + Integer.MIN_VALUE);
        
        // Konversi Desimal ke Biner, Oktal, dan Heksadesimal
        int nilai = 25;
        System.out.println("Desimal: " + nilai);
        System.out.println("Biner: " + Integer.toBinaryString(nilai));
        System.out.println("Oktal: " + Integer.toOctalString(nilai));
        System.out.println("Heksadesimal: " + Integer.toHexString(nilai));
        System.out.println("#########################################"); 
    }
    
    enum Hari {                       //Membuat enum Hari
        SENIN, SELASA, RABU, KAMIS, JUMAT, SABTU, MINGGU
    }
    
    public static void enumerasi(String[] args) {
        System.out.println("Enumerasi");
        Hari hariIni = Hari.SENIN;

        if (hariIni == Hari.SENIN) {
            System.out.println("Hari ini adalah Senin!");
            System.out.println("Besok adalah " + Hari.SELASA);
        }
    }
}
