package com.cpted.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpted.beans.OrganizationBean;
import com.cpted.controller.process.CptedController;
import com.google.gson.Gson;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
		String code = request.getParameter("CODE");
		String name = request.getParameter("NAME");

		OrganizationBean organization = new OrganizationBean();
		organization.setID(id);
		organization.setPw(password);
		organization.setCode(code);
		organization.setName(name);

		int ret = CptedController.getInstance().signUp(organization);

		switch (ret) {
		case -3:
			System.out.println("ID duplicate");

			break;

		case -2:
			System.out.println("wrong code");

			break;

		case -1:

			System.out.println("signup error");

			break;

		case 0:

			System.out.println("not start");

			break;

		case 1:

			Gson gson = new Gson();
			String organizationJson = gson.toJson(organization);
			System.out.println(organizationJson);

			break;

		default:

			break;

		}

	}

}
