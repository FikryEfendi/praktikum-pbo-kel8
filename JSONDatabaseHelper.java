import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class JSONDatabaseHelper {
    private static final String DB_FILE = "perpustakaan_data.json";
    private JSONObject database;

    public JSONDatabaseHelper() {
        loadDatabase();
    }

    private void loadDatabase() {
        try {
            File file = new File(DB_FILE);
            if (file.exists()) {
                String content = new String(Files.readAllBytes(Paths.get(DB_FILE)));
                database = new JSONObject(content);
                
                // Cek apakah ada buku, jika tidak inisialisasi
                if (!database.has("buku") || database.getJSONArray("buku").length() == 0) {
                    initializeBuku();
                }
            } else {
                initializeNewDatabase();
            }
        } catch (IOException e) {
            e.printStackTrace();
            initializeNewDatabase();
        }
    }

    private void initializeNewDatabase() {
        database = new JSONObject();
        
        // Admin default
        JSONArray admins = new JSONArray();
        JSONObject admin = new JSONObject();
        admin.put("username", "admin");
        admin.put("password", "admin123");
        admin.put("nama", "Administrator");
        admins.put(admin);
        database.put("admins", admins);
        
        // Peminjaman kosong
        database.put("peminjaman", new JSONArray());
        database.put("last_loan_id", 0);
        
        // Inisialisasi 50 buku
        initializeBuku();
        
        saveDatabase();
    }

    private void initializeBuku() {
        JSONArray buku = new JSONArray();
        
        // Data 50 buku
        String[][] bukuData = {
            // {judul, pengarang, penerbit, tahun, kategori, isbn, rak, jumlah}
            {"Pemrograman Java untuk Pemula", "John Doe", "Informatika Press", "2022", "Pemrograman", "978-123-456-001", "A1", "3"},
            {"Algoritma dan Struktur Data", "Jane Smith", "Tech Books", "2021", "Pemrograman", "978-123-456-002", "A1", "2"},
            {"Python Programming Mastery", "Robert Johnson", "Code House", "2023", "Pemrograman", "978-123-456-003", "A2", "4"},
            {"JavaScript Modern", "Emily Davis", "Web Dev Press", "2022", "Web Development", "978-123-456-004", "B1", "3"},
            {"React dan Redux", "Michael Brown", "Frontend Books", "2023", "Web Development", "978-123-456-005", "B1", "2"},
            {"Node.js Backend Development", "Sarah Wilson", "Backend Press", "2022", "Web Development", "978-123-456-006", "B2", "3"},
            {"Database MySQL Advanced", "David Lee", "Database Corp", "2021", "Database", "978-123-456-007", "C1", "2"},
            {"PostgreSQL Complete Guide", "Jennifer White", "SQL Books", "2022", "Database", "978-123-456-008", "C1", "3"},
            {"MongoDB for Beginners", "Thomas Anderson", "NoSQL Press", "2023", "Database", "978-123-456-009", "C2", "2"},
            {"Jaringan Komputer", "William Taylor", "Network Publishing", "2021", "Jaringan", "978-123-456-010", "D1", "4"},
            {"Cisco CCNA Study Guide", "Lisa Martinez", "Cisco Press", "2022", "Jaringan", "978-123-456-011", "D1", "2"},
            {"Network Security Fundamentals", "James Garcia", "Security Books", "2023", "Jaringan", "978-123-456-012", "D2", "3"},
            {"Linux System Administration", "Patricia Rodriguez", "Linux Press", "2022", "Sistem Operasi", "978-123-456-013", "E1", "3"},
            {"Windows Server 2022", "Christopher Martinez", "Microsoft Books", "2023", "Sistem Operasi", "978-123-456-014", "E1", "2"},
            {"Ubuntu Server Complete", "Mary Hernandez", "Open Source Press", "2021", "Sistem Operasi", "978-123-456-015", "E2", "3"},
            {"Android Development with Kotlin", "Daniel Lopez", "Mobile Books", "2023", "Mobile Development", "978-123-456-016", "F1", "4"},
            {"iOS Swift Programming", "Nancy Gonzalez", "Apple Press", "2022", "Mobile Development", "978-123-456-017", "F1", "2"},
            {"Flutter Cross-Platform", "Paul Wilson", "Hybrid Apps", "2023", "Mobile Development", "978-123-456-018", "F2", "3"},
            {"Machine Learning Basics", "Steven Anderson", "AI Publishers", "2022", "AI & Machine Learning", "978-123-456-019", "G1", "2"},
            {"Deep Learning with Python", "Karen Thomas", "Neural Press", "2023", "AI & Machine Learning", "978-123-456-020", "G1", "3"},
            {"Natural Language Processing", "Betty Jackson", "NLP Books", "2022", "AI & Machine Learning", "978-123-456-021", "G2", "2"},
            {"Ethical Hacking", "Edward White", "Security Pro", "2023", "Keamanan Siber", "978-123-456-022", "H1", "3"},
            {"Cybersecurity Essentials", "Helen Harris", "Cyber Books", "2022", "Keamanan Siber", "978-123-456-023", "H1", "2"},
            {"Penetration Testing Guide", "Donald Martin", "Pentesting Press", "2023", "Keamanan Siber", "978-123-456-024", "H2", "3"},
            {"Discrete Mathematics", "Jason Thompson", "Math Publishers", "2021", "Matematika", "978-123-456-025", "I1", "4"},
            {"Linear Algebra Applications", "Sandra Garcia", "Matrix Press", "2022", "Matematika", "978-123-456-026", "I1", "2"},
            {"Calculus for Computer Science", "Kevin Martinez", "Calc Books", "2023", "Matematika", "978-123-456-027", "I2", "3"},
            {"Design Patterns in Java", "Michelle Robinson", "Pattern Press", "2022", "Pemrograman", "978-123-456-028", "A3", "2"},
            {"Clean Code Principles", "Brian Clark", "Code Quality Books", "2023", "Pemrograman", "978-123-456-029", "A3", "3"},
            {"Git Version Control", "Amy Rodriguez", "DevOps Press", "2022", "Pemrograman", "978-123-456-030", "A4", "4"},
            {"Docker and Kubernetes", "Ryan Lewis", "Container Books", "2023", "Web Development", "978-123-456-031", "B3", "2"},
            {"Microservices Architecture", "Nicole Lee", "Architecture Press", "2022", "Web Development", "978-123-456-032", "B3", "3"},
            {"REST API Design", "Justin Walker", "API Books", "2023", "Web Development", "978-123-456-033", "B4", "2"},
            {"Big Data Analytics", "Melissa Hall", "Data Science Press", "2022", "Database", "978-123-456-034", "C3", "3"},
            {"Data Warehousing", "Andrew Allen", "DW Publishers", "2023", "Database", "978-123-456-035", "C3", "2"},
            {"Redis In-Memory Database", "Rachel Young", "Cache Books", "2022", "Database", "978-123-456-036", "C4", "3"},
            {"Wireless Networks", "Gregory Hernandez", "WiFi Press", "2023", "Jaringan", "978-123-456-037", "D3", "2"},
            {"Network Protocols Deep Dive", "Victoria King", "Protocol Books", "2022", "Jaringan", "978-123-456-038", "D3", "3"},
            {"Cloud Networking", "Dennis Wright", "Cloud Press", "2023", "Jaringan", "978-123-456-039", "D4", "4"},
            {"macOS System Programming", "Angela Lopez", "Apple Dev Books", "2022", "Sistem Operasi", "978-123-456-040", "E3", "2"},
            {"Operating System Concepts", "Timothy Hill", "OS Theory Press", "2023", "Sistem Operasi", "978-123-456-041", "E3", "3"},
            {"Kernel Development", "Deborah Scott", "Low Level Books", "2022", "Sistem Operasi", "978-123-456-042", "E4", "2"},
            {"React Native Complete", "Scott Green", "Mobile Framework", "2023", "Mobile Development", "978-123-456-043", "F3", "3"},
            {"Mobile UI/UX Design", "Cynthia Adams", "Design Books", "2022", "Mobile Development", "978-123-456-044", "F3", "2"},
            {"Progressive Web Apps", "Raymond Baker", "PWA Press", "2023", "Mobile Development", "978-123-456-045", "F4", "3"},
            {"Computer Vision", "Stephanie Nelson", "Vision Press", "2022", "AI & Machine Learning", "978-123-456-046", "G3", "2"},
            {"Reinforcement Learning", "Peter Carter", "RL Books", "2023", "AI & Machine Learning", "978-123-456-047", "G3", "3"},
            {"AI Ethics and Society", "Laura Mitchell", "Ethics Press", "2022", "AI & Machine Learning", "978-123-456-048", "G4", "2"},
            {"Blockchain Security", "Frank Perez", "Crypto Books", "2023", "Keamanan Siber", "978-123-456-049", "H3", "3"},
            {"Digital Forensics", "Gloria Roberts", "Forensic Press", "2022", "Keamanan Siber", "978-123-456-050", "H4", "2"}
        };
        
        for (int i = 0; i < bukuData.length; i++) {
            JSONObject book = new JSONObject();
            book.put("id", i + 1);
            book.put("judul", bukuData[i][0]);
            book.put("pengarang", bukuData[i][1]);
            book.put("penerbit", bukuData[i][2]);
            book.put("tahun_terbit", Integer.parseInt(bukuData[i][3]));
            book.put("kategori", bukuData[i][4]);
            book.put("isbn", bukuData[i][5]);
            book.put("rak_lokasi", bukuData[i][6]);
            int jumlah = Integer.parseInt(bukuData[i][7]);
            book.put("jumlah_total", jumlah);
            book.put("jumlah_tersedia", jumlah);
            buku.put(book);
        }
        
        database.put("buku", buku);
        database.put("last_book_id", 50);
        saveDatabase();
    }

    private void saveDatabase() {
        try (FileWriter file = new FileWriter(DB_FILE)) {
            file.write(database.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ============ USER/ADMIN METHODS ============
    
    public User authenticateAdmin(String username, String password) {
        try {
            JSONArray admins = database.getJSONArray("admins");
            for (int i = 0; i < admins.length(); i++) {
                JSONObject admin = admins.getJSONObject(i);
                if (admin.getString("username").equals(username) && 
                    admin.getString("password").equals(password)) {
                    return new User(
                        admin.getString("username"),
                        admin.getString("password"),
                        admin.getString("nama"),
                        "ADMIN",
                        "", "", "", "", "", "", "Aktif"
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ============ BOOK METHODS ============
    
    public ArrayList<Book> getAllBuku() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            JSONArray buku = database.getJSONArray("buku");
            for (int i = 0; i < buku.length(); i++) {
                JSONObject bookJson = buku.getJSONObject(i);
                books.add(jsonToBook(bookJson));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBukuById(int id) {
        try {
            JSONArray buku = database.getJSONArray("buku");
            for (int i = 0; i < buku.length(); i++) {
                JSONObject bookJson = buku.getJSONObject(i);
                if (bookJson.getInt("id") == id) {
                    return jsonToBook(bookJson);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> cariBuku(String keyword) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            JSONArray buku = database.getJSONArray("buku");
            String lowerKeyword = keyword.toLowerCase();
            
            for (int i = 0; i < buku.length(); i++) {
                JSONObject bookJson = buku.getJSONObject(i);
                String judul = bookJson.getString("judul").toLowerCase();
                String pengarang = bookJson.getString("pengarang").toLowerCase();
                String kategori = bookJson.getString("kategori").toLowerCase();
                
                if (judul.contains(lowerKeyword) || pengarang.contains(lowerKeyword) || 
                    kategori.contains(lowerKeyword)) {
                    books.add(jsonToBook(bookJson));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public ArrayList<Book> getBukuTersedia() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            JSONArray buku = database.getJSONArray("buku");
            for (int i = 0; i < buku.length(); i++) {
                JSONObject bookJson = buku.getJSONObject(i);
                if (bookJson.getInt("jumlah_tersedia") > 0) {
                    books.add(jsonToBook(bookJson));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    private Book jsonToBook(JSONObject bookJson) {
        return new Book(
            bookJson.getInt("id"),
            bookJson.getString("judul"),
            bookJson.getString("pengarang"),
            bookJson.getString("penerbit"),
            bookJson.getInt("tahun_terbit"),
            bookJson.getString("kategori"),
            bookJson.getString("isbn"),
            bookJson.getInt("jumlah_total"),
            bookJson.getInt("jumlah_tersedia"),
            bookJson.getString("rak_lokasi")
        );
    }

    private void updateJumlahBuku(int idBuku, int perubahan) {
        try {
            JSONArray buku = database.getJSONArray("buku");
            for (int i = 0; i < buku.length(); i++) {
                JSONObject book = buku.getJSONObject(i);
                if (book.getInt("id") == idBuku) {
                    int tersedia = book.getInt("jumlah_tersedia");
                    book.put("jumlah_tersedia", tersedia + perubahan);
                    saveDatabase();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ LOAN METHODS ============
    
    public boolean tambahPeminjaman(String namaPeminjam, String nimMahasiswa, 
                                    int idBuku, LocalDate tanggalPinjam, LocalDate deadline) {
        try {
            // Cek ketersediaan buku
            Book book = getBukuById(idBuku);
            if (book == null || !book.isTersedia()) {
                return false;
            }
            
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            int newId = database.getInt("last_loan_id") + 1;
            
            JSONObject loan = new JSONObject();
            loan.put("id", newId);
            loan.put("nama_peminjam", namaPeminjam);
            loan.put("nim_mahasiswa", nimMahasiswa);
            loan.put("id_buku", idBuku);
            loan.put("judul_buku", book.getJudul());
            loan.put("tanggal_pinjam", tanggalPinjam.toString());
            loan.put("deadline_pengembalian", deadline.toString());
            loan.put("tanggal_kembali", null);
            loan.put("status", "Dipinjam");
            
            peminjaman.put(loan);
            database.put("last_loan_id", newId);
            
            // Kurangi jumlah buku tersedia
            updateJumlahBuku(idBuku, -1);
            
            saveDatabase();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean kembalikanBuku(int idPeminjaman, LocalDate tanggalKembali) {
        try {
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            for (int i = 0; i < peminjaman.length(); i++) {
                JSONObject loan = peminjaman.getJSONObject(i);
                if (loan.getInt("id") == idPeminjaman) {
                    loan.put("status", "Dikembalikan");
                    loan.put("tanggal_kembali", tanggalKembali.toString());
                    
                    // Tambah jumlah buku tersedia
                    int idBuku = loan.getInt("id_buku");
                    updateJumlahBuku(idBuku, 1);
                    
                    saveDatabase();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Loan> getPeminjamanAktif() {
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            for (int i = 0; i < peminjaman.length(); i++) {
                JSONObject loanJson = peminjaman.getJSONObject(i);
                if ("Dipinjam".equals(loanJson.getString("status"))) {
                    loans.add(jsonToLoan(loanJson));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
    }

    public ArrayList<Loan> getRiwayatPeminjaman() {
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            for (int i = 0; i < peminjaman.length(); i++) {
                JSONObject loanJson = peminjaman.getJSONObject(i);
                loans.add(jsonToLoan(loanJson));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
    }

    private Loan jsonToLoan(JSONObject loanJson) {
        int id = loanJson.getInt("id");
        String namaPeminjam = loanJson.getString("nama_peminjam");
        String nimMahasiswa = loanJson.getString("nim_mahasiswa");
        int idBuku = loanJson.getInt("id_buku");
        String judulBuku = loanJson.getString("judul_buku");
        LocalDate tanggalPinjam = LocalDate.parse(loanJson.getString("tanggal_pinjam"));
        LocalDate deadline = LocalDate.parse(loanJson.getString("deadline_pengembalian"));
        
        LocalDate tanggalKembali = null;
        if (!loanJson.isNull("tanggal_kembali")) {
            tanggalKembali = LocalDate.parse(loanJson.getString("tanggal_kembali"));
        }
        
        String status = loanJson.getString("status");
        
        return new Loan(id, namaPeminjam, nimMahasiswa, idBuku, judulBuku, 
                       tanggalPinjam, deadline, tanggalKembali, status);
    }

    public ArrayList<Loan> cariPeminjaman(String keyword) {
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            String lowerKeyword = keyword.toLowerCase();
            
            for (int i = 0; i < peminjaman.length(); i++) {
                JSONObject loanJson = peminjaman.getJSONObject(i);
                String namaPeminjam = loanJson.getString("nama_peminjam").toLowerCase();
                String judulBuku = loanJson.getString("judul_buku").toLowerCase();
                String nim = loanJson.getString("nim_mahasiswa").toLowerCase();
                
                if (namaPeminjam.contains(lowerKeyword) || judulBuku.contains(lowerKeyword) ||
                    nim.contains(lowerKeyword)) {
                    loans.add(jsonToLoan(loanJson));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
    }

    // ============ STATISTICS METHODS ============
    
    public int getTotalPeminjamanAktif() {
        int count = 0;
        try {
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            for (int i = 0; i < peminjaman.length(); i++) {
                JSONObject loan = peminjaman.getJSONObject(i);
                if ("Dipinjam".equals(loan.getString("status"))) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getTotalPeminjamanSelesai() {
        int count = 0;
        try {
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            for (int i = 0; i < peminjaman.length(); i++) {
                JSONObject loan = peminjaman.getJSONObject(i);
                if ("Dikembalikan".equals(loan.getString("status"))) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getTotalTerlambat() {
        int count = 0;
        try {
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            LocalDate today = LocalDate.now();
            for (int i = 0; i < peminjaman.length(); i++) {
                JSONObject loan = peminjaman.getJSONObject(i);
                if ("Dipinjam".equals(loan.getString("status"))) {
                    LocalDate deadline = LocalDate.parse(loan.getString("deadline_pengembalian"));
                    if (today.isAfter(deadline)) {
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getTotalBuku() {
        try {
            return database.getJSONArray("buku").length();
        } catch (Exception e) {
            return 0;
        }
    }

    public int getTotalBukuTersedia() {
        int count = 0;
        try {
            JSONArray buku = database.getJSONArray("buku");
            for (int i = 0; i < buku.length(); i++) {
                JSONObject book = buku.getJSONObject(i);
                if (book.getInt("jumlah_tersedia") > 0) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    // ============ UTILITY METHODS ============
    
    public boolean hapusPeminjaman(int idPeminjaman) {
        try {
            JSONArray peminjaman = database.getJSONArray("peminjaman");
            for (int i = 0; i < peminjaman.length(); i++) {
                JSONObject loan = peminjaman.getJSONObject(i);
                if (loan.getInt("id") == idPeminjaman) {
                    peminjaman.remove(i);
                    saveDatabase();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String exportToJSON() {
        return database.toString(4);
    }

    public boolean importFromJSON(String jsonString) {
        try {
            database = new JSONObject(jsonString);
            saveDatabase();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}