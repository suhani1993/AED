/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Employee.Employee;
import Business.Enterprise.LabEnterprise.LabTest;
import Business.Operation.Operation;
import Business.Patient.Patient;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aditi
 */
public class Appointment {
    int appointmentId;
    String type; //online, in-person
    Date date;
    Employee doctor;
    Patient patient;
    AppointmentStatus status;  //new, booked, cancelled, rescheduled, completed , mark for billing
    String location;
    private Operation operation;
    LabTest labTest;
    Prescription prescription;

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
    
    public Appointment(int count){
        this.appointmentId = count;
        prescription= new Prescription();
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }

    
    
    
    @Override
    public String toString()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String strDate = dateFormat.format(this.date); 
        return strDate;
    }
    
    
   // Appointment-> New, markforbilling, markforsurgery, markforTest, close
    
    public enum AppointmentStatus{
        New("New"),
        Markforbilling("Markforbilling"),
        Markforsurgery("Markforsurgery"),
        MarkforTest("MarkforTest"),
        Close("Close"),
        AnalyseReport("AnalyseReport"),
        GeneratedReport("GeneratedReport"),
        Cancel("Cancel");
        
        private String value;
        private AppointmentStatus(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
