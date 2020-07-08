package com.Alpha.Model;

import java.util.ArrayList;

public class LecturerInboxModel {

	private ArrayList<FeedbackModel> lecturerInbox = new ArrayList<>();

	public ArrayList<FeedbackModel> getLecturerInbox() {
		return lecturerInbox;
	}

	public void setLecturerInbox(FeedbackModel feedback) {
		this.lecturerInbox.add(feedback);
	}
}
