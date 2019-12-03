package com.demo.dao;

import java.util.List;

import com.demo.beans.ProductPOJO;

public interface ProductDao {

	public List<ProductPOJO> getProduct(int cid);
	ProductPOJO getProductById(int pid);
	public boolean update(int pid,int qty, int prc);
	

}
