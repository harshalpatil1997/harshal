package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.CategoryPOJO;
import com.mysql.cj.protocol.Resultset;

public class CategoryDaoImpl implements CategoryDao
{
	static PreparedStatement csel=null;
	static Connection conn=null;
	static
	{
		
		try {
			conn=MyConnection.getMyConnection();
			csel=conn.prepareStatement("select * from category");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<CategoryPOJO> getCategory() {
		ResultSet rs;
		try {
			rs = csel.executeQuery();
			List<CategoryPOJO> clist=new ArrayList<>();
			while(rs.next())
			{
				CategoryPOJO c=new CategoryPOJO(rs.getInt(1), rs.getString(2));
				clist.add(c);
			}
			return clist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
}
