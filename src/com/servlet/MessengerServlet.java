package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Messenger;
import com.pojo.Patient;

/**
 * Servlet implementation class MessengerServlet
 */
//@WebServlet("/MessengerController")
public class MessengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Messenger messenger = new Messenger();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessengerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=(String) request.getAttribute("act");
		if(act==null) {
			act=request.getParameter("act");
		}
		if(act.equals("Messenger")) {
			request.setAttribute("act", "Messenger");
			RequestDispatcher rd = request.getRequestDispatcher("Messenger.jsp");
			rd.forward(request, response);
		} else if(act.equals("shift")) {
			request.setAttribute("shiftList", Messenger.shiftPatientList);
			request.setAttribute("act", "showShift");
			RequestDispatcher rd = request.getRequestDispatcher("Messenger.jsp");
			rd.forward(request, response);
		} else if(act.equals("Shift Patient")) {
			int patientId = Integer.parseInt(request.getParameter("personId"));
			messenger.shiftPatient(Patient.getPatientById(patientId));
			request.setAttribute("act", "Messenger");
			RequestDispatcher rd = request.getRequestDispatcher("Messenger.jsp");
			rd.forward(request, response);
		} else if(act.equals("getMedicine")) {
			request.setAttribute("medicineList", Messenger.medicinePatientList);
			request.setAttribute("act", "showMedicine");
			RequestDispatcher rd = request.getRequestDispatcher("Messenger.jsp");
			rd.forward(request, response);
		} else if(act.equals("Get Medicine Patient")) {
			int patientId = Integer.parseInt(request.getParameter("personId"));
			messenger.getMedcine(Patient.getPatientById(patientId));
			request.setAttribute("act", "Messenger");
			RequestDispatcher rd = request.getRequestDispatcher("Messenger.jsp");
			rd.forward(request, response);
		} else if(act.equals("Go Home")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(act.equals("Go Back")) {
			request.setAttribute("act", "Messenger");
			RequestDispatcher rd = request.getRequestDispatcher("Messenger.jsp");
			rd.forward(request, response);
		} 
	}

}
