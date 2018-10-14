package com.pojo;

public class MealManager extends Staff{
	public void setMealPlanForPatient(Patient patient) {
		patient.getMedicalHistory().getDietPlan();
		patient.setMealPlan("Meal Plan");
	}
}
