package com.test;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pojo.Messenger;
import com.pojo.Patient;

public class MessengerTest {
	static Messenger messenger;
	static Patient patient;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		patient = new Patient("Kate", new GregorianCalendar(1888,1,31), "Indian", "A+", "1212");
		messenger = new Messenger();
	}
	
	@Test 
	public void testShiftPatient() throws Exception {
		messenger.shiftPatient(patient);
		//Assert.assertEquals(patient.getRoom(), 3);
	}
}
