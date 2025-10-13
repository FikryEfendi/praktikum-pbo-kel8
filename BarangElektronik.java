/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum7;

/**
 *
 * @author fikry
 */
public class BarangElektronik extends Produk implements HargaAkhir{
    private int garansi;
    
    public BarangElektronik(String nama, int harga, int garansi){
        super(nama, harga);
        this.garansi = garansi;
    }
    public void tampilGaransi(){
        System.out.println("Garansi barang: "+ garansi +" tahun");
    }
    @Override
    public double hitungPajak(){
        return harga * 0.01;
    }
    @Override
    public double hitungHarga(){
        return harga * 1.01;
    }
}