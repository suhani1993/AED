/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Appointment.Appointment;
import Business.Department.Receptionist;
import Business.Doctor.Doctor;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LabEnterprise.LabTestDirectory;
import Business.Medicine.MedicineDirectory;
import Business.Network.Network;
import Business.Operation.Operation;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.NurseWorkRequest;
import Business.WorkQueue.ReceptionistWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Appointment appointment;
    private Employee doctor;
    private Patient patient;
    private MedicineDirectory medicineList;
    private EcoSystem ecosystem;
    private LabTestDirectory labTestList;
    private Employee receptionist;
    private Network network;
    //private EcoSystem ecosystem;
    
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, Organization organization, UserAccount account, Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
        this.ecosystem=ecosystem;
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.network= enterprise.getNetwork();//getNetwork();
        valueLabel.setText(enterprise.getName());
        this.doctor=userAccount.getEmployee();
        populateRequestTable();
        scheduleSurgeryJPanel.setVisible(false);
    }

    
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) DoctorWorkAreaTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[2];
            row[0] = ((DoctorWorkRequest)request).getPatient();//request.getMessage();
            row[1] = ((DoctorWorkRequest)request).getAppointment();//getReceiver();
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
        DoctorWorkAreaTable = new javax.swing.JTable();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        btnViewAppointments = new javax.swing.JButton();
        btnViewPatientHistory = new javax.swing.JButton();
        btnAssignNextDoctor = new javax.swing.JButton();
        btnCompleted = new javax.swing.JButton();
        btnPrescribeMeds = new javax.swing.JButton();
        btnScheduleSurgery = new javax.swing.JButton();
        btnScheduleLabTest = new javax.swing.JButton();
        scheduleSurgeryJPanel = new javax.swing.JPanel();
        appoinmtntDTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        patientNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        oprDesc = new javax.swing.JLabel();
        cmbOperationType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOprDescptn = new javax.swing.JTextArea();
        backJButton = new javax.swing.JButton();

        DoctorWorkAreaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient Name", "Appointment Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DoctorWorkAreaTable);
        if (DoctorWorkAreaTable.getColumnModel().getColumnCount() > 0) {
            DoctorWorkAreaTable.getColumnModel().getColumn(1).setResizable(false);
        }

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setText("<value>");

        btnViewAppointments.setText(" View Appointment");
        btnViewAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAppointmentsActionPerformed(evt);
            }
        });

        btnViewPatientHistory.setText("View Patient History");
        btnViewPatientHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPatientHistoryActionPerformed(evt);
            }
        });

        btnAssignNextDoctor.setText("Assign Next Doctor");
        btnAssignNextDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignNextDoctorActionPerformed(evt);
            }
        });

        btnCompleted.setText("Appointment Completed");
        btnCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletedActionPerformed(evt);
            }
        });

        btnPrescribeMeds.setText("Prescribe Medicines");
        btnPrescribeMeds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescribeMedsActionPerformed(evt);
            }
        });

        btnScheduleSurgery.setText("Schedule Surgery");
        btnScheduleSurgery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleSurgeryActionPerformed(evt);
            }
        });

        btnScheduleLabTest.setText("Schedule Test");
        btnScheduleLabTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleLabTestActionPerformed(evt);
            }
        });

        scheduleSurgeryJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add Schedule"));

        appoinmtntDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appoinmtntDTxtActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Appointment ID:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Patient Name:");

        jLabel3.setText("Schedule Date:");

        saveButton.setText("Save/Update");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        oprDesc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        oprDesc.setText("Decription:");

        cmbOperationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Operation:");

        txtOprDescptn.setColumns(20);
        txtOprDescptn.setRows(5);
        jScrollPane2.setViewportView(txtOprDescptn);

        javax.swing.GroupLayout scheduleSurgeryJPanelLayout = new javax.swing.GroupLayout(scheduleSurgeryJPanel);
        scheduleSurgeryJPanel.setLayout(scheduleSurgeryJPanelLayout);
        scheduleSurgeryJPanelLayout.setHorizontalGroup(
            scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleSurgeryJPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(oprDesc)
                    .addComponent(jLabel5)
                    .addGroup(scheduleSurgeryJPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(saveButton)))
                .addGap(27, 27, 27)
                .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closebtn)
                    .addGroup(scheduleSurgeryJPanelLayout.createSequentialGroup()
                        .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbOperationType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(appoinmtntDTxt)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(scheduleSurgeryJPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(patientNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(scheduleSurgeryJPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(dateTxt)))))
                .addContainerGap())
        );
        scheduleSurgeryJPanelLayout.setVerticalGroup(
            scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleSurgeryJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appoinmtntDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(patientNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbOperationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oprDesc)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(scheduleSurgeryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closebtn)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(refreshTestJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(backJButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAssignNextDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnViewAppointments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnViewPatientHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnPrescribeMeds, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnScheduleLabTest, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnScheduleSurgery, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(scheduleSurgeryJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(btnCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refreshTestJButton))
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnViewAppointments)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewPatientHistory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAssignNextDoctor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrescribeMeds)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnScheduleLabTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnScheduleSurgery)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCompleted)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scheduleSurgeryJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(backJButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        scheduleSurgeryJPanel.getAccessibleContext().setAccessibleName("Add Surgery");
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();
        
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void btnViewAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAppointmentsActionPerformed

        ViewAppointmentJPanel viewAppointmentJPanel = new ViewAppointmentJPanel(userProcessContainer, userAccount, organization, enterprise, ecosystem);
        userProcessContainer.add("viewAppointmentJPanel",viewAppointmentJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewAppointmentsActionPerformed

    private void btnViewPatientHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPatientHistoryActionPerformed
        int selectedRow = DoctorWorkAreaTable.getSelectedRow();
        if(selectedRow >= 0){
            Patient patient = (Patient)enterprise.getPatientDirectory().getPatientList().get(selectedRow);
            //            Order order = (Order)OrderJTable.getValueAt(selectedRow, 0);
            PatientHistoryJPanel patientHistoryJPanel = new PatientHistoryJPanel(userProcessContainer, userAccount, organization, enterprise, ecosystem, patient);
            userProcessContainer.add("patientHistoryJPanel",patientHistoryJPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnViewPatientHistoryActionPerformed

    private void btnAssignNextDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignNextDoctorActionPerformed

    }//GEN-LAST:event_btnAssignNextDoctorActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(appoinmtntDTxt.getText().equals("") || patientNameTxt.getText().equals("") ||  dateTxt.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "fields cannot be empty");
        }
        else{
            try {
                int selectedrow=DoctorWorkAreaTable.getSelectedRow();
                Operation operation= new Operation();//(Operation)DoctorWorkAreaTable.getValueAt(selectedrow, 0);
                
                Patient patient = (Patient) DoctorWorkAreaTable.getValueAt(selectedrow, 0);
                Appointment appointment = (Appointment) DoctorWorkAreaTable.getValueAt(selectedrow, 1);
                
                String date1=dateTxt.getText();
                operation.setPatient(patient);
                
                operation.setOperationDate(date1);
                if(txtOprDescptn.getText() != null){
                operation.setOperationDescription(txtOprDescptn.getText());
                }
                else { 
                    operation.setOperationDescription(" ");
                
                }
                
                operation.setOperationCharge(10000.00);
                operation.setDoctor(doctor);
                operation.setStatus(Operation.OperationStatus.WaitingConfirmation.getValue());
                
                //set operation
                appointment.setOperation(operation);
                appointment.setStatus("New");
                NurseWorkRequest workreq = new NurseWorkRequest();
                workreq.setAppointment(appointment);
                workreq.setMessage("New Patient for Operation, please confirm an operation Date.");
                
                workreq.setSender(userAccount);
                workreq.setPatient(patient);
                
                
                //get today's Date->
                Date date= new Date();
                workreq.setRequestDate(date);
                workreq.setResolveDate(date);
                workreq.setStatus(Appointment.AppointmentStatus.Markforsurgery.getValue());
                UserAccount nurseUserAcc =null;
                //need employee list of the doctor's department -> organization
                List<UserAccount> userAccDir=  organization.getUserAccountDirectory().getUserAccountList();
                //List<UserAccount> nurseList = enterprise.getUserAccountDirectory().getUserAccountList();
                for(UserAccount account: userAccDir)
                {
                    if(account.getRole().roleValue().equals("Nurse Role"))
                    {
                        workreq.setReceiver(account);
                        account.getWorkQueue().getWorkRequestList().add(workreq);
                    }
                    
                }
                
              
                
       
                
                
                JOptionPane.showMessageDialog(null, "Schedule added successfully!");
                scheduleSurgeryJPanel.setVisible(false);
                appoinmtntDTxt.setText("");
                patientNameTxt.setText("");
                //bloodGrpTxt.setText("");
                dateTxt.setText("");
                txtOprDescptn.setText("");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Date must be entered in YYYY-MM-DD format");
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        scheduleSurgeryJPanel.setVisible(false);
    }//GEN-LAST:event_closebtnActionPerformed

    private void btnScheduleSurgeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleSurgeryActionPerformed
        int selectedrow=DoctorWorkAreaTable.getSelectedRow();
        if(selectedrow<0)
        {
            
            JOptionPane.showMessageDialog(null, "Please select a Patient Appointment");
            return;
       
        }
           Appointment appointment = (Appointment) DoctorWorkAreaTable.getValueAt(selectedrow, 1);
           Patient patient = (Patient) DoctorWorkAreaTable.getValueAt(selectedrow, 0);
           scheduleSurgeryJPanel.setVisible(true);        
           appoinmtntDTxt.setText(String.valueOf(appointment.getAppointmentId()));
           patientNameTxt.setText(patient.getName());
            //populate operation types
           populateOperationType();
        
        
    }//GEN-LAST:event_btnScheduleSurgeryActionPerformed

    
    public void populateOperationType(){
        cmbOperationType.removeAllItems();
        
        for (Operation.OperationType type : Operation.OperationType.values()){
            cmbOperationType.addItem(type.toString());
        }


    }
    
    private void btnPrescribeMedsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescribeMedsActionPerformed
        
        int selectedRow = DoctorWorkAreaTable.getSelectedRow();
        
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please select a Patient Appointment");
            return;
        }
        patient = (Patient)DoctorWorkAreaTable.getValueAt(selectedRow, 0);
        appointment= (Appointment)DoctorWorkAreaTable.getValueAt(selectedRow, 1);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("PrescriptionJPanel", new PrescriptionJPanel(userProcessContainer, patient, appointment, doctor, medicineList, ecosystem, enterprise));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPrescribeMedsActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void appoinmtntDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appoinmtntDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appoinmtntDTxtActionPerformed

    private void btnScheduleLabTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleLabTestActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("AssignLabTestJPanel", new AssignLabTestJPanel(userProcessContainer, patient, appointment, labTestList,network));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnScheduleLabTestActionPerformed

    private void btnCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletedActionPerformed
        //fetch selected row...
        //0th patient 1th appoint
        //        appointment.setStaus("Mark for billing");
                
                
          /*      ReceptionistWorkRequest work = new ReceptionistWorkRequest();
                work.setApp(appointment);
                work.setPatient(patient);
                work.setDoctor(doctor);
                        work.setSender(userACcountDr);
                        work.setReceiver(userAccount);
                work.setStatus("Mark for billing")     ;
                UserAccount Recuseracc;
                useracc.getWorkQueue().getWorkRequestList().add(work);*/
    }//GEN-LAST:event_btnCompletedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DoctorWorkAreaTable;
    private javax.swing.JTextField appoinmtntDTxt;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAssignNextDoctor;
    private javax.swing.JButton btnCompleted;
    private javax.swing.JButton btnPrescribeMeds;
    private javax.swing.JButton btnScheduleLabTest;
    private javax.swing.JButton btnScheduleSurgery;
    private javax.swing.JButton btnViewAppointments;
    private javax.swing.JButton btnViewPatientHistory;
    private javax.swing.JButton closebtn;
    private javax.swing.JComboBox<String> cmbOperationType;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel oprDesc;
    private javax.swing.JTextField patientNameTxt;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel scheduleSurgeryJPanel;
    private javax.swing.JTextArea txtOprDescptn;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
