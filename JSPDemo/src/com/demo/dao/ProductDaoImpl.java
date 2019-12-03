package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.ProductPOJO;

public class ProductDaoImpl implements ProductDao{

	static PreparedStatement psel=null;
	static PreparedStatement pbyid=null;
	static PreparedStatement pupd=null;
	static Connection conn=null;
	static
	{
		
		try {
			conn=MyConnection.getMyConnection();
			psel=conn.prepareStatement("select * from product_pract where cid=?");
			pbyid=conn.prepareStatement("select * from product_pract where pid=?");
			pupd=conn.prepareStatement("update product_pract set quantity=?,price=? where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<ProductPOJO> getProduct(int cid) {
		try {
			psel.setInt(1,cid);
			ResultSet rs=psel.executeQuery();
			List<ProductPOJO> plist=new ArrayList<>();
			while(rs.next())
			{
				plist.add(new ProductPOJO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(5),rs.getInt(4)));
			}
			return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductPOJO getProductById(int pid) {
		try {
			pbyid.setInt(1, pid);
			ResultSet rs=pbyid.executeQuery();
			if(rs.next())
			{
				return new ProductPOJO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(5),rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(int pid,int qty, int prc) {
		try {
			pupd.setInt(1,qty);
			pupd.setInt(2,prc);
			pupd.setInt(3,pid);
			int n=pupd.executeUpdate();
			if(n>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}

}
