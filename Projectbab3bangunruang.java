package com.mycompany.projectbab3bangunruang;
import java.util.Scanner;

public class Projectbab3bangunruang {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan nama kubus: ");
        String namaKubus = input.nextLine();
        
        System.out.print("Masukkan panjang sisi kubus: ");
        int sisiKubus = input.nextInt();
        
        int volumeKubus = sisiKubus * sisiKubus * sisiKubus;
        
        System.out.println("Volume kubus = "+ volumeKubus +" cm");
    }
}
