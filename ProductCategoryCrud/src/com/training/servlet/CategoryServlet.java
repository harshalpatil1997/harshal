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

import com.training.beans.Category;
import com.training.service.CategoryService;
import com.training.service.CategoryServiceImpl;

public class CategoryServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession sess=request.getSession();
		CategoryService cs=new CategoryServiceImpl();
		String nm=(String)sess.getAttribute("uname");
		if(nm!=null) {
		   out.println("Welcome "+nm);
		   List<Category> cList=cs.getAllCategory();
		   out.println("<form action='save'>");
		   out.println("<select name='cat'>");
		   for(Category c:cList) {
			  out.println("<option value='"+c.getCid()+"'>"+c.getcName()+"</option>");
		   }
		   out.println("</select>");
		   out.println("<input type='submit' name='btn' value='Submit'>");
		   out.println("</form>");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			out.println("<h3>please re-enter credential..</h3>");
			rd.include(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		doGet(request,response);
	}

}
