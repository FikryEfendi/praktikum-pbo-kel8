
import java.util.Scanner;

public class Projectbab4hasilpraktikum {

    public static void main(String[] args) {
       Percabangan(args);
       Perulangan(args);
       ControlStatement(args);
    }
    
    public static void Percabangan(String[] args) {
        System.out.println("Percabangan");
        //if-else
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai: ");
        int nilai = input.nextInt();
        if (nilai>75){
            System.out.println("Anda lulus ujian");
        } else {
            System.out.println("Anda harus mengulang ujian");
        }
        System.out.println("");
        
        //if-else if-else
        System.out.print("Masukkan nilai2: ");
        int nilai2 = input.nextInt();
        if (nilai2>75){
            System.out.println("Anda lulus ujian");
        } else if (nilai2>65) {
            System.out.println("Nilai anda berada di ambang batas kelulusan");
        } else {
            System.out.println("Anda harus mengulang ujian");
        }
        input.nextLine();
        System.out.println("");
        
        //switch case
        System.out.print("Masukkan warna (RGB): ");
        String warna = input.nextLine();
        switch (warna) {
            case "R" :
                System.out.println("Anda memilih warna merah");
                break;
            case "G" :
                System.out.println("Anda memilih warna hijau");
                break;
            case "B" :
                System.out.println("Anda memilih warna biru");
                break;
            default:
                System.out.println("Warna tidak tersedia");
        }
        System.out.println("");
        
        //nested if
        System.out.print("Masukkan angka : ");
        int angka = input.nextInt();
        if (angka >=0) {
            System.out.print("Bilangan bernilai positif ");
            if (angka % 2 == 0) {
                System.out.println("dan genap");
            } else {
                System.out.println("dan ganjil");
            }
        } else if (angka == 0) {
            System.out.println("Bilangan bernilai netral");
        } else {
            System.out.print("Bilangan bernilai negatif ");
            if (angka % 2 == 0) {
                System.out.println("dan genap");
            } else {
                System.out.println("dan ganjil");
            }
        }
        System.out.println("#################################################");
    }
    
    public static void Perulangan(String[] args) {
        System.out.println("Perulangan");
        //for 
        String[] mahasiswa = {"Aflah", "Dini", "Fikry", "Nabil"};
        for (int i = 0; i < mahasiswa.length; i++) {
            System.out.println("Mahasiswa ke-"+ (i+1) +": "+ mahasiswa[i]);
        }
        System.out.println("");
        
        //while
        Scanner input = new Scanner(System.in);
        String password = "";
        while (!password.equals("java123")) {
            System.out.print("Masukkan Password: ");
            password = input.nextLine();
        }
        System.out.println("Login berhasil");
        System.out.println("");
        
        //do while
        int x = 6;
        do{
            System.out.println("Do While Loop ke- "+ x);
            x++;
        } while (x<=5);
        System.out.println("");
        
        //nested loop
        System.out.println("Mencetak nomor kursi bioskop");
        char kursi = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(kursi +""+ j +" ");
            }
            System.out.println();
            kursi++;
        }
        System.out.println("#################################################");
    }
    
    public static void ControlStatement(String[] args) {
        System.out.println("Control Statement");
        //break
        for (int d = 1; d <= 10; d++){
            if (d == 5){
                System.out.println("Break di angka "+ d);
                break;
            }
            System.out.println("Angka: "+ d);
        }
        System.out.println("");
        
        //continue
        for (int e = 1; e <= 10; e++) {
            if (e % 2 == 0) {
                continue;
            }
            System.out.println("Bilangan ganjil : "+ e);
        }
        System.out.println("#################################################");
    }
}
