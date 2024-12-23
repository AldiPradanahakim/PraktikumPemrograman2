package view;

import javax.swing.*;
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

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.add(new JLabel("ID:"));
        txtId = new JTextField();
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
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        // Add components
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
