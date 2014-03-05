package com.rit.todolist.publisher;

import javax.xml.ws.Endpoint;

import com.rit.todolist.services.TodoListImpl;

public class WSPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/WS/TodoList",
				new TodoListImpl());
		System.out.println("Service Published");
	}
}
