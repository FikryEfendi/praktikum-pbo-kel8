public class Barangelektronik extends Produk {
    private int garansi;
    

    public Barangelektronik ( String nama, double harga, int garansi, ){
        super (nama, harga);
        this.garansi = garansi;
    }

    public void tampilkanGaransi(){
        super.tampilkanInfo();
        System.out.println ("Garansi = " + garansi + " tahun");
    }

}
