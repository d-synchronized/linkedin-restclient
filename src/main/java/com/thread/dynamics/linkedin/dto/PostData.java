package com.thread.dynamics.linkedin.dto;

public class PostData {
	
	private String comment;
	
	private ContentData contentData;
	
	private VisibilityData visibilityData;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ContentData getContentData() {
		return contentData;
	}

	public void setContentData(ContentData contentData) {
		this.contentData = contentData;
	}

	public VisibilityData getVisibilityData() {
		return visibilityData;
	}

	public void setVisibilityData(VisibilityData visibilityData) {
		this.visibilityData = visibilityData;
	}
	
	
}
