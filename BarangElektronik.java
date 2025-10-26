/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.praktikumpbo.projectbab7hasil;

/**
 *
 * @author Lenovo
 */
public class BarangElektronik extends Produk {
    private int garansi;
    
    //constructor. make kata kerja super buat make constructor superclass
    public BarangElektronik (String nama, int harga, int garansi){
        super(nama, harga);
        this.garansi = garansi;
    }
    
    public void tampilkanGaransi(){
        System.out.println("Garansi    : " +garansi+ " bulan");
    }
}
