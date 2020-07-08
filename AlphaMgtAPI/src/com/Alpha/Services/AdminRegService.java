package com.Alpha.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Alpha.Database.DatabaseConnection;
import com.Alpha.Model.AdminLoginModel;
import com.Alpha.Model.AdminRegisterModel;
import com.Alpha.Model.ResponseModel;

public class AdminRegService {
	private PreparedStatement st=null;
	private ResultSet rs= null;
	ResponseModel response = new ResponseModel();
	public ResponseModel AdminReg(AdminRegisterModel adminRegModel){
	String sql;
		try{
		Connection con = new DatabaseConnection().getConnection();
		
		sql = "SELECT * FROM admin WHERE email=? AND phoneNo=?";
		
		st = con.prepareStatement(sql);
		
		st.setString(1, adminRegModel.getEmail());
		st.setString(2,adminRegModel.getPhoneNo());
		
		rs= st.executeQuery();
		if(rs.next()){
			response.setResponseCode(-1000);
			response.setResponseMessage("Admin Record Already Exists.");
			
		}
		
		else{
		
		sql = "INSERT INTO admin(first_name, last_name, email, username, password, phoneNo) VALUES(?,?,?,?,?,?)";
		//execute statement
		st=con.prepareStatement(sql);
		//set params
		st.setString(1, adminRegModel.getFirstName());
		st.setString(2,adminRegModel.getLastName());
		st.setString(3,adminRegModel.getEmail());
		st.setString(4, adminRegModel.getUserName());
		st.setString(5, adminRegModel.getPassword());
		st.setString(6, adminRegModel.getPhoneNo());
	
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
