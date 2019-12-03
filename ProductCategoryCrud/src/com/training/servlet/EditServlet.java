package com.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.beans.Product;
import com.training.service.CategoryService;
import com.training.service.CategoryServiceImpl;

public class EditServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("pid"));
		CategoryService cs=new CategoryServiceImpl();
		Product p=cs.getProductById(pid);
		out.println("<form action='updateProduct'>");
		out.println("Pid : <input type='hidden' name='pid' value='"+p.getPid()+"'>");
		out.println("Product Name: <input type='text' name='pname' value='"+p.getPname()+"'>");
		out.println("Quantity : <input type='text' name='pqty' value='"+p.getQty()+"'>");
		out.println("Category Id : <input type='text' name='cid' value='"+p.getCid()+"'>");
		out.println(" <input type='submit' name='btn' value='Update Product'>");
		out.println("</form>");
	}
}
