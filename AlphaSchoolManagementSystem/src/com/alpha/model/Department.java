package com.alpha.model;

public class Department {
	
	private int course;
	
	

	
	public int getCourse() {
		return course;
	}




	public void setCourse(int course) {
		this.course = course;
	}



	public  Department(String dep,  int cou) {
		
		switch(dep) {
		 case "Computer Science":  cou =10;
		 course = cou;
		 break;
		 case "Botany":  cou= 12;
		 course = cou;
		break;
		 case "Physics": cou=13;
		 course = cou;
		 break;
		 case "Mathematics": cou=14;
		 course = cou;
		 break;
		 case "Food Science": cou = 15;
		 course = cou;
		 break;
		 case "Nutrition and dietetics": cou =16;
		 course = cou;
		 break;
		default: cou=1000;
		course = cou;
		 }
		 
		
	}
}


