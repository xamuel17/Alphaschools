package com.alpha.model;

public class LecturerDetails {

		//method to return saved info from remote database and use globally on the project
		  public static LectLoginModel LectloginDetails(String Lect_fName, String Lect_lName, String lectEmail ) {
			  LectLoginModel loginModel = new LectLoginModel();
			loginModel.setLect_fName(Lect_fName);
			loginModel.setLect_lName(Lect_lName);
			loginModel.setEmail(lectEmail);
			  return loginModel;
		  }
}





