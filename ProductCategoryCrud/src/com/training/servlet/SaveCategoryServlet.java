package com.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveCategoryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cat"));
		HttpSession sess=request.getSession();
		sess.setAttribute("catid",cid);
		RequestDispatcher rd=request.getRequestDispatcher("product");
		rd.forward(request, response);
	}

}
