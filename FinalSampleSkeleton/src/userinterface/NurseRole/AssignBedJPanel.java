/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NurseRole;

import Business.Appointment.Appointment;
import Business.Bed.Bed;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Operation.Operation;
import Business.Organization.BedManagementDepartment;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Utility.Validation;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aditi
 */
public class AssignBedJPanel extends javax.swing.JPanel {

    
    JPanel userProcessContainer;
    Enterprise enterprise;
    Appointment appointment;
    Patient patient;
    UserAccount doctor;
    UserAccount nurseUserAccount;
    WorkRequest workrequest;
    BedManagementDepartment bedorg;
    /**
     * Creates new form AssignBed
     */
    public AssignBedJPanel(JPanel userProcessContainer, Enterprise enterprise, Appointment appointment, Patient patient, UserAccount doctor, UserAccount nurseUserAccount, WorkRequest workrequest) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.enterprise= enterprise;
        this.doctor= doctor;
        this.patient= patient;
        this.appointment= appointment;
        this.nurseUserAccount= nurseUserAccount;
        this.workrequest= workrequest;
        this.bedorg= getBedDepartment();
        populateStatusCMB();
        populateDetails();
    }

    
    BedManagementDepartment getBedDepartment(){
        //enterprise.getOrganizationDirectory().getOrganizationList();
        
        boolean flag=false;
        BedManagementDepartment bedOrg=null;
        OrganizationDirectory orgDir = enterprise.getOrganizationDirectory();
        for(Organization org : orgDir.getOrganizationList() ){
            if(org.getName().equals(Organization.Type.BedManagement.getValue()))
            {
                //if bed management departemtn is present then navigate to bed management screen
                flag = true;
                bedOrg = (BedManagementDepartment)org;
            }
        }
        
        if(flag == true)
        {
            return bedOrg;
        }
        return null;
    }
    
    
    void populateStatusCMB(){
          viewStatusCmb.removeAllItems();
        
        for (Appointment.AppointmentStatus status : Appointment.AppointmentStatus.values()){
            viewStatusCmb.addItem(status.getValue());
        }

    }
    
