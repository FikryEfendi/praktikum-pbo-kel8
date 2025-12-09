import javax.swing.*;
import java.awt.*;

public class MainAppFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private JSONDatabaseHelper db;
    public static User loggedInUser;

    // Konstanta Navigasi
    public static final String LOGIN_VIEW = "LoginView";
    public static final String ADMIN_DASHBOARD = "AdminDashboard";
    public static final String DAFTAR_BUKU = "DaftarBuku";
    public static final String PEMINJAMAN_AKTIF = "PeminjamanAktif";
    public static final String RIWAYAT_PEMINJAMAN = "RiwayatPeminjaman";

    private AdminDashboardPanel adminDashboard;
    private DaftarBukuPanel daftarBuku;
    private PeminjamanAktifPanel peminjamanAktif;
    private RiwayatPeminjamanPanel riwayatPeminjaman;

    public MainAppFrame() {
        setTitle("Sistem Perpustakaan - Admin Portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 750);
        setLocationRelativeTo(null);

        // Inisialisasi Database
        db = new JSONDatabaseHelper();

        // Inisialisasi Views
        LoginPanel loginPanel = new LoginPanel(this);
        adminDashboard = new AdminDashboardPanel(this, db);
        daftarBuku = new DaftarBukuPanel(this, db);
        peminjamanAktif = new PeminjamanAktifPanel(this, db);
        riwayatPeminjaman = new RiwayatPeminjamanPanel(this, db);

        // Tambahkan Views sebagai "Kartu"
        mainPanel.add(loginPanel, LOGIN_VIEW);
        mainPanel.add(adminDashboard, ADMIN_DASHBOARD);
        mainPanel.add(daftarBuku, DAFTAR_BUKU);
        mainPanel.add(peminjamanAktif, PEMINJAMAN_AKTIF);
        mainPanel.add(riwayatPeminjaman, RIWAYAT_PEMINJAMAN);

        add(mainPanel);
        cardLayout.show(mainPanel, LOGIN_VIEW);
    }

    public void showView(String viewName) {
        cardLayout.show(mainPanel, viewName);
        
        // Refresh data ketika panel ditampilkan
        if (viewName.equals(ADMIN_DASHBOARD)) {
            adminDashboard.refreshData();
        } else if (viewName.equals(DAFTAR_BUKU)) {
            daftarBuku.refreshData();
        } else if (viewName.equals(PEMINJAMAN_AKTIF)) {
            peminjamanAktif.refreshData();
        } else if (viewName.equals(RIWAYAT_PEMINJAMAN)) {
            riwayatPeminjaman.refreshData();
        }
    }

    public void attemptLogin(String username, String password) {
        User user = db.authenticateAdmin(username, password);
        if (user != null) {
            loggedInUser = user;
            adminDashboard.setUser(user);
            showView(ADMIN_DASHBOARD);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Username atau Password salah.", 
                "Login Gagal", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public JSONDatabaseHelper getDatabase() {
        return db;
    }

    public void refreshDashboard() {
        adminDashboard.refreshData();
    }
    
    public void refreshDaftarBuku() {
        daftarBuku.refreshData();
    }

    public static void main(String[] args) {
        // Set Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new MainAppFrame().setVisible(true);
        });
    }
}