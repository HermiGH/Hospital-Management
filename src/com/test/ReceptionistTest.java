package com.test;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pojo.Patient;
import com.pojo.ReceptionistPojo;

import junit.framework.Assert;

public class ReceptionistTest {
	static Patient patient;
	static ReceptionistPojo receptionist;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		patient = new Patient("Kate", new GregorianCalendar(1888,1,31), "Indian", "A+", "1212");
		receptionist = new ReceptionistPojo();
	}
	
	@Test
	public void testGetAppointment() throws Exception{
		Assert.assertNotNull(receptionist.getInPatientAppointment(patient, 5));
	}
}
