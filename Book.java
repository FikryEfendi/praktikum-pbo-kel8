public class Book {
    private int id;
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;
    private String kategori;
    private String isbn;
    private int jumlahTotal;
    private int jumlahTersedia;
    private String rakLokasi;
    
    public Book(int id, String judul, String pengarang, String penerbit, 
                int tahunTerbit, String kategori, String isbn, 
                int jumlahTotal, int jumlahTersedia, String rakLokasi) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
        this.isbn = isbn;
        this.jumlahTotal = jumlahTotal;
        this.jumlahTersedia = jumlahTersedia;
        this.rakLokasi = rakLokasi;
    }
    
    // Getters
    public int getId() { return id; }
    public String getJudul() { return judul; }
    public String getPengarang() { return pengarang; }
    public String getPenerbit() { return penerbit; }
    public int getTahunTerbit() { return tahunTerbit; }
    public String getKategori() { return kategori; }
    public String getIsbn() { return isbn; }
    public int getJumlahTotal() { return jumlahTotal; }
    public int getJumlahTersedia() { return jumlahTersedia; }
    public String getRakLokasi() { return rakLokasi; }
    
    // Setters
    public void setJumlahTersedia(int jumlahTersedia) {
        this.jumlahTersedia = jumlahTersedia;
    }
    
    public boolean isTersedia() {
        return jumlahTersedia > 0;
    }
    
    public String getStatus() {
        if (jumlahTersedia == 0) {
            return "Dipinjam Semua";
        } else if (jumlahTersedia < jumlahTotal) {
            return "Tersedia (" + jumlahTersedia + "/" + jumlahTotal + ")";
        } else {
            return "Tersedia";
        }
    }
    
    @Override
    public String toString() {
        return judul + " - " + pengarang;
    }
}