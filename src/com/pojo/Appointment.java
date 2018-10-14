package com.pojo;

import java.util.Calendar;

public class Appointment {
	int appointmentId;
	Calendar date;
	int patientId;
	int doctorId;
	
	
	public Appointment(Calendar date, int patientId, int doctorId) {
		super();
		this.appointmentId = (int )(Math.random() * 50 + 1);
		this.date = date;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", date=" + date + ", patientId=" + patientId
				+ ", doctorId=" + doctorId + "]";
	}
	
}
