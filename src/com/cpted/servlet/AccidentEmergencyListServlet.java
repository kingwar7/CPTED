package com.cpted.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cpted.beans.AccidentEmergency;
import com.cpted.controller.process.CptedController;

/**
 * Servlet implementation class AccidentEmergencyListServlet
 */
public class AccidentEmergencyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccidentEmergencyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String center_id = (String)session.getAttribute("CENTED_ID");
		if(center_id!=null)
		{
			List<AccidentEmergency> accidentEmergencylist = CptedController.getInstance().GetUncheckedAccidentEmegencyList(center_id);

			request.setAttribute("AccidentEmergencylist", accidentEmergencylist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/receiveAccident.jsp");
			
			dispatcher.forward(request, response);
		}
		else
		{
			System.out.println("no center_id in accidentemergencylist");
			
		}
//		String a = accidentEmergencylist.get(2).getLongitude();
//		double ab = Double.parseDouble(a);
//		 a = accidentEmergencylist.get(1).getLongtitude();
//		 ab = Double.parseDouble(a);
//		 a = accidentEmergencylist.get(0).getLongtitude();
//		 ab = Double.parseDouble(a);
//		 a = accidentEmergencylist.get(3).getLongtitude();
//		 ab = Double.parseDouble(a);
				
	}

}
