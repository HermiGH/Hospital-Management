package com.pojo;

import java.util.HashMap;

public class MedicalHistory {
	String diagnosis;
	String dietPlan;
	HashMap<String, String> labResult;
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getDietPlan() {
		return dietPlan;
	}
	public void setDietPlan(String dietPlan) {
		this.dietPlan = dietPlan;
	}
	public HashMap<String, String> getLabResult() {
		return labResult;
	}
	public void setLabResult(HashMap<String, String> labResult) {
		this.labResult = labResult;
	}
	@Override
	public String toString() {
		return "MedicalHistory [diagnosis=" + diagnosis + ", dietPlan=" + dietPlan + ", labResult=" + labResult + "]";
	}
	
	
}
