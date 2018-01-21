<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.dao.*" %>
<%@ page import = "com.javaex.vo.*" %>

<%
	int getno = Integer.valueOf(request.getParameter("no"));
	String password = request.getParameter("password");
	GuestBookDAO dao = new GuestBookDAO();
	GuestBookVO vo = dao.selectGuestBook(getno);
	System.out.println(password);
	System.out.println(vo.getPassword());
	if(password.equals(vo.getPassword())){
		dao.deleteGuestBook(getno);
		response.sendRedirect("list.jsp");
	}else{
		response.sendRedirect("deletefail.html");
	}
%>