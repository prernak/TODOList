
package com.rit.todolist.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TodoListImplService", targetNamespace = "http://services.todolist.rit.com/", wsdlLocation = "http://localhost:8081/WS/TodoList?wsdl")
public class TodoListImplService
    extends Service
{

    private final static URL TODOLISTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException TODOLISTIMPLSERVICE_EXCEPTION;
    private final static QName TODOLISTIMPLSERVICE_QNAME = new QName("http://services.todolist.rit.com/", "TodoListImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/WS/TodoList?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TODOLISTIMPLSERVICE_WSDL_LOCATION = url;
        TODOLISTIMPLSERVICE_EXCEPTION = e;
    }

    public TodoListImplService() {
        super(__getWsdlLocation(), TODOLISTIMPLSERVICE_QNAME);
    }

    public TodoListImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TODOLISTIMPLSERVICE_QNAME, features);
    }

    public TodoListImplService(URL wsdlLocation) {
        super(wsdlLocation, TODOLISTIMPLSERVICE_QNAME);
    }

    public TodoListImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TODOLISTIMPLSERVICE_QNAME, features);
    }

    public TodoListImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TodoListImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TodoList
     */
    @WebEndpoint(name = "TodoListImplPort")
    public TodoList getTodoListImplPort() {
        return super.getPort(new QName("http://services.todolist.rit.com/", "TodoListImplPort"), TodoList.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TodoList
     */
    @WebEndpoint(name = "TodoListImplPort")
    public TodoList getTodoListImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.todolist.rit.com/", "TodoListImplPort"), TodoList.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TODOLISTIMPLSERVICE_EXCEPTION!= null) {
            throw TODOLISTIMPLSERVICE_EXCEPTION;
        }
        return TODOLISTIMPLSERVICE_WSDL_LOCATION;
    }

}