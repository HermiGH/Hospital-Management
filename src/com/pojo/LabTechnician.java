package com.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LabTechnician extends Staff{
	public static ArrayList<Patient> testPatientList=new ArrayList<>();
	public void testBloodSample(Patient patient) {
		List<String> tests = patient.getLabTestOrder();
		HashMap<String, String> result = new HashMap<>();
		for(String test:tests) {
			result.put(test, "result");
		}
		Iterator<Patient> it = testPatientList.iterator();
		while(it.hasNext()){
			Patient p =it.next();
			if(p.personId==patient.personId) {
				patient.getMedicalHistory().setLabResult(result);
				it.remove();
				break;
			}
		}
	}

}
