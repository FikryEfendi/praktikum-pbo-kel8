import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class Latihan9 implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;

    private JFrame frame;
    private JPanel panelKonten;
    private CardLayout cardLayout;
    
    private JTextField namaField;
    private JTextField nimField;
    private JTextField kelaminField;

    public Latihan9() {
        frame = new JFrame("Data Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(4, 1, 10, 10));
        panelMenu.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMenu.setBackground(Color.LIGHT_GRAY);

        JButton tombolTambah = new JButton("Tambah Data");
        JButton tombolLihat = new JButton("Lihat Data");
        
        panelMenu.add(tombolTambah);
        panelMenu.add(tombolLihat);

        tombolTambah.addActionListener(this);
        tombolLihat.addActionListener(this);

        frame.add(panelMenu, BorderLayout.WEST);

        cardLayout = new CardLayout();
        panelKonten = new JPanel(cardLayout);

        JPanel halamanTambah = buatHalamanTambah();
        JPanel halamanLihat = buatHalamanLihat();

        panelKonten.add(halamanTambah, "TAMBAH");
        panelKonten.add(halamanLihat, "LIHAT");

        frame.add(panelKonten, BorderLayout.CENTER);

        frame.setVisible(true);
        cardLayout.show(panelKonten, "TAMBAH"); 
    }

    private JPanel buatHalamanTambah() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nama:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        namaField = new JTextField(20);
        panel.add(namaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("NIM:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        nimField = new JTextField(20);
        panel.add(nimField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Kelamin:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        kelaminField = new JTextField(20);
        panel.add(kelaminField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        JButton tombolSimpan = new JButton("Simpan");
        tombolSimpan.addActionListener(this);
        panel.add(tombolSimpan, gbc);

        return panel;
    }

    private JPanel buatHalamanLihat() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel judul = new JLabel("Daftar Mahasiswa");
        judul.setFont(new Font("Arial", Font.BOLD, 16));
        judul.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel.add(judul, BorderLayout.NORTH);
        
        String[] namaKolom = {"NIM", "Nama", "Kelamin"};

        tableModel = new DefaultTableModel(namaKolom, 0);

        table = new JTable(tableModel);
        
        table.setDefaultEditor(Object.class, null); 
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 

        JScrollPane scrollPane = new JScrollPane(table); 
        
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton tombolDelete = new JButton("Hapus Data Terpilih");
        JButton tombolUpdate = new JButton("Perbarui Data Terpilih");

        JPanel panelButton = new JPanel();
        panelButton.add(tombolDelete);
        panelButton.add(tombolUpdate);
        panel.add(panelButton, BorderLayout.SOUTH);

        tombolDelete.addActionListener(this);
        tombolUpdate.addActionListener(this);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); 

        if (command.equals("Tambah Data")) {
            cardLayout.show(panelKonten, "TAMBAH"); 
        
        } else if (command.equals("Lihat Data")) {
            cardLayout.show(panelKonten, "LIHAT"); 

        } else if (command.equals("Simpan")) {
            simpanData();
        } else if (command.equals("Hapus Data Terpilih")) {
            hapusData();
        } else if (command.equals("Perbarui Data Terpilih")) {
            perbaruiData();
        }
    }

    private void simpanData() {
        String nama = namaField.getText();
        String nim = nimField.getText();
        String kelamin = kelaminField.getText();

        if (nama.isEmpty() || nim.isEmpty() || kelamin.isEmpty()) {
            JOptionPane.showMessageDialog(frame, 
                "Nama, NIM, dan Kelamin tidak boleh ada yang kosong!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (char c : nim.toCharArray()) {
            if (!Character.isDigit(c)) {
                JOptionPane.showMessageDialog(frame, 
                    "NIM harus berupa angka!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        for (Vector<Object> existingRow : tableModel.getDataVector()) {
            String existingNim = (String) existingRow.get(0);
            if (existingNim.equals(nim)) {
                JOptionPane.showMessageDialog(frame, 
                    "NIM sudah ada dalam data!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        

        Object[] dataBaru = {nim, nama, kelamin };
        tableModel.addRow(dataBaru); 

        JOptionPane.showMessageDialog(frame, 
            "Data berhasil disimpan!", 
            "Sukses", 
            JOptionPane.INFORMATION_MESSAGE);

        namaField.setText("");
        nimField.setText("");
        kelaminField.setText("");
    }

    private void hapusData() {
        int barisTerpilih = table.getSelectedRow();
        if (barisTerpilih == -1) {
            JOptionPane.showMessageDialog(frame, 
                "Pilih data yang akan dihapus!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(frame, 
            "Apakah Anda yakin ingin menghapus data ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            tableModel.removeRow(barisTerpilih);
            JOptionPane.showMessageDialog(frame, 
                "Data berhasil dihapus!", 
                "Sukses", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void perbaruiData() {
        int barisTerpilih = table.getSelectedRow();
        if (barisTerpilih == -1) {
            JOptionPane.showMessageDialog(frame, 
                "Pilih data yang akan diperbarui!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nimLama = (String) tableModel.getValueAt(barisTerpilih, 0);

        String namaBaru = JOptionPane.showInputDialog(frame, 
            "Masukkan Nama baru:", 
            tableModel.getValueAt(barisTerpilih, 1));
        String nimBaru = JOptionPane.showInputDialog(frame, 
            "Masukkan NIM baru:", 
            nimLama);
        String kelaminBaru = JOptionPane.showInputDialog(frame, 
            "Masukkan Kelamin baru:", 
            tableModel.getValueAt(barisTerpilih, 2));

        if (namaBaru != null && nimBaru != null && kelaminBaru != null &&
            !namaBaru.isEmpty() && !nimBaru.isEmpty() && !kelaminBaru.isEmpty()) {

            tableModel.setValueAt(namaBaru, barisTerpilih, 1);
            tableModel.setValueAt(nimBaru, barisTerpilih, 0);
            tableModel.setValueAt(kelaminBaru, barisTerpilih, 2);

            JOptionPane.showMessageDialog(frame, 
                "Data berhasil diperbarui!", 
                "Sukses", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, 
                "Data tidak boleh ada yang kosong!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Latihan9();
            }
        });
    }
}