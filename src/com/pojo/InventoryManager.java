package com.pojo;

import java.util.ArrayList;

public class InventoryManager extends Staff{
	static ArrayList<Patient> patientList = new ArrayList<>(10);
	public static int getBed(Patient patient) {
		try {
			patientList.add(patient);	
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No rooms available");
			return 0;
		}
		
		return patientList.indexOf(patient);
	}
}
