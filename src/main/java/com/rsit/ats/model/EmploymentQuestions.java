package com.rsit.ats.model;

public class EmploymentQuestions {

	private String workedBefore;
	private String previousWorkDetails;
	private String workAuthorization;
	private String typeOfAuthorization;
    private String clearance;
    private String typeOfClearence;
    private String relocation;
    private Double expectedAnnualPay;
    
    
	public String getWorkedBefore() {
		return workedBefore;
	}
	public void setWorkedBefore(String workedBefore) {
		this.workedBefore = workedBefore;
	}
	public String getPreviousWorkDetails() {
		return previousWorkDetails;
	}
	public void setPreviousWorkDetails(String previousWorkDetails) {
		this.previousWorkDetails = previousWorkDetails;
	}
	public String getWorkAuthorization() {
		return workAuthorization;
	}
	public void setWorkAuthorization(String workAuthorization) {
		this.workAuthorization = workAuthorization;
	}
	public String getTypeOfAuthorization() {
		return typeOfAuthorization;
	}
	public void setTypeOfAuthorization(String typeOfAuthorization) {
		this.typeOfAuthorization = typeOfAuthorization;
	}
	public Double getExpectedAnnualPay() {
		return expectedAnnualPay;
	}
	public void setExpectedAnnualPay(Double expectedAnnualPay) {
		this.expectedAnnualPay = expectedAnnualPay;
	}
	public String getClearance() {
		return clearance;
	}
	public void setClearance(String clearance) {
		this.clearance = clearance;
	}
	public String getTypeOfClearence() {
		return typeOfClearence;
	}
	public void setTypeOfClearence(String typeOfClearence) {
		this.typeOfClearence = typeOfClearence;
	}
	public String getRelocation() {
		return relocation;
	}
	public void setRelocation(String relocation) {
		this.relocation = relocation;
	}
}
