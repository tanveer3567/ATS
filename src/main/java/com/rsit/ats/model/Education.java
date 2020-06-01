package com.rsit.ats.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Education {
	
    private String school;
    private String degree;
    private String majorStudy;
    private String minorStudy;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-mm-dd")
    private Date endDate;
    private Double gpa;
    private String city;
    private String state;
    private String country;
    
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getMajorStudy() {
		return majorStudy;
	}
	public void setMajorStudy(String majorStudy) {
		this.majorStudy = majorStudy;
	}
	public String getMinorStudy() {
		return minorStudy;
	}
	public void setMinorStudy(String minorStudy) {
		this.minorStudy = minorStudy;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
    
}
