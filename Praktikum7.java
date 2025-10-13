/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum7;

/**
 *
 * @author fikry
 */
public class Praktikum7 {
    public static void main(String[] args) {
        BarangElektronik laptop = new BarangElektronik("Laptop", 12000000, 2);
        laptop.tampilInfo();
        laptop.tampilGaransi();
        System.out.println("---------------------");
        
        Produk p1 = new Produk("Buku", 6000);
        BarangElektronik p2 = new BarangElektronik("Mouse", 50000, 6);
        
        p1.tampilInfo();
        System.out.println("Pajak produk umum: "+ p1.hitungPajak());
        System.out.println("Harga akhir produk: "+ p1.hitungHarga());
        System.out.println("---------------------");
        p2.tampilInfo();
        p2.tampilGaransi();
        System.out.println("Pajak barang garansi: "+ p2.hitungPajak());
        System.out.println("Harga akhir produk: "+ p2.hitungHarga());
        System.out.println("---------------------");
    }
}

