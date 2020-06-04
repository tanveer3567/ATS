package com.rsit.ats.model;

public class Applicant {
	
	private Integer jobId;
	private String resumeUrl;
	private String resumeS3Key;
	private PersonalDetails personalDetails;
	private EduAndExp eduAndExp;
	private EmploymentQuestions employmentQuestions;
	private Profiles profiles;
	private EqualEmployementQuestions equalEmploymentQuestions;
	private String status;
	private String submittedByName;
	private String submittedByEmail;
	private String submittedByComments;
	
	public Integer getJobId() {
		return jobId;
	}
	public String getResumeUrl() {
		return resumeUrl;
	}
	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}
	public String getResumeS3Key() {
		return resumeS3Key;
	}
	public void setResumeS3Key(String resumeS3Key) {
		this.resumeS3Key = resumeS3Key;
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
	public String getSubmittedByName() {
		return submittedByName;
	}
	public void setSubmittedByName(String submittedByName) {
		this.submittedByName = submittedByName;
	}
	public String getSubmittedByEmail() {
		return submittedByEmail;
	}
	public void setSubmittedByEmail(String submittedByEmail) {
		this.submittedByEmail = submittedByEmail;
	}
	public String getSubmittedByComments() {
		return submittedByComments;
	}
	public void setSubmittedByComments(String submittedByComments) {
		this.submittedByComments = submittedByComments;
	}
}
