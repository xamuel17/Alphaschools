package com.alpha.model;

public class StudentDetails {
	//method to return saved info from remote database and use globally on the project
	  public static StudLoginModel loginDetails(String Stud_fName, String Stud_lName, String Stud_email) {
		  StudLoginModel loginModel = new StudLoginModel();
		  loginModel.setStud_fName(Stud_fName);
		  loginModel.setStud_lName(Stud_lName);
		  loginModel.setEmail(Stud_email);
		  return loginModel;
	  }
}
