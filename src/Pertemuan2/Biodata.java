package Pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class Biodata extends JFrame {

    public Biodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(40, 40, 100, 20);

        // TextField untuk Nama
        JTextField textNama = new JTextField();
        textNama.setBounds(40, 60, 200, 30);

        // Label untuk Nomor HP
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(40, 100, 100, 20);

        // TextField untuk Nomor HP
        JTextField textNomorHP = new JTextField();
        textNomorHP.setBounds(40, 120, 200, 30);

        // Tombol untuk menyimpan biodata
        JButton button = new JButton("Simpan");
        button.setBounds(40, 160, 100, 30);

        // TextArea untuk menampilkan output
        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(40, 200, 300, 200);

        // ActionListener untuk tombol
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();
                String nomorHP = textNomorHP.getText();
                // Tambahkan nama dan nomor HP ke TextArea
                    txtOutput.append("Nama: " + nama + "\nNomor HP: " + nomorHP + "\n====================\n");
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
        this.add(button);
        this.add(txtOutput);

        // Set ukuran dan layout
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata biodata = new Biodata();
                biodata.setVisible(true);
            }
        });
    }
}
