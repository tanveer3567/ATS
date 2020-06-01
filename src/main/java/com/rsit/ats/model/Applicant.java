package com.rsit.ats.model;

public class Applicant {
	
	private Integer jobId;
	private PersonalDetails personalDetails;
	private EduAndExp eduAndExp;
	private EmploymentQuestions employmentQuestions;
	private Profiles profiles;
	private EqualEmployementQuestions equalEmploymentQuestions;
	private String status;
	
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public EduAndExp getEduAndExp() {
		return eduAndExp;
	}
	public void setEduAndExp(EduAndExp eduAndExp) {
		this.eduAndExp = eduAndExp;
	}
	public EmploymentQuestions getEmploymentQuestions() {
		return employmentQuestions;
	}
	public void setEmploymentQuestions(EmploymentQuestions employmentQuestions) {
		this.employmentQuestions = employmentQuestions;
	}
	public Profiles getProfiles() {
		return profiles;
	}
	public void setProfiles(Profiles profiles) {
		this.profiles = profiles;
	}
	public EqualEmployementQuestions getEqualEmploymentQuestions() {
		return equalEmploymentQuestions;
	}
	public void setEqualEmploymentQuestions(EqualEmployementQuestions equalEmploymentQuestions) {
		this.equalEmploymentQuestions = equalEmploymentQuestions;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
