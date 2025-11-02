
public class Fakultas {
    public String nama;
    private int jumlahJurusan;
    
    static int jumlahFakultas = 0;
    
    public Fakultas(String nama, int jumlahJurusan){
        this.nama = nama;
        this.jumlahJurusan = jumlahJurusan;
        jumlahFakultas++;
    }
    public void tampilkanInfo(){
        System.out.println("Nama Fakultas : "+ nama);
        System.out.println("Jumlah Jurusan : "+ jumlahJurusan);
    }
    public static void tampilkanJumlahFakultas(){
        System.out.println("Jumlah Fakultas adalah :"+ jumlahFakultas);
    }
}
