package com.alpha.model;

public class UserDetails {
	//method to return saved info from remote database and use globally on the project
	  public static LoginModel loginDetails(String fName, String lName,int adminRegId) {
		  LoginModel loginModel = new LoginModel();
		  loginModel.setfName(fName);
		  loginModel.setlName(lName);
		  loginModel.setAdminRegId(adminRegId);
		  return loginModel;
	  }
	  
}
