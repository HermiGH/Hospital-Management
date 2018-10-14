package com.pojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import com.data.Inventory;
import com.data.Inventory.Department;

public class Doctor extends Person{
	Department department;
	String workingWeekList = "0000000";
	HashMap<Calendar,Appointment> appointmentList;
	public Doctor(String name, Calendar dob, String nationality, String bloodGrp, String insuranceNumber, Department department, String workingWeekList) {
		super(name, dob, nationality, bloodGrp, insuranceNumber);
		this.department = department;
		this.workingWeekList = workingWeekList;
		this.appointmentList = new HashMap<>();
	}
	/*@Requires({"department>-"})
	@Ensures("doctor!=null")*/
	public static Doctor getDoctor(int department) {
		Doctor doctor =null;
		for(Doctor doctorL:Inventory.doctorList) {
			if(doctorL.department.getValue()==department) {
				doctor = doctorL;
			}
		}
		return doctor;
	}
	public static Doctor getDoctorById(int doctorId) {
		Doctor doctor =null;
		for(Doctor doctorL:Inventory.doctorList) {
			if(doctorL.personId==doctorId) {
				return doctorL;
			}
		}
		return doctor;
	}
	/*@Requires({"patient!=null"})*/
	public boolean checkPatient(Patient patient, String medicine, String diagnosis, String test) {
		patient.getMedicalHistory().setDiagnosis(diagnosis);
		ArrayList<String> medicines = new ArrayList<String>();
		medicines.add(medicine);
		patient.setMedicinePrescribed(medicines);
		ArrayList<String> labTests = new ArrayList<String>();
		labTests.add(test);
		patient.setLabTestOrder(labTests);
		return true;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getWorkingWeekList() {
		return workingWeekList;
	}
	public void setWorkingWeekList(String workingWeekList) {
		this.workingWeekList = workingWeekList;
	}
	public HashMap<Calendar,Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(HashMap<Calendar,Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	
}
