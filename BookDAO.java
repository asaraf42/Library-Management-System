package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dbutil.DBConnect;
import com.app.dto.BookDTO;

public class BookDAO {
	
	public List<BookDTO> displayAll() throws Exception
	{
		List<BookDTO> book=new ArrayList<BookDTO>();
		Connection con=DBConnect.getConnection();
		PreparedStatement pstmt=con.prepareStatement("select * from book");
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			BookDTO dto=new BookDTO();
			dto.setBid(rs.getInt(1));
			dto.setBname(rs.getString(2));
			dto.setBauthor(rs.getString(3));
			dto.setPrice(rs.getDouble(4));
			dto.setBquantity(rs.getInt(5));
			dto.setPages(rs.getInt(6));
			book.add(dto);
		}
		DBConnect.closeConnection(con);
		return book;
	}
	public boolean update(int bid) throws Exception
	{
		boolean res=true;
		Connection con=DBConnect.getConnection();
		PreparedStatement pstmt=con.prepareStatement("update book set bquantity=bquantity-1 where bid=?");
		pstmt.setInt(1, bid);
		int nori=pstmt.executeUpdate();
		if(nori!=1)
		{
			res=false;
		}
		DBConnect.closeConnection(con);
		return res;
	}
}