package com.Alpha.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Alpha.Database.DatabaseConnection;
import com.Alpha.Model.ResponseModel;
import com.Alpha.Model.StudentRegisterModel;

public class StudentRegService {
	private PreparedStatement st=null;
	private ResultSet rs= null;
	ResponseModel response = new ResponseModel();
	public ResponseModel StudentReg(StudentRegisterModel studentRegModel){
		
		String sql;
		try{
		Connection con = new DatabaseConnection().getConnection();
		
		
sql = "SELECT * FROM student WHERE level=? AND matric_no=?";
		
		st = con.prepareStatement(sql);
		
		st.setInt(1, studentRegModel.getLevel());
		st.setString(2,studentRegModel.getMatricNo());
		
		rs= st.executeQuery();
		if(rs.next()){
			response.setResponseCode(-1000);
			response.setResponseMessage("Admin Record Already Exists.");
			
		}
		
		else{
		
		sql = "INSERT INTO student(reg_id,first_name, last_name, level, dept_id, email, matric_no, username, password, admin_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
		//execute statement
		st=con.prepareStatement(sql);
		//set params
		st.setLong(1, studentRegModel.getRegId());
		st.setString(2, studentRegModel.getFirstName());
		st.setString(3, studentRegModel.getLastName());
		st.setInt(4,studentRegModel.getLevel());
		st.setLong(5,studentRegModel.getDeptId() );
		st.setString(6,studentRegModel.getEmail());
		st.setString(7, studentRegModel.getMatricNo());
		st.setString(8, studentRegModel.getUsername());
		st.setString(9,studentRegModel.getPassword());
		st.setLong(10, studentRegModel.getAdminId());
		
		
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
