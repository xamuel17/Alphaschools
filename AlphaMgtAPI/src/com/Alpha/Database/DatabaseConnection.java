package com.Alpha.Database;

import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseConnection {
public static void Main(String[]args){
		
	    System.out.println("hello");	
	}
	private static Connection conn;
	public Connection getConnection(){
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/alpha_school_mgt_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
	    conn = con;
	
		
	}catch(Exception e){
		conn=null;
		
	}
	return conn;
	}

	
	
}
