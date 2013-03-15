package com.cpted.beans;

public class ChargedAreaBean {
	
//	private int id;
	private double top;
	private double left;
	private double right;
	private double bottom;
	private int checked;
	private int center_idx;
	private String name;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	public int getID() {
//		return id;
//	}
//	public void setID(int id) {
//		this.id = id;
//	}
	
	public double getTop() {
		return top;
	}
	public void setTop(double top) {
		this.top = top;
	}
	
	public double getLeft() {
		return left;
	}
	public void setLeft(double left) {
		this.left = left;
	}
	
	public double getRight() {
		return right;
	}
	public void setRight(double right) {
		this.left = right;
	}
	
	public double getBottom() {
		return bottom;
	}
	public void setBottom(double bottom) {
		this.bottom = bottom;
	}

	public int getCenterID() {
		return center_idx;
	}
	
	public void setCenterID(int center_idx) {
		this.center_idx = center_idx;
	}

	public int getCheck() {
		return checked;
	}
	public void setCheck(int checked) {
		this.checked = checked;
	}
}
