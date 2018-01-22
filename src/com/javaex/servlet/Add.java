package com.javaex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDAO;
import com.javaex.vo.GuestBookVO;


@WebServlet("/Add")
public class Add extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	}

}
