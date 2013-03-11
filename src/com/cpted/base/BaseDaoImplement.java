package com.cpted.base;

import java.util.List;

import org.apache.log4j.Logger;

public class BaseDaoImplement implements BaseDao{
	//기본 베이??dao 구현
	protected final Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void insert() throws Exception {
		// TODO Auto-generated method stub
		try{
			
			
		}
		catch(Exception e){
			logger.error("BaseDaoImplement : "+e.toString());
			throw e;
		}
	}

	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		try{
			
			
		}
		catch(Exception e){
			logger.error("BaseDaoImplement : "+e.toString());
			throw e;
		}
	}

	@Override
	public void delete() throws Exception {
		// TODO Auto-generated method stub
		try{
			
			
		}
		catch(Exception e){
			logger.error("BaseDaoImplement : "+e.toString());
			throw e;
		}
	}
/*
	@Override
	public Object getQueryForObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQueryForString() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getQueryForList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
}
