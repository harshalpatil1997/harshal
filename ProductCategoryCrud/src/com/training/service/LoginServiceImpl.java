package com.training.service;

import com.training.beans.MyUser;
import com.training.dao.LoginDao;
import com.training.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

		private LoginDao ldao;
		
	public LoginServiceImpl() {
			super();
			this.ldao = new LoginDaoImpl();
		}

	@Override
	public boolean validate(String u, String p) {
			MyUser u1 =ldao.validateUser(u,p);
			System.out.println("User in service"+u1);
			if(u1!=null) {
				return true;
			}
		return false;
	}

		
}