void populateDetails(){
    viewPatientNametxt.setText(patient.getName());
    viewAppnmtID.setText(String.valueOf(appointment.getAppointmentId()));
    viewDrTxt.setText(doctor.getEmployee().getName());
    viewpatientIdTxt.setText(String.valueOf(patient.getId()));
    emailIDTxt.setText(patient.getEmailID());
    phoneNumberTxt.setText(patient.getPhoneNum());
    viewStatusCmb.setSelectedItem(appointment.getStatus());
    viewRequestDateTxt.setText(workrequest.getRequestDate().toString());
    txtAreaMessage.setText(workrequest.getMessage());
    Operation oprtn = appointment.getOperation();
    if(oprtn != null && oprtn.getBedAssigned() !=null)
    {
        Bed bed = oprtn.getBedAssigned();
        txtBedId.setText(String.valueOf(bed.getBedID()));
        txtBedIPrice.setText(String.valueOf(bed.getPrice()));
        txtBedType.setText(bed.getBedType().toString());
        txtBedAssignDate.setText(oprtn.getOperationDate());
        
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

        viewDetailsJPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emailIDTxt = new javax.swing.JTextField();
        viewPatientNametxt = new javax.swing.JTextField();
        viewpatientIdTxt = new javax.swing.JTextField();
        phoneNumberTxt = new javax.swing.JTextField();
        txtBedId = new javax.swing.JTextField();
        viewAppnmtID = new javax.swing.JTextField();
        viewStatusCmb = new javax.swing.JComboBox();
        viewRequestDateTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        viewDrTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMessage = new javax.swing.JTextArea();
        txtBedType = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBedIPrice = new javax.swing.JTextField();
        btnviewBed = new javax.swing.JButton();
        txtBedAssignDate = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        assignJPanel = new javax.swing.JPanel();
        lblBedStatus = new javax.swing.JLabel();
        bedStatusCmb = new javax.swing.JComboBox();
        btnView = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bedJTable = new javax.swing.JTable();
        txtBedDate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        closebtn = new javax.swing.JButton();
        btnAssignBed = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        bedTypeCmb = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewDetailsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "View Appointment Details"));
        viewDetailsJPanel.setToolTipText("");
        viewDetailsJPanel.setAutoscrolls(true);

        jLabel2.setText("Status");

        jLabel3.setText("Patient ID");

        jLabel4.setText("Patient Name");

        jLabel5.setText("Appointment ID");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");

        jLabel1.setText("Patient Email ID");

        jLabel6.setText("Contact Number");

        jLabel7.setText("Bed ID");

        jLabel8.setText("Bed Type");

        jLabel9.setText("Request Date");

        emailIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailIDTxtActionPerformed(evt);
            }
        });

        viewPatientNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientNametxtActionPerformed(evt);
            }
        });

        viewpatientIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewpatientIdTxtActionPerformed(evt);
            }
        });

        phoneNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTxtActionPerformed(evt);
            }
        });

        txtBedId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedIdActionPerformed(evt);
            }
        });

        viewAppnmtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAppnmtIDActionPerformed(evt);
            }
        });

        viewStatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        viewRequestDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestDateTxtActionPerformed(evt);
            }
        });

        jLabel10.setText("Doctor");

        viewDrTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDrTxtActionPerformed(evt);
            }
        });

        jLabel11.setText("Message");

        txtAreaMessage.setColumns(20);
        txtAreaMessage.setRows(5);
        jScrollPane1.setViewportView(txtAreaMessage);

        txtBedType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedTypeActionPerformed(evt);
            }
        });

        jLabel13.setText("Price");

        txtBedIPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedIPriceActionPerformed(evt);
            }
        });

        btnviewBed.setText("Assign Bed");
        btnviewBed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewBedActionPerformed(evt);
            }
        });

        txtBedAssignDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedAssignDateActionPerformed(evt);
            }
        });

        jLabel16.setText("Assigned Date");

        javax.swing.GroupLayout viewDetailsJPanelLayout = new javax.swing.GroupLayout(viewDetailsJPanel);
        viewDetailsJPanel.setLayout(viewDetailsJPanelLayout);
        viewDetailsJPanelLayout.setHorizontalGroup(
            viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDetailsJPanelLayout.createSequentialGroup()
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewDetailsJPanelLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(updateBtn)
                        .addGap(37, 37, 37)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDetailsJPanelLayout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewDetailsJPanelLayout.createSequentialGroup()
                                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13))
                                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDetailsJPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDetailsJPanelLayout.createSequentialGroup()
                                                .addComponent(btnviewBed)
                                                .addGap(141, 141, 141))))
                                    .addGroup(viewDetailsJPanelLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtBedAssignDate, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                            .addComponent(txtBedIPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                            .addComponent(txtBedType)
                                            .addComponent(txtBedId))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(viewDetailsJPanelLayout.createSequentialGroup()
                                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailIDTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                        .addComponent(viewPatientNametxt))
                                    .addComponent(viewpatientIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(viewDetailsJPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(viewDrTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDetailsJPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(viewRequestDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDetailsJPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(viewStatusCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDetailsJPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(viewAppnmtID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel16))))
                .addGap(19, 19, 19))
        );
        viewDetailsJPanelLayout.setVerticalGroup(
            viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDetailsJPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(viewpatientIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewAppnmtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(viewPatientNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(viewStatusCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(emailIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewRequestDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(phoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(viewDrTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnviewBed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBedId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBedType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtBedIPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtBedAssignDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(viewDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(updateBtn))
                .addContainerGap())
        );

        add(viewDetailsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        assignJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Assign Bed"));
        assignJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBedStatus.setText("Bed Status");
        assignJPanel.add(lblBedStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        bedStatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Occupied", "Assigned Laundry" }));
        bedStatusCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedStatusCmbActionPerformed(evt);
            }
        });
        assignJPanel.add(bedStatusCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 146, -1));

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        assignJPanel.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        bedJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bed ID", "Status", "Patient", "Date", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bedJTable);

        assignJPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 350, 210));

        txtBedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBedDateActionPerformed(evt);
            }
        });
        assignJPanel.add(txtBedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 141, 145, -1));

        jLabel14.setText("Date");
        assignJPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 144, -1, -1));

        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        assignJPanel.add(closebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 103, -1));

        btnAssignBed.setText("Assign");
        btnAssignBed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignBedActionPerformed(evt);
            }
        });
        assignJPanel.add(btnAssignBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jLabel15.setText("Bed Type");
        assignJPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        bedTypeCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        bedTypeCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedTypeCmbActionPerformed(evt);
            }
        });
        assignJPanel.add(bedTypeCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 146, -1));

        add(assignJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 370, 540));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        assignJPanel.setVisible(false);
    }//GEN-LAST:event_closebtnActionPerformed

    private void emailIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailIDTxtActionPerformed

    private void viewPatientNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPatientNametxtActionPerformed

    private void viewpatientIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewpatientIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewpatientIdTxtActionPerformed

    private void phoneNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtActionPerformed

    private void txtBedIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedIdActionPerformed

    private void viewAppnmtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAppnmtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewAppnmtIDActionPerformed

    private void viewRequestDateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestDateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewRequestDateTxtActionPerformed

    private void viewDrTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDrTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewDrTxtActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        Component[] componentArray =userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        NurseWorkAreaJPanel sysAdminwajp = (NurseWorkAreaJPanel) component;
        sysAdminwajp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void bedStatusCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedStatusCmbActionPerformed
       // Organization organization = (Organization) bedStatusCmb.getSelectedItem();
        //if (organization != null){
            //populateEmployeeComboBox(organization);
            // populateRoleComboBox(organization);
        //}
    }//GEN-LAST:event_bedStatusCmbActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        
        
        
        String dateString = txtBedDate.getText();
        
        if(dateString == null || dateString.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter date!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        boolean validDate = Validation.validateDate(dateString);
        if(validDate == false)
        {
            JOptionPane.showMessageDialog(null, "Date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String type =(String) bedTypeCmb.getSelectedItem();
        
        
        populateBedTable(dateString,type );

    }//GEN-LAST:event_btnViewActionPerformed

    
    void populateBedTable(String dateString, String bedType) {
        
        //convert string to date
        try{
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=formatter1.parse(dateString);
        
        List<Bed> bedList = bedorg.getBedList().getBedList();
        DefaultTableModel model = (DefaultTableModel) bedJTable.getModel();
        
        model.setRowCount(0);
        for(Bed bed: bedList)
        {
            boolean checkBedAvalibility = bedorg.checkIfBedAvailbleOnDate(date1, bed);
        
        
        if(checkBedAvalibility && bed.getBedType().getBedType().equals(bedType)){
        
        //String bedStatus = (String)bedStatusCmb.getSelectedItem();
        
            Object[] row = new Object[5];
            row[0] = bed.getBedID();
            row[1] = bed.getStatus().getStatus();
            Patient p = bed.getPatient();
            row[2] = p == null ? "": p;
            row[3] = "";
            row[4] = bed.getBedType();
            model.addRow(row);
            //row[2] = 
            
        }//if checkBedAvalibility true ends
        }//outer for loop
        
        }//try
        
        catch(Exception e){
            System.out.println("Exception occured in AssignBed :populateBedTableMethod");
        }
    }
    
    
    private void txtBedTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedTypeActionPerformed

    private void txtBedIPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedIPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedIPriceActionPerformed

    private void txtBedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedDateActionPerformed

    private void btnviewBedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewBedActionPerformed
        // TODO add your handling code here:
        assignJPanel.setVisible(true);
        populateBedTypeCmb();
        lblBedStatus.setVisible(false);
        bedStatusCmb.setVisible(false);
    }//GEN-LAST:event_btnviewBedActionPerformed

    private void btnAssignBedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignBedActionPerformed
        // TODO add your handling code here:
        
        
         int row = bedJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String dateString = txtBedDate.getText();
        
        if(dateString == null || dateString.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter date!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        boolean validDate = Validation.validateDate(dateString);
        if(validDate == false)
        {
            JOptionPane.showMessageDialog(null, "Date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        Bed selectedBed= (Bed)  bedJTable.getValueAt(row,0);
        /*if(! selectedBed.getStatus().equals(Bed.BedStatus.Available))
        {
            JOptionPane.showMessageDialog(null, "Cannot assign as bed is not available!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }*/
        //if bed is not availbale cannot assign
        
        
        //String to date convert
        
       
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1;
        try {
            date1 = formatter1.parse(dateString);
            bedorg.assignBedToPatientOnDate(date1, selectedBed);
            selectedBed.setStatus(Bed.BedStatus.Occupied);
            JOptionPane.showMessageDialog(null, "Bed Assigned Successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            Operation opr= appointment.getOperation();
            opr.setBedAssigned(selectedBed);
            opr.setOperationDate(dateString);
            opr.setPerson(nurseUserAccount.getEmployee());
            opr.setStatus(Operation.OperationStatus.BedAssigned.getValue());
            
        } catch (ParseException ex) {
            Logger.getLogger(AssignBedJPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occured in string to date conversion !!!!!! : method-> btnAssignBedActionPerformed");
        }
        
        
        //if all good then assign bed to this patient appointment
        //change appoitnment status
        
        
        
    }//GEN-LAST:event_btnAssignBedActionPerformed

    void populateBedStatusCmb(){
          bedStatusCmb.removeAllItems();
        
        for (Bed.BedStatus status : Bed.BedStatus.values()){
            bedStatusCmb.addItem(status.getStatus());
        }
    }
    
    
    void populateBedTypeCmb(){
          bedTypeCmb.removeAllItems();
        
        for (Bed.BedType status : Bed.BedType.values()){
            bedTypeCmb.addItem(status.getBedType());
        }
    }
    
    
    private void bedTypeCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedTypeCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bedTypeCmbActionPerformed

    private void txtBedAssignDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBedAssignDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedAssignDateActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel assignJPanel;
    private javax.swing.JTable bedJTable;
    private javax.swing.JComboBox bedStatusCmb;
    private javax.swing.JComboBox bedTypeCmb;
    private javax.swing.JButton btnAssignBed;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnviewBed;
    private javax.swing.JButton closebtn;
    private javax.swing.JTextField emailIDTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBedStatus;
    private javax.swing.JTextField phoneNumberTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextArea txtAreaMessage;
    private javax.swing.JTextField txtBedAssignDate;
    private javax.swing.JTextField txtBedDate;
    private javax.swing.JTextField txtBedIPrice;
    private javax.swing.JTextField txtBedId;
    private javax.swing.JTextField txtBedType;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField viewAppnmtID;
    private javax.swing.JPanel viewDetailsJPanel;
    private javax.swing.JTextField viewDrTxt;
    private javax.swing.JTextField viewPatientNametxt;
    private javax.swing.JTextField viewRequestDateTxt;
    private javax.swing.JComboBox viewStatusCmb;
    private javax.swing.JTextField viewpatientIdTxt;
    // End of variables declaration//GEN-END:variables
}
