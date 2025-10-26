/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.praktikumpbo.projek6tugas;

/**
 *
 * @author Lenovo
 */
public class Jurusan {
    String nama;
    private final String kodeJurusan;
    private int banyakDosen;
    
    static int banyakJurusan = 0;
    
    public Jurusan (String nama, String kodeJurusan, int banyakDosen){
        this.nama = nama;
        this.kodeJurusan = kodeJurusan;
        this.banyakDosen = banyakDosen;
        banyakJurusan++;
    }
    
    //getter
    public String getKodeJurusan(){
        return kodeJurusan;
    }
    public int getBanyakDosen(){
        return banyakDosen;
    }
    //setter
    public void setBanyakDosen(int banyakDosenBaru){
        if (banyakDosenBaru > 0){
            this.banyakDosen = banyakDosenBaru;
        }
        else if (banyakDosenBaru == 0){
            this.banyakDosen = banyakDosenBaru;
            System.out.println("tidak ada lagi dosen dalam jurusan ini.");
        }
        else {
            System.out.println("banyak dosen tidak bisa negatif");
        }
        System.out.println("Banyak dosen jurusan " +nama+ " baru :" +banyakDosen);
    }
}
