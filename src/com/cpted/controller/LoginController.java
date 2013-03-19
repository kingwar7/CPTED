package com.cpted.controller;

import com.cpted.beans.LoginBean;
import com.cpted.model.Login;

public class LoginController {
	private DaoController daoController;
	
	
	
	
	public DaoController getDaoController() {
		return daoController;
	}




	public void setDaoController(DaoController daoController) {
		this.daoController = daoController;
	}




	public boolean login(LoginBean loginBean) throws Exception{
		Login login =new Login(loginBean);
		boolean flag=login.login();
		
		if(flag){
			return daoController.getOrganizationDao().checkLogin(
				loginBean.getId(), loginBean.getPassword());
		}
		else{
			return false;
		}
		//Login login=new Login(login);
		
		
	}
}
