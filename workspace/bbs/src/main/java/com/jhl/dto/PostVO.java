package com.jhl.dto;

public class PostVO {
	
	private int postNumber;
	private String postTitle;
	private String postWriter;
	private int views;
	private String contents;
	private String postPassword;
	
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostWriter() {
		return postWriter;
	}
	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Object getPostPassword() {
		return postPassword;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostPassword(String setPostPassword) {
		this.postPassword = setPostPassword;
		
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
		
	}
	
	

}
