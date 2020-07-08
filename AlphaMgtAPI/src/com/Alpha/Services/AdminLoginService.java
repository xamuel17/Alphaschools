package com.Alpha.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Alpha.Database.DatabaseConnection;
import com.Alpha.Model.AdminLoginModel;

public class AdminLoginService {
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	AdminLoginModel alm = new AdminLoginModel();

	
	public AdminLoginModel validateAdminLogin(String firstname,String email){
		
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getConnection();
			String sql= "SELECT * FROM admin WHERE first_name=? AND email =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstname);
			stmt.setString(2, email);
			rs = stmt.executeQuery();
			if(rs.next()){
				alm.setAdmin_id(rs.getLong("Admin_id"));
				alm.setFirstname(rs.getString("first_name"));
				alm.setLastname(rs.getString("last_name"));
				alm.setEmail(rs.getString("email"));
				alm.setUsername(rs.getString("username"));
				alm.setPassword(rs.getString("password"));
				alm.setPhoneNo(rs.getInt("phoneNo"));
				alm.setCreated(rs.getDate("date_reg"));
				alm.setResponseMessage("Successful.");
				alm.setResponseCode(00);
			
			}else{
				alm.setResponseMessage("Invalid Login.");
				alm.setResponseCode(-1000);
				
			}
		}catch(Exception e){
			
			alm.setResponseMessage("Connection Error. ");
			alm.setResponseCode(-1001);
			
		}
		return alm;
		
	}
	
	

}
