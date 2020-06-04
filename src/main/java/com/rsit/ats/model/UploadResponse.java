package com.rsit.ats.model;

public class UploadResponse {

	private String fileKey;
	private String fileUrl;
	
	public UploadResponse() {
		
	}
	
	public UploadResponse(String fileKey, String fileUrl) {
		this.fileKey = fileKey;
		this.fileUrl = fileUrl;
	}
	
	public String getFileKey() {
		return fileKey;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
}
