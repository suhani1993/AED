/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Doctor.Doctor;
import Business.Enterprise.LabEnterprise.LabTest;
import Business.Operation.OperationDirectory;
import Business.Patient.Patient;
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
    Doctor doctor;
    Patient patient;
    String status;  //booked, cancelled, rescheduled, completed
    String location;
    OperationDirectory operationDirectory;
    List<LabTest> labTestList;
    
    public Appointment(int count){
        this.appointmentId = count;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public OperationDirectory getOperationDirectory() {
        return operationDirectory;
    }

    public void setOperationDirectory(OperationDirectory operationDirectory) {
        this.operationDirectory = operationDirectory;
    }

    public List<LabTest> getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(List<LabTest> labTestList) {
        this.labTestList = labTestList;
    }
    
    
    
    
    
}