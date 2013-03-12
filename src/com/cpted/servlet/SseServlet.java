package com.cpted.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpted.controller.process.CptedController;

/**
 * Servlet implementation class SseServlet
 */
public class SseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SseServlet() {
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
		String param=request.getParameter("param");
		System.out.println("SseServelt come & param : "+param);
		
		
		//param으로 분기하여 원하는 데이터 만들어 와서 아래의 serverData에 json data 넣기
		try {
			ArrayList aaa=CptedController.getInstance().getDaoController().getAccidentDao().LoadAccidentAllCurrent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setCharacterEncoding("utf8");
		response.setContentType("text/event-stream; charset=UTF-8");		
		
		PrintWriter out = response.getWriter();
		
		String serverData="123123123";
		
		
		out.print("retry: 10000\n"); //10초 타임아웃
		out.print("data: {" + serverData + "}\n\n");  
		out.flush();  
		out.close();
	}

}
