package com.javaex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDAO;
import com.javaex.vo.GuestBookVO;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	}

}
