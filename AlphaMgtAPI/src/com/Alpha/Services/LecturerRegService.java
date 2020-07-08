package com.Alpha.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Alpha.Database.DatabaseConnection;
import com.Alpha.Model.LecturerLoginModel;
import com.Alpha.Model.LecturerRegisterModel;
import com.Alpha.Model.ResponseModel;



public class LecturerRegService {
	
	private PreparedStatement st=null;
	private ResultSet rs= null;
	ResponseModel response = new ResponseModel();
	public ResponseModel LecturerReg(LecturerRegisterModel lecturerRegModel){
		
		String sql;
		try{
		Connection con = new DatabaseConnection().getConnection();
		
		
sql = "SELECT * FROM lecturer WHERE email=? AND phoneno=?";

		st = con.prepareStatement(sql);
		
		st.setString(1, lecturerRegModel.getEmail());
		st.setString(2,lecturerRegModel.getPhoneNo());
		
		rs= st.executeQuery();
		if(rs.next()){
			response.setResponseCode(-1000);
			response.setResponseMessage("Admin Record Already Exists.");
			
		}
		
		else{
		
		sql = "INSERT INTO lecturer(staff_id,firstname, lastname, email, username, password, phoneno, admin_id,dept_id) VALUES(?,?,?,?,?,?,?,?,?)";
		//execute statement
		st=con.prepareStatement(sql);
		//set params
		st.setLong(1,lecturerRegModel.getStaffId());
		st.setString(2,lecturerRegModel.getFirstName());
		st.setString(3,lecturerRegModel.getLastName());
		
		st.setString(4,lecturerRegModel.getEmail());	
		st.setString(5,lecturerRegModel.getUserName());
		st.setString(6,lecturerRegModel.getPassword());
		st.setString(7,lecturerRegModel.getPhoneNo());
		
	
		st.setLong(8,lecturerRegModel.getAdminId());
		st.setLong(9,lecturerRegModel.getDeptId());
		
		
		if(st.executeUpdate()>0){
			response.setResponseCode(00);
			response.setResponseMessage("Registration Successful.");
		}else{
			
			response.setResponseCode(-1000);
			response.setResponseMessage("Registration failed.");
		}
		}
		}catch(Exception e){
			
			e.printStackTrace();
			response.setResponseCode(-1001);
			response.setResponseMessage("Connection error.");
			
		}
		
		return response;
	}

}
