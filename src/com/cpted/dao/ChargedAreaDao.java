package com.cpted.dao;

import java.util.ArrayList;

import com.cpted.beans.ChargedAreaBean;

public interface ChargedAreaDao {
	//센터 아이디에 따른 적용된 담당구역
	public ArrayList<ChargedAreaBean> GetCheckedChagedAreaList() throws Exception;
	
	//센터 아이디에 따른 모든 담당구역
	public ArrayList<ChargedAreaBean> GetAllChagedAreaList() throws Exception ;
	
	//담당 구역 추가
	public void AddChagedArea(String name, String top, String bottom , String left , String right ) throws Exception;
	
	// 여러담당구역 중 식별자(아이디)에 따른 담당구역 
	public ChargedAreaBean GetChargedArea(int id) throws Exception;
	
	// 담당구역 수정
	public void ModifyChagedArea(int id , String name, String top, String bottom , String left , String right, int checked) throws Exception;
	
	
 // 담당구역 삭제
 	public void RemoveChagedArea(ChargedAreaBean chargedArea) throws Exception;
 	
	
}
