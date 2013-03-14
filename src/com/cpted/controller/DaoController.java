package com.cpted.controller;

import com.cpted.dao.AccidentDao;
import com.cpted.dao.AccidentDaoImplement;

public class DaoController {
	private AccidentDao accidentDao;
	
	public DaoController(){
		accidentDao=new AccidentDaoImplement();		
	}
	
	public AccidentDao getAccidentDao(){
		return accidentDao;		
	}
}
