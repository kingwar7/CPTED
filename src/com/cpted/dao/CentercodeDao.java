package com.cpted.dao;

public interface CentercodeDao {
	    // 기관 인증 코드 식별
		public boolean CheckOrganizationAuthCode(String code) throws Exception;
}
