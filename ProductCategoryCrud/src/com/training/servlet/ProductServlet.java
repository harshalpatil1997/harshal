package com.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.beans.Product;
import com.training.service.CategoryService;
import com.training.service.CategoryServiceImpl;

public class ProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession sess=request.getSession();
		int cid=(Integer)sess.getAttribute("catid");
		System.out.println(cid);
		String nm=(String)sess.getAttribute("uname");
		CategoryService cs=new CategoryServiceImpl();
		if(nm!=null) {
			List<Product> pList=cs.getAllProductsByCategory(cid);
			if(pList!=null) {
				out.println("Welcome "+nm);
				out.println("<table border='2'>");
				for(Product p:pList) {
				out.println("<tr>");
				out.println("<td>"+p.getPid()+"</td>");
				out.println("<td>"+p.getPname()+"</td>");
				out.println("<td>"+p.getQty()+"</td>");
				out.println("<td><a href='deletep?pid="+p.getPid()+"'>delete</a>/<a href='edit?pid="+p.getPid()+"'>edit</a></td>");
				out.println("</tr>");
				}
				out.println("</table>");
				out.println("<a href='AddProduct.html'>Add Product</a>");
				
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			out.println("<h3>please re-enter credential..</h3>");
			rd.include(request, response);
		}
		
	}

}
