/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum7;

/**
 *
 * @author fikry
 */
public class Produk implements HargaAkhir{
    protected String nama;
    protected int harga;
    
    public Produk(String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }
    public void tampilInfo(){
        System.out.println("Nama barang: "+ nama);
        System.out.println("Harga barang: "+ harga);
    }
    public double hitungPajak(){
        return harga * 0.05;
    }
    @Override
    public double hitungHarga(){
        return harga * 1.05;
    }
}