package com.demo.service;

import com.demo.beans.MyEmployee;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	LoginDao ldao=new LoginDaoImpl();
	@Override
	public boolean loginValidation(String nm, String pass) {
	
MyEmployee e= ldao.Validate(nm, pass);
		
		if(e!=null &&  nm.equals(e.getName()) && pass.equals(e.getPass()))
		{
			return true;
		}
		
		return false;
	}
	}


