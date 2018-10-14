package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.Inventory;
import com.pojo.Dietician;
import com.pojo.LabTechnician;
import com.pojo.Messenger;

/**
 * Servlet implementation class InventoryServlet
 */
//@WebServlet("/InventoryController")
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryServlet() {
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
		String act = (String) request.getAttribute("act");
		if(act==null) {
			act=request.getParameter("act");
		}
		if(act.equals("Go Home")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(act.equals("Go Back") || act.equals("Inventory")) {
			request.setAttribute("act", "Inventory");
			RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
			rd.forward(request, response);
		} else if(act.equals("viewPatient")) {
			request.setAttribute("patientList", Inventory.patientList);
			request.setAttribute("act", "viewPatient");
			RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
			rd.forward(request, response);
		} else if(act.equals("viewDoctor")) {
			//System.out.println("viewDoctor");
			request.setAttribute("doctorList", Inventory.doctorList);
			request.setAttribute("act", "viewDoctor");
			RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
			rd.forward(request, response);
		}else if(act.equals("viewAppointment")) {
			//System.out.println("appointment");
			request.setAttribute("appointmentList", Inventory.appointmentList);
			request.setAttribute("act", "viewAppointment");
			RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
			rd.forward(request, response);
		}else if(act.equals("viewPatientShift")) {
			//System.out.println("appointment");
			request.setAttribute("shiftPatientList", Messenger.shiftPatientList);
			request.setAttribute("act", "viewPatientShift");
			RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
			rd.forward(request, response);
		}else if(act.equals("viewPatientMedicine")) {
			//System.out.println("appointment");
			request.setAttribute("medicinePatientList", Messenger.medicinePatientList);
			request.setAttribute("act", "viewPatientMedicine");
			RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
			rd.forward(request, response);
		}else if(act.equals("viewPatientDiet")) {
			//System.out.println("appointment");
			request.setAttribute("dieticianList", Dietician.dieticianList);
			request.setAttribute("act", "viewPatientDiet");
			RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
			rd.forward(request, response);
		}else if(act.equals("viewPatientTest")) {
			//System.out.println("appointment");
			request.setAttribute("testPatientList", LabTechnician.testPatientList);
			request.setAttribute("act", "viewPatientTest");
			RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
			rd.forward(request, response);
		}
	}

}
