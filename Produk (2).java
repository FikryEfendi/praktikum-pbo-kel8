/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.praktikumpbo.projectbab7hasil;

/**
 *
 * @author Lenovo
 */
public class Produk {
    protected String nama;
    protected int harga;
    
    //constructor
    public Produk (String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }
    
    public void tampilkanInfo(){
        System.out.println("Nama produk : " + nama);
        System.out.println("harga       : " + harga);
    }
}
