package Pertemuan6;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryManagementApp extends JFrame {
    private JTextField tfCode, tfName, tfOtherCategory;
    private JTextArea taDescription;
    private JRadioButton rbElectronics, rbClothing, rbOther;
    private JCheckBox cbNeedsInspection;
    private JComboBox<String> cbSupplier;
    private JList<String> listItems;
    private JSlider sliderMinStock;
    private JSpinner spinnerQuantity;
    private JTable tableInventory;
    private DefaultTableModel inventoryModel;
    private DefaultListModel<String> itemListModel;

    public InventoryManagementApp() {
        setTitle("Aplikasi Manajemen Inventori");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Kode Item
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Kode Item:"), gbc);

        gbc.gridx = 1;
        tfCode = new JTextField();
        formPanel.add(tfCode, gbc);

        // Nama Item
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Nama Item:"), gbc);

        gbc.gridx = 1;
        tfName = new JTextField();
        formPanel.add(tfName, gbc);

        // Deskripsi Item
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Deskripsi:"), gbc);

        gbc.gridx = 1;
        taDescription = new JTextArea(3, 20);
        taDescription.setLineWrap(true);
        taDescription.setWrapStyleWord(true);
        JScrollPane scrollDescription = new JScrollPane(taDescription);
        formPanel.add(scrollDescription, gbc);

        // Kategori Item
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Kategori:"), gbc);

        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbElectronics = new JRadioButton("Elektronik");
        rbClothing = new JRadioButton("Pakaian");
        rbOther = new JRadioButton("Lainnya");
        ButtonGroup categoryGroup = new ButtonGroup();
        categoryGroup.add(rbElectronics);
        categoryGroup.add(rbClothing);
        categoryGroup.add(rbOther);
        categoryPanel.add(rbElectronics);
        categoryPanel.add(rbClothing);
        categoryPanel.add(rbOther);

        // Text field untuk kategori lainnya
        tfOtherCategory = new JTextField(15);
        tfOtherCategory.setVisible(false); // Tersembunyi sampai "Lainnya" dipilih
        categoryPanel.add(tfOtherCategory);

        gbc.gridx = 1;
        formPanel.add(categoryPanel, gbc);

        // Memerlukan Pemeriksaan
        gbc.gridx = 0;
        gbc.gridy = 4;
        cbNeedsInspection = new JCheckBox("Perlu Diperiksa");
        formPanel.add(cbNeedsInspection, gbc);

        // Supplier
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(new JLabel("Supplier:"), gbc);

        gbc.gridx = 1;
        cbSupplier = new JComboBox<>(new String[]{"Supplier A", "Supplier B", "Supplier C"});
        formPanel.add(cbSupplier, gbc);

        // Jumlah (Spinner dan Slider)
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(new JLabel("Jumlah:"), gbc);

        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        spinnerQuantity = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1)); // JSpinner untuk jumlah
        sliderMinStock = new JSlider(0, 100, 0); // JSlider untuk jumlah minimum
        sliderMinStock.setMajorTickSpacing(10);
        sliderMinStock.setMinorTickSpacing(10);
        sliderMinStock.setPaintTicks(true);
        sliderMinStock.setPaintLabels(true);

        // Sinkronisasi slider dan spinner
        sliderMinStock.addChangeListener(e -> spinnerQuantity.setValue(sliderMinStock.getValue()));
        spinnerQuantity.addChangeListener(e -> sliderMinStock.setValue((Integer) spinnerQuantity.getValue()));

        quantityPanel.add(spinnerQuantity);
        quantityPanel.add(sliderMinStock);
        gbc.gridx = 1;
        formPanel.add(quantityPanel, gbc);

        // Tombol Tambah, Edit, dan Hapus
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton btnAdd = new JButton("Tambah Item");
        JButton btnEdit = new JButton("Edit Item");
        JButton btnDelete = new JButton("Hapus Item");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.NORTH);

        // Daftar Barang
        itemListModel = new DefaultListModel<>();
        listItems = new JList<>(itemListModel);
        JScrollPane scrollItems = new JScrollPane(listItems);
        scrollItems.setPreferredSize(new Dimension(150, 100));

        // Tabel Inventori
        String[] columnNames = {"Kode Item", "Nama Item", "Deskripsi", "Kategori", "Supplier", "Jumlah"};
        inventoryModel = new DefaultTableModel(columnNames, 0);
        tableInventory = new JTable(inventoryModel);
        JScrollPane scrollPane = new JScrollPane(tableInventory);

        // Menambahkan panel untuk daftar barang dan tabel
        JPanel inventoryPanel = new JPanel(new BorderLayout());
        inventoryPanel.add(scrollItems, BorderLayout.WEST);
        inventoryPanel.add(scrollPane, BorderLayout.CENTER);
        add(inventoryPanel, BorderLayout.CENTER);

        // Aksi Tombol Tambah Item
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        // Aksi Tombol Edit Item
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editItem();
            }
        });

        // Aksi Tombol Hapus Item
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem();
            }
        });

        // Listener untuk menampilkan item yang dipilih
        listItems.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedItem = listItems.getSelectedValue();
                    if (selectedItem != null) {
                        loadItemDetails(selectedItem);
                    }
                }
            }
        });

        // Listener untuk kategori lainnya
        rbOther.addActionListener(e -> {
            tfOtherCategory.setVisible(rbOther.isSelected());
            if (rbOther.isSelected()) {
                tfOtherCategory.requestFocus();
                tfOtherCategory.setText(""); // Kosongkan text field ketika dipilih
            } else {
                tfOtherCategory.setText(""); // Kosongkan jika tidak dipilih
            }
        });
    }

    private void addItem() {
        String code = tfCode.getText().trim();
        String name = tfName.getText().trim();
        String description = taDescription.getText().trim();
        String category = rbElectronics.isSelected() ? "Elektronik" :
                rbClothing.isSelected() ? "Pakaian" :
                        tfOtherCategory.getText().trim(); // Ambil nilai dari text field
        String supplier = (String) cbSupplier.getSelectedItem();
        int quantity = (Integer) spinnerQuantity.getValue(); // Mengambil nilai dari JSpinner

        if (!code.isEmpty() && !name.isEmpty()) {
            inventoryModel.addRow(new Object[]{code, name, description, category, supplier, quantity});
            itemListModel.addElement(name); // Menambahkan item ke JList
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void editItem() {
        int selectedRow = tableInventory.getSelectedRow();
        if (selectedRow != -1) {
            String code = tfCode.getText().trim();
            String name = tfName.getText().trim();
            String description = taDescription.getText().trim();
            String category = rbElectronics.isSelected() ? "Elektronik" :
                    rbClothing.isSelected() ? "Pakaian" :
                            tfOtherCategory.getText().trim(); // Ambil nilai dari text field
            String supplier = (String) cbSupplier.getSelectedItem();
            int quantity = (Integer) spinnerQuantity.getValue(); // Mengambil nilai dari JSpinner

            if (!code.isEmpty() && !name.isEmpty()) {
                inventoryModel.setValueAt(code, selectedRow, 0);
                inventoryModel.setValueAt(name, selectedRow, 1);
                inventoryModel.setValueAt(description, selectedRow, 2);
                inventoryModel.setValueAt(category, selectedRow, 3);
                inventoryModel.setValueAt(supplier, selectedRow, 4);
                inventoryModel.setValueAt(quantity, selectedRow, 5);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih item untuk diedit.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteItem() {
        int selectedRow = tableInventory.getSelectedRow();
        if (selectedRow != -1) {
            inventoryModel.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih item untuk dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadItemDetails(String itemName) {
        for (int i = 0; i < inventoryModel.getRowCount(); i++) {
            if (inventoryModel.getValueAt(i, 1).equals(itemName)) {
                tfCode.setText((String) inventoryModel.getValueAt(i, 0));
                tfName.setText(itemName);
                taDescription.setText((String) inventoryModel.getValueAt(i, 2));
                String category = (String) inventoryModel.getValueAt(i, 3);
                if (category.equals("Elektronik")) {
                    rbElectronics.setSelected(true);
                } else if (category.equals("Pakaian")) {
                    rbClothing.setSelected(true);
                } else {
                    rbOther.setSelected(true);
                    tfOtherCategory.setText(category);
                    tfOtherCategory.setVisible(true);
                }
                cbSupplier.setSelectedItem(inventoryModel.getValueAt(i, 4));
                spinnerQuantity.setValue(inventoryModel.getValueAt(i, 5));
                break;
            }
        }
    }

    private void clearFields() {
        tfCode.setText("");
        tfName.setText("");
        taDescription.setText("");
        rbElectronics.setSelected(false);
        rbClothing.setSelected(false);
        rbOther.setSelected(false);
        tfOtherCategory.setText("");
        tfOtherCategory.setVisible(false); // Sembunyikan text field
        cbSupplier.setSelectedIndex(0);
        spinnerQuantity.setValue(1); // Reset spinner
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventoryManagementApp app = new InventoryManagementApp();
            app.setVisible(true);
        });
    }
}
