package com.rit.todolist.client;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class UserUtil {
	
	public static String getUserId(String username) {
		String userId = null;
		Users users = getUserData();
		for (User user:users.getUsers()) {
			if (user.getUsername().equals(username)) {
				return user.getId();
			}
		}
		return userId;
	}
	
	public static String getUsername(String userId) {
		String username = null;
		Users users = getUserData();
		for (User user:users.getUsers()) {
			if (user.getId().equals(userId)) {
				return user.getUsername();
			}
		}
		return userId;
	}
	
	private static Users getUserData() {
		XStream xstream = new XStream(new StaxDriver());
		xstream.addImplicitCollection (Users.class, "users");
		xstream.alias("users", Users.class);
		xstream.alias("user", User.class);
		Users users = null;
		try {
			users = (Users)xstream.fromXML(new FileReader("user.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

}
