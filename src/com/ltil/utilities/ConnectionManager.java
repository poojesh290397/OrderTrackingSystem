package com.ltil.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection = null ;
	
	private ConnectionManager() {}
	
	public static Connection getConnection()
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
	 try
	 {
		 System.out.println("in the connectionmanager class");
	Class.forName("oracle.jdbc.driver.OracleDriver")	 ;
	System.out.println("got the connection");
		connection = DriverManager.getConnection(url,username,password); 
	 }
	catch(SQLException sq)
	 {
		
		sq.printStackTrace();
	 } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return connection;
	}
	
	
	
}
