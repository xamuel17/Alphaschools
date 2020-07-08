package com.alpha.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.alpha.database.DatabaseConnect;

public class test {
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DatabaseConnect obj =  new DatabaseConnect();
			con = obj.getConnection();
			 stmt = con.createStatement();
			 String sql ="SELECT * FROM feedback WHERE student_email= 'pet@gmail.com'";
			 
			 rs= stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 ArrayList lecEmail = new ArrayList();
				   String lec = rs.getString("lecturer_email");
				
				  lecEmail.add(lec);
					System.out.println(lecEmail);
			
			
			
			 }
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
