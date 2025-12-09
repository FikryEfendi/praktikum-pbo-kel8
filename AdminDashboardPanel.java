import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminDashboardPanel extends JPanel {
    private MainAppFrame parentFrame;
    private JSONDatabaseHelper db;
    private JLabel namaAdminLabel;
    private JLabel totalBukuLabel;
    private JLabel totalAktifLabel;
    private JLabel totalSelesaiLabel;
    private JLabel totalTerlambatLabel;

    public AdminDashboardPanel(MainAppFrame parentFrame, JSONDatabaseHelper db) {
        this.parentFrame = parentFrame;
        this.db = db;
        setLayout(new BorderLayout());
        setBackground(UITheme.BACKGROUND);
        add(SidebarUtil.createAdminSidebar(parentFrame, MainAppFrame.ADMIN_DASHBOARD), BorderLayout.WEST);
        add(createContent(), BorderLayout.CENTER);
    }

    public void setUser(User user) {
        if (namaAdminLabel != null && user != null) {
            namaAdminLabel.setText("Halo, " + user.getNama() + "!");
        }
    }

    public void refreshData() {
        if (totalBukuLabel != null) {
            totalBukuLabel.setText(String.valueOf(db.getTotalBuku()));
        }
        if (totalAktifLabel != null) {
            totalAktifLabel.setText(String.valueOf(db.getTotalPeminjamanAktif()));
        }
        if (totalSelesaiLabel != null) {
            totalSelesaiLabel.setText(String.valueOf(db.getTotalPeminjamanSelesai()));
        }
        if (totalTerlambatLabel != null) {
            totalTerlambatLabel.setText(String.valueOf(db.getTotalTerlambat()));
        }
    }

    private JScrollPane createContent() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(UITheme.BACKGROUND);
        content.setBorder(new EmptyBorder(UITheme.PADDING_LARGE, UITheme.PADDING_LARGE, 
                                         UITheme.PADDING_LARGE, UITheme.PADDING_LARGE));

        namaAdminLabel = new JLabel("Halo, Administrator!");
        namaAdminLabel.setFont(UITheme.FONT_TITLE);
        namaAdminLabel.setForeground(UITheme.TEXT_PRIMARY);
        namaAdminLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(namaAdminLabel);

        JLabel subtitle = new JLabel("Sistem Perpustakaan - Admin Portal");
        subtitle.setFont(UITheme.FONT_BODY);
        subtitle.setForeground(UITheme.TEXT_SECONDARY);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(subtitle);
        content.add(Box.createVerticalStrut(UITheme.PADDING_LARGE));

        // Announcement Card
        ModernCardPanel announcementCard = new ModernCardPanel();
        announcementCard.setBackground(new Color(227, 242, 253));
        announcementCard.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(UITheme.PRIMARY_LIGHT, 2),
            new EmptyBorder(UITheme.PADDING_MEDIUM, UITheme.PADDING_MEDIUM, 
                          UITheme.PADDING_MEDIUM, UITheme.PADDING_MEDIUM)
        ));
        announcementCard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        announcementCard.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel announcementTitle = new JLabel("📢 Pengumuman");
        announcementTitle.setFont(UITheme.FONT_HEADING_3);
        announcementTitle.setForeground(UITheme.PRIMARY_DARK);

        JLabel announcementText = new JLabel("Selamat datang di Sistem Perpustakaan. Kelola peminjaman dengan efisien.");
        announcementText.setFont(UITheme.FONT_BODY);
        announcementText.setForeground(UITheme.TEXT_SECONDARY);

        announcementCard.setLayout(new BoxLayout(announcementCard, BoxLayout.Y_AXIS));
        announcementCard.add(announcementTitle);
        announcementCard.add(Box.createVerticalStrut(UITheme.SPACING_SMALL));
        announcementCard.add(announcementText);
        content.add(announcementCard);
        content.add(Box.createVerticalStrut(UITheme.PADDING_LARGE));

        // Statistics Section
        JLabel statsTitle = new JLabel("Statistik Perpustakaan");
        statsTitle.setFont(UITheme.FONT_HEADING_2);
        statsTitle.setForeground(UITheme.TEXT_PRIMARY);
        statsTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(statsTitle);
        content.add(Box.createVerticalStrut(UITheme.SPACING_MEDIUM));

        // Cards Statistik
        JPanel cardPanel = new JPanel(new GridLayout(2, 2, UITheme.PADDING_MEDIUM, UITheme.PADDING_MEDIUM));
        cardPanel.setBackground(UITheme.BACKGROUND);
        cardPanel.setOpaque(false);
        cardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 320));
        cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        int totalBuku = db.getTotalBuku();
        int totalAktif = db.getTotalPeminjamanAktif();
        int totalSelesai = db.getTotalPeminjamanSelesai();
        int totalTerlambat = db.getTotalTerlambat();

        StatisticCard bukuCard = new StatisticCard("Total Buku", String.valueOf(totalBuku), 
                                                    "Koleksi perpustakaan", UITheme.INFO);
        totalBukuLabel = (JLabel) bukuCard.getComponent(2);

        StatisticCard aktifCard = new StatisticCard("Sedang Dipinjam", String.valueOf(totalAktif), 
                                                    "Buku aktif dipinjam", UITheme.PRIMARY);
        totalAktifLabel = (JLabel) aktifCard.getComponent(2);

        StatisticCard selesaiCard = new StatisticCard("Sudah Dikembalikan", String.valueOf(totalSelesai), 
                                                      "Total dikembalikan", UITheme.SUCCESS);
        totalSelesaiLabel = (JLabel) selesaiCard.getComponent(2);

        StatisticCard terlambatCard = new StatisticCard("Terlambat", String.valueOf(totalTerlambat), 
                                                        "Perlu tindakan", UITheme.DANGER);
        totalTerlambatLabel = (JLabel) terlambatCard.getComponent(2);

        cardPanel.add(bukuCard);
        cardPanel.add(aktifCard);
        cardPanel.add(selesaiCard);
        cardPanel.add(terlambatCard);
        content.add(cardPanel);
        content.add(Box.createVerticalStrut(UITheme.PADDING_LARGE));

        // Quick Actions
        JLabel actionTitle = new JLabel("Aksi Cepat");
        actionTitle.setFont(UITheme.FONT_HEADING_2);
        actionTitle.setForeground(UITheme.TEXT_PRIMARY);
        actionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(actionTitle);
        content.add(Box.createVerticalStrut(UITheme.SPACING_MEDIUM));

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        actionPanel.setOpaque(false);
        actionPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        actionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        ModernButton btnTambahPeminjaman = new ModernButton("+ Tambah Peminjaman Baru");
        btnTambahPeminjaman.setButtonType(ModernButton.ButtonType.SUCCESS);
        btnTambahPeminjaman.addActionListener(e -> {
            parentFrame.showView(MainAppFrame.PEMINJAMAN_AKTIF);
        });

        ModernButton btnDaftarBuku = new ModernButton("Lihat Daftar Buku");
        btnDaftarBuku.setButtonType(ModernButton.ButtonType.PRIMARY);
        btnDaftarBuku.addActionListener(e -> {
            parentFrame.showView(MainAppFrame.DAFTAR_BUKU);
        });

        ModernButton btnLihatAktif = new ModernButton("Lihat Peminjaman Aktif");
        btnLihatAktif.setButtonType(ModernButton.ButtonType.PRIMARY);
        btnLihatAktif.addActionListener(e -> {
            parentFrame.showView(MainAppFrame.PEMINJAMAN_AKTIF);
        });

        ModernButton btnLihatRiwayat = new ModernButton("Lihat Riwayat");
        btnLihatRiwayat.setButtonType(ModernButton.ButtonType.INFO);
        btnLihatRiwayat.addActionListener(e -> {
            parentFrame.showView(MainAppFrame.RIWAYAT_PEMINJAMAN);
        });

        actionPanel.add(btnTambahPeminjaman);
        actionPanel.add(btnDaftarBuku);
        actionPanel.add(btnLihatAktif);
        actionPanel.add(btnLihatRiwayat);
        content.add(actionPanel);
        content.add(Box.createVerticalGlue());

        return new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                              JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    // Inner Classes
    private static class ModernCardPanel extends JPanel {
        private int cornerRadius = 15;
        private Color borderColor = UITheme.BORDER;

        public ModernCardPanel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            super.paintComponent(g);
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
            g2.dispose();
        }
    }

    private static class StatisticCard extends RoundedCardPanel {
        public StatisticCard(String title, String value, String subtitle, Color accentColor) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(UITheme.SURFACE);
            setBorderColor(UITheme.BORDER);

            JPanel accentBar = new JPanel();
            accentBar.setBackground(accentColor);
            accentBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 4));
            accentBar.setMinimumSize(new Dimension(0, 4));
            add(accentBar);

            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(UITheme.FONT_BODY);
            titleLabel.setForeground(UITheme.TEXT_SECONDARY);
            titleLabel.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 12));
            add(titleLabel);

            JLabel valueLabel = new JLabel(value);
            valueLabel.setFont(UITheme.FONT_TITLE);
            valueLabel.setForeground(accentColor);
            valueLabel.setBorder(BorderFactory.createEmptyBorder(4, 12, 0, 12));
            add(valueLabel);

            JLabel subtitleLabel = new JLabel(subtitle);
            subtitleLabel.setFont(UITheme.FONT_SMALL);
            subtitleLabel.setForeground(UITheme.TEXT_HINT);
            subtitleLabel.setBorder(BorderFactory.createEmptyBorder(4, 12, 12, 12));
            add(subtitleLabel);

            add(Box.createVerticalGlue());
        }
    }
}