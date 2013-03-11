package com.cpted.model;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cpted.controller.process.CptedController;

public class InitializeProcess implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		CptedController.getInstance();
	}

}
