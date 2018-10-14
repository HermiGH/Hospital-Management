package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.LabTechnician;
import com.pojo.Messenger;
import com.pojo.Patient;

/**
 * Servlet implementation class LabTechnicianServlet
 */
//@WebServlet(name = "LabTechnicianController", urlPatterns = { "/LabTechnicianController" })
public class LabTechnicianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      LabTechnician labTech = new LabTechnician();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabTechnicianServlet() {
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
		if(act.equals("LabTech")) {
			request.setAttribute("act", "LabTech");
			RequestDispatcher rd = request.getRequestDispatcher("LabTech.jsp");
			rd.forward(request, response);
		} else if(act.equals("test")) {
			request.setAttribute("testList", LabTechnician.testPatientList);
			request.setAttribute("act", "test");
			RequestDispatcher rd = request.getRequestDispatcher("LabTech.jsp");
			rd.forward(request, response);
		} else if(act.equals("Test Patient")) {
			int patientId = Integer.parseInt(request.getParameter("personId"));
			labTech.testBloodSample(Patient.getPatientById(patientId));
			request.setAttribute("act", "LabTech");
			RequestDispatcher rd = request.getRequestDispatcher("LabTech.jsp");
			rd.forward(request, response);
		} else if(act.equals("Go Home")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(act.equals("Go Back")) {
			request.setAttribute("act", "LabTech");
			RequestDispatcher rd = request.getRequestDispatcher("LabTech.jsp");
			rd.forward(request, response);
		} 
	}

}
