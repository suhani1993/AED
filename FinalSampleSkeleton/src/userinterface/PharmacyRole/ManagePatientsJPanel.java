/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyRole;

import Business.Appointment.Appointment;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PharmacyEnterprise.Pharmacy;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preranaurs
 */
public class ManagePatientsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePatientsJPanel
     */
    private JPanel userProcessContainer;
    private Patient patient;
    private Appointment appointment;
    private Pharmacy pharmacy;
    private Employee doctor;
    private UserAccount userAccount;
    private Enterprise enterprise;
   

    ManagePatientsJPanel(JPanel userProcessContainer, Patient patient, Appointment appointment, Employee doctor, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.patient = patient;
        this.appointment = appointment;
        this.pharmacy = pharmacy;
        this.doctor = doctor;
        this.userAccount = userAccount;
        this.enterprise =  enterprise;
        populatePatientsTbl();
    }
    
    public void populatePatientsTbl(){
        DefaultTableModel model = (DefaultTableModel) PatientsDetailsTbl.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            //if(!((PharmacyWorkRequest)request).getAppointment().getStatus().equals("Cancel")){
            Object[] row = new Object[3];
            row[0] = ((PharmacyWorkRequest)request).getPatient();//request.getMessage();
            row[1] = ((PharmacyWorkRequest)request).getAppointment();
            row[2] = ((PharmacyWorkRequest)request).getDoctor();
            //row[3] = ((DoctorWorkRequest)request).getAppointment().getStatus();//getReceiver();
            //row[4] = ((DoctorWorkRequest)request);//getReceiver();
            //row[5] = ((DoctorWorkRequest)request).getStatus();//getReceiver();
            //row[2] = request.getStatus();
//            String result = ((LabTestWorkRequest) request).getTestResult();
            //row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        PatientsDetailsTbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        viewPatientBtn = new javax.swing.JButton();

        PatientsDetailsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient Name", "Appointment ID", "Doctor Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(PatientsDetailsTbl);
        if (PatientsDetailsTbl.getColumnModel().getColumnCount() > 0) {
            PatientsDetailsTbl.getColumnModel().getColumn(0).setResizable(false);
            PatientsDetailsTbl.getColumnModel().getColumn(1).setResizable(false);
            PatientsDetailsTbl.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        viewPatientBtn.setText("View Patient");
        viewPatientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 111, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewPatientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewPatientBtn)
                .addContainerGap(189, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewPatientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientBtnActionPerformed
        int selectedRow = PatientsDetailsTbl.getSelectedRow();
        if(selectedRow < 0){
            
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        
        }
        Appointment appointment= (Appointment) PatientsDetailsTbl.getValueAt(selectedRow, 1);
        ViewPatientJPanel viewPatientJPanel = new ViewPatientJPanel(userProcessContainer, userAccount, patient, pharmacy, appointment,enterprise);
        userProcessContainer.add("ViewPatientJPanel",viewPatientJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewPatientBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PatientsDetailsTbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewPatientBtn;
    // End of variables declaration//GEN-END:variables
}