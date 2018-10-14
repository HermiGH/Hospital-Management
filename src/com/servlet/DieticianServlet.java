package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Dietician;
import com.pojo.LabTechnician;
import com.pojo.Patient;

/**
 * Servlet implementation class DieticianServlet
 */
//@WebServlet("/DieticianController")
public class DieticianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Dietician diet = new Dietician();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DieticianServlet() {
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
		if(act.equals("Dietician")) {
			request.setAttribute("act", "Dietician");
			RequestDispatcher rd = request.getRequestDispatcher("Dietician.jsp");
			rd.forward(request, response);
		} else if(act.equals("diet")) {
			request.setAttribute("dietList", Dietician.dieticianList);
			request.setAttribute("act", "diet");
			RequestDispatcher rd = request.getRequestDispatcher("Dietician.jsp");
			rd.forward(request, response);
		} else if(act.equals("Diet Patient")) {
			int patientId = Integer.parseInt(request.getParameter("personId"));
			diet.alotDietPlan(Patient.getPatientById(patientId));
			request.setAttribute("act", "Dietician");
			RequestDispatcher rd = request.getRequestDispatcher("Dietician.jsp");
			rd.forward(request, response);
		} else if(act.equals("Go Home")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(act.equals("Go Back")) {
			request.setAttribute("act", "Dietician");
			RequestDispatcher rd = request.getRequestDispatcher("Dietician.jsp");
			rd.forward(request, response);
		}
	}

}
