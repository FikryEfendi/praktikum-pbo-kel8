public class Buku {
    String Judul;
    String Kategori;
    double Dendaperhari;
    int Hariketerlambatan;
    double Totaldenda = Dendaperhari * Hariketerlambatan;

    public Buku(String Judul, String Kategori, double Dendaperhari, int Hariketerlambatan, double Totaldenda){
        this.Judul = Judul;
        this.Kategori = Kategori;
        this.Dendaperhari = Dendaperhari;
        this.Hariketerlambatan = Hariketerlambatan;
        this.Totaldenda = Totaldenda;
        } 

    public void tampilanData(Referensi){
        System.out.println("Judul = " + Judul);
        System.out.println("Kategori = " + Kategori);
        System.out.println("Denda Perhari = " Dendaperhari);
        System.out.println("Hari Keterlambatan = " + Hariketerlambatan);
        if (Hariketerlambatan > 3){
            double Denda = Totaldenda * 0.2;
            System.out.println("Total Denda " + Totaldenda + Denda);
        }else{
            System.out.println("Total denda " + Totaldenda);
        }

      public void tampilanData(Umum){
        System.out.println("Judul = " + Judul);
        System.out.println("Kategori = " + Kategori);
        System.out.println("Denda Perhari = " Dendaperhari);
        System.out.println("Hari Keterlambatan = " + Hariketerlambatan);
        if (Hariketerlambatan > 7){
            double Denda = Totaldenda * 0.1;
            System.out.println("Total Denda " + Totaldenda + Denda);
        }else{
            System.out.println("Total denda " + Totaldenda);
        }
    }
}
