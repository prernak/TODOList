package com.rit.todolist.services;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.jws.WebService;

import com.rit.todolist.bo.User;
import com.rit.todolist.bo.Users;
import com.rit.todolist.controller.TodoUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

@WebService(endpointInterface = "com.rit.todolist.services.TodoList")
public class TodoListImpl implements TodoList {


	@Override
	public String getUserId(String username) {
		String userId = null;
		XStream xstream = new XStream(new StaxDriver());
		xstream.addImplicitCollection (Users.class, "users");
		xstream.alias("users", Users.class);
		xstream.alias("user", User.class);
		Users users=null;
		try {
			users = (Users)xstream.fromXML(new FileReader("user.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("usssssss  "+users.getUsers());
		for (User user:users.getUsers()) {
			if (user.getUsername().equals(username)) {
				return user.getId();
			}
		}
		return userId;
	}
	
	@Override
	public boolean getAuth(String username, String password) {
		TodoUtil todo = new TodoUtil();
			String pass=  todo.getUserPassword(username);
		return pass.equals(password);

	}
	
	public static void main(String[] args) {
		TodoListImpl td=new TodoListImpl();
		td.getAuth("rahul","prerna");
		System.out.println(td.getAuth("rahul","prerna"));
		
	}
}
