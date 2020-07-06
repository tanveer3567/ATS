package com.rsit.ats.model;

import java.util.List;

public class EduAndExp {

	private List<Education> education;
    private List<WorkExperience> workExperience;
	
	public List<Education> getEducation() {
		return education;
	}
	public void setEducation(List<Education> education) {
		this.education = education;
	}
	public List<WorkExperience> getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(List<WorkExperience> workExperience) {
		this.workExperience = workExperience;
	}
}
