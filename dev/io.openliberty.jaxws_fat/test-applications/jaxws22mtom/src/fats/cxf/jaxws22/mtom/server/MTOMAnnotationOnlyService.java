/*******************************************************************************
 * Copyright (c) 2024 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package fats.cxf.jaxws22.mtom.server;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.soap.MTOM;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 *
 */
@MTOM
@WebServiceClient(name = "MTOMAnnotationOnlyService", targetNamespace = "http://server.mtom.jaxws22.cxf.fats/",
                  wsdlLocation = "WEB-INF/wsdl/MTOMAnnotationOnlyService.wsdl")
public class MTOMAnnotationOnlyService extends Service {

    private final static QName MTOMANNOTATIONONLYSERVICE_QNAME = new QName("http://server.mtom.jaxws22.cxf.fats/", "MTOMAnnotationOnlyService");

    public MTOMAnnotationOnlyService(URL wsdlLocation) {
        super(wsdlLocation, MTOMANNOTATIONONLYSERVICE_QNAME);
    }

    public MTOMAnnotationOnlyService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MTOMANNOTATIONONLYSERVICE_QNAME, features);
    }

    public MTOMAnnotationOnlyService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MTOMAnnotationOnlyService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *         returns MTOMAnnotationOnly
     */
    @WebEndpoint(name = "MTOMAnnotationOnlyPort")
    public MTOMAnnotationOnly getMTOMAnnotationOnlyPort() {
        return super.getPort(new QName("http://server.mtom.jaxws22.cxf.fats/", "MTOMAnnotationOnlyPort"), MTOMAnnotationOnly.class);
    }

    /**
     *
     * @param features
     *            A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported features not in the <code>features</code> parameter will have their default
     *            values.
     * @return
     *         returns MTOMAnnotationOnly
     */
    @WebEndpoint(name = "MTOMAnnotationOnlyPort")
    public MTOMAnnotationOnly getMTOMAnnotationOnlyPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.mtom.jaxws22.cxf.fats/", "MTOMAnnotationOnlyPort"), MTOMAnnotationOnly.class, features);
    }

}
