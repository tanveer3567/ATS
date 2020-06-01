package com.rsit.ats.model;

public class EmploymentQuestions {

	private Boolean workedBefore;
	private String previousWorkDetails;
	private Boolean workAuthorization;
	private String typeOfAuthorization;
    private Boolean clearance;
    private String typeOfClearence;
    private Boolean relocation;
    private Double expectedAnnualPay;
    
    
	public Boolean getWorkedBefore() {
		return workedBefore;
	}
	public void setWorkedBefore(Boolean workedBefore) {
		this.workedBefore = workedBefore;
	}
	public String getPreviousWorkDetails() {
		return previousWorkDetails;
	}
	public void setPreviousWorkDetails(String previousWorkDetails) {
		this.previousWorkDetails = previousWorkDetails;
	}
	public Boolean getWorkAuthorization() {
		return workAuthorization;
	}
	public void setWorkAuthorization(Boolean workAuthorization) {
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
	public Boolean getClearance() {
		return clearance;
	}
	public void setClearance(Boolean clearance) {
		this.clearance = clearance;
	}
	public String getTypeOfClearence() {
		return typeOfClearence;
	}
	public void setTypeOfClearence(String typeOfClearence) {
		this.typeOfClearence = typeOfClearence;
	}
	public Boolean getRelocation() {
		return relocation;
	}
	public void setRelocation(Boolean relocation) {
		this.relocation = relocation;
	}
}
