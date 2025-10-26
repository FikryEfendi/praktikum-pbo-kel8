/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.projek6tugas;

/**
 *
 * @author Lenovo
 */
public class Projek6tugas {

    public static void main(String[] args) {
        Fakultas f1 = new Fakultas("Fakultas Teknik", "11");
        Fakultas f2 = new Fakultas("Fakultas Ekonomi dan Bisnis", "08");
        
        f1.printData();
        f2.printData();
        
        Jurusan j1 = new Jurusan("Teknik Elektro", "3", 40);
        Jurusan j2 = new Jurusan("Akuntansi", "4", 35);
        
        System.out.println("Banyak fakultas yang telah terdata: " + Fakultas.banyakFakultas);
        System.out.println("Banyak jurusan yang telah terdata: " + Jurusan.banyakJurusan);
        System.out.println("Total dosen dalam jurusan yang telah didata: " + (j1.getBanyakDosen() + j2.getBanyakDosen()));
        
        System.out.println("DATA FAKULTAS");
        f1.printData();
        f2.printData();
        
        System.out.println("DATA JURUSAN");
        System.out.println("1. Nama Jurusan: " +j1.nama);
        System.out.println("Kode Jurusan: " +j1.getKodeJurusan());
        System.out.println("Banyak Dosen: " +j1.getBanyakDosen() + '\n');
        
        System.out.println("2. Nama Jurusan: " +j2.nama);
        System.out.println("Kode Jurusan: " +j2.getKodeJurusan());
        System.out.println("Banyak Dosen: " +j2.getBanyakDosen() + '\n');
        
        j2.setBanyakDosen(37);
    }
}
