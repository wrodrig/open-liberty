/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.ejbcontainer.remote.client.internal.injection;

import java.io.Serializable;

import com.ibm.ejs.container.EJSHome;

/**
 * EJB Link Information for EJB Reference binding resolution. (Client version)
 * Used to support both ejb-link from XML and beanName and beanInterface from
 * the @EJB annotation.<p>
 *
 * This class is used to hold the information needed to resolve a JNDI lookup
 * in the java:comp name space that a component may do to get a reference
 * to either a component home or business interface of a EJB bean. <p>
 *
 * This class is NOT used when a binding override has been provided.
 * When a binding has been provided, the built in naming indirect
 * lookup support is used. <p>
 */
public class EJBLinkClientInfo implements Serializable
{
    private static final long serialVersionUID = -4638070374419093229L;

    /**
     * Name of the ejb-ref.
     */
    final String ivRefName;

    /**
     * Application name of the referencing bean, NOT the referenced bean.
     **/
    final String ivApplication;

    /**
     * Module name of the referencing bean, NOT the referenced bean.
     **/
    final String ivModule;

    /**
     * Component name of the referencing bean, NOT the referenced bean.
     */
    final String ivComponent;

    /**
     * Name of the EJB specified on ejb-link or annotation.
     **/
    final String ivBeanName;

    /**
     * Name of the local or remote, component or business interface.
     * May also be the Home interface when unknown.
     */
    final String ivBeanInterface;

    /**
     * Name of the home interface, if known to be a home. Otherwise,
     * the home interface may be set in ivBeanInterface if it cannot
     * be determined to be a home (as when specified from annotations).
     **/
    final String ivHomeInterface;

    /**
     * True if ejb reference must be a local reference (ejb-local-ref).
     */
    final boolean ivIsLocalRef;

    /**
     * True if ejb reference must be a remote reference (ejb-ref).
     */
    final boolean ivIsRemoteRef;

    /**
     * Transient field that references the home of the referenced EJB.
     * This field is for performance, and is not set until the first
     * time the reference is resolved (looked up or injected).
     **/
    transient EJSHome ivHome;

    /**
     * Construct an instance for a specified J2EEName of the internal home for
     * the EJB 3 bean and for a specified name of the local interface.
     *
     * @param refName Name of the ejb-ref.
     * @param application Application name of the referencing bean, NOT the referenced bean.
     * @param module Module name of the referencing bean, NOT the referenced bean.
     * @param component Component name of the referencing bean, NOT the referenced bean.
     * @param beanName Name of the EJB specified on ejb-link or annotation.
     * @param beanInterface Name of the local or remote, component or business interface.
     *            May also be the Home interface when unknown.
     * @param homeInterface Name of the home interface, if known to be a home.
     * @param localRef True if ejb reference must be a local reference (ejb-local-ref).
     * @param remoteRef True if ejb reference must be a remote reference (ejb-ref).
     */
    public EJBLinkClientInfo(String refName,
                             String application,
                             String module,
                             String component,
                             String beanName,
                             String beanInterface,
                             String homeInterface,
                             boolean localRef,
                             boolean remoteRef)
    {
        ivRefName = refName;
        ivApplication = application;
        ivModule = module;
        ivComponent = component;
        ivBeanName = beanName;
        ivBeanInterface = beanInterface;
        ivHomeInterface = homeInterface;
        ivIsLocalRef = localRef;
        ivIsRemoteRef = remoteRef;
    }

}
