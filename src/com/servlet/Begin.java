package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Begin
 */
public class Begin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Begin() {
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
		response.setContentType("text/html");
		String name = request.getParameter("checkBox");
		System.out.println(name);
		if(name.equals("Receptionist")) {
			//System.out.println("Receptionist");
			RequestDispatcher rd = request.getRequestDispatcher("Receptionist.jsp");
			rd.forward(request, response);
		}else if(name.equals("Doctor")) {
			//System.out.println("Doctor");
			request.setAttribute("doctor", "Doctor");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(name.equals("Submit Doctor Id")) {
			//System.out.println("Doctor");
			//System.out.println(request.getParameter("doctorId"));
			request.setAttribute("doctorId", request.getParameter("doctorId"));
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/DoctorController");
			rd.forward(request, response);
			
			//response.sendRedirect("/DoctorController");
		} else if(name.equals("Nurse")) {
			//System.out.println("Nurse");
			request.setAttribute("act", "Nurse");
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/NurseController");
			rd.forward(request, response);
		} else if(name.equals("Messenger")) {
			//System.out.println("Nurse");
			request.setAttribute("act", "Messenger");
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/MessengerController");
			rd.forward(request, response);
		}  else if(name.equals("Inventory")) {
			//System.out.println("Nurse");
			request.setAttribute("act", "Inventory");
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/InventoryController");
			rd.forward(request, response);
		} else if(name.equals("LabTech")) {
			//System.out.println("Nurse");
			request.setAttribute("act", "LabTech");
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/LabTechnicianController");
			rd.forward(request, response);
		}  else if(name.equals("Dietician")) {
			//System.out.println("Nurse");
			request.setAttribute("act", "Dietician");
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/DieticianController");
			rd.forward(request, response);
		} 
	}

}
