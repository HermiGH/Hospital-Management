package com.servlet;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.Inventory;
import com.pojo.Appointment;
import com.pojo.Nurse;
import com.pojo.Patient;

/**
 * Servlet implementation class NurseServlet
 */
//@WebServlet("/NurseController")
public class NurseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Nurse nurse = new Nurse("Gladis",new GregorianCalendar(1992,1,30),"Indian","A+","12111");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NurseServlet() {
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
		String act=(String)request.getAttribute("act");
		if(act==null) {
			act=request.getParameter("act");
		}
		//System.out.println("nURSE ACT "+act);
		if(act.equals("Nurse")) {
			request.setAttribute("act", "nurse");
			RequestDispatcher rd = request.getRequestDispatcher("Nurse.jsp");
			rd.forward(request, response);
		} else if(act.equals("checkInPatient")) {
			////System.out.println("hello from CheckInPatient");
			request.setAttribute("act", "checkInPatientAct");
			request.setAttribute("patientList",Nurse.myPatientList);
			////System.out.println("nurse size "+Nurse.myPatientList.size());
			
			if(Nurse.myPatientList.isEmpty()||Nurse.myPatientList.size()==0) {
				request.setAttribute("act", "Nurse");
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Nurse.jsp");
				rd.forward(request, response);
			}
			
		} else if(act.equals("Check In Patient")) {
			int patientId =Integer.parseInt(request.getParameter("personId"));
			////System.out.println("patient to check in "+patientId);
			Patient.getPatientById(patientId);
			Iterator<Patient> it = Nurse.myPatientList.iterator();
			boolean found=false;
			while(it.hasNext()){
				Patient a =it.next();
				if(a.getPersonId()==patientId) {
					////System.out.println("found patient to delete");
					nurse.checkInPatient(a);
					it.remove();
					found=true;
					break;
				}
			} 
			if(found==false &&(Nurse.myPatientList.isEmpty()||Nurse.myPatientList.size()==0)) {
				request.setAttribute("act", "Nurse");
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("act", "nurse");
				RequestDispatcher rd = request.getRequestDispatcher("Nurse.jsp");
				rd.forward(request, response);
			}
			
			//request.setAttribute("act", "nurse");
			
		}else if(act.equals("Go Home")) {
			//request.setAttribute("act", "nurse");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		//doGet(request, response);
	}

}
