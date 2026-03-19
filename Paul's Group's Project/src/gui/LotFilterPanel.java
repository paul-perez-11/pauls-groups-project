/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Paul Joel D. Perez <pjdperez@mymail.mapua.edu.ph>
 */

package gui;

import models.Lot;

public class LotFilterPanel extends javax.swing.JPanel {

    private java.lang.Runnable onChange;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JTextField txtMaxPrice;
    private javax.swing.JTextField txtLotArea;
    private javax.swing.JTextField txtFloorArea;

    public LotFilterPanel(java.lang.Runnable onChange) {
        this.onChange = onChange;
        initComponentsCustom();
    }

    private void initComponentsCustom() {
        // Programmatic GUI construction bypassing NetBeans .form constraints
        setBackground(new java.awt.Color(45, 45, 45));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createEmptyBorder(15, 10, 0, 10), // Adds Top, Left, Bottom, Right padding
            javax.swing.BorderFactory.createTitledBorder(null, "Search Filters", 
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, 
                new java.awt.Font("Arial", 1, 14), java.awt.Color.WHITE)
        ));
        
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        java.awt.Font font = new java.awt.Font("Arial", 0, 14);
        java.awt.Color fg = java.awt.Color.WHITE;

        // 1. Status Filter
        javax.swing.JLabel lblStatus = new javax.swing.JLabel("Status:");
        lblStatus.setForeground(fg); lblStatus.setFont(font);
        statusCombo = new javax.swing.JComboBox<>(new String[]{"All", "Available", "Reserved", "Sold", "Pending Purchase", "Pending Reservation"});
        statusCombo.setFont(font);

        // 2. Type Filter
        javax.swing.JLabel lblType = new javax.swing.JLabel("Type:");
        lblType.setForeground(fg); lblType.setFont(font);
        typeCombo = new javax.swing.JComboBox<>(new String[]{"All", "Callista", "AlliyahInner", "AlliyahOuter"});
        typeCombo.setFont(font);

        // 3. Max Price Filter
        javax.swing.JLabel lblPrice = new javax.swing.JLabel("Max Price (PHP):");
        lblPrice.setForeground(fg); lblPrice.setFont(font);
        txtMaxPrice = new javax.swing.JTextField(8);
        txtMaxPrice.setFont(font);

        // 4. Lot Area Filter
        javax.swing.JLabel lblLotArea = new javax.swing.JLabel("Min Lot Area (sqm):");
        lblLotArea.setForeground(fg); lblLotArea.setFont(font);
        txtLotArea = new javax.swing.JTextField(4);
        txtLotArea.setFont(font);

        // 5. Floor Area Filter
        javax.swing.JLabel lblFloorArea = new javax.swing.JLabel("Min Floor Area (sqm):");
        lblFloorArea.setForeground(fg); lblFloorArea.setFont(font);
        txtFloorArea = new javax.swing.JTextField(4);
        txtFloorArea.setFont(font);

        // 6. Action Buttons
        javax.swing.JButton btnApply = new javax.swing.JButton("Apply");
        btnApply.setFont(new java.awt.Font("Arial", 1, 14));
        btnApply.setBackground(new java.awt.Color(0, 153, 255));
        btnApply.setForeground(java.awt.Color.WHITE);
        
        javax.swing.JButton btnClear = new javax.swing.JButton("Clear");
        btnClear.setFont(font);
        
        // --- Listeners ---
        btnApply.addActionListener(e -> onChange.run());
        btnClear.addActionListener(e -> {
            statusCombo.setSelectedIndex(0);
            typeCombo.setSelectedIndex(0);
            txtMaxPrice.setText("");
            txtLotArea.setText("");
            txtFloorArea.setText("");
            onChange.run();
        });

        // Add components to layout
        add(lblStatus); add(statusCombo);
        add(lblType); add(typeCombo);
        add(lblPrice); add(txtMaxPrice);
        add(lblLotArea); add(txtLotArea);
        add(lblFloorArea); add(txtFloorArea);
        add(btnApply); add(btnClear);
    }

    public boolean evaluateLot(Lot lot) {
        String selectedStatus = statusCombo.getSelectedItem().toString();
        String selectedType = typeCombo.getSelectedItem().toString();

        if (!selectedStatus.equals("All") && !lot.getStatus().equalsIgnoreCase(selectedStatus)) return false;
        if (!selectedType.equals("All") && !lot.getLotType().equalsIgnoreCase(selectedType)) return false;

        try {
            if (!txtMaxPrice.getText().trim().isEmpty()) {
                double max = Double.parseDouble(txtMaxPrice.getText().trim().replace(",", ""));
                if (lot.getTcp() > max) return false;
            }
            if (!txtLotArea.getText().trim().isEmpty()) {
                double minLotArea = Double.parseDouble(txtLotArea.getText().trim().replace(",", ""));
                if (lot.getLotArea() < minLotArea) return false;
            }
            if (!txtFloorArea.getText().trim().isEmpty()) {
                double minFloorArea = Double.parseDouble(txtFloorArea.getText().trim().replace(",", ""));
                if (lot.getFloorArea() < minFloorArea) return false;
            }
        } catch (NumberFormatException e) {
            // Ignore malformed text input silently and allow the lot to pass
        }
        
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
