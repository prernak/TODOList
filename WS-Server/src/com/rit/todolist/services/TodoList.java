package com.rit.todolist.services;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TodoList {
	// @WebMethod FileReader getTodoListTitle(String username);
	 @WebMethod boolean getAuth(String username, String password);
	 @WebMethod String getUserId(String username);
}
