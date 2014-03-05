package com.rit.todolist.client;

import java.io.PrintWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  
	    TransformerFactory tFactory = 
	        TransformerFactory.newInstance();
	      String directory = 
	        "%JWSDP_HOME%\\webapps\\jaxpack\\WEB-INF\\";
	    
	    String page = "todo";//request.getParameter("page" );

	    if( page != null ) {
	      try {
	        Transformer trans = 
	            tFactory.newTransformer( 
	          new StreamSource( "todoXsl" + ".xsl" ) );
	        trans.transform( 
	            new StreamSource( "todo" + ".xml" ), 
	          new StreamResult( System.out ) );
	      } catch( TransformerException te ) 
	      { te.printStackTrace(); }
	    } else {
	    //  PrintWriter out = response.getWriter();
	      System.out.println("Page parameter missing." );
	    }
	}

}
