package com.app.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection con=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=asaraf");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection con)
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
