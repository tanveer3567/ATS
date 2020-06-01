package com.rsit.ats.model;

public class JobDetails {

	private int jobId;
    private String jobTitle;
    private String applicantGroup;
    private String ownership;
    
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getApplicantGroup() {
		return applicantGroup;
	}
	public void setApplicantGroup(String applicantGroup) {
		this.applicantGroup = applicantGroup;
	}
	public String getOwnership() {
		return ownership;
	}
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
}
