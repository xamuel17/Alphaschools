package com.Alpha.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.Alpha.Database.DatabaseConnection;
import com.Alpha.Model.LecturerLoginModel;


public class LecturerLoginService {

	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	LecturerLoginModel lm = new LecturerLoginModel();

	
	public LecturerLoginModel validateLecturerLogin(String firstname,String email){
		
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getConnection();
			String sql= "SELECT * FROM lecturer WHERE firstname=? AND email =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstname);
			stmt.setString(2, email);
			rs = stmt.executeQuery();
			if(rs.next()){
			lm.setStaffId(rs.getLong("staff_id"));
			lm.setFirstname(rs.getString("firstname"));
			lm.setLastname(rs.getString("lastname"));
			lm.setEmail(rs.getString("email"));
			lm.setUsername(rs.getString("username"));
			lm.setPassword(rs.getString("password"));
			lm.setPhoneNo(rs.getInt("phoneno"));
			lm.setAdminId(rs.getLong("dept_id"));
			lm.setCreated(rs.getDate("date_reg"));
				lm.setResponseMessage("Successful.");
				lm.setResponseCode(00);
			
			}else{
				lm.setResponseMessage("Invalid Login.");
				lm.setResponseCode(-1000);
				
			}
		}catch(Exception e){
			
			lm.setResponseMessage("Connection Error. ");
			lm.setResponseCode(-1001);
			
		}
		return lm;
		
	}
	
	

}
