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
import Business.Medicine.Medicine;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReceptionistWorkRequest;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preranaurs
 */
public class ViewPatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewPatientJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Patient patient;
    private Employee doctor;
    private Pharmacy pharmacy;
    private Appointment appointment;
    private Enterprise enterprise;
    private UserAccount receptionist;
    
    
    

    ViewPatientJPanel(JPanel userProcessContainer, UserAccount userAccount, Patient patient, Pharmacy pharmacy, Appointment appointment,Enterprise enterprise ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.patient = patient;
        this.pharmacy = pharmacy;
        this.appointment = appointment;
        this.enterprise =  enterprise;
        patientNameTxt.setText(patient.getName());
        //doctorNameTxt.setText(doctor.getName());
        //appointmentIdTxt.setText(Integer.parseInt((appointment.getAppointmentId())));
        appointment.setAppointmentId(Integer.parseInt(appointmentIdTxt.getText()));
        populateMedicine();
        
    }
    
    public void populateMedicine(){
         DefaultTableModel model = (DefaultTableModel) medicineQuantityTbl.getModel();
        model.setRowCount(0);
        Double totalPrice = 0.0;
        for (Map.Entry<Medicine, Integer> entry : appointment.getPrescription().getMedicineListquanity().entrySet()){
         Object[] row = new Object[5];
            row[0] = entry.getKey();
            row[1] = entry.getValue();
            Medicine medicine = null;
            for(Medicine med : ((Pharmacy) enterprise).getMedicineList().getMedicineList()){
                if(med.equals(entry.getKey())){
            row[2] = med.getPrice();       
               medicine = med;
                    break;
                }
            }
            if(medicine == null){   
            }
            else{
            row[3] = entry.getValue() * medicine.getPrice();
            totalPrice += entry.getValue() * medicine.getPrice();
            }
            row[4] = pharmacy.getName();
            model.addRow(row);
            
    }
        totalPriceTxt.setText(String.valueOf(totalPrice));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        patientNameTxt = new javax.swing.JTextField();
        appointmentIdTxt = new javax.swing.JTextField();
        totalPriceTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineQuantityTbl = new javax.swing.JTable();

        jLabel1.setText("Patient Medicine Details");

        jLabel2.setText("Patient Name :");

        jLabel3.setText("Appointment ID :");

        jLabel5.setText("Total Price :");

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        patientNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameTxtActionPerformed(evt);
            }
        });

        appointmentIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentIdTxtActionPerformed(evt);
            }
        });

        totalPriceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPriceTxtActionPerformed(evt);
            }
        });

        medicineQuantityTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Medicine Name", "Quantity", "Unit Price", "Total Price", "Pharmacy Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(medicineQuantityTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appointmentIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitBtn)
                            .addComponent(totalPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(patientNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(appointmentIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalPriceTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitBtn)
                .addGap(0, 249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
         ReceptionistWorkRequest workreq = new ReceptionistWorkRequest();
                workreq.setStatus("New");
                appointment.setStatus(Appointment.AppointmentStatus.Markforbilling.getValue());
                workreq.setMessage("Prepare Bill for this Patient");
                workreq.setSender(userAccount);
                workreq.setPatient(patient);
                workreq.setDoctor(doctor);
                workreq.setReceiver(receptionist);
                //Appointment appointment = (Appointment) 
                receptionist.getWorkQueue().getWorkRequestList().add(workreq);
                //UserAccount recepUseracc = null;
                //List<UserAccount> userAccDir=  organization.getUserAccountDirectory().getUserAccountList();
                //List<UserAccount> nurseList = enterprise.getUserAccountDirectory().getUserAccountList();
                //workreq.setReceiver(receptionist.getUserAccountDirectory().getUserAccountList().get(0));
                JOptionPane.showMessageDialog(null, "Appointment status changed to Mark for Billing & Pharmacist Request completed");
                //JOptionPane.showMessageDialog(null, "Doctor Work status changed to Mark for Billing");
        
    }//GEN-LAST:event_submitBtnActionPerformed

    private void patientNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNameTxtActionPerformed

    private void appointmentIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentIdTxtActionPerformed

    private void totalPriceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPriceTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPriceTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appointmentIdTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicineQuantityTbl;
    private javax.swing.JTextField patientNameTxt;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField totalPriceTxt;
    // End of variables declaration//GEN-END:variables
}