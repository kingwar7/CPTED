package com.cpted.beans;

public class OrganizationBean {
	private String id;
	private String pw;
	private String code;
	private String name;
	private String etc;
//	private int center_idx;
		
	
	public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
//	public int getCenterID() {
//		return center_idx;
//	}
//	public void setCenterID(int CenterID) {
//		this.center_idx = CenterID;
//	}
}
