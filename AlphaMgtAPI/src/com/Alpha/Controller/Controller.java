package com.Alpha.Controller;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.Alpha.Model.AdminLoginModel;
import com.Alpha.Model.FeedbackModel;
import com.Alpha.Model.LecturerInboxModel;
import com.Alpha.Model.LecturerLoginModel;
import com.Alpha.Model.AdminRegisterModel;
import com.Alpha.Model.LecturerRegisterModel;
import com.Alpha.Model.ResponseModel;
import com.Alpha.Model.StudentLoginModel;
import com.Alpha.Model.StudentRegisterModel;
import com.Alpha.Services.AdminLoginService;
import com.Alpha.Services.AdminRegService;
import com.Alpha.Services.FeedBackServices;
import com.Alpha.Services.LecturerLoginService;
import com.Alpha.Services.LecturerRegService;
import com.Alpha.Services.StudentLoginService;
import com.Alpha.Services.StudentRegService;
import com.google.gson.Gson;

//Login
@Path("/api")
public class Controller {
@POST
@Path("/admin/login")
@Produces(MediaType.APPLICATION_JSON)


public String getAdminLogin(@QueryParam("firstname") String firstname, @QueryParam("email") String email){
 AdminLoginModel alms = new AdminLoginService().validateAdminLogin(firstname, email);
	
	
	 String response = new Gson().toJson(alms);
	 return response;

}


@POST
@Path("/student/login")
@Produces(MediaType.APPLICATION_JSON)
public String login(@QueryParam("matricNo") String matricNo, @QueryParam("level") String level){
	 StudentLoginModel slm =  new StudentLoginService().validateStudentLogin(matricNo, level);
	 String response = new Gson().toJson(slm);
	 return response;
}






@POST
@Path("/lecturer/login")
@Produces(MediaType.APPLICATION_JSON)
public String getlecturerlogin(@QueryParam("firstname") String firstname, @QueryParam("email") String email){
	 LecturerLoginModel lm =  new LecturerLoginService().validateLecturerLogin(firstname, email);
	 String response = new Gson().toJson(lm);
	 return response;
}


/* Registration*/
@POST
@Path("/admin/registration")
@Produces(MediaType.APPLICATION_JSON)
public String adminReg(String request){
	AdminRegisterModel adminRegModel = new AdminRegisterModel();
	 adminRegModel = new Gson().fromJson(request, AdminRegisterModel.class);
	    ResponseModel responseModel = new AdminRegService().AdminReg(adminRegModel);
	       return new Gson().toJson(responseModel);
}



@POST
@Path("/student/registration")
@Produces(MediaType.APPLICATION_JSON)
public String studentReg(String request1){
	StudentRegisterModel studRegModel = new StudentRegisterModel();
	 studRegModel = new Gson().fromJson(request1, StudentRegisterModel.class);
	    ResponseModel responseModel1 = new StudentRegService().StudentReg(studRegModel);
	     return new Gson().toJson(responseModel1);
	    
}






@POST
@Path("/lecturer/registration")
@Produces(MediaType.APPLICATION_JSON)
public String lecturerReg(String request2){
	LecturerRegisterModel lecRegModel = new LecturerRegisterModel();
	 lecRegModel = new Gson().fromJson(request2, LecturerRegisterModel.class);
	    ResponseModel responseModel2 = new LecturerRegService().LecturerReg(lecRegModel);
	     return new Gson().toJson(responseModel2);
	    
}


@POST
@Path("/feedback/{dept_id}")
//@Produces(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String getfeedback(@PathParam("dept_id") long dept_id){
	 LecturerInboxModel fbs = new FeedBackServices().feedback(dept_id) ;
		
	 String response = new Gson().toJson(fbs);
return response;	
}
	
}

