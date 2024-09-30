package Pertemuan2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cobacoba extends JFrame {

    private JPanel panel;

    public cobacoba() {
        panel = new JPanel();
        panel.setLayout(null);

        // Atur ukuran preferred untuk panel
        panel.setPreferredSize(new Dimension(400, 900)); // Misalnya, 400x900

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tambahkan panel ke JScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(450, 800)); // Ukuran scroll pane
        this.add(scrollPane, BorderLayout.CENTER); // Tambahkan JScrollPane ke frame

        // Label untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(30, 20, 120, 25);
        panel.add(labelNama); // Tambahkan ke panel

        // TextField untuk Nama
        JTextField textNama = new JTextField();
        textNama.setBounds(30, 50, 250, 25);
        panel.add(textNama); // Tambahkan ke panel

        // Label untuk Nomor HP
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(30, 90, 120, 25);
        panel.add(labelNomorHP); // Tambahkan ke panel

        // TextField untuk Nomor HP
        JTextField textNomorHP = new JTextField();
        textNomorHP.setBounds(30, 120, 250, 25);
        panel.add(textNomorHP); // Tambahkan ke panel

        // Label untuk Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(30, 160, 120, 25);
        panel.add(labelRadio); // Tambahkan ke panel

        // RadioButton untuk Laki-Laki
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(30, 190, 100, 25);
        panel.add(radioButton1); // Tambahkan ke panel

        // RadioButton untuk Perempuan
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(130, 190, 100, 25);
        panel.add(radioButton2); // Tambahkan ke panel

        // ButtonGroup untuk mengelompokkan radio button
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // CheckBox untuk Warga Negara Asing
        JCheckBox checkBox1 = new JCheckBox("Warga Negara Asing");
        checkBox1.setBounds(30, 220, 200, 25);
        panel.add(checkBox1); // Tambahkan ke panel

        // Label untuk Jenis Tabungan
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
        labelJenisTabungan.setBounds(30, 250, 120, 25);
        panel.add(labelJenisTabungan); // Tambahkan ke panel

        // JList untuk pilihan jenis tabungan
        String[] jenisTabungan = {"Tabungan Muda", "Tabungan Investasi", "Tabungan Haji", "Tabungan Pendidikan",
                "Tabungan Rencana", "Tabungan Emas", "Tabungan Pensiun", "Tabungan Kesehatan"};
        JList<String> listTabungan = new JList<>(jenisTabungan);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneTabungan = new JScrollPane(listTabungan);
        scrollPaneTabungan.setBounds(30, 280, 250, 100); // Ukuran scroll pane untuk jenis tabungan
        panel.add(scrollPaneTabungan); // Tambahkan ke panel

        // Label untuk Frekuensi Transaksi
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi/bulan:");
        labelFrekuensi.setBounds(30, 400, 200, 25);
        panel.add(labelFrekuensi); // Tambahkan ke panel

        // Slider untuk frekuensi transaksi (1-100)
        JSlider sliderFrekuensi = new JSlider(0, 100, 1);
        sliderFrekuensi.setBounds(30, 430, 300, 50);
        sliderFrekuensi.setMajorTickSpacing(10);
        sliderFrekuensi.setMinorTickSpacing(5);
        sliderFrekuensi.setPaintTicks(true);
        sliderFrekuensi.setPaintLabels(true);
        panel.add(sliderFrekuensi); // Tambahkan ke panel

        // Label untuk Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(30, 490, 120, 25);
        panel.add(labelPassword); // Tambahkan ke panel

        // Password Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 520, 250, 25);
        panel.add(passwordField); // Tambahkan ke panel

        // Label untuk Confirm Password
        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(30, 550, 150, 25);
        panel.add(labelConfirmPassword); // Tambahkan ke panel

        // Confirm Password Field
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(30, 580, 250, 25);
        panel.add(confirmPasswordField); // Tambahkan ke panel

        // Label untuk Tanggal Lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(30, 610, 120, 25);
        panel.add(labelTanggalLahir); // Tambahkan ke panel

        // Spinner untuk tanggal lahir
        SpinnerModel modelTanggal = new SpinnerDateModel();
        JSpinner spinnerTanggal = new JSpinner(modelTanggal);
        spinnerTanggal.setBounds(30, 640, 150, 25);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTanggal, "dd-MM-yyyy");
        spinnerTanggal.setEditor(editor);
        panel.add(spinnerTanggal); // Tambahkan ke panel

        // Tombol untuk menyimpan data
        JButton button = new JButton("Simpan");
        button.setBounds(30, 680, 100, 40);
        panel.add(button); // Tambahkan ke panel

        // TextArea untuk menampilkan output
        JTextArea txtOutput = new JTextArea();
        txtOutput.setEditable(false);

        // JScrollPane untuk memberikan fungsi scroll pada JTextArea
        JScrollPane scrollPaneOutput = new JScrollPane(txtOutput);
        scrollPaneOutput.setBounds(30, 730, 380, 100);  // Mengatur posisi dan ukuran JScrollPane
        panel.add(scrollPaneOutput); // Tambahkan ke panel

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
                String tanggalLahir = editor.getFormat().format(spinnerTanggal.getValue());

                // Tambahkan data ke TextArea
                txtOutput.append("Nama    : " + nama + "\n");
                txtOutput.append("Nomor HP: " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append("WNA     : " + wna + "\n");
                txtOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
                txtOutput.append("Frekuensi Transaksi/bulan: " + frekuensi + "\n");
                txtOutput.append("Password Status: " + passwordStatus + "\n");
                txtOutput.append("Tanggal Lahir: " + tanggalLahir + "\n");
                txtOutput.append("----------------------------------------\n");
            }
        });

        // ActionListener untuk menu Reset
        resetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textNama.setText("");
                textNomorHP.setText("");
                radioButton1.setSelected(true);
                checkBox1.setSelected(false);
                listTabungan.clearSelection();
                sliderFrekuensi.setValue(1); // Reset ke default
                passwordField.setText("");
                confirmPasswordField.setText("");
                spinnerTanggal.setValue(new java.util.Date()); // Reset ke tanggal sekarang
                txtOutput.setText(""); // Kosongkan output
            }
        });

        // ActionListener untuk menu Exit
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Keluar dari program
            }
        });

        // Set ukuran dan layout
        this.setSize(450, 850);
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
