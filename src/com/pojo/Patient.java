package com.pojo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import com.data.Inventory;
import com.data.Inventory.Department;
import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class Patient extends Person {
	
	Department currentDepartment;
	int doctorId;
	MedicalHistory medicalHistory; 
	List<String> medicinePrescribed;
	List<String> labTestOrder;
	//In-patient details
	Appointment appointment;
	//Out-patient details
	String mealPlan;
	int floor;
	int room;
	public String getMealPlan() {
		return mealPlan;
	}

	public void setMealPlan(String mealPlan) {
		this.mealPlan = mealPlan;
	}

	public Patient(String name, Calendar dob, String nationality, String bloodGrp, String insuranceNumber) {
		super(name, dob, nationality, bloodGrp, insuranceNumber);
		this.medicalHistory = new MedicalHistory();
	}

	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	/*@Requires({"sc!=null"})
	@Ensures("patient!=null")*/
	public static Patient storePatientDetails(final Scanner sc) {
		System.out.println("Is patient new (Y/N)?");
		boolean isNewPatient =(sc.next().charAt(0)=='Y' || sc.next().charAt(0)=='y')?true:false;
		Patient patient=null;
		if(isNewPatient) {
			System.out.println("Name: ");
	        String name = sc.next();
	        
	        System.out.println("Nationality: ");
	        String nationality = sc.next();
	        
	        System.out.println("Blood Group: ");
	        String bloodGrp = sc.next();
	        
	        System.out.println("Insurance Number: ");
	        String insuranceNumber = sc.next();
	        
	        patient = new Patient(name, new GregorianCalendar(2013,5,31), nationality, bloodGrp, insuranceNumber);
	        
	        System.out.println("Adding patient to the patient inventory");
	        Inventory.patientList.add(patient);
		} else {
			System.out.println("Patient Id: ");
			int id = sc.nextInt();
			for(Patient patientL: Inventory.patientList) {
				if(patientL.personId==id) {
					patient = patientL;
				}
			}
		}
		return patient;
	}
	
	public static Patient getPatientById(int patientId) {
		for(Patient p:Inventory.patientList) {
			if(p.personId==patientId) {
				return p;
			}
		}
		return null;
	}

	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public List<String> getMedicinePrescribed() {
		return medicinePrescribed;
	}

	public void setMedicinePrescribed(List<String> medicinePrescribed) {
		this.medicinePrescribed = medicinePrescribed;
	}

	public List<String> getLabTestOrder() {
		return labTestOrder;
	}

	public void setLabTestOrder(List<String> labTestOrder) {
		this.labTestOrder = labTestOrder;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Patient [ patientID ="+this.getPersonId()+" currentDepartment=" + currentDepartment + ", doctorId=" + doctorId + ", medicalHistory="
				+ medicalHistory + ", mealPlan=" + mealPlan + ", medicinePrescribed=" + medicinePrescribed + "]";
	}

	public boolean getCheckedAppointment(Doctor doctor, String medicine, String diagnosis, String test) {
		return doctor.checkPatient(this,medicine,diagnosis,test);
	}
}
