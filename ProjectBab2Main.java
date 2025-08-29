/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.projectbab2;

/**
 *
 * @author Lenovo
 */
public class ProjectBab2 {

    public static void main(String[] args) {
        //Inisialisasi variabel dengan nilai setiap data
        String nama = "Hafizah Dini Aqila";
        final long NIM = 2407113977L;
        double[] ip = {3.86, 3.74};
        String alamat = "Jalan Pesantren no. 8, Kelurahan Tengkerang Timur,"
                        + "\n\t\t Kecamatan Tenayan Raya, Kota Pekanbaru";
        int umur = 19;
        char golonganDarah = 'B';
        
        //Konversi salah satu IP menjadi tipe data byte
        byte ipDalamByte = (byte) ip[1];
        
        //Cetak nilai setiap variabel ke layar
        System.out.println("Nama          : " + nama);
        System.out.println("NIM           : " + NIM);
        System.out.println("Alamat        : " + alamat);
        System.out.println("IP Semester 1 : " + ip[0]);
        System.out.println("IP Semester 2 : " + ip[1]);
        System.out.println("Golongan Darah: " + golonganDarah);
        
        System.out.println("\nIP semester 2 dalam byte : " + ipDalamByte);
    }
}
