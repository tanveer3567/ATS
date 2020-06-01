package com.rsit.ats.model;

import java.util.List;

public class EduAndExp {

	private List<Education> education;
	private Integer yearsOfExperience;
	private Integer monthsOfExperience;
    private List<WorkExperience> workExperience;
    private List<String> skills;
    
	public List<Education> getEducation() {
		return education;
	}
	public void setEducations(List<Education> educations) {
		this.education = educations;
	}
	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public Integer getMonthsOfExperience() {
		return monthsOfExperience;
	}
	public void setMonthsOfExperience(Integer monthsOfExperience) {
		this.monthsOfExperience = monthsOfExperience;
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
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}   
}
