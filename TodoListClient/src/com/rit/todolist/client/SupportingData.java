package com.rit.todolist.client;

import java.util.ArrayList;
import java.util.List;

public class SupportingData {
	
	private List<Priority> priorities = new ArrayList<Priority>();
	private List<Status> statusList = new ArrayList<Status>();
	private List<Catagory> catagories = new ArrayList<Catagory>();
	
	public List<Priority> getPriorities() {
		return priorities;
	}
	public void setPriorities(List<Priority> priorities) {
		this.priorities = priorities;
	}
	public List<Status> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}
	public List<Catagory> getCatagories() {
		return catagories;
	}
	public void setCatagories(List<Catagory> catagories) {
		this.catagories = catagories;
	}

}
