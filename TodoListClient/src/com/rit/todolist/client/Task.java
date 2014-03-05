package com.rit.todolist.client;

import java.util.ArrayList;
import java.util.List;

public class Task {
	
	private String title;
	private String duedate;
	private String description;
	private List<Contributor> contributors = new ArrayList<Contributor>(); 
	private String priority;
	private String status;
	private String catagory;
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Contributor> getContributors() {
		return contributors;
	}
	public void setContributors(List<Contributor> contributors) {
		this.contributors = contributors;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
