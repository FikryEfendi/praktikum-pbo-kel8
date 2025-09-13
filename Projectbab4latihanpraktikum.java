package com.mycompany.projectbab4latihanpraktikum;
import java.util.Scanner;

public class Projectbab4latihanpraktikum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean alur = true;
        
        while(alur){
            System.out.println("Program menghitung luas bangun datar");
            System.out.println("Pilih bangun datar");
            System.out.println("1. Persegi");
            System.out.println("2. Persegi Panjang");
            System.out.println("3. Lingkaran");
            System.out.println("4. Segitiga");
            
            System.out.print("Pilihan: ");
            int pilihan = input.nextInt();
            input.nextLine();
            
            switch(pilihan){
                case 1:
                    System.out.println("Persegi");
                    System.out.print("Masukkan Sisi Persegi: ");
                    int sisi = input.nextInt();
                    int luasPersegi = sisi * sisi;
                    System.out.println("Luas Persegi : "+ luasPersegi +" cm");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Persegi Panjang");
                    System.out.print("Masukkan Panjang: ");
                    int panjang = input.nextInt();
                    System.out.print("Masukkan lebar: ");
                    int lebar = input.nextInt();
                    int luasPersegiPanjang = panjang * lebar;
                    System.out.println("Luas Persegi Panjang : "+ luasPersegiPanjang +" cm");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Lingkaran");
                    System.out.print("Masukkan jari-jari Lingkaran: ");
                    double jari = input.nextInt();
                    double pi = 3.14;
                    double luasLingkaran = pi * (jari * jari);
                    System.out.println("Luas Lingkaran : "+ luasLingkaran +" cm");
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Segitiga");
                    System.out.print("Masukkan Alas Segitiga: ");
                    int alas = input.nextInt();
                    System.out.print("Masukkan Tinggi Segitiga: ");
                    int tinggi = input.nextInt();
                    int luasSegitiga = (alas * tinggi) / 2;
                    System.out.println("Luas Segitiga : "+ luasSegitiga +" cm");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    System.out.println("");
                    break;
            }

        }
    }
}
