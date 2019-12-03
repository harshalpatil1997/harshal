package com.demo.service;

import java.util.List;

import com.demo.beans.CategoryPOJO;
import com.demo.dao.CategoryDao;
import com.demo.dao.CategoryDaoImpl;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao cd=new CategoryDaoImpl();
	public List<CategoryPOJO> getAllCategory() 
	{
		return cd.getCategory();
	}

}
