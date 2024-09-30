package Pertemuan2;

import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class PendaftaranNasabah extends JFrame {

    public PendaftaranNasabah() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Label untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(30, 10, 120, 25);

        // TextField untuk Nama
        JTextField textNama = new JTextField();
        textNama.setBounds(30, 30, 250, 25);

        // Label untuk Nomor HP
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(30, 55, 120, 25);

        // TextField untuk Nomor HP
        JTextField textNomorHP = new JTextField();
        textNomorHP.setBounds(30, 75, 250, 25);

        // Label untuk Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(30, 100, 120, 25);

        // RadioButton untuk Laki-Laki
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(30, 120, 100, 25);

        // RadioButton untuk Perempuan
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(130, 120, 100, 25);

        // ButtonGroup untuk mengelompokkan radio button
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // CheckBox untuk Warga Negara Asing
        JCheckBox checkBox1 = new JCheckBox("Warga Negara Asing");
        checkBox1.setBounds(30, 145, 200, 25);

        // Label untuk Jenis Tabungan
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
        labelJenisTabungan.setBounds(30, 170, 120, 25);

        // JList untuk pilihan jenis tabungan (tanpa JScrollPane)
        String[] jenisTabungan = {"Tabungan Muda", "Tabungan Investasi", "Tabungan Haji", "Tabungan Pendidikan"};
        JList<String> listTabungan = new JList<>(jenisTabungan);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listTabungan.setBounds(30, 200, 250, jenisTabungan.length * 20); // Ukuran disesuaikan agar semua item terlihat

        // Label untuk Frekuensi Transaksi
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi/bulan:");
        labelFrekuensi.setBounds(30, 280, 200, 25);

        // Slider untuk frekuensi transaksi (1-100)
        JSlider sliderFrekuensi = new JSlider(0, 100, 1);
        sliderFrekuensi.setBounds(30, 300, 300, 50);
        sliderFrekuensi.setMajorTickSpacing(10);
        sliderFrekuensi.setMinorTickSpacing(5);
        sliderFrekuensi.setPaintTicks(true);
        sliderFrekuensi.setPaintLabels(true);

        // Label untuk Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(30, 350, 120, 25);

        // Password Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 370, 250, 25);

        // Label untuk Confirm Password
        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(30, 400, 150, 25);

        // Confirm Password Field
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(30, 420, 250, 25);

        // Label untuk Tanggal Lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(30, 450, 120, 25);

        // JComboBox untuk tanggal
        Integer[] tanggal = new Integer[31];
        for (int i = 0; i < 31; i++) {
            tanggal[i] = i + 1;
        }
        JComboBox<Integer> comboTanggal = new JComboBox<>(tanggal);
        comboTanggal.setBounds(30, 470, 50, 25);

        // JComboBox untuk bulan
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        JComboBox<String> comboBulan = new JComboBox<>(bulan);
        comboBulan.setBounds(90, 470, 100, 25);

        // JComboBox untuk tahun
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer[] tahun = new Integer[121]; // Dari 1900 hingga tahun ini
        for (int i = 0; i < 121; i++) {
            tahun[i] = currentYear - 120 + i; // Mengatur tahun dari 1900 hingga tahun sekarang
        }
        JComboBox<Integer> comboTahun = new JComboBox<>(tahun);
        comboTahun.setBounds(200, 470, 80, 25);

        // Tombol untuk menyimpan data
        JButton button = new JButton("Simpan");
        button.setBounds(30, 510, 100, 40);

        // TextArea untuk menampilkan output
        JTextArea txtOutput = new JTextArea();
        txtOutput.setEditable(false);

        // JScrollPane untuk memberikan fungsi scroll pada JTextArea
        JScrollPane scrollPaneOutput = new JScrollPane(txtOutput);
        scrollPaneOutput.setBounds(30, 560, 380, 150);  // Mengatur posisi dan ukuran JScrollPane

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // ActionListener untuk tombol Simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                String wna = "";

                // Ambil pilihan jenis kelamin
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                } else if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                // Cek status WNA
                if (checkBox1.isSelected()) {
                    wna = "Ya";
                } else {
                    wna = "Tidak";
                }

                // Ambil data dari text field
                String nama = textNama.getText();
                String nomorHP = textNomorHP.getText();
                String jenisTabungan = listTabungan.getSelectedValue();
                int frekuensi = sliderFrekuensi.getValue(); // Ambil nilai dari slider

                // Ambil password
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();

                // Cek apakah password dan confirm password cocok
                String passwordStatus = new String(password).equals(new String(confirmPassword)) ? "Cocok" : "Tidak Cocok";

                // Ambil tanggal lahir
                int tanggalLahir = (Integer) comboTanggal.getSelectedItem();
                String bulanLahir = (String) comboBulan.getSelectedItem();
                int tahunLahir = (Integer) comboTahun.getSelectedItem();

                // Tambahkan data ke TextArea
                txtOutput.append("Nama    : " + nama + "\n");
                txtOutput.append("Nomor HP: " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append("WNA     : " + wna + "\n");
                txtOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
                txtOutput.append("Frekuensi Transaksi/bulan: " + frekuensi + "\n");
                txtOutput.append("Password Status: " + passwordStatus + "\n");
                txtOutput.append("Tanggal Lahir: " + tanggalLahir + " " + bulanLahir + " " + tahunLahir + "\n");
                txtOutput.append("=================================\n");
            }
        });

        // ActionListener untuk menu Reset
        resetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Kosongkan semua input dan output
                textNama.setText("");
                textNomorHP.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                sliderFrekuensi.setValue(1); // Reset slider
                txtOutput.setText("");
                bg.clearSelection();
                listTabungan.clearSelection();
                checkBox1.setSelected(false);
                radioButton1.setSelected(true); // Reset ke Laki-Laki
                comboTanggal.setSelectedIndex(0);
                comboBulan.setSelectedIndex(0);
                comboTahun.setSelectedIndex(0);
            }
        });

        // ActionListener untuk menu Exit
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Menambahkan semua komponen ke JFrame
        this.add(labelNama);
        this.add(textNama);
        this.add(labelNomorHP);
        this.add(textNomorHP);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox1);
        this.add(labelJenisTabungan);
        this.add(listTabungan);
        this.add(labelFrekuensi);
        this.add(sliderFrekuensi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelTanggalLahir);
        this.add(comboTanggal);
        this.add(comboBulan);
        this.add(comboTahun);
        this.add(button);
        this.add(scrollPaneOutput);

        this.setLayout(null);
        this.setSize(500, 800);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PendaftaranNasabah pendaftaranNasabah = new PendaftaranNasabah();
                pendaftaranNasabah.setVisible(true);
            }
        });
    }
}
