package com.cpted.model;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.cpted.beans.DBConnectionPool;

public class InitializeDBConnection implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext Destoryed.....!!");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		
		System.out.println("contextInitialized : "+driver+":"+url+":"+user+":"+password);
		
		DBConnectionPool cp=DBConnectionPool.getInstance();
		cp.driverLoading(driver,url,user,password);
		
		System.out.println("ServletContext Initialized.....^^");
	}

}
