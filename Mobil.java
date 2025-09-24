package com.mycompany.mobil;

public class Mobil {
    
    private String merek;
    private String warna;
    private int tahun;
    private double harga;
    
    // Contoh Overloading
    // Constructor 1
    public Mobil() {
        this.merek = "Unknown";
        this.warna = "Putih";
        this.tahun = 2023;
        this.harga = 0.0;
    }
    // Constructor 2
    public Mobil(String merek) {
        this.merek = merek;
        this.warna = "Putih";
        this.tahun = 2023;
        this.harga = 0.0;
    }
    
    // Method
    public void nyalakanMesin(){
        System.out.println("Mesin Dinyalakan");
    }
    public void matikanMesin(){
        System.out.println("Mesin Dimatikan");
    }

    // Contoh default constructor
    /* public Mobil(){
        this.merek = "Unknown";
        this.warna = "Unknown";
    }

    // Contoh constructor dengan parameter
    public Mobil(String merek, String warna, int tahun){
        this.merek = merek;
        this.warna = warna;
        this.tahun = tahun;
    }
    
    // Contoh Object Instantiation
    Mobil mobil1 = new Mobil();
    Mobil mobil2 = new Mobil();*/
    
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil();
        Mobil mobil2 = new Mobil("Toyota");

        mobil1.nyalakanMesin();
        mobil2.matikanMesin();
    }
}

abstract class Hewan {
    String nama;
    
    Hewan(String nama) {
        this.nama = nama;
    }
    // Method abstract (wajib diimplementasikan oleh subclass)
    abstract void suara();
    
    // Method biasa
    void info() {
        System.out.println("Nama Hewan: "+ nama);
    }
}
