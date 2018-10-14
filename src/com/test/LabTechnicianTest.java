package com.test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pojo.LabTechnician;
import com.pojo.Patient;

public class LabTechnicianTest {
	static LabTechnician labTech;
	static Patient patient;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		patient = new Patient("Kate", new GregorianCalendar(1888,1,31), "Indian", "A+", "1212");
		labTech = new LabTechnician();
		ArrayList<String> labTests = new ArrayList<String>();
		labTests.add("test1");
		labTests.add("test2");
		patient.setLabTestOrder(labTests);
	}
	
	@Test
	public void testTestBloodSample() throws Exception {
		labTech.testBloodSample(patient);
		//Assert.assertNotNull(patient.getMedicalHistory().getLabResult());
	}
}
