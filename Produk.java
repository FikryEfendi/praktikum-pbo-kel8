/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.praktikumpbo.projek6hasilprak;

/**
 *
 * @author Lenovo
 */
public class Produk {
    public String nama;
    private double harga;
    protected int stok;
    private String namaSupplier = "Anton";
    
    //static variable
    static int jumlahProduk = 0; //untuk setiap product yang dibuat, HANYA ADA SATU VARIABEL jumlahProduk
    
    public Produk (String nama, double harga, int stok){
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        jumlahProduk++;
    }
 
    
    public void tampilkanInfo() {
        System.out.println("nama: " +nama);
        System.out.println("harga: " + harga);
        System.out.println("Stok: " + stok);     
        
    }
    
    private void namaSupplier(){
        System.out.println("Nama Supplier: " + namaSupplier + '\n');
    }
    
    public void namaSupplierFix(){
        namaSupplier(); //memanggil function namaSupplier, yang hanya bisa diakses class Produk saja
    }
    
    //Getter (mendapatkan nilai atribut private)
    public double getHarga(){
        return harga; //mendapatkan nilai harga
    }
    
    //Setter (mengubah nilai atribut private)
    public void setHarga (double hargaBaru){
        if (hargaBaru > 0){
            this.harga = hargaBaru;
            System.out.println("harga baru adalah: " + this.harga);
        }
        else if (hargaBaru == 0){
            this.harga = hargaBaru;
            System.out.println("Barang gratis!");
        }
        else{
            System.out.println("harga tidak bisa negatif");
        }
        
    }
}
