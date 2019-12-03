package com.training.service;

import java.util.List;

import com.training.beans.Category;
import com.training.beans.Product;

public interface CategoryService {
	List<Category> getAllCategory();

	List<Product> getAllProductsByCategory(int cid);

	int addProduct(Product p);

	Product getProductById(int pid);

	int updateProduct(Product p);

}
