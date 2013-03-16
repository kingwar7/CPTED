package com.cpted.dao;

import com.cpted.beans.OrganizationBean;

public interface OrganizationDao {
	// memberdao???�요??interface ?�언
	public boolean SignUp(OrganizationBean organization) throws Exception;

	// 로그인 id,pw검사
		public boolean checkLogin(String id, String password) throws Exception;

	// 아이디 중복
	// 중복이면 True 출력
	public boolean idDuplicate(OrganizationBean organization) throws Exception;

	// 회원정보 수정
	// code는 바꿀 수 없다.
	public boolean updateOrganization(OrganizationBean organization)
			throws Exception;

	// 회원정보 삭제
	// code는 바꿀 수 없다.
	public boolean deleteOrganization(OrganizationBean organization)
			throws Exception;
	
	public String getCenterIDx(String id, String password)throws Exception;

}
