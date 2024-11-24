/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan7.InvetoryManagement.src.view.main;



import Pertemuan7.InvetoryManagement.src.view.Inventory.InventoryManagementForm;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventoryManagementForm form = new InventoryManagementForm();
            form.setVisible(true);
        });
    }
}
