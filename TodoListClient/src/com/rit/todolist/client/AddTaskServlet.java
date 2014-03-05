package com.rit.todolist.client;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.sun.xml.internal.fastinfoset.util.ContiguousCharArrayArray;

/**
 * Servlet implementation class AddTaskServlet
 */
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTaskServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = new Task();
		task.setTitle((String) request.getParameter("titleField"));
		task.setCatagory((String) request.getParameter("catagory"));
		task.setPriority((String) request.getParameter("priorityCombo"));
		task.setDuedate((String) request.getParameter("dateField"));
		task.setDescription((String) request.getParameter("descField"));
		task.setStatus("Pending");
		List<Contributor> contributors = new ArrayList<Contributor>();
		Contributor contributor = new Contributor();
		contributor.setName((String) request.getParameter("textfield"));
		System.out.println((String) request.getParameter("textfield"));
		contributor.setEmail((String) request.getParameter("textfield2"));
		System.out.println((String) request.getParameter("textfield2"));
		contributor.setPhoneNumber((String) request.getParameter("textfield3"));
		contributor.setAddress((String) request.getParameter("textfield4"));
		contributors.add(contributor);

		Contributor contributor2 = new Contributor();
		contributor2.setName((String) request.getParameter("textfield5"));
		contributor2.setEmail((String) request.getParameter("textfield6"));
		contributor2.setPhoneNumber((String) request.getParameter("textfield7"));
		contributor2.setAddress((String) request.getParameter("textfield8"));
		contributors.add(contributor2);

		Contributor contributor3 = new Contributor();
		contributor3.setName((String) request.getParameter("textfield9"));
		contributor3.setEmail((String) request.getParameter("textfield10"));
		contributor3.setPhoneNumber((String) request.getParameter("textfield11"));
		contributor3.setAddress((String) request.getParameter("textfield12"));
		contributors.add(contributor3);
		task.setContributors(contributors);
		try {
			modifiyXML(task);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		String username = request.getParameter("username"));

		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer trans = tFactory.newTransformer(new StreamSource(
					"todoXsl" + ".xsl"));
			trans.setParameter("userid", UserUtil.getUserId(username));
			trans.setParameter("username", username);
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

	private void modifiyXML(Task task) throws ParserConfigurationException, SAXException, IOException, 
	TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse("todo.xml");

		Element newTask = (Element) dom.createElement("Task");
		Element dueDate = dom.createElement("duedate");
		dueDate.setTextContent(task.getDuedate());
		newTask.appendChild(dueDate);
		Element title = dom.createElement("title");
		title.setTextContent(task.getTitle());
		newTask.appendChild(title);
		Element status = dom.createElement("status");
		status.setTextContent("s1");
		newTask.appendChild(status);
		Element priority = dom.createElement("priority");
		priority.setTextContent(task.getPriority());
		newTask.appendChild(priority);
		Element desc = dom.createElement("description");
		desc.setTextContent(task.getDescription());
		newTask.appendChild(desc);

		//contributors
		Element contributors = (Element) dom.createElement("contributors");
		for (Contributor contri:task.getContributors()) {

//			if (!contri.getName().equals("")) {
				Element contributor = dom.createElement("contributor");
				Element email = dom.createElement("email");
				email.setTextContent(contri.getEmail());
				contributor.appendChild(email);

				Element name = dom.createElement("name");
				name.setTextContent(contri.getName());
				contributor.appendChild(name);

				Element phone = dom.createElement("phoneNumber");
				phone.setTextContent(contri.getPhoneNumber());
				contributor.appendChild(phone);

				Element address = dom.createElement("address");
				address.setTextContent(contri.getAddress());
				contributor.appendChild(address);
				contributors.appendChild(contributor);
			}

//		}
		newTask.appendChild(contributors);

		NodeList users = dom.getElementsByTagName("user");

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		String username = "u87490";
		String catagory = "House Chores";
		String s="//user[@ID='"+username+"']//category[name='"+catagory+"']";
		XPathExpression expr;
		Object result = null;
		try {
			expr = xpath.compile(s);
			result = expr.evaluate(dom, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Node node = (Node) result;
		node.appendChild(newTask);


		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		//initialize StreamResult with File object to save to file
		StreamResult result1 = new StreamResult("todo.xml");
		DOMSource source = new DOMSource(dom);
		transformer.transform(source, result1);
		String xmlString = result1.toString();
		System.out.println(xmlString);
	}

}
