package com.cpted.model;

public class Login {
	private String id;
	private String pw;
	
	public Login(String id,String pw){
		this.id=id;
		this.pw=pw;		
	}
	
	public boolean checkUser(){
		
		return true;
	}
}
