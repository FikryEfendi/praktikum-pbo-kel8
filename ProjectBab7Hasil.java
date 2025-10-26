/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.projectbab7hasil;

/**
 *
 * @author Lenovo
 */
public class ProjectBab7Hasil {

    public static void main(String[] args) {
        //instantiasi object
        Produk p1 = new Produk("Boneka", 50000);
//        BarangElektronik p2 = new BarangElektronik("Handphone", 3500000, 3);
        Produk p2 = new BarangElektronik("Laptop", 20000000, 5);
        
        //panggil membermethod per object
        p1.tampilkanInfo();
        p2.tampilkanInfo();
//        p2.tampilkanGaransi();
    }
}
