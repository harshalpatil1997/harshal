package com.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.beans.Product;
import com.training.service.CategoryService;
import com.training.service.CategoryServiceImpl;

public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		int pqty=Integer.parseInt(request.getParameter("pqty"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		Product p=new Product(pid,pname,pqty,cid);
		CategoryService cs=new CategoryServiceImpl();
		int n=cs.addProduct(p);
		RequestDispatcher rd=request.getRequestDispatcher("product");
		rd.forward(request,response);
	}

}
