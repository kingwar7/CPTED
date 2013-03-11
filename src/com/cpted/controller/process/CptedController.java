package com.cpted.controller.process;

import com.cpted.base.BaseController;
import com.cpted.controller.*;

public class CptedController extends BaseController{
	private static CptedController sys=new CptedController();	
	
	private AccidentController accidentController;
	private MemberController memberController;
	
	
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
	
	
}
