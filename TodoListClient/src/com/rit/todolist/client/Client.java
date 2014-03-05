package com.rit.todolist.client;

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

/**
 * Servlet implementation class Client
 */
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		response.setContentType("text/html");

		TodoListImplService service = new TodoListImplService();
		TodoList bs = service.getTodoListImplPort();

		if (!(bs.getAuth(username, password)))
			response.sendRedirect("loginfailed.html");
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer trans = tFactory.newTransformer(new StreamSource(
					"todoXsl" + ".xsl"));
			trans.setParameter("userid", UserUtil.getUserId(username));
			trans.setParameter("username", "rahul");
			trans.transform(new StreamSource("todo" + ".xml"),
					new StreamResult(response.getOutputStream()));
		} catch (TransformerException te) {
			te.printStackTrace();
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
