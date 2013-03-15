package com.cpted.controller.process;

import com.cpted.base.BaseController;
import com.cpted.beans.OrganizationBean;
import com.cpted.controller.*;
import com.cpted.model.Login;

public class CptedController extends BaseController {
	private static CptedController sys = new CptedController();

	private AccidentController accidentController;
	private MemberController memberController;
	private DaoController daoController;

	static {
		sys = new CptedController();
		try {
			sys.initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CptedController static method error");
			e.printStackTrace();
		}
	}

	public void initialize() throws Exception {
		System.out.println("CptedController initialize...");
		accidentController = new AccidentController();
		memberController = new MemberController();
		daoController = new DaoController();
	}

	public static synchronized CptedController getInstance() {
		if (sys == null) {
			sys = new CptedController();
			System.out
					.println("Because sys null => CptedController initialize...");
		}
		return sys;
	}

	public AccidentController getAccidentController() {
		return this.accidentController;
	}

	public MemberController getMemberController() {
		return this.memberController;
	}

	public DaoController getDaoController() {
		return this.daoController;
	}

	// return -2 => code error
	// return -1 => signup error
	// return 1 => ok
	// return -3 => idduplicate
	public int signUp(OrganizationBean organization) {

		int ret = 0;
		try {
			boolean checkedCode = daoController.getCentercodeDao()
					.CheckOrganizationAuthCode(organization.getCode());

			if (checkedCode) {

				if (daoController.getOrganizationDao()
						.idDuplicate(organization)) {
					// 아이디 중복
					ret = -3;
				} else {

					if (daoController.getOrganizationDao().SignUp(
							organization)) {
						ret = 1;
						// 회원가입됨
					} else {

						ret = -1;
						// 실패 
					}
				}
			} else {
				ret = -2;
				// 코드 불일치

			}

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return ret;

	}
	
	

}
