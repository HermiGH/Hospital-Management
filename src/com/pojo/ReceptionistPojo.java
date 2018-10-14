package com.pojo;

import java.util.Calendar;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class ReceptionistPojo extends Staff{
	//should have the department for appointment
	/*@Requires({"patient!=null","department!=0"})
	@Ensures({"appointment!=null"})*/
	public Appointment getInPatientAppointment(Patient patient, int department) {
		Doctor doctor = Doctor.getDoctor(department);
		//doctor.getAppointmentList();
		String doctorsWeekList = doctor.getWorkingWeekList();
		//Adding one day of the week
		Calendar appointmentDate = Calendar.getInstance(); 
		appointmentDate.set(7, appointmentDate.get(7)+1);
		if(doctorsWeekList.charAt(appointmentDate.get(7))==0) {
			for(int i=0;i<doctorsWeekList.length();i++) {
				if(doctorsWeekList.charAt(i)==1) {
					appointmentDate.set(7, i);
					break;
				}
			}
		}
		Appointment appointment = new Appointment(appointmentDate, patient.getPersonId(), doctor.getPersonId());
		doctor.getAppointmentList().put(appointmentDate, appointment);
		patient.setAppointment(appointment);
		patient.setDoctorId(doctor.getPersonId());
		patient.setCurrentDepartment(doctor.getDepartment());
		return appointment;
	}
}
