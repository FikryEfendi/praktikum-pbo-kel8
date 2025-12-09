import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PeminjamanAktifPanel extends JPanel {
    private MainAppFrame parentFrame;
    private JSONDatabaseHelper db;
    private JPanel listContainer;
    private JTextField searchField;

    public PeminjamanAktifPanel(MainAppFrame parentFrame, JSONDatabaseHelper db) {
        this.parentFrame = parentFrame;
        this.db = db;
        setLayout(new BorderLayout());
        setBackground(UITheme.BACKGROUND);
        add(SidebarUtil.createAdminSidebar(parentFrame, MainAppFrame.PEMINJAMAN_AKTIF), BorderLayout.WEST);
        add(createContent(), BorderLayout.CENTER);
    }

    public void refreshData() {
        loadPeminjamanAktif();
    }

    private JScrollPane createContent() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(UITheme.BACKGROUND);
        content.setBorder(new EmptyBorder(UITheme.PADDING_LARGE, UITheme.PADDING_LARGE, 
                                         UITheme.PADDING_LARGE, UITheme.PADDING_LARGE));

        JLabel header = new JLabel("Peminjaman Aktif");
        header.setFont(UITheme.FONT_TITLE);
        header.setForeground(UITheme.TEXT_PRIMARY);
        header.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(header);

        JLabel subtitle = new JLabel("Kelola buku yang sedang dipinjam oleh mahasiswa");
        subtitle.setFont(UITheme.FONT_BODY);
        subtitle.setForeground(UITheme.TEXT_SECONDARY);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(subtitle);
        content.add(Box.createVerticalStrut(20));

        // Toolbar
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        toolbar.setOpaque(false);
        toolbar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        toolbar.setAlignmentX(Component.LEFT_ALIGNMENT);

        ModernButton btnTambah = new ModernButton("+ Tambah Peminjaman");
        btnTambah.setButtonType(ModernButton.ButtonType.SUCCESS);
        btnTambah.addActionListener(e -> showTambahPeminjamanDialog());

        searchField = new JTextField(20);
        searchField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(UITheme.BORDER, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        ModernButton btnCari = new ModernButton("Cari");
        btnCari.setButtonType(ModernButton.ButtonType.PRIMARY);
        btnCari.addActionListener(e -> cariPeminjaman());

        ModernButton btnRefresh = new ModernButton("Refresh");
        btnRefresh.setButtonType(ModernButton.ButtonType.SECONDARY);
        btnRefresh.addActionListener(e -> loadPeminjamanAktif());

        toolbar.add(btnTambah);
        toolbar.add(Box.createHorizontalStrut(30));
        toolbar.add(new JLabel("Cari:"));
        toolbar.add(searchField);
        toolbar.add(btnCari);
        toolbar.add(btnRefresh);
        content.add(toolbar);
        content.add(Box.createVerticalStrut(20));

        // List Container
        listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
        listContainer.setOpaque(false);
        listContainer.setAlignmentX(Component.LEFT_ALIGNMENT);

        loadPeminjamanAktif();

        content.add(listContainer);
        content.add(Box.createVerticalGlue());

        return new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                              JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void loadPeminjamanAktif() {
        listContainer.removeAll();
        ArrayList<Loan> loans = db.getPeminjamanAktif();

        if (loans.isEmpty()) {
            JLabel emptyLabel = new JLabel("Tidak ada peminjaman aktif saat ini.");
            emptyLabel.setFont(UITheme.FONT_HEADING_3);
            emptyLabel.setForeground(UITheme.TEXT_HINT);
            listContainer.add(emptyLabel);
        } else {
            for (Loan loan : loans) {
                listContainer.add(createLoanCard(loan));
                listContainer.add(Box.createVerticalStrut(15));
            }
        }

        listContainer.revalidate();
        listContainer.repaint();
    }

    private void cariPeminjaman() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadPeminjamanAktif();
            return;
        }

        listContainer.removeAll();
        ArrayList<Loan> loans = db.cariPeminjaman(keyword);
        
        // Filter hanya yang statusnya Dipinjam
        ArrayList<Loan> aktif = new ArrayList<>();
        for (Loan loan : loans) {
            if ("Dipinjam".equals(loan.getStatus())) {
                aktif.add(loan);
            }
        }

        if (aktif.isEmpty()) {
            JLabel emptyLabel = new JLabel("Tidak ditemukan hasil untuk: " + keyword);
            emptyLabel.setFont(UITheme.FONT_HEADING_3);
            emptyLabel.setForeground(UITheme.TEXT_HINT);
            listContainer.add(emptyLabel);
        } else {
            for (Loan loan : aktif) {
                listContainer.add(createLoanCard(loan));
                listContainer.add(Box.createVerticalStrut(15));
            }
        }

        listContainer.revalidate();
        listContainer.repaint();
    }

    private JPanel createLoanCard(final Loan loan) {
        RoundedCardPanel card = new RoundedCardPanel();
        card.setLayout(new BorderLayout(15, 10));
        card.setBorderColor(loan.isTerlambat() ? UITheme.DANGER : UITheme.PRIMARY_LIGHT);
        card.setBorderThickness(loan.isTerlambat() ? 2 : 1);
        card.setBackground(UITheme.SURFACE);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 140));

        // Info Panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);
        infoPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel judulLabel = new JLabel(loan.getJudulBuku());
        judulLabel.setFont(UITheme.FONT_HEADING_3);
        judulLabel.setForeground(UITheme.TEXT_PRIMARY);

        JLabel peminjamLabel = new JLabel("Peminjam: " + loan.getNamaPeminjam() + " (NIM: " + loan.getNimMahasiswa() + ")");
        peminjamLabel.setFont(UITheme.FONT_BODY);
        peminjamLabel.setForeground(UITheme.TEXT_SECONDARY);

        JLabel tanggalLabel = new JLabel("Dipinjam: " + loan.getTanggalPinjamFormatted());
        tanggalLabel.setFont(UITheme.FONT_SMALL);
        tanggalLabel.setForeground(UITheme.TEXT_SECONDARY);

        JLabel deadlineLabel = new JLabel("Deadline: " + loan.getDeadlineFormatted());
        deadlineLabel.setFont(UITheme.FONT_SMALL);
        deadlineLabel.setForeground(loan.isTerlambat() ? UITheme.DANGER : UITheme.TEXT_SECONDARY);

        if (loan.isTerlambat()) {
            JLabel terlambatLabel = new JLabel("⚠️ Terlambat " + loan.getHariTerlambat() + " hari");
            terlambatLabel.setFont(UITheme.FONT_SMALL_BOLD);
            terlambatLabel.setForeground(UITheme.DANGER);
            infoPanel.add(terlambatLabel);
        }

        infoPanel.add(judulLabel);
        infoPanel.add(peminjamLabel);
        infoPanel.add(tanggalLabel);
        infoPanel.add(deadlineLabel);

        // Action Panel
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        actionPanel.setOpaque(false);
        actionPanel.setBorder(new EmptyBorder(0, 0, 10, 15));

        ModernButton btnKembalikan = new ModernButton("Kembalikan");
        btnKembalikan.setButtonType(ModernButton.ButtonType.SUCCESS);
        btnKembalikan.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Tandai buku '" + loan.getJudulBuku() + "' sebagai dikembalikan oleh " + loan.getNamaPeminjam() + "?",
                "Konfirmasi Pengembalian",
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = db.kembalikanBuku(loan.getId(), LocalDate.now());
                if (success) {
                    JOptionPane.showMessageDialog(this,
                        "Buku berhasil dikembalikan!",
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
                    loadPeminjamanAktif();
                    parentFrame.refreshDashboard();
                    parentFrame.refreshDaftarBuku();
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Gagal mengembalikan buku.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        actionPanel.add(btnKembalikan);

        card.add(infoPanel, BorderLayout.CENTER);
        card.add(actionPanel, BorderLayout.SOUTH);

        return card;
    }

    private void showTambahPeminjamanDialog() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JTextField namaMahasiswaField = new JTextField(25);
        JTextField nimMahasiswaField = new JTextField(25);
        
        // ComboBox untuk pilih buku
        ArrayList<Book> bukuTersedia = db.getBukuTersedia();
        JComboBox<Book> bukuComboBox = new JComboBox<>();
        for (Book book : bukuTersedia) {
            bukuComboBox.addItem(book);
        }
        bukuComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, 
                                                         int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Book) {
                    Book book = (Book) value;
                    setText(book.getJudul() + " - " + book.getPengarang() + " [" + book.getStatus() + "]");
                }
                return this;
            }
        });

        JSpinner tanggalPinjamSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor1 = new JSpinner.DateEditor(tanggalPinjamSpinner, "dd/MM/yyyy");
        tanggalPinjamSpinner.setEditor(dateEditor1);

        JSpinner deadlineSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(deadlineSpinner, "dd/MM/yyyy");
        deadlineSpinner.setEditor(dateEditor2);

        // Set default dates
        tanggalPinjamSpinner.setValue(new java.util.Date());
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DAY_OF_MONTH, 7);
        deadlineSpinner.setValue(cal.getTime());

        // Add components
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Nama Mahasiswa:"), gbc);
        gbc.gridx = 1;
        formPanel.add(namaMahasiswaField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("NIM Mahasiswa:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nimMahasiswaField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Pilih Buku:"), gbc);
        gbc.gridx = 1;
        formPanel.add(bukuComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Tanggal Pinjam:"), gbc);
        gbc.gridx = 1;
        formPanel.add(tanggalPinjamSpinner, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Deadline Pengembalian:"), gbc);
        gbc.gridx = 1;
        formPanel.add(deadlineSpinner, gbc);

        int result = JOptionPane.showConfirmDialog(this, formPanel,
            "Tambah Peminjaman Baru",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String namaMahasiswa = namaMahasiswaField.getText().trim();
            String nimMahasiswa = nimMahasiswaField.getText().trim();
            Book selectedBook = (Book) bukuComboBox.getSelectedItem();

            if (namaMahasiswa.isEmpty() || nimMahasiswa.isEmpty() || selectedBook == null) {
                JOptionPane.showMessageDialog(this,
                    "Semua field harus diisi!",
                    "Validasi Error",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            java.util.Date tanggalPinjamDate = (java.util.Date) tanggalPinjamSpinner.getValue();
            java.util.Date deadlineDate = (java.util.Date) deadlineSpinner.getValue();

            LocalDate tanggalPinjam = new java.sql.Date(tanggalPinjamDate.getTime()).toLocalDate();
            LocalDate deadline = new java.sql.Date(deadlineDate.getTime()).toLocalDate();

            boolean success = db.tambahPeminjaman(namaMahasiswa, nimMahasiswa, selectedBook.getId(), 
                                                  tanggalPinjam, deadline);

            if (success) {
                JOptionPane.showMessageDialog(this,
                    "Peminjaman berhasil ditambahkan!",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                loadPeminjamanAktif();
                parentFrame.refreshDashboard();
                parentFrame.refreshDaftarBuku();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal menambahkan peminjaman. Buku mungkin tidak tersedia.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}