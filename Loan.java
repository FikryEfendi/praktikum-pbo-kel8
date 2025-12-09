import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {
    private int id;
    private String namaPeminjam;
    private String nimMahasiswa;
    private int idBuku;
    private String judulBuku;
    private LocalDate tanggalPinjam;
    private LocalDate deadlinePengembalian;
    private LocalDate tanggalKembali;
    private String status;
    
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    
    public Loan(int id, String namaPeminjam, String nimMahasiswa, int idBuku, String judulBuku, 
                LocalDate tanggalPinjam, LocalDate deadlinePengembalian, 
                LocalDate tanggalKembali, String status) {
        this.id = id;
        this.namaPeminjam = namaPeminjam;
        this.nimMahasiswa = nimMahasiswa;
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.deadlinePengembalian = deadlinePengembalian;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
    }
    
    public int getId() { 
        return id; 
    }
    
    public String getNamaPeminjam() { 
        return namaPeminjam; 
    }
    
    public String getNimMahasiswa() {
        return nimMahasiswa;
    }
    
    public int getIdBuku() {
        return idBuku;
    }
    
    public String getJudulBuku() { 
        return judulBuku; 
    }
    
    public LocalDate getTanggalPinjam() { 
        return tanggalPinjam; 
    }
    
    public LocalDate getDeadlinePengembalian() { 
        return deadlinePengembalian; 
    }
    
    public LocalDate getTanggalKembali() { 
        return tanggalKembali; 
    }
    
    public String getStatus() { 
        return status; 
    }
    
    public String getTanggalPinjamFormatted() { 
        return tanggalPinjam.format(dtf); 
    }
    
    public String getDeadlineFormatted() { 
        return deadlinePengembalian.format(dtf); 
    }
    
    public String getTanggalKembaliFormatted() {
        return (tanggalKembali != null) ? tanggalKembali.format(dtf) : "-";
    }
    
    public boolean isTerlambat() {
        if ("Dikembalikan".equals(status)) {
            return false;
        }
        return LocalDate.now().isAfter(deadlinePengembalian);
    }
    
    public long getHariTerlambat() {
        if (!isTerlambat()) return 0;
        return java.time.temporal.ChronoUnit.DAYS.between(deadlinePengembalian, LocalDate.now());
    }
}