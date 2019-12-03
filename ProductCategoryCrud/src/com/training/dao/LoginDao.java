package com.training.dao;

import com.training.beans.MyUser;

public interface LoginDao {
	
	public MyUser validateUser(String u, String p);
}
