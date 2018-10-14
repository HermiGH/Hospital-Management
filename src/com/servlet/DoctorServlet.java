package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.Inventory;
import com.pojo.Appointment;
import com.pojo.Doctor;
import com.pojo.Nurse;
import com.pojo.Patient;

/**
 * Servlet implementation class DoctorServlet
 */
//@WebServlet("/DoctorController")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Doctor doctor=null;
    public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("doGet");
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		Doctor doctor = Doctor.getDoctorById(doctorId);setDoctor(doctor);
		RequestDispatcher rd = request.getRequestDispatcher("Doctor.jsp");
		rd.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		////System.out.println("doPost");
		String act = (String)request.getAttribute("act");
		if(act==null) {
			act=request.getParameter("act");
		}
		if(act!=null&&act.equals("Go Back")) {
			//setDoctor(null);
			RequestDispatcher rd = request.getRequestDispatcher("Doctor.jsp");
			rd.forward(request, response);
		} else if(act!=null&&act.equals("Go Home")) {
			setDoctor(null);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(getDoctor()==null) {
			int doctorId = Integer.parseInt(request.getParameter("doctorId"));
			Doctor doctor = Doctor.getDoctorById(doctorId);
			setDoctor(doctor);
			RequestDispatcher rd = request.getRequestDispatcher("Doctor.jsp");
			rd.forward(request, response);
		} else {
			//System.out.println("act in Doctor Servlet "+act);
			if(act.equals("checkPatient")) {
				//setDoctor(null);
				
				ArrayList<Patient> patientList =new ArrayList<>();
				for(Appointment a:Inventory.appointmentList) {
					if(a.getDoctorId()==getDoctor().getPersonId()) {
						patientList.add(Patient.getPatientById(a.getPatientId()));
					}
				}
				if(patientList.isEmpty()) {
					request.setAttribute("act", "errorDoctor");
					RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("patientList", patientList);
					request.setAttribute("act", "checkPatientList");
					RequestDispatcher rd = request.getRequestDispatcher("DoctorNext.jsp");
					rd.forward(request, response);
				}
			}else if(act.equals("Submit Diagnosis")) {
				int patientId  =Integer.parseInt(request.getParameter("personId"));
				////System.out.println(patientId);
				Patient patient = Patient.getPatientById(patientId);
				////System.out.println("patient"+patient.toString());
				////System.out.println("nurse size "+Nurse.myPatientList.size());
				Nurse.myPatientList.add(patient);
				////System.out.println("nurse size "+Nurse.myPatientList.size());
				getDoctor().checkPatient(patient,(String) request.getAttribute("medicine"), (String)request.getAttribute("diagnosis"), (String)(request.getAttribute("test")));
				Iterator<Appointment> it = Inventory.appointmentList.iterator();
				while(it.hasNext()){
					Appointment a =it.next();
					if(a.getDoctorId()==getDoctor().getPersonId()&&a.getPatientId()==patient.getPersonId()) {
						////System.out.println("found appointment to delete");
						it.remove();
						break;
					}
				}
				/*for(Appointment a :Inventory.appointmentList) {
					if(a.getDoctorId()==getDoctor().getPersonId()&&a.getPatientId()==patient.getPersonId()) {
						//System.out.println("found appointment to delete");
						Inventory.appointmentList.remove(a);
					}
				}*/
				RequestDispatcher rd = request.getRequestDispatcher("Doctor.jsp");
				rd.forward(request, response);
			} else if(act.equals("viewPatientList")) {
				ArrayList<Patient> patientList =new ArrayList<>();
				for(Appointment a:Inventory.appointmentList) {
					if(a.getDoctorId()==getDoctor().getPersonId()) {
						patientList.add(Patient.getPatientById(a.getPatientId()));
					}
				}
				if(patientList.isEmpty()) {
					request.setAttribute("act", "errorDoctor");
					RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("patientList", patientList);
					request.setAttribute("act", "showPatientList");
					RequestDispatcher rd = request.getRequestDispatcher("DoctorNext.jsp");
					rd.forward(request, response);
				}
				
			} else if(act.equals("viewAppointmentList")) {
				ArrayList<Appointment> appointmentList =new ArrayList<>();
				for(Appointment a:Inventory.appointmentList) {
					if(a.getDoctorId()==getDoctor().getPersonId()) {
						appointmentList.add(a);
					}
				}
				if(appointmentList.isEmpty()) {
					request.setAttribute("act", "errorDoctor");
					RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("appointmentList", appointmentList);
					request.setAttribute("act", "showAppointmentList");
					RequestDispatcher rd = request.getRequestDispatcher("DoctorNext.jsp");
					rd.forward(request, response);
				}
			}
		}
		
	}

}
