package com.service;

import java.util.GregorianCalendar;
import java.util.Scanner;
import com.data.Inventory;
import com.pojo.Appointment;
import com.pojo.Doctor;
import com.pojo.Nurse;
import com.pojo.Patient;
import com.pojo.ReceptionistPojo;
//-javaagent:lib\cofoja.contracts.asm-1.3-20160207.jar
public class StartService {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		forBreak:for(int i=0;i<=5;i++) {
	        System.out.println("Please select from the following options:");
	        System.out.println("1. Book patient appointment");
	        System.out.println("2. Exit");
	        int option = sc.nextInt();
	        switch(option) {
	        case 1:
		        	System.out.println("which department?");
		        	System.out.println("1.Pediatric\n2.Orthopedic\n3.ENT\n4.Endocrinology\n5.Cardiology\n6.Dermatology\n7.Emergency\n8.Surgery\n9.Oncology;");
		        	int department = sc.nextInt();
		        	Patient patient = Patient.storePatientDetails(sc);
		        	ReceptionistPojo receptionist = new ReceptionistPojo();
		        	System.out.println("Receptionist scheduling patient appointment");
		        	Appointment appointment = receptionist.getInPatientAppointment(patient, department);
		        	System.out.println("Patient details after appointment scheduled "+patient.toString());
		        	System.out.println("Appointmet scheduled "+appointment.toString());
		        	
		        	Nurse nurse  = new Nurse("Gladis",new GregorianCalendar(1992,1,30),"Indian","A+","12111");
		        	Doctor doctor = null;
		        	System.out.println("gettting doctor based on the appointment");
		        	for(Doctor doctorL:Inventory.doctorList) {
		    			if(doctorL.getPersonId()==appointment.getDoctorId()) {
		    				doctor = doctorL;
		    			}
		    		}
		        //if to admit
		        	if(	patient.getCheckedAppointment(doctor,"medicine","diagnosis","test")) {
		        		//needs to be admitted
		        		nurse.checkInPatient(patient);
		        	}
		        	System.out.println(patient.toString());
		        	break;
	        case 2:
	        		break forBreak;
	        }
		}
	}
}
