package com.test;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.data.Inventory.Department;
import com.pojo.Doctor;
import com.pojo.Patient;

public class DoctorTest {
	static Doctor doctor;
	static Patient patient;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		doctor = new Doctor("Philips", new GregorianCalendar(1888,1,31), "Indian", "A+", "111111", Department.Pediatric, "01111110");
		patient = new Patient("Kate", new GregorianCalendar(1888,1,31), "Indian", "A+", "1212");
	}
	@Test
	public void testGetDoctor() throws Exception {
		Doctor doctor1 = Doctor.getDoctor(5);
		Assert.assertEquals(doctor1.getDepartment(), Department.Cardiology);
	}
	
	@Test
	public void testCheckPatient() throws Exception {
		Assert.assertTrue(doctor.checkPatient(patient,"medicine","diagnosis","test"));
		Assert.assertNotNull(patient.getMedicinePrescribed());
		Assert.assertNotNull(patient.getLabTestOrder());
	}
}
