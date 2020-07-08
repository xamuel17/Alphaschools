package com.Alpha.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Alpha.Database.DatabaseConnection;

import com.Alpha.Model.StudentLoginModel;

public class StudentLoginService {

	
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	StudentLoginModel slm = new StudentLoginModel();

	
	public StudentLoginModel validateStudentLogin(String matricNo,String level){
		
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getConnection();
			String sql= "SELECT * FROM student WHERE matric_no=? AND level =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, matricNo);
			stmt.setString(2, level);
			rs = stmt.executeQuery();
			if(rs.next()){
				slm.setRegId(rs.getLong("reg_id"));
				slm.setFirstName(rs.getString("first_name"));
				slm.setLastName(rs.getString("last_name"));
				slm.setLevel(rs.getInt("level"));
				slm.setDeptId(rs.getInt("dept_id"));
				slm.setEmail(rs.getString("email"));
				slm.setMatricNo(rs.getString("matric_no"));
				slm.setUsername(rs.getString("password"));
				slm.setAdminId(rs.getLong("admin_id"));
				slm.setCreated(rs.getDate("date_reg"));
				slm.setResponseMessage("Successful.");
				slm.setResponseCode(00);
			
			}else{
				slm.setResponseMessage("Invalid Login.");
				slm.setResponseCode(-1000);
				
			}
		}catch(Exception e){
			
			slm.setResponseMessage("Connection Error. ");
			slm.setResponseCode(-1001);
			
		}
		return slm;
		
	}
}
