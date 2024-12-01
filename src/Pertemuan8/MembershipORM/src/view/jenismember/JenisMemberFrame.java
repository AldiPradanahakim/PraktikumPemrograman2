package Pertemuan8.MembershipORM.src.view.jenismember;

import Pertemuan8.MembershipORM.src.dao.JenisMemberDao;
import Pertemuan8.MembershipORM.src.model.JenisMember;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class JenisMemberFrame extends JFrame {
    private final JenisMemberDao jenisMemberDao;

    private JTextField idField, nameField;
    private JButton addButton, updateButton, deleteButton;

    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;

        setTitle("Jenis Member Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idField = new JTextField(10);
        nameField = new JTextField(10);
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        addButton.addActionListener(this::addJenisMember);
        updateButton.addActionListener(this::updateJenisMember);
        deleteButton.addActionListener(this::deleteJenisMember);

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Name:"));
        add(nameField);
        add(addButton);
        add(updateButton);
        add(deleteButton);
    }

    private void addJenisMember(ActionEvent e) {
        String name = nameField.getText();
        JenisMember jenisMember = new JenisMember(name);

        int result = jenisMemberDao.insert(jenisMember);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Jenis Member added successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add Jenis Member.");
        }
    }

    private void updateJenisMember(ActionEvent e) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();

        JenisMember jenisMember = new JenisMember(id, name);

        int result = jenisMemberDao.update(jenisMember);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Jenis Member updated successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update Jenis Member.");
        }
    }

    private void deleteJenisMember(ActionEvent e) {
        int id = Integer.parseInt(idField.getText());

        int result = jenisMemberDao.delete(id);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Jenis Member deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete Jenis Member.");
        }
    }
}