package com.pojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Nurse extends Person{
	//Nurse nurse = new Nurse("Gladis",new GregorianCalendar(1992,1,30),"Indian","A+","12111");
	public static ArrayList<Patient> myPatientList=new ArrayList<>();
	public Nurse(String name, Calendar dob, String nationality, String bloodGrp, String insuranceNumber) {
		super(name, dob, nationality, bloodGrp, insuranceNumber);
		// TODO Auto-generated constructor stub
	}
	/*@Requires({"patient!=null"})*/
	public void checkInPatient(Patient patient) {
		Dietician dietician = new Dietician();
		LabTechnician labTech = new LabTechnician();
		Messenger messenger = new Messenger();
		//notify messenger,
		transferPatient(messenger,patient);
		//notify messsenger to get medicine
		System.out.println("Nurse requesting Messenger to get medicine");
		Messenger.medicinePatientList.add(patient);
		//messenger.getMedcine(patient);
		System.out.println("Nurse requesting Dietician to assign a diet plan");
		Dietician.dieticianList.add(patient);
		//dietician.alotDietPlan(patient);
		System.out.println("Nurse requesting Lab Technician to do the necessary tests");
		//labTech.testBloodSample(patient);
		LabTechnician.testPatientList.add(patient);
		
	}
	/*@Requires({"messenger!=null","patient!=null"})*/
	public void transferPatient(Messenger messenger,Patient patient) {
		System.out.println("Nurse requesting Messenger to shift patient");
		Messenger.shiftPatientList.add(patient);
	}
}
