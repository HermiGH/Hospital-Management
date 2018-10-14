package com.test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pojo.Nurse;
import com.pojo.Patient;

public class NurseTest {
	static Nurse nurse;
	static Patient patient;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		patient = new Patient("Kate", new GregorianCalendar(1888,1,31), "Indian", "A+", "1212");
		ArrayList<String> labTests = new ArrayList<String>();
		labTests.add("test1");
		labTests.add("test2");
		patient.setLabTestOrder(labTests);
		nurse = new Nurse("Gladis",new GregorianCalendar(1992,1,30),"Indian","A+","12111");
	}
	
	@Test
	public void testCheckInPatient() throws Exception {
		nurse.checkInPatient(patient);
	}
}
