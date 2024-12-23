package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BookView extends JFrame {
    public JTable table;
    public JTextField txtId, txtTitle, txtAuthor, txtGenre, txtYear;
    public JButton btnAdd, btnUpdate, btnDelete, btnClear;

    public BookView() {
        setTitle("Book Manager");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new TitledBorder("Books List"));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(new TitledBorder("Book Details"));
        inputPanel.add(new JLabel("ID:"));
        txtId = new JTextField();
        txtId.setEditable(false); // ID hanya untuk baca (Read-Only)
        inputPanel.add(txtId);
        inputPanel.add(new JLabel("Title:"));
        txtTitle = new JTextField();
        inputPanel.add(txtTitle);
        inputPanel.add(new JLabel("Author:"));
        txtAuthor = new JTextField();
        inputPanel.add(txtAuthor);
        inputPanel.add(new JLabel("Genre:"));
        txtGenre = new JTextField();
        inputPanel.add(txtGenre);
        inputPanel.add(new JLabel("Year:"));
        txtYear = new JTextField();
        inputPanel.add(txtYear);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        // Main Layout
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add MouseListener to JTable
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    txtId.setText(table.getValueAt(selectedRow, 0).toString());
                    txtTitle.setText(table.getValueAt(selectedRow, 1).toString());
                    txtAuthor.setText(table.getValueAt(selectedRow, 2).toString());
                    txtGenre.setText(table.getValueAt(selectedRow, 3).toString());
                    txtYear.setText(table.getValueAt(selectedRow, 4).toString());
                }
            }
        });
    }
}
