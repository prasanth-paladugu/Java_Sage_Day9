package com.src;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DataBaseConnection 
{ 
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException 
	{ 
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","7382353516@Dp"); 
		return con; 
	} 
} 

