/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan7.InvetoryManagement.src.view.Inventory;

import  Pertemuan7.InvetoryManagement.src.dao.InventoryDAO;
import  Pertemuan7.InvetoryManagement.src.model.InventoryItem;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class InventoryManagementForm extends JFrame {
    private JTable tableInventory;
    private InventoryDAO inventoryDAO;

    public InventoryManagementForm() {
        setTitle("Manajemen Inventori");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inventoryDAO = new InventoryDAO();

        // Tabel Inventori
        String[] columnNames = {"Kode", "Nama", "Deskripsi", "Kategori", "Supplier", "Jumlah"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        tableInventory = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableInventory);
        add(scrollPane, BorderLayout.CENTER);

        // Tombol
        JPanel buttonPanel = new JPanel();
        JButton btnLoad = new JButton("Load Data");
        JButton btnAdd = new JButton("Tambah Item");
        JButton btnDelete = new JButton("Hapus Item");
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        add(buttonPanel, BorderLayout.SOUTH);

        // Aksi Tombol
        btnLoad.addActionListener(e -> loadData(tableModel));
        btnAdd.addActionListener(e -> addItem());
        btnDelete.addActionListener(e -> deleteItem(tableModel));
    }

    private void loadData(DefaultTableModel tableModel) {
        tableModel.setRowCount(0); // Bersihkan tabel
        try {
            List<InventoryItem> items = inventoryDAO.getAllInventoryItems();
            for (InventoryItem item : items) {
                tableModel.addRow(new Object[]{
                        item.getCode(),
                        item.getName(),
                        item.getDescription(),
                        item.getCategory(),
                        item.getSupplier(),
                        item.getQuantity()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addItem() {
        String code = JOptionPane.showInputDialog(this, "Kode Item:");
        String name = JOptionPane.showInputDialog(this, "Nama Item:");
        String description = JOptionPane.showInputDialog(this, "Deskripsi:");
        String category = JOptionPane.showInputDialog(this, "Kategori:");
        String supplier = JOptionPane.showInputDialog(this, "Supplier:");
        int quantity = Integer.parseInt(JOptionPane.showInputDialog(this, "Jumlah:"));

        InventoryItem item = new InventoryItem(code, name, description, category, supplier, quantity);
        try {
            inventoryDAO.addInventoryItem(item);
            JOptionPane.showMessageDialog(this, "Item berhasil ditambahkan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding item: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteItem(DefaultTableModel tableModel) {
        int selectedRow = tableInventory.getSelectedRow();
        if (selectedRow != -1) {
            String code = (String) tableModel.getValueAt(selectedRow, 0);
            try {
                inventoryDAO.deleteInventoryItem(code);
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Item berhasil dihapus!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error deleting item: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih item untuk dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
}
