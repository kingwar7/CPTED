package com.cpted.beans;

public abstract class MemberBean {
	private String id;
	private String categorize;//?�반, 긴급, ?�험�?��
//	private String code;//경위??
	private String gcm;//?�송???�람
	private int phone;
	private int age;
	private int gender;
	private String etc;
	
	
	

	public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	
	
	public String getCategorize() {
		return categorize;
	}
	public void setCategorize(String categorize) {
		this.categorize = categorize;
	}
	
	public String getGcm() {
		return gcm;
	}
	public void setGcm(String gcm) {
		this.gcm = gcm;
	}
	
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
		
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
		
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
		
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}	
}
