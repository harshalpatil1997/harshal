package com.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.beans.Category;
import com.training.beans.Product;

public class CategoryDaoImpl implements CategoryDao{
    static Connection conn=null;
    static PreparedStatement cAll=null;
    static PreparedStatement pAllByCat=null;
    static PreparedStatement pAdd=null;
    static PreparedStatement pById=null;
    static PreparedStatement pUpdate=null;
    static{
    	conn=MyConnection.getMyConnection();
    	try {
			cAll=conn.prepareStatement("select * from Category");
			pAllByCat=conn.prepareStatement("select * from product_acts where cid=?");
			pAdd=conn.prepareStatement("insert into product_acts(pid,pname,qty,cid) values(?,?,?,?)");
			pById=conn.prepareStatement("select * from product_acts where pid=?");
			pUpdate=conn.prepareStatement("update product_acts set pname=?,qty=?,cid=? where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	@Override
	public List<Category> getAllCategory() {
		try {
			ResultSet rs=cAll.executeQuery();
			List<Category> clist=new ArrayList<>();
			while(rs.next()) {
				Category c=new Category(rs.getInt(1),rs.getString(2),rs.getString(3));
				clist.add(c);
			}
			return clist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Product> getAllProductByCategory(int cid) {
		try {
			pAllByCat.setInt(1, cid);
			ResultSet rs=pAllByCat.executeQuery();
			List<Product> plist=new ArrayList<>();
			while(rs.next()) {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(6));
				plist.add(p);
			}
			return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int addProduct(Product p) {
		try {
			pAdd.setInt(1, p.getPid());
			pAdd.setString(2,p.getPname());
			pAdd.setInt(3, p.getQty());
			pAdd.setInt(4, p.getCid());
			return pAdd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public Product getProductById(int pid) {
		try {
			pById.setInt(1,pid);
			ResultSet rs=pById.executeQuery();
			if(rs.next()) {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(6));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateProductData(Product p) {
		try {
			pUpdate.setString(1,p.getPname());
			pUpdate.setInt(2,p.getQty());
			pUpdate.setInt(3,p.getCid());
			pUpdate.setInt(4,p.getPid());
			return pUpdate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
