package com.cpted.model;

public class Login {
	private String id;
	private String password;
	
	public Login(String id,String password){
		this.id=id;
		this.password=password;		
	}
	
	public boolean checkUser(){
		
		return true;
	}
	
	public String getID()
	{
		return id;
		
	}
	public String getPassword()
	{
		
		return password;
	}
}
