package com.cpted.model;

import com.cpted.beans.LoginBean;



public class Login {
	private LoginBean loginBean;
	
	public Login(LoginBean loginBean){
		this.loginBean=loginBean;
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}




	public boolean checkUser(){
		
		return true;
	}
	
	public boolean login(){
		//정규 표현식
		
		
		return true;
		
	}
}
