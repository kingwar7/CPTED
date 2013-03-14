package com.cpted.beans;

public abstract class AccidentBean implements Comparable<AccidentBean> {
	private String date;//?�짜
	private String categorize;//?�반, 긴급, ?�험�?��
	private String location;//경위??
	private String id;//?�송???�람
	private String content;
	private String longtitude;
	private String latitude;
	private boolean checked;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getCategorize() {
		return categorize;
	}
	public void setCategorize(String categorize) {
		this.categorize = categorize;
	}
	
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
		
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}	
	
	
	@Override
	public int compareTo(AccidentBean o) {
		  if (getDate() == null || o.getDate() == null)
		      return 0;
		    return getDate().compareTo(o.getDate());
	}
	
}