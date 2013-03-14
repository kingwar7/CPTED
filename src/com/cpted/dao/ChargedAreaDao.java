package com.cpted.dao;

import java.util.ArrayList;

import com.cpted.beans.ChargedAreaBean;

public interface ChargedAreaDao {
	public ArrayList<ChargedAreaBean> GetCheckedChagedAreaList() throws Exception;
	public ArrayList<ChargedAreaBean> GetAllChagedAreaList() throws Exception ;
	public void AddChagedArea(String name, String top, String bottom , String left , String right ) throws Exception;
	// 아이디에 따른 담당구역 
	public ChargedAreaBean GetChargedArea(int id) throws Exception;
	
}
