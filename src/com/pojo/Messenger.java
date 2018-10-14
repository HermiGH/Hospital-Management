package com.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Messenger extends Staff{
	public static ArrayList<Patient> medicinePatientList=new ArrayList<>();
	public static ArrayList<Patient> shiftPatientList=new ArrayList<>();
	public void shiftPatient(Patient patient) {
		int bed = InventoryManager.getBed(patient);
		Iterator<Patient> it = shiftPatientList.iterator();
		while(it.hasNext()){
			Patient p =it.next();
		
			if(p.personId==patient.personId) {
				patient.setRoom(bed);
				it.remove();
				break;
			}
		}
		System.out.println("shifted patient to ward");
	}

	/*@Requires({"patient!=null"})*/
	public void getMedcine(Patient patient) {
		Iterator<Patient> it = medicinePatientList.iterator();
		while(it.hasNext()){
			Patient p =it.next();
		
			if(p.personId==patient.personId) {
				it.remove();
				break;
			}
		}
		System.out.println("Bought medicine from the pharmacy");
	}

}
