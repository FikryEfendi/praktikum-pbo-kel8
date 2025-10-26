/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.projek6hasilprak;

/**
 *
 * @author Lenovo
 */
public class Projek6hasilprak {

    public static void main(String[] args) {
        Produk p1 = new Produk ("Laptop", 12000000, 5);
        Produk p2 = new Produk ("Handphone", 5000000, 2);
        
//        System.out.println(p1.nama);
//        System.out.println(p1.harga);
//        System.out.println(p1.stok);

        p1.tampilkanInfo();
//        p1.namaSupplier(); //error karena access modifiernya private
        p1.namaSupplierFix();
        p2.tampilkanInfo();
        
        p1.setHarga(9000000);
        System.out.println("Harga baru produk " +p1.nama+ " adalah: " + p1.getHarga());
        
        System.out.println("Jumlah produk yang telah dibuat adalah: " +Produk.jumlahProduk); 
        //panggil pakai nama Class untuk manggil static method 
    }
}
