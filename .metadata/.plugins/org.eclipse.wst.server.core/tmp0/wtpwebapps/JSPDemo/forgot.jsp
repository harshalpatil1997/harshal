<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.demo.service.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name=request.getParameter("name");
	String pass=request.getParameter("pass");
	if(name.equals("admin") && pass.equals("admin"))
	{
		
	}
		
	/* LoginService ls=new LoginServiceImpl();
	boolean ans=ls.loginValidation(name,pass);
	if(ans)
	{
		 session=request.getSession();
		 if(session.isNew()) {
			session.setAttribute("name",name);
		}
		out.println("login successfull");
		RequestDispatcher rd= request.getRequestDispatcher("category");
		rd.forward(request, response);
	}
	else
	{
		out.println("Please re-enter the credentials");
		RequestDispatcher rd1= request.getRequestDispatcher("index.html");
		rd1.include(request, response);
	}
	 */	
%>

</body>
</html>