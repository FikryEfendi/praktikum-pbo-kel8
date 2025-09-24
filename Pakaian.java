/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.praktikumpbo.projectbab5;

/**
 *
 * @author Lenovo
 */
//definisi class
public class Pakaian {
   String bahan;
   String ukuran;
   String warna;
   double panjangCm;
   
   //overloaded constructor
   public Pakaian(){
        this.bahan = "katun";
        this.ukuran = "M";
        this.warna = "hitam";
   }
   
   public Pakaian(String warnaSampel, String ukuranSampel){
       this.warna = warnaSampel;
       this.ukuran = ukuranSampel;
       this.bahan = "linen";
       this.panjangCm = 70.0;       
   }
   
   public Pakaian(String bahanSampel, String warnaSampel, String ukuranSampel, double panjangSampel){
       this.bahan = bahanSampel;
       this.ukuran = ukuranSampel;
       this.warna = warnaSampel;
       this.panjangCm = panjangSampel;
   }
   
   //overloaded method
   static public void deskripsi(String bahan, String warna){
       System.out.printf("Pakaian ini berbahan %s dan berwarna %s\n\n", bahan, warna);
   }
   
    static public void deskripsi(String bahan, String warna, String ukuran, double panjang){
       System.out.printf("Pakaian ini berbahan %s dan berwarna %s,\nukurannya %s dengan panjang %f cm\n\n",
               bahan, warna, ukuran, panjang);
   }
    
    public String deskripsi(String ukuran, double panjang){
       return "Pakaian ini ukurannya " + ukuran + "(panjang " + panjang + " cm)";
   }
    
}
