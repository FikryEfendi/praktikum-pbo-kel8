/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum6latihan;

/**
 *
 * @author fikry
 */
public class Jurusan {
    public String nama;
    private int jumlahProdi;
    
    public Jurusan(String nama, int jumlahProdi){
        this.nama = nama;
        this.jumlahProdi = jumlahProdi;
    }
    public int getJumlahProdi(){
        return jumlahProdi;
    }
    public void setJumlahProdi(int jumlahProdiBaru){
        this.jumlahProdi = jumlahProdiBaru;
        System.out.println("Jumlah Prodi baru adalah : "+ this.jumlahProdi);
    }
    public void tampilkanInfo(){
        System.out.println("Nama Jurusan : "+ nama);
    }
}
