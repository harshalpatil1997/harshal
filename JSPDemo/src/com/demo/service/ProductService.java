package com.demo.service;

import java.util.List;

import com.demo.beans.ProductPOJO;

public interface ProductService {

	public List<ProductPOJO> getProducts(int cid);
	public ProductPOJO getProductById(int pid);
	public boolean updateProduct(int pid,int qty,int prc);
		
}
