/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManageAirliner;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.Airplane;
import Business.Fleet;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aditi
 */
public class ManageAirplaneJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageAirplaneJPanel
     */
        AirlinerDirectory airlinerdirectory;
    javax.swing.JPanel userProcessContainer;
   Airliner airliner;
   Fleet airplaneDir;
    
public ManageAirplaneJPanel(javax.swing.JPanel spane, Airliner airliner, AirlinerDirectory sd, Fleet airplaneDir) {
    initComponents();
    userProcessContainer = spane;
    airlinerdirectory = sd;
    this.airliner= airliner;
    this.airplaneDir=airplaneDir;
    
    if(!airplaneDir.getAirplaneList().isEmpty()){
    populateAirplaneList();
    }
    
    
    lblAirlinerName.setText(airliner.getAirLinerName());
}


public void populateAirplaneList()
    {
        //using airlinerDirectory populate table
        DefaultTableModel model = (DefaultTableModel) tblAirplane.getModel();
        model.setRowCount(0);
        List<Airplane> airplaneList = airplaneDir.getAirplaneList();
        for (Airplane s : airplaneList) {
            //check airline name in airplane
            if(s.getAirlinerName().equals(airliner.getAirLinerName()))
            {
            Object row[] = new Object[5];
            row[0] = s;
            row[1] = s.getWindowSeatCount();
            row[2] = s.getMiddleSeatCount();
            row[3] = s.getAisleSeatCount();
            row[4] = s.getModelNum();
            model.addRow(row); 
            }
            
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewAirplane = new javax.swing.JButton();
        btnViewAirplane = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAirplane = new javax.swing.JTable();
        lblAirlinerName = new javax.swing.JLabel();

        btnNewAirplane.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNewAirplane.setText("New Airplane");
        btnNewAirplane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAirplaneActionPerformed(evt);
            }
        });

        btnViewAirplane.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewAirplane.setText("View Airplane");
        btnViewAirplane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAirplaneActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Airplanes for");

        tblAirplane.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airplane", "Window Seat", "Middle Seat", "Aisle Seat", "Model Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAirplane);

        lblAirlinerName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAirlinerName.setText("Airliner");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnBack)
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAirlinerName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewAirplane)
                        .addGap(123, 123, 123)
                        .addComponent(btnViewAirplane))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblAirlinerName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewAirplane)
                            .addComponent(btnViewAirplane)))
                    .addComponent(btnBack))
                .addContainerGap(222, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewAirplaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAirplaneActionPerformed
        // TODO add your handling code here:
        int row = tblAirplane.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Airplane airplane = (Airplane)tblAirplane.getValueAt(row,0);
        AirlinerDirectory ad = airlinerdirectory;
        //UserProcessContainer.removeAll();
        ViewAirplane msjp = new ViewAirplane (userProcessContainer,airplane, airliner);
        userProcessContainer.add("ViewAirplane",msjp); //any name will do
        ((java.awt.CardLayout)userProcessContainer.getLayout()).next(userProcessContainer);
        
        
        
    }//GEN-LAST:event_btnViewAirplaneActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        backAction();
    }//GEN-LAST:event_btnBackActionPerformed

    private void backAction(){
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        ManageAirlinersJPanel ms = (ManageAirlinersJPanel) c;
        ms.populateAirlinerList();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    
    } 
    private void btnNewAirplaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAirplaneActionPerformed
        // TODO add your handling code here:
        Airliner ad = airliner;
        //UserProcessContainer.removeAll();
        CreateNewAirplaneJPanel msjp = new CreateNewAirplaneJPanel (userProcessContainer, ad, airplaneDir);
        userProcessContainer.add("CreateNewAirplaneJPanel",msjp); //any name will do
        ((java.awt.CardLayout)userProcessContainer.getLayout()).next(userProcessContainer);
        
        
        
    }//GEN-LAST:event_btnNewAirplaneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNewAirplane;
    private javax.swing.JButton btnViewAirplane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAirlinerName;
    private javax.swing.JTable tblAirplane;
    // End of variables declaration//GEN-END:variables
}
