package com.test;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pojo.Dietician;
import com.pojo.Patient;

public class DieticianTest {
	static Dietician dietician;
	static Patient patient;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dietician  = new Dietician();
		patient = new Patient("Kate", new GregorianCalendar(1888,1,31), "Indian", "A+", "1212");
	}
	
	@Test
	public void testAlotDietPlan() throws Exception {
		dietician.alotDietPlan(patient);
		//Assert.assertNotNull(patient.getMedicalHistory().getDietPlan());
	}
}
