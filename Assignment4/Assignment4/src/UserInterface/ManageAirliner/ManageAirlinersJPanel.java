/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManageAirliner;

import Business.AirlinerDirectory;

/**
 *
 * @author aditi
 */
public class ManageAirlinersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageAirlinersJPanel
     */
    AirlinerDirectory airlinerdirectory;
    javax.swing.JPanel cardSequenceJPanel;
   

    
public ManageAirlinersJPanel(javax.swing.JPanel spane, AirlinerDirectory sd) {
    
    cardSequenceJPanel = spane;
    airlinerdirectory = sd;
    
    populateAirlinerList();
    
    initComponents();
}

    public void populateAirlinerList()
    {
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAirliner = new javax.swing.JTable();
        btnNewAirliner = new javax.swing.JButton();
        btnViewAirliner = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnmngAirplane = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Airliners");

        tblAirliner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airliner"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAirliner);

        btnNewAirliner.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNewAirliner.setText("New Airliner");

        btnViewAirliner.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewAirliner.setText("View Airliner");
        btnViewAirliner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAirlinerActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("<Back");
        btnBack.setToolTipText("");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnmngAirplane.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnmngAirplane.setText("Manage Airplane");
        btnmngAirplane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmngAirplaneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnBack)
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewAirliner)
                        .addGap(123, 123, 123)
                        .addComponent(btnViewAirliner))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnmngAirplane)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewAirliner)
                            .addComponent(btnViewAirliner)))
                    .addComponent(btnBack))
                .addGap(90, 90, 90)
                .addComponent(btnmngAirplane)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewAirlinerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAirlinerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewAirlinerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnmngAirplaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmngAirplaneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmngAirplaneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNewAirliner;
    private javax.swing.JButton btnViewAirliner;
    private javax.swing.JButton btnmngAirplane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAirliner;
    // End of variables declaration//GEN-END:variables
}
