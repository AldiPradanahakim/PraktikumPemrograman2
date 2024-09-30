package Pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class Biodata2 extends JFrame {

    public Biodata2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(30, 20, 120, 25);

        // TextField untuk Nama
        JTextField textNama = new JTextField();
        textNama.setBounds(30, 50, 250, 25);

        // Label untuk Nomor HP
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(30, 90, 120, 25);

        // TextField untuk Nomor HP
        JTextField textNomorHP = new JTextField();
        textNomorHP.setBounds(30, 120, 250, 25);

        // Label untuk Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(30, 160, 120, 25);

        // RadioButton untuk Laki-Laki
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(30, 190, 100, 25);

        // RadioButton untuk Perempuan
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(30, 220, 100, 25);

        // ButtonGroup untuk mengelompokkan radio button
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // CheckBox untuk Warga Negara Asing
        JCheckBox checkBox1 = new JCheckBox("Warga Negara Asing");
        checkBox1.setBounds(30, 250, 200, 25);

        // Tombol untuk menyimpan biodata
        JButton button = new JButton("Simpan");
        button.setBounds(30, 290, 100, 40);

        // TextArea untuk menampilkan output
        JTextArea txtOutput = new JTextArea();
        txtOutput.setEditable(false);

        // JScrollPane untuk memberikan fungsi scroll pada JTextArea
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(30, 350, 380, 150);  // Mengatur posisi dan ukuran JScrollPane

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

                // Tambahkan data ke TextArea
                txtOutput.append("Nama    : " + nama + "\n");
                txtOutput.append("Nomor HP: " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                txtOutput.append("WNA     : " + wna + "\n");
                txtOutput.append("=================================\n");

                // Kosongkan input setelah disimpan
                textNama.setText("");
                textNomorHP.setText("");
            }
        });

        // Tambahkan komponen ke frame
        this.add(labelNama);
        this.add(textNama);
        this.add(labelNomorHP);
        this.add(textNomorHP);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox1);
        this.add(button);
        this.add(scrollPane);

        // Set ukuran dan layout
        this.setSize(450, 800);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata2 biodata2 = new Biodata2();
                biodata2.setVisible(true);
            }
        });
    }
}
