import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class RiwayatPeminjamanPanel extends JPanel {
    private MainAppFrame parentFrame;
    private JSONDatabaseHelper db;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public RiwayatPeminjamanPanel(MainAppFrame parentFrame, JSONDatabaseHelper db) {
        this.parentFrame = parentFrame;
        this.db = db;
        setLayout(new BorderLayout());
        setBackground(UITheme.BACKGROUND);
        add(SidebarUtil.createAdminSidebar(parentFrame, MainAppFrame.RIWAYAT_PEMINJAMAN), BorderLayout.WEST);
        add(createContent(), BorderLayout.CENTER);
    }

    public void refreshData() {
        loadRiwayat();
    }

    private JScrollPane createContent() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(UITheme.BACKGROUND);
        content.setBorder(new EmptyBorder(UITheme.PADDING_LARGE, UITheme.PADDING_LARGE, 
                                         UITheme.PADDING_LARGE, UITheme.PADDING_LARGE));

        JLabel header = new JLabel("Riwayat Peminjaman");
        header.setFont(UITheme.FONT_TITLE);
        header.setForeground(UITheme.TEXT_PRIMARY);
        header.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(header);

        JLabel subtitle = new JLabel("Lihat semua data peminjaman dan status pengembalian");
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

        searchField = new JTextField(20);
        searchField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(UITheme.BORDER, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        ModernButton btnCari = new ModernButton("Cari");
        btnCari.setButtonType(ModernButton.ButtonType.PRIMARY);
        btnCari.addActionListener(e -> cariRiwayat());

        ModernButton btnRefresh = new ModernButton("Refresh");
        btnRefresh.setButtonType(ModernButton.ButtonType.SECONDARY);
        btnRefresh.addActionListener(e -> loadRiwayat());

        ModernButton btnSemuaStatus = new ModernButton("Semua");
        btnSemuaStatus.setButtonType(ModernButton.ButtonType.INFO);
        btnSemuaStatus.addActionListener(e -> loadRiwayat());

        ModernButton btnDipinjam = new ModernButton("Sedang Dipinjam");
        btnDipinjam.setButtonType(ModernButton.ButtonType.INFO);
        btnDipinjam.addActionListener(e -> filterByStatus("Dipinjam"));

        ModernButton btnDikembalikan = new ModernButton("Dikembalikan");
        btnDikembalikan.setButtonType(ModernButton.ButtonType.SUCCESS);
        btnDikembalikan.addActionListener(e -> filterByStatus("Dikembalikan"));

        toolbar.add(new JLabel("Cari:"));
        toolbar.add(searchField);
        toolbar.add(btnCari);
        toolbar.add(btnRefresh);
        toolbar.add(Box.createHorizontalStrut(20));
        toolbar.add(new JLabel("Filter:"));
        toolbar.add(btnSemuaStatus);
        toolbar.add(btnDipinjam);
        toolbar.add(btnDikembalikan);

        content.add(toolbar);
        content.add(Box.createVerticalStrut(20));

        // Table
        String[] columnNames = {"ID", "Nama Mahasiswa", "NIM", "Judul Buku", "Tgl Pinjam", 
                               "Deadline", "Tgl Kembali", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        table.setFont(UITheme.FONT_BODY);
        table.setRowHeight(35);
        table.getTableHeader().setFont(UITheme.FONT_BODY_BOLD);
        table.getTableHeader().setBackground(UITheme.PRIMARY_LIGHT);
        table.getTableHeader().setForeground(UITheme.TEXT_PRIMARY);
        table.setSelectionBackground(UITheme.PRIMARY_LIGHTER);

        // Hide ID column
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setWidth(0);

        // Adjust column widths
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);

        loadRiwayat();

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        tableScroll.setBorder(BorderFactory.createLineBorder(UITheme.BORDER));
        content.add(tableScroll);

        JScrollPane mainScroll = new JScrollPane(content);
        mainScroll.setBorder(null);
        return mainScroll;
    }

    private void loadRiwayat() {
        tableModel.setRowCount(0);
        ArrayList<Loan> loans = db.getRiwayatPeminjaman();

        for (Loan loan : loans) {
            Object[] row = {
                loan.getId(),
                loan.getNamaPeminjam(),
                loan.getNimMahasiswa(),
                loan.getJudulBuku(),
                loan.getTanggalPinjamFormatted(),
                loan.getDeadlineFormatted(),
                loan.getTanggalKembaliFormatted(),
                loan.getStatus()
            };
            tableModel.addRow(row);
        }
    }

    private void cariRiwayat() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadRiwayat();
            return;
        }

        tableModel.setRowCount(0);
        ArrayList<Loan> loans = db.cariPeminjaman(keyword);

        for (Loan loan : loans) {
            Object[] row = {
                loan.getId(),
                loan.getNamaPeminjam(),
                loan.getNimMahasiswa(),
                loan.getJudulBuku(),
                loan.getTanggalPinjamFormatted(),
                loan.getDeadlineFormatted(),
                loan.getTanggalKembaliFormatted(),
                loan.getStatus()
            };
            tableModel.addRow(row);
        }
    }

    private void filterByStatus(String status) {
        tableModel.setRowCount(0);
        ArrayList<Loan> allLoans = db.getRiwayatPeminjaman();

        for (Loan loan : allLoans) {
            if (loan.getStatus().equals(status)) {
                Object[] row = {
                    loan.getId(),
                    loan.getNamaPeminjam(),
                    loan.getNimMahasiswa(),
                    loan.getJudulBuku(),
                    loan.getTanggalPinjamFormatted(),
                    loan.getDeadlineFormatted(),
                    loan.getTanggalKembaliFormatted(),
                    loan.getStatus()
                };
                tableModel.addRow(row);
            }
        }
    }
}