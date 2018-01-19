<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.vo.*" %>
<%@ page import = "com.javaex.dao.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	String content = request.getParameter("content");


	System.out.println(name);
	System.out.println(pass);
	System.out.println(content);
	
	GuestBookVO vo = new GuestBookVO(name, pass, content);
	
	GuestBookDAO dao = new GuestBookDAO();
	dao.insertGuestBook(vo);
	
	response.sendRedirect("list.jsp");

%>