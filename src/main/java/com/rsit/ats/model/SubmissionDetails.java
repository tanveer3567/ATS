package com.rsit.ats.model;

public class SubmissionDetails {

	private String submittedByName;
	private String submittedByEmail;
	private String submittedByComments;
	private String resumeUrl;
	private String resumeS3Key;
	private String status;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
