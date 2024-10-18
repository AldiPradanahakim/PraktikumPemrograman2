package Pertemuan3;

import  javax.swing.*;
import java.awt.event.*;

public class WindowListenerExample {
    public static void main(String[] args) {
        //Membuat frame
        JFrame frame = new JFrame("WindowListener Example");

        //membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Lakukan operasi pada jendel. ");
        label.setBounds(50, 50, 300, 30);

        //menambahkan windowlistener ke frame
        frame.addWindowListener(new WindowAdapter() {
           //dijalankan ketika jendela ke frame
           public void windowOpened(WindowEvent e) {
               label.setText("Window Opened");
           }

           //Dijalankan ketika jendela sedang dalam proses penutupan
            public void windowClosing(WindowEvent e) {
               label.setText("Window Closed");
               // bisa dijalankan system.exit(0); jika ingin menghentikan program
            }

            //dijalankan ketika jendela benar-benar ditutup
            public void windowClosed(WindowEvent e) {
               System.out.println("Window Closed");
            }

            //dijalankan ketika jendela diminimalkan
            public void windowIconified(WindowEvent e) {
               label.setText("Window Minimized");
            }

            //dijalankan ketika jendela dipulihkan dari minimalkan
            public void windowDeiconified(WindowEvent e) {
               label.setText("Window Restored");
            }

            //dijalankan ketika jendela menjadi aktif (berfokus)
            public void windowActivated(WindowEvent e) {
               label.setText("Window Activated");
            }

            //dijalankan ketika jendela kehilangan fokus
            public void windowDeactivated(WindowEvent e) {
               label.setText("Window Deactivated");
            }
        });

        //menambahkan label ke frame
        frame.add(label);

        //setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // agar jendela benar benar tertutup
    }
}
