/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.projectbab5;

/**
 *
 * @author Lenovo
 */
public class ProjectBab5 {

    public static void main(String[] args) {
        //inisialisasi objek dengan parameter berbeda-beda    
        Pakaian p1 = new Pakaian();
        Pakaian p2 = new Pakaian("pink", "XL");
        Pakaian p3 = new Pakaian("spandex", "kuning", "M", 65.5);
        
        //pemanggilan overloaded method
        Pakaian.deskripsi(p1.bahan, p1.warna);
        Pakaian.deskripsi(p2.bahan, p2.warna, p2.ukuran, p2.panjangCm);
        System.out.println(p3.deskripsi(p3.ukuran, p3.panjangCm));
        
    }
}
