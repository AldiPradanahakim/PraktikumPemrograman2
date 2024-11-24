/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan7.InvetoryManagement.src.model;

import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

public class InventoryItem {
    private String code;
    private String name;
    private String description;
    private String category;
    private String supplier;
    private int quantity;

    public InventoryItem(String code, String name, String description, String category, String supplier, int quantity) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.supplier = supplier;
        this.quantity = quantity;
    }

    // Getter and Setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
