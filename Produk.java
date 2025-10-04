/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum6;

/**
 *
 * @author fikry
 */
public class Produk {
    public String nama;
    private double harga;
    protected int stok;
    private String namaSuplier = "fikry";
    
    static int jumlahProduk = 0;
    
    public static void tampilkanJumlahProduk(){
        System.out.println("Jumlah produk adalah : "+ jumlahProduk);
    }
    public Produk(String nama, double harga, int stok){
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        jumlahProduk ++;
    }
    public double getHarga(){
        return harga;
    }
    public void setHarga(double hargaBaru){
        if(hargaBaru > 0){
            this.harga = hargaBaru;
            System.out.println("Harga baru adalah : "+ this.harga);
        }
        else if (hargaBaru == 0){
            this.harga = hargaBaru;
            System.out.println("Barang Gratis!!!");
        }
        else{
            System.out.println("Harga tidak bisa negatif");
        }
    }
    
    public void tampilkanInfo(){
        System.out.println("nama : "+ nama);
        System.out.println("harga : "+ harga);
        System.out.println("stok : "+ stok);
    }
    public void tampilNamaSuplier(){
        System.out.println("Nama Suplier : "+ namaSuplier);
    }
}