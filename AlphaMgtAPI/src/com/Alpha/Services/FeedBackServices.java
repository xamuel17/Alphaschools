package com.Alpha.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Alpha.Database.DatabaseConnection;
import com.Alpha.Model.FeedbackModel;
import com.Alpha.Model.LecturerInboxModel;

public class FeedBackServices {
	private PreparedStatement st=null;
	private ResultSet rs= null;
	private Connection con;
	LecturerInboxModel lecturerInboxModel = new LecturerInboxModel();
	
	public LecturerInboxModel feedback(long dept_id){
		try{
			DatabaseConnection dc = new DatabaseConnection();
		con =  dc.getConnection();
		
		String sql = "SELECT * FROM feedback WHERE dept_id=?";
		st= con.prepareStatement(sql);
		//set params
		st.setLong(1, dept_id);
		//System.out.print(dc.getConnection());
		rs = st.executeQuery();
		while(rs.next()){
			FeedbackModel fbm = new FeedbackModel();
			fbm.setMessageId(rs.getLong("message_id"));
			fbm.setDeptID(rs.getInt("dept_id"));
			fbm.setLevel(rs.getInt("level"));
			fbm.setMatNo(rs.getString("matno"));
			fbm.setStudentEmail(rs.getString("student_email"));
			fbm.setLecturerEmail(rs.getString("lecturer_email"));
			fbm.setSubject(rs.getString("subject"));
			fbm.setMessage(rs.getString("message"));
			fbm.setDate(rs.getDate("date"));
			lecturerInboxModel.setLecturerInbox(fbm);
			
		}
	
		}catch(Exception e){
			e.printStackTrace();		
			
		}
		
		return lecturerInboxModel;
	}

}
