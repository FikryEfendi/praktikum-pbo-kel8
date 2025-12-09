public class User {
    private String id;
    private String password;
    private String nama;
    private String role; // "ADMIN"
    
    // Data Profile Tambahan (tidak digunakan untuk admin, tapi tetap ada untuk compatibility)
    private String prodi;
    private String telepon;
    private String email;
    private String angkatan;
    private String pembimbingAkademik;
    private String semester;
    private String status;
    
    public User(String id, String password, String nama, String role, 
                String prodi, String telepon, String email, String angkatan, 
                String pembimbingAkademik, String semester, String status) {
        this.id = id;
        this.password = password;
        this.nama = nama;
        this.role = role;
        this.prodi = prodi;
        this.telepon = telepon;
        this.email = email;
        this.angkatan = angkatan;
        this.pembimbingAkademik = pembimbingAkademik;
        this.semester = semester;
        this.status = status;
    }
    
    // Getters
    public String getId() { return id; }
    public String getPassword() { return password; }
    public String getNama() { return nama; }
    public String getRole() { return role; }
    public String getProdi() { return prodi; }
    public String getTelepon() { return telepon; }
    public String getEmail() { return email; }
    public String getAngkatan() { return angkatan; }
    public String getPembimbingAkademik() { return pembimbingAkademik; }
    public String getSemester() { return semester; }
    public String getStatus() { return status; }
}