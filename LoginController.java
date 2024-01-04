package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.app.dao.BookDAO;
import com.app.dao.UserDAO;
import com.app.dto.BookDTO;
import com.app.dto.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDTO dto=new UserDTO();
       UserDAO dao=new UserDAO();
       BookDAO bdao=new BookDAO();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		dto.setName(username);
		dto.setPassword(password);
		List<BookDTO> book;
		try {
			book=bdao.displayAll();
			if(dao.login(dto))
			{
				pw.println("<container style=\"display:flex;\">");
				for(BookDTO x:book)
				{
				pw.println("<div><img src='http://localhost:8080/Library Management System/Images/"+x.getBname()+ ".jpg' alt='image is loading'><br>"
						+"<h2>Bookname : "+x.getBname()+"<br>Price : "+x.getPrice()+"<br>Author : "+x.getBauthor()+"<br>Quantity : "+x.getBquantity()+"</h2>"
						+"<form action='BuyBook' method='get'>"
						+"<pre>"
						+"<input type='submit' value='Buynow'><br>"
						+"<input type='text' value='"+x.getBid()+"'name='bid' hidden=''>"
						+"</pre>"
						+"</form>"+"</div>");
				}
			pw.println("</container>");
			}
			else
			{
				pw.println("Something went wrong...!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

}
