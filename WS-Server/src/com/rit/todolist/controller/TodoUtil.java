package com.rit.todolist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TodoUtil {

	public Document getXMLDoc() {
		Document doc = null;
		try {
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setNamespaceAware(true); 
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			try {
				doc = builder.parse("user.xml");
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return doc;
	}

	public List<String> getTaskTitles() {
		
		Document doc = getXMLDoc();
		List<String> nodeTitles = new ArrayList<String>();
		String userId = "u9111";
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		String s="//user[@id='"+userId+"\']/catagory/task/title/text()";
		XPathExpression expr;
		Object result = null;
		try {
			expr = xpath.compile(s);
			result = expr.evaluate(doc, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			nodeTitles.add(nodes.item(i).getNodeValue()); 
		}
		return nodeTitles;
	}
	
	

	public String getUserPassword(String username) {
		
		
		Document doc = getXMLDoc();
		
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		String s="//user[name='"+username+"']/password/text()";
		XPathExpression expr;
		Object result = null;
		try {
			expr = xpath.compile(s);
			result = expr.evaluate(doc, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Node node = (Node) result;
		String passwordCypher = node.getTextContent();
		System.out.println("");
		RSA rsa=new RSA();
		String password=rsa.decryptPassword(passwordCypher);
		return password;
	}

}
