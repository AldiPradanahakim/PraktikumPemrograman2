package Pertemuan8.MembershipORM.src.view.member;

import Pertemuan8.MembershipORM.src.dao.JenisMemberDao;
import Pertemuan8.MembershipORM.src.dao.MemberDao;
import Pertemuan8.MembershipORM.src.Model.Member;
import Pertemuan8.MembershipORM.src.Model.JenisMember;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MemberFrame extends JFrame {
    private final MemberDao memberDao;
    private final JenisMemberDao jenisMemberDao;

    private JTextField idField, nameField;
    private JComboBox<String> jenisMemberCombo;
    private JButton addButton, updateButton, deleteButton;
    private JTable memberTable;

    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;

        setTitle("Member Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idField = new JTextField(10);
        nameField = new JTextField(10);
        jenisMemberCombo = new JComboBox<>();
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        memberTable = new JTable();

        populateComboJenis();

        addButton.addActionListener(this::addMember);
        updateButton.addActionListener(this::updateMember);
        deleteButton.addActionListener(this::deleteMember);

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Jenis Member:"));
        add(jenisMemberCombo);
        add(addButton);
        add(updateButton);
        add(deleteButton);

        add(new JScrollPane(memberTable));
    }

    public void populateComboJenis() {
        List<JenisMember> jenisMembers = jenisMemberDao.findAll();
        jenisMemberCombo.removeAllItems();
        for (JenisMember jenisMember : jenisMembers) {
            jenisMemberCombo.addItem(jenisMember.getNama());
        }
    }

    private void addMember(ActionEvent e) {
        String name = nameField.getText();
        String jenis = (String) jenisMemberCombo.getSelectedItem();

        JenisMember jenisMember = jenisMemberDao.findAll().stream()
                .filter(jm -> jm.getNama().equals(jenis))
                .findFirst().orElse(null);

        if (jenisMember != null) {
            Member member = new Member(name, jenisMember.getId());
            int result = memberDao.insert(member);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Member added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add member.");
            }
        }
    }

    private void updateMember(ActionEvent e) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String jenis = (String) jenisMemberCombo.getSelectedItem();

        JenisMember jenisMember = jenisMemberDao.findAll().stream()
                .filter(jm -> jm.getNama().equals(jenis))
                .findFirst().orElse(null);

        if (jenisMember != null) {
            Member member = new Member(id, name, jenisMember.getId());
            int result = memberDao.update(member);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Member updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update member.");
            }
        }
    }

    private void deleteMember(ActionEvent e) {
        int id = Integer.parseInt(idField.getText());

        int result = memberDao.delete(id);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Member deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete member.");
        }
    }
}