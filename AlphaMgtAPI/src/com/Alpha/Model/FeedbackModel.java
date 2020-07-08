package com.Alpha.Model;

import java.util.Date;

public class FeedbackModel {
private long messageId;
private long deptID;
private int level;
private String matNo;
private String studentEmail;
private  String lecturerEmail;
private String subject;
private String message;
private Date date;

public long getMessageId() {
	return messageId;
}
public void setMessageId(long messageId) {
	this.messageId = messageId;
}
public long getDeptID() {
	return deptID;
}
public void setDeptID(long deptID) {
	this.deptID = deptID;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public String getMatNo() {
	return matNo;
}
public void setMatNo(String matNo) {
	this.matNo = matNo;
}
public String getStudentEmail() {
	return studentEmail;
}
public void setStudentEmail(String studentEmail) {
	this.studentEmail = studentEmail;
}
public String getLecturerEmail() {
	return lecturerEmail;
}
public void setLecturerEmail(String lecturerEmail) {
	this.lecturerEmail = lecturerEmail;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}



}
