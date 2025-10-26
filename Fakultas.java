/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.praktikumpbo.projek6tugas;

/**
 *
 * @author Lenovo
 */
public class Fakultas {
    String nama;
    private final String kodeFakultas;
    
    static int banyakFakultas = 0;
    
    public Fakultas (String nama, String kodeFakultas){
        this.nama = nama;
        this.kodeFakultas = kodeFakultas;
        banyakFakultas++;
    }
    
    //getter
    public void printData(){
        System.out.println("Nama Fakultas: " +nama);
        System.out.println("Kode Fakultas: " +kodeFakultas +'\n');
    }

    
}
