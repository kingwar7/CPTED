package com.cpted.controller;

import com.cpted.dao.AccidentDao;
import com.cpted.dao.AccidentDaoImplement;
import com.cpted.dao.CentercodeDao;
import com.cpted.dao.CentercodeDaoImplement;
import com.cpted.dao.OrganizationDao;
import com.cpted.dao.OrganizationDaoImplement;

public class DaoController {
	private AccidentDao accidentDao;
	private OrganizationDao organizationDao;
	private CentercodeDao centercodeDao;
	
	public DaoController(){
		accidentDao=new AccidentDaoImplement();		
		organizationDao = new OrganizationDaoImplement();
		centercodeDao = new CentercodeDaoImplement();
	}
	
	public AccidentDao getAccidentDao(){
		return accidentDao;		
	}
	
	
	public OrganizationDao getOrganizationDao(){
		
		return organizationDao;
	}
	
	public CentercodeDao getCentercodeDao(){
		
		
		return centercodeDao;
		
	}
	
	
	
}
