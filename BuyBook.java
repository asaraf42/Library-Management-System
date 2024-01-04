package com.app.buybook;

import java.io.IOException;
import java.io.PrintWriter;

import com.app.dao.BookDAO;
import com.app.dto.BookDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BuyBook")
public class BuyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDTO dto=new BookDTO();
	BookDAO dao=new BookDAO();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int Bid=Integer.parseInt(request.getParameter("bid"));
		try {
			if(dao.update(Bid))
			{
				pw.println("Purchase sucessfully");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
