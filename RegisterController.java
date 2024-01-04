package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.app.dao.UserDAO;
import com.app.dto.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO dao=new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		long mobileno= Long.parseLong(request.getParameter("mobileno"));
		String email=request.getParameter("email");
		System.out.println(email);
		System.out.println(name);
		UserDTO dto=new UserDTO(name,password,mobileno,email);
		try {
			if(dao.insert(dto))
			{
				pw.println("<h3>Register Successfully...!!!</h3>");
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
