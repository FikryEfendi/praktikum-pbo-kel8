public class Klubbola {
    String namaTim;
    String kota;
    int trophy;
    int tahunBerdiri;

    // Konstruktor
    public Klubbola(String namaTim, String kota, int trophy, int tahunBerdiri) {
        this.namaTim = namaTim;
        this.kota = kota;
        this.trophy = trophy;
        this.tahunBerdiri = tahunBerdiri;
    }

    public Klubbola(String namaTim, String kota, int tahunBerdiri){
        this.namaTim = namaTim;
        this.kota = kota;
        this.tahunBerdiri = tahunBerdiri;
        this.trophy = 0;
    }

    public void tampilkanTim(String pesan) {
        System.out.println("Klub Sepakbola " + namaTim + " berasal dari kota " + kota + " dan berdiri pada tahun " + tahunBerdiri + " dan kini memiliki " + trophy + " trophy");
        System.out.println(pesan);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    public void tampilkanTim() {
        System.out.println("Klub Sepakbola " + namaTim + " berasal dari kota " + kota + " dan berdiri pada tahun " + tahunBerdiri + " dan kini memiliki " + trophy + " trophy");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    /* Getter dan Setter
    public String getNama() {
        return namaTim;
    }

    public void setNama(String namaTim) {
        this.namaTim = namaTim;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public int getTahunBerdiri() {
        return tahunBerdiri;
    }

    public void setTahunBerdiri(int tahunBerdiri) {
        this.tahunBerdiri = tahunBerdiri;
    }

    @Override
    public String toString() {
        return "Klubbola{" +
                "namaTim='" + namaTim + '\'' +
                ", kota='" + kota + '\'' +
                ", tahunBerdiri=" + tahunBerdiri +
                '}';
    }*/
}