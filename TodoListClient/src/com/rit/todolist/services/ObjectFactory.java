
package com.rit.todolist.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rit.todolist.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUserIdResponse_QNAME = new QName("http://services.todolist.rit.com/", "getUserIdResponse");
    private final static QName _GetAuthResponse_QNAME = new QName("http://services.todolist.rit.com/", "getAuthResponse");
    private final static QName _GetUserId_QNAME = new QName("http://services.todolist.rit.com/", "getUserId");
    private final static QName _GetAuth_QNAME = new QName("http://services.todolist.rit.com/", "getAuth");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rit.todolist.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAuthResponse }
     * 
     */
    public GetAuthResponse createGetAuthResponse() {
        return new GetAuthResponse();
    }

    /**
     * Create an instance of {@link GetUserId }
     * 
     */
    public GetUserId createGetUserId() {
        return new GetUserId();
    }

    /**
     * Create an instance of {@link GetAuth }
     * 
     */
    public GetAuth createGetAuth() {
        return new GetAuth();
    }

    /**
     * Create an instance of {@link GetUserIdResponse }
     * 
     */
    public GetUserIdResponse createGetUserIdResponse() {
        return new GetUserIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.todolist.rit.com/", name = "getUserIdResponse")
    public JAXBElement<GetUserIdResponse> createGetUserIdResponse(GetUserIdResponse value) {
        return new JAXBElement<GetUserIdResponse>(_GetUserIdResponse_QNAME, GetUserIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.todolist.rit.com/", name = "getAuthResponse")
    public JAXBElement<GetAuthResponse> createGetAuthResponse(GetAuthResponse value) {
        return new JAXBElement<GetAuthResponse>(_GetAuthResponse_QNAME, GetAuthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.todolist.rit.com/", name = "getUserId")
    public JAXBElement<GetUserId> createGetUserId(GetUserId value) {
        return new JAXBElement<GetUserId>(_GetUserId_QNAME, GetUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.todolist.rit.com/", name = "getAuth")
    public JAXBElement<GetAuth> createGetAuth(GetAuth value) {
        return new JAXBElement<GetAuth>(_GetAuth_QNAME, GetAuth.class, null, value);
    }

}
