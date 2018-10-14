package com.servlet;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.data.Inventory;
import com.pojo.Appointment;
import com.pojo.Patient;
import com.pojo.ReceptionistPojo;

/**
 * Servlet implementation class Receptionist
 */
//@WebServlet("/Receptionist")
public class Receptionist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Receptionist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("act").equals("Submit Patient Details")) {
			String name = (String) request.getParameter("name");
			String nationality = (String) request.getParameter("nationality");
			String bloodGroup =  (String) request.getParameter("bloodGroup");
			String insurance =  (String) request.getParameter("insurance");
			Patient patient = new Patient(name, new GregorianCalendar(2013,5,31), nationality, bloodGroup, insurance);
			Inventory.patientList.add(patient);
			response.sendRedirect("Receptionist.jsp");
		} else if (request.getParameter("act").equals("Submit Appointment")) {
			int department = Integer.parseInt(request.getParameter("department"));
			int patientId = Integer.parseInt(request.getParameter("patientId"));
			Patient patient = Patient.getPatientById(patientId);
			ReceptionistPojo receptionist = new ReceptionistPojo();
			//System.out.println("Receptionist scheduling patient appointment");
			Appointment appointment = receptionist.getInPatientAppointment(patient, department);
			Inventory.appointmentList.add(appointment);
			response.sendRedirect("Receptionist.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("act");
		//System.out.println(name);
		if(name.equals("patient")) {
			request.setAttribute("act", "patient");
			RequestDispatcher rd = request.getRequestDispatcher("ReceptionistNext.jsp");
			rd.forward(request, response);
		}else if(name.equals("appointment")) {
			//System.out.println("appointment");
			request.setAttribute("act", "appointment");
			RequestDispatcher rd = request.getRequestDispatcher("ReceptionistNext.jsp");
			rd.forward(request, response);
		}else if(name.equals("viewPatient")) {
			//System.out.println("viewPatient");
			request.setAttribute("patientList", Inventory.patientList);
			request.setAttribute("act", "viewPatient");
			RequestDispatcher rd = request.getRequestDispatcher("ReceptionistNext.jsp");
			rd.forward(request, response);
		}else if(name.equals("viewDoctor")) {
			//System.out.println("viewDoctor");
			request.setAttribute("doctorList", Inventory.doctorList);
			request.setAttribute("act", "viewDoctor");
			RequestDispatcher rd = request.getRequestDispatcher("ReceptionistNext.jsp");
			rd.forward(request, response);
		}else if(name.equals("Go Back")) {
			request.setAttribute("act", "Go Back");
			RequestDispatcher rd = request.getRequestDispatcher("Receptionist.jsp");
			rd.forward(request, response);
		}else if(name.equals("Go Home")) {
			request.setAttribute("act", "Go Home");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else if(name.equals("viewAppointment")) {
			//System.out.println("viewAppointment");
			request.setAttribute("appointmentList", Inventory.appointmentList);
			request.setAttribute("act", "viewAppointment");
			RequestDispatcher rd = request.getRequestDispatcher("ReceptionistNext.jsp");
			rd.forward(request, response);
		}
		
	}

}
