package com.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.pojo.Appointment;
import com.pojo.Doctor;
import com.pojo.Patient;

public class Inventory {
	
	public enum Department{
		Pediatric(1), Orthopedic(2), ENT(3), Endocrinology(4), Cardiology(5), Dermatology(6), Emergency(7), Surgery(8), Oncology(9);
		private final int value;
		private Department(int value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	public enum WeekList{
		SUN, MON, TUE, WED, THURS, FRI, SAT;
	}
	public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	static {
		Doctor doctor1 = new Doctor("Philip", new GregorianCalendar(1888,1,31), "Indian", "A+", "111111", Department.Cardiology, "01111110");
		Doctor doctor2 = new Doctor("Andy", new GregorianCalendar(1888,3,30), "Indian", "A+", "111112", Department.Surgery, "01111110");
		Doctor doctor3 = new Doctor("Justin", new GregorianCalendar(1888,5,30), "Indian", "A+", "111113", Department.Orthopedic, "01111110");
		Doctor doctor4 = new Doctor("Jason", new GregorianCalendar(1888,7,30), "Indian", "A+", "111114", Department.Oncology, "01111110");
		Doctor doctor5 = new Doctor("Jose", new GregorianCalendar(1888,9,30), "Indian", "A+", "111115", Department.Dermatology, "01111110");
		Doctor doctor6 = new Doctor("John", new GregorianCalendar(1888,11,30), "Indian", "A+", "111116", Department.Emergency, "01111110");
		doctorList.add(doctor1);
		doctorList.add(doctor2);
		doctorList.add(doctor3);
		doctorList.add(doctor4);
		doctorList.add(doctor5);
		doctorList.add(doctor6);
	}
	
	public static ArrayList<Patient> patientList = new ArrayList<Patient>(50);
	static {
		Patient doctor1 = new Patient("Pretty", new GregorianCalendar(1988,1,31), "Indian", "A+", "211111");
		Patient doctor2 = new Patient("Nikhila", new GregorianCalendar(1988,3,30), "Indian", "B+", "211112");
		Patient doctor3 = new Patient("Harika", new GregorianCalendar(1988,5,30), "Indian", "O+", "211113");
		Patient doctor4 = new Patient("Tejaswini", new GregorianCalendar(1988,7,30), "Indian", "A-", "211114");
		Patient doctor5 = new Patient("Jose", new GregorianCalendar(1988,9,30), "Indian", "A+", "211115");
		Patient doctor6 = new Patient("John", new GregorianCalendar(1988,11,30), "Indian", "A+", "211116");
		patientList.add(doctor1);
		patientList.add(doctor2);
		patientList.add(doctor3);
		patientList.add(doctor4);
		patientList.add(doctor5);
		patientList.add(doctor6);
	}
	public static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>(50);
	
}
