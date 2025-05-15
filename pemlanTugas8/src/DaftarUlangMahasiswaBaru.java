package src;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DaftarUlangMahasiswaBaru extends JFrame {
    private JTextField texFieldAlamat, texFieldNoPendaftaran, texFieldNoTelp, texFieldEmail;
    private JDateChooser dateChooser;
    private JTextArea textAreaAlamat;
    private JButton buttonSubmit;

    // Constructor untuk inisialisasi form input
    public DaftarUlangMahasiswaBaru() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(400, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        // Label dan Input serta ukuran dan posisi
        JLabel labelNama = new JLabel("Nama Lengkap");
        labelNama.setBounds(20, 20, 120, 25);
        add(labelNama);

        texFieldAlamat = new JTextField();
        texFieldAlamat.setBounds(150, 20, 200, 25);
        add(texFieldAlamat);

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir");
        labelTanggalLahir.setBounds(20, 55, 120, 25);
        add(labelTanggalLahir);

        // Mengganti TextField dengan JDateChooser
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd-MM-yyyy");
        dateChooser.setBounds(150, 55, 200, 25);
        add(dateChooser);

        JLabel labelNoPendaftaran = new JLabel("No. Pendaftaran");
        labelNoPendaftaran.setBounds(20, 90, 120, 25);
        add(labelNoPendaftaran);

        texFieldNoPendaftaran = new JTextField();
        texFieldNoPendaftaran.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Menolak karakter non-digit
                }
            }
        });
        texFieldNoPendaftaran.setBounds(150, 90, 200, 25);
        add(texFieldNoPendaftaran);

        JLabel labelNoTelp = new JLabel("No. Telp");
        labelNoTelp.setBounds(20, 125, 120, 25);
        add(labelNoTelp);

        texFieldNoTelp = new JTextField();
        texFieldNoTelp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Menolak karakter non-digit
                }
            }
        });
        texFieldNoTelp.setBounds(150, 125, 200, 25);
        add(texFieldNoTelp);

        JLabel labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(20, 160, 120, 25);
        add(labelAlamat);

        textAreaAlamat = new JTextArea();
        JScrollPane scrollAlamat = new JScrollPane(textAreaAlamat);
        scrollAlamat.setBounds(150, 160, 200, 50);
        add(scrollAlamat);

        JLabel labelEmail = new JLabel("E-mail");
        labelEmail.setBounds(20, 220, 120, 25);
        add(labelEmail);

        texFieldEmail = new JTextField();
        texFieldEmail.setBounds(150, 220, 200, 25);
        add(texFieldEmail);

        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(150, 260, 100, 30);
        add(buttonSubmit);

        // Supaya tombol submit bisa ditekan dan melakukan aksi
        buttonSubmit.addActionListener(e -> submitForm());

        setVisible(true);
    }

    // Method untuk menampilkan pesan konfirmasi dan menampilkan data
    private void submitForm() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String tanggalLahir = "";

        if (dateChooser.getDate() != null) {
            tanggalLahir = sdf.format(dateChooser.getDate());
        }

        if (texFieldAlamat.getText().isEmpty() || dateChooser.getDate() == null ||
                texFieldNoPendaftaran.getText().isEmpty() || texFieldNoTelp.getText().isEmpty() ||
                textAreaAlamat.getText().isEmpty() || texFieldEmail.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah anda yakin data yang Anda isi sudah benar?",
                "Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION);

        if (confirm == JOptionPane.OK_OPTION) {
            tampilkanData(tanggalLahir);
        }
    }

    // Method untuk menampilkan data yang diisi
    private void tampilkanData(String tanggalLahir) {
        JFrame dataFrame = new JFrame("");
        dataFrame.setSize(480, 360);
        dataFrame.setLocationRelativeTo(null);
        dataFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dataFrame.setResizable(false);
        dataFrame.setLayout(new BorderLayout(10, 10));

        // Panel utama dengan padding
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel judul dengan styling
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Form Daftar Ulang Mahasiswa Baru");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(44, 62, 80));
        titlePanel.add(titleLabel);

        // Panel data dengan GridBagLayout untuk susunan yang rapi
        JPanel dataPanel = new JPanel(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        dataPanel.setBackground(new Color(236, 240, 241));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 15);

        // Label fields dengan styling
        JLabel[] labels = {
                new JLabel("Nama"),
                new JLabel("Tanggal Lahir"),
                new JLabel("No. Pendaftaran"),
                new JLabel("No. Telp"),
                new JLabel("Alamat"),
                new JLabel("E-mail")
        };

        // Data values
        JLabel[] values = {
                createValueLabel(texFieldAlamat.getText()),
                createValueLabel(tanggalLahir),
                createValueLabel(texFieldNoPendaftaran.getText()),
                createValueLabel(texFieldNoTelp.getText()),
                createValueLabel(textAreaAlamat.getText()),
                createValueLabel(texFieldEmail.getText())
        };

        // Menambahkan komponen ke panel
        for (int i = 0; i < labels.length; i++) {
            // Style label
            labels[i].setFont(new Font("Arial", Font.BOLD, 12));

            // Tambahkan label dan nilai
            gbc.gridx = 0;
            gbc.gridy = i;
            dataPanel.add(labels[i], gbc);

            gbc.gridx = 1;
            dataPanel.add(new JLabel(" : "), gbc);

            gbc.gridx = 2;
            gbc.weightx = 1.0;
            dataPanel.add(values[i], gbc);
            gbc.weightx = 0.0;
        }

        // Panel tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton buttonClose = new JButton("Tutup");
        buttonClose.setBackground(new Color(52, 152, 219));
        buttonClose.setForeground(Color.WHITE);
        buttonClose.addActionListener(e -> dataFrame.dispose());
        buttonPanel.add(buttonClose);

        // Susun panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(dataPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        dataFrame.add(mainPanel);

        dataFrame.setVisible(true);
    }

    private JLabel createValueLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DaftarUlangMahasiswaBaru::new);
    }
}
