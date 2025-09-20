public class LatihanPraktikumBab5 {
    public static void main(String[] args) {
        CharGenshin karakter1 = new CharGenshin("Columbina");
        CharGenshin karakter2 = new CharGenshin("Childe", 23, "Bow");
        CharGenshin karakter3 = new CharGenshin("Hutao", "Pyro", 19, "Polearm");

        karakter1.getInfo();
        karakter2.getInfo();
        karakter3.getInfo();

        karakter1.berlatih();
        karakter2.berlatih("All-Devouring Narwhal");
        karakter3.berlatih("Treasure Hoarder", "Zhongli");
        karakter1.berlatih("The Wild Hunt", "Lumine");
    }
}

class CharGenshin {
    // Atribut
    public String nama;
    public String elemen;
    public int usia;
    public String senjata;

    //Constructor overloading
    public CharGenshin(String nama) {
        this.nama = nama;
        this.elemen = "Unknown";
        this.usia = 500;
        this.senjata = "Unknown";
    }

    public CharGenshin(String nama, int usia, String senjata) {
        this.nama = nama;
        this.elemen = "Double Elemental";
        this.usia = usia;
        this.senjata = senjata;
    }

    public CharGenshin(String nama, String elemen, int usia, String senjata) {
        this.nama = nama;
        this.elemen = elemen;
        this.usia = usia;
        this.senjata = senjata;
    }

     // Method overloading
    public void berlatih() {
        System.out.println(nama + " berlatih sendirian di Spiral Abyss!");
    }

    public void berlatih(String monster) {
        System.out.println(nama + " berlatih melawan " + monster + "!");
    }

    public void berlatih(String monster, String teman) {
        System.out.println(nama + " berlatih melawan " + monster + " bersama " + teman + "!");
    }

    // Print info karakter
    public void getInfo() {
        System.out.println("Informasi Karakter");
        System.out.println("Nama     : " + nama);
        System.out.println("Elemen   : " + elemen);
        System.out.println("Usia     : " + usia + " tahun");
        System.out.println("Senjata  : " + senjata);
        System.out.println("");
    }
}