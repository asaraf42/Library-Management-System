package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dbutil.DBConnect;
import com.app.dto.UserDTO;

public class UserDAO {
	
	public boolean insert(UserDTO dto) throws Exception
	{
		boolean res=true;
		Connection con=DBConnect.getConnection();
		PreparedStatement pstmt=con.prepareStatement("insert into libraryregister values(?,?,?,?)");
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPassword());
		pstmt.setLong  (3, dto.getMbno());
		pstmt.setString(4, dto.getEmail());
		
		int nori=pstmt.executeUpdate();
		if(nori!=1)
		{
			res=false;
		}
		return res;
	}
	
	public boolean login(UserDTO dto) throws Exception
	{
		boolean res=true;
		Connection con=DBConnect.getConnection();
		PreparedStatement pstmt=con.prepareStatement("select * from libraryregister where username=? and password=?");
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()==false)
		{
			res=false;
		}
		return res;
	}
}
