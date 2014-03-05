package com.rit.todolist.client;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class PriorityStatusUtil {
	
	public static String getPriorityValue(String id) {
		SupportingData data = getSupportingData();
		for (Priority priority:data.getPriorities()) {
			if (priority.getId().equals(id)) {
				return priority.getValue();
			}
		}
		return "";
	}
	
	public static String getPriorityId(String value) {
		SupportingData data = getSupportingData();
		for (Priority priority:data.getPriorities()) {
			if (priority.getValue().equals(value)) {
				return priority.getId();
			}
		}
		return "";
	}
	
	public static String getStatusValue(String id) {
		SupportingData data = getSupportingData();
		for (Status status:data.getStatusList()) {
			if (status.getId().equals(id)) {
				return status.getValue();
			}
		}
		return "";
	}
	
	public static String getStatusId(String value) {
		SupportingData data = getSupportingData();
		for (Status status:data.getStatusList()) {
			if (status.getValue().equals(value)) {
				return status.getId();
			}
		}
		return "";
	}
	
	private static SupportingData getSupportingData() {
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("supportingData", SupportingData.class);
		xstream.addImplicitCollection (SupportingData.class, "priorities");
		xstream.addImplicitCollection (SupportingData.class, "statusList");
		xstream.addImplicitCollection (SupportingData.class, "catagories");
		xstream.alias("priority", Priority.class);
		xstream.alias("status", Status.class);
		xstream.alias("catagory", Catagory.class);
		SupportingData data = null;
		try {
			data = (SupportingData)xstream.fromXML(new FileReader("applicationSupport.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
