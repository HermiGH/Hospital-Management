package com.pojo;

import java.util.ArrayList;
import java.util.Iterator;

public class Dietician extends Staff {
	public static ArrayList<Patient> dieticianList = new ArrayList<>();
	public void alotDietPlan(Patient patient) {
		Iterator<Patient> it = dieticianList.iterator();
		while(it.hasNext()){
			Patient p =it.next();
			if(p.personId==patient.personId) {
				patient.getMedicalHistory().getDiagnosis();
				//check diagnosis and accordingly assign diet plan
				patient.getMedicalHistory().setDietPlan("Diet Plan");
				it.remove();
				break;
			}
		}
	}
}
