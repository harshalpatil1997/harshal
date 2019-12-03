package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyEmployee;


public class LoginDaoImpl implements LoginDao
{
	public static Connection conn=null;
	public static PreparedStatement psel=null;
	static {
		
		try {
			conn=MyConnection.getMyConnection();
			psel=conn.prepareStatement("select * from Employee where uname=? and pass=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MyEmployee Validate(String nm, String pass) {
		try {
			psel.setString(1, nm);
			psel.setString(2, pass);
			ResultSet rs=psel.executeQuery();
			if(rs.next())
			{
				return new MyEmployee(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return null;
	}

}
