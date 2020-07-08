package com.alpha.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnect {
	
private Connection conn = null;


	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/alpha_school_mgt_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		conn = con;
		}
		catch(Exception e) {
			conn = null;
			e.printStackTrace();
			System.out.println(e);
		}
		
		return conn;
	}
//	public static void main(String[] args)throws SQLException {
//		System.out.println(new DatabaseConnect().getConnection());
//		//System.out.println("connected");
//
//	}

}
