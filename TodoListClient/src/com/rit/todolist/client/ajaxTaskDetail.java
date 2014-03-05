package com.rit.todolist.client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.rit.todolist.services.TodoList;
import com.rit.todolist.services.TodoListImplService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * Servlet implementation class ajaxTaskDetail
 */
public class ajaxTaskDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxTaskDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "rahul";//request.getParameter("username");
		String password = "prerna";//request.getParameter("password");
		
		String taskId=request.getParameter("taskId");
		response.setContentType("text/html");

		TransformerFactory tFactory = TransformerFactory.newInstance();

		try {
			Transformer trans = tFactory.newTransformer(new StreamSource(
					"getTaskDetailXsl" + ".xsl"));
			trans.setParameter("taskId", taskId);
			//trans.setParameter("username", "rahul");
			trans.transform(new StreamSource("todo" + ".xml"),
					new StreamResult(response.getOutputStream()));
		} catch (TransformerException te) {
			te.printStackTrace();
		}

	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
