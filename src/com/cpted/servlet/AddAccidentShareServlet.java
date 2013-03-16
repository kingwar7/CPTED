package com.cpted.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpted.beans.AccidentGeneral;
import com.cpted.beans.AccidentShare;
import com.cpted.controller.process.CptedController;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddAccidentShareServlet
 */
public class AddAccidentShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccidentShareServlet() {
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

		// 영웅이 폰 넘버를 보내줄 경우 폰으로 USERID를 찾는다.

		// user_idx를 보내주면 바로 넣으면 된다

		String datetime = request.getParameter("DATETIME");
		String longtitude = request.getParameter("LONGTITUDE");
		String latitude = request.getParameter("LATITUDE");
		String image = request.getParameter("IMAGE");
		String content = request.getParameter("CONTENT");
		String degree = request.getParameter("DEGREE");
		String userid = request.getParameter("USERID");
		
		if(datetime != null && longtitude != null && latitude != null && degree != null && userid  != null)
		{
		
			AccidentShare accidentShare = new AccidentShare();
			accidentShare.setDate(datetime);
			accidentShare.setCategorize("0");
			accidentShare.setLongtitude(longtitude);
			accidentShare.setLatitude(latitude);
			accidentShare.setPhoto(image);
			accidentShare.setContent(content);
			accidentShare.setDegree(degree);
			accidentShare.setChecked(0);
			accidentShare.setUserid(userid);
	
			if(CptedController.getInstance().AddAccidentShare(
					accidentShare))
			{
				
				
				Gson gson = new Gson();
				String addAccidentGeneralJson = gson.toJson(accidentShare);
				System.out.println(addAccidentGeneralJson);
			}
			else
			{
				
				System.out.println("add accidentgeneral");
			}
		}
		else
		{
			System.out.println("add accidentgeneral");
		}
	}

}