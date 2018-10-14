package com.test;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pojo.InventoryManager;
import com.pojo.Patient;

public class InventoryManagerTest {
	static Patient patient;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		patient = new Patient("Kate", new GregorianCalendar(1888,1,31), "Indian", "A+", "1212");
	}
	
	@Test
	public void testGetBed() throws Exception {
		InventoryManager.getBed(patient);
		//Assert.assertNotSame(patient.getRoom(), 0);
	}
	@Test
	public void testGetBedMoreThan10Patients() throws Exception {
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		InventoryManager.getBed(patient);
		Assert.assertEquals(InventoryManager.getBed(patient),0);
	}
}
