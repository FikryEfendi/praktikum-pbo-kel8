/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum6;

/**
 *
 * @author fikry
 */
public class Praktikum6 {

    public static void main(String[] args) {
        Produk p1 = new Produk("Laptop", 12000000, 5);
        Produk p2 = new Produk("Handphone", 5000000, 10);
        Produk p3 = new Produk("Laptop", 12000000, 5);
        Produk p4 = new Produk("Handphone", 5000000, 10);
        
        p1.tampilkanInfo();
        p1.tampilNamaSuplier();
        p1.setHarga(10800000);
        System.out.println("Harga produk adalah : "+ p1.getHarga());
        System.out.println("Jumlah produk adalah : "+ Produk.jumlahProduk);
        Produk.tampilkanJumlahProduk();
    }
}
