package com.Alpha.Model;

import java.util.Date;

public class StudentLoginModel {
private long regId;
private String firstName;
private String lastName;
private int level;
private long deptId;
private String email;
private String matricNo;
private String username;
private String password;
private long adminId;
private Date created;
private String responseMessage;
private int responseCode;

public String getResponseMessage() {
	return responseMessage;
}
public void setResponseMessage(String responseMessage) {
	this.responseMessage = responseMessage;
}
public int getResponseCode() {
	return responseCode;
}
public void setResponseCode(int responseCode) {
	this.responseCode = responseCode;
}
public long getRegId() {
	return regId;
}
public void setRegId(long regId) {
	this.regId = regId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public long getDeptId() {
	return deptId;
}
public void setDeptId(long deptId) {
	this.deptId = deptId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMatricNo() {
	return matricNo;
}
public void setMatricNo(String matricNo) {
	this.matricNo = matricNo;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getAdminId() {
	return adminId;
}
public void setAdminId(long adminId) {
	this.adminId = adminId;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}


}
