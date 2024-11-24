/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan7.InvetoryManagement.src.dao;

import Pertemuan7.InvetoryManagement.src.db.DatabaseConnection;
import Pertemuan7.InvetoryManagement.src.model.InventoryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {
    public void addInventoryItem(InventoryItem item) throws SQLException {
        String query = "INSERT INTO inventory (code, name, description, category, supplier, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, item.getCode());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getDescription());
            stmt.setString(4, item.getCategory());
            stmt.setString(5, item.getSupplier());
            stmt.setInt(6, item.getQuantity());
            stmt.executeUpdate();
        }
    }

    public List<InventoryItem> getAllInventoryItems() throws SQLException {
        List<InventoryItem> items = new ArrayList<>();
        String query = "SELECT * FROM inventory";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                InventoryItem item = new InventoryItem(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getString("supplier"),
                        rs.getInt("quantity")
                );
                items.add(item);
            }
        }
        return items;
    }

    public void deleteInventoryItem(String code) throws SQLException {
        String query = "DELETE FROM inventory WHERE code = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, code);
            stmt.executeUpdate();
        }
    }
}
