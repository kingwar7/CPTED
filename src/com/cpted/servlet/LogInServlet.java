package com.cpted.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cpted.beans.LoginBean;
import com.cpted.controller.process.CptedController;
import com.cpted.model.Login;
import com.google.gson.Gson;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
		LoginBean loginBean = new LoginBean(id,password);
		
		if(CptedController.getInstance().checklogIn(loginBean))
		{
			String centeridx = CptedController.getInstance().getCenterIDx(loginBean);
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_ID", loginBean.getId());
			session.setAttribute("CENTED_ID", centeridx);
		
			Gson gson = new Gson();
			String loginJson = gson.toJson(loginBean);
			System.out.println(loginJson);
		}
		else
		{	
			System.out.println("Login fail");
		}
	}

}
