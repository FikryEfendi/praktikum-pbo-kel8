/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum6latihan;

/**
 *
 * @author fikry
 */
public class Praktikum6Latihan {

    public static void main(String[] args) {
        Fakultas f1 = new Fakultas("Teknik", 7);
        Fakultas f2 = new Fakultas("FMIPA", 5);
        Jurusan j1 = new Jurusan("Elektro", 3);
        
        f1.tampilkanInfo();
        f2.tampilkanInfo();
        Fakultas.tampilkanJumlahFakultas();
        j1.tampilkanInfo();
        System.out.println("Jumlah Prodi : "+ j1.getJumlahProdi());
        j1.setJumlahProdi(5);
        
    }
}
