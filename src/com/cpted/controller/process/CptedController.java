package com.cpted.controller.process;

import com.cpted.base.BaseController;
import com.cpted.controller.*;
import com.cpted.model.Login;

public class CptedController extends BaseController{
	private static CptedController sys=new CptedController();	
	
	private AccidentController accidentController;
	private MemberController memberController;
	private DaoController daoController;
	
	static{
		sys=new CptedController();		
		try {
			sys.initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CptedController static method error");
			e.printStackTrace();
		}
	}
	
	public void initialize() throws Exception{
		System.out.println("CptedController initialize...");
		accidentController=new AccidentController();
		memberController=new MemberController();
		daoController=new DaoController();
	}
	
	public static synchronized CptedController getInstance(){
		if (sys == null) {
			sys=new CptedController();
			System.out.println("Because sys null => CptedController initialize...");
        }
		return sys;		
	}
	
	public AccidentController getAccidentController(){
		return this.accidentController;
	}
	
	public MemberController getMemberController(){
		return this.memberController;
	}
	
	public DaoController getDaoController(){
		return this.daoController;
	}
	
	//public boolean login(String id, String pw){
//		Login login=new Login(id,pw);
//		
//		boolean flag=login.checkUser();
//		
//		if(flag){
//			return daoController.getUserDao().login(md5(id),md5(pw));
//		}
//		else{
//			return false;
//		}
	//}
	
	
	
	
	
}
