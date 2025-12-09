import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

public class DaftarBukuPanel extends JPanel {
    private MainAppFrame parentFrame;
    private JSONDatabaseHelper db;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JComboBox<String> kategoriFilter;

    public DaftarBukuPanel(MainAppFrame parentFrame, JSONDatabaseHelper db) {
        this.parentFrame = parentFrame;
        this.db = db;
        setLayout(new BorderLayout());
        setBackground(UITheme.BACKGROUND);
        add(SidebarUtil.createAdminSidebar(parentFrame, MainAppFrame.DAFTAR_BUKU), BorderLayout.WEST);
        add(createContent(), BorderLayout.CENTER);
    }

    public void refreshData() {
        loadBuku();
    }

    private JScrollPane createContent() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(UITheme.BACKGROUND);
        content.setBorder(new EmptyBorder(UITheme.PADDING_LARGE, UITheme.PADDING_LARGE, 
                                         UITheme.PADDING_LARGE, UITheme.PADDING_LARGE));

        JLabel header = new JLabel("Daftar Buku Perpustakaan");
        header.setFont(UITheme.FONT_TITLE);
        header.setForeground(UITheme.TEXT_PRIMARY);
        header.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(header);

        JLabel subtitle = new JLabel("Lihat semua koleksi buku dan ketersediaannya");
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
        btnCari.addActionListener(e -> cariBuku());

        ModernButton btnRefresh = new ModernButton("Refresh");
        btnRefresh.setButtonType(ModernButton.ButtonType.SECONDARY);
        btnRefresh.addActionListener(e -> loadBuku());

        // Filter Kategori
        String[] kategoris = {"Semua Kategori", "Pemrograman", "Jaringan", "Database", 
                             "Sistem Operasi", "Web Development", "Mobile Development", 
                             "AI & Machine Learning", "Keamanan Siber", "Matematika"};
        kategoriFilter = new JComboBox<>(kategoris);
        kategoriFilter.addActionListener(e -> filterByKategori());

        // Filter Status
        ModernButton btnSemuaStatus = new ModernButton("Semua Status");
        btnSemuaStatus.setButtonType(ModernButton.ButtonType.INFO);
        btnSemuaStatus.addActionListener(e -> loadBuku());

        ModernButton btnTersedia = new ModernButton("Tersedia");
        btnTersedia.setButtonType(ModernButton.ButtonType.SUCCESS);
        btnTersedia.addActionListener(e -> filterByStatus(true));

        ModernButton btnDipinjam = new ModernButton("Sedang Dipinjam");
        btnDipinjam.setButtonType(ModernButton.ButtonType.DANGER);
        btnDipinjam.addActionListener(e -> filterByStatus(false));

        toolbar.add(new JLabel("Cari:"));
        toolbar.add(searchField);
        toolbar.add(btnCari);
        toolbar.add(btnRefresh);
        toolbar.add(Box.createHorizontalStrut(10));
        toolbar.add(kategoriFilter);
        toolbar.add(Box.createHorizontalStrut(10));
        toolbar.add(btnSemuaStatus);
        toolbar.add(btnTersedia);
        toolbar.add(btnDipinjam);

        content.add(toolbar);
        content.add(Box.createVerticalStrut(20));

        // Table
        String[] columnNames = {"ID", "Judul Buku", "Pengarang", "Kategori", 
                               "Tahun", "Penerbit", "Rak", "Total", "Tersedia", "Status"};
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

        // Set column widths
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);

        loadBuku();

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        tableScroll.setBorder(BorderFactory.createLineBorder(UITheme.BORDER));
        content.add(tableScroll);

        JScrollPane mainScroll = new JScrollPane(content);
        mainScroll.setBorder(null);
        return mainScroll;
    }

    private void loadBuku() {
        tableModel.setRowCount(0);
        ArrayList<Book> books = db.getAllBuku();

        for (Book book : books) {
            Object[] row = {
                book.getId(),
                book.getJudul(),
                book.getPengarang(),
                book.getKategori(),
                book.getTahunTerbit(),
                book.getPenerbit(),
                book.getRakLokasi(),
                book.getJumlahTotal(),
                book.getJumlahTersedia(),
                book.getStatus()
            };
            tableModel.addRow(row);
        }
    }

    private void cariBuku() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadBuku();
            return;
        }

        tableModel.setRowCount(0);
        ArrayList<Book> books = db.cariBuku(keyword);

        for (Book book : books) {
            Object[] row = {
                book.getId(),
                book.getJudul(),
                book.getPengarang(),
                book.getKategori(),
                book.getTahunTerbit(),
                book.getPenerbit(),
                book.getRakLokasi(),
                book.getJumlahTotal(),
                book.getJumlahTersedia(),
                book.getStatus()
            };
            tableModel.addRow(row);
        }
    }

    private void filterByKategori() {
        String kategori = (String) kategoriFilter.getSelectedItem();
        if (kategori.equals("Semua Kategori")) {
            loadBuku();
            return;
        }

        tableModel.setRowCount(0);
        ArrayList<Book> allBooks = db.getAllBuku();

        for (Book book : allBooks) {
            if (book.getKategori().equals(kategori)) {
                Object[] row = {
                    book.getId(),
                    book.getJudul(),
                    book.getPengarang(),
                    book.getKategori(),
                    book.getTahunTerbit(),
                    book.getPenerbit(),
                    book.getRakLokasi(),
                    book.getJumlahTotal(),
                    book.getJumlahTersedia(),
                    book.getStatus()
                };
                tableModel.addRow(row);
            }
        }
    }

    private void filterByStatus(boolean tersedia) {
        tableModel.setRowCount(0);
        ArrayList<Book> allBooks = db.getAllBuku();

        for (Book book : allBooks) {
            if (tersedia && book.isTersedia()) {
                Object[] row = {
                    book.getId(),
                    book.getJudul(),
                    book.getPengarang(),
                    book.getKategori(),
                    book.getTahunTerbit(),
                    book.getPenerbit(),
                    book.getRakLokasi(),
                    book.getJumlahTotal(),
                    book.getJumlahTersedia(),
                    book.getStatus()
                };
                tableModel.addRow(row);
            } else if (!tersedia && !book.isTersedia()) {
                Object[] row = {
                    book.getId(),
                    book.getJudul(),
                    book.getPengarang(),
                    book.getKategori(),
                    book.getTahunTerbit(),
                    book.getPenerbit(),
                    book.getRakLokasi(),
                    book.getJumlahTotal(),
                    book.getJumlahTersedia(),
                    book.getStatus()
                };
                tableModel.addRow(row);
            }
        }
    }
}