package com.training.service;

import java.util.List;

import com.training.beans.Category;
import com.training.beans.Product;
import com.training.dao.CategoryDao;
import com.training.dao.CategoryDaoImpl;

public class CategoryServiceImpl implements CategoryService{

	CategoryDao cdao;
	
	public CategoryServiceImpl() {
		cdao=new CategoryDaoImpl();
	}

	@Override
	public List<Category> getAllCategory() {
		return cdao.getAllCategory();
		
	}

	@Override
	public List<Product> getAllProductsByCategory(int cid) {
		return cdao.getAllProductByCategory(cid);
		
	}

	@Override
	public int addProduct(Product p) {
		return cdao.addProduct(p);
	}

	@Override
	public Product getProductById(int pid) {
		return cdao.getProductById(pid);
		
	}

	@Override
	public int updateProduct(Product p) {
		return cdao.updateProductData(p);
	}

}
