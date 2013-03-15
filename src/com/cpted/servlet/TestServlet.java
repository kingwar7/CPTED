package com.cpted.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpted.beans.OrganizationBean;
import com.cpted.controller.process.CptedController;



/**
 * Servlet implementation class TestSerlvet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String key1=request.getParameter("id");
//		String key2=request.getParameter("pw");
//		
//		boolean loginFlag=CptedController.getInstance().login(key1, key2);
//		
//		if(loginFlag){
//			
//		}
//		else{
//			
//		}
		
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		
		
		
		OrganizationBean organization = new OrganizationBean();
		organization.setID(id);
		organization.setPw(password);
		organization.setCode(code);
		organization.setName(name);
		
		
		int ret = CptedController.getInstance().signUp(organization);
		
		
		
	}

}
