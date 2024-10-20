/*******************************************************************************
 * Copyright (c) 2003 IBM Corporation and others.
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
package com.ibm.ws.sip.container.rules;

import java.util.Iterator;
import java.util.List;

import javax.servlet.sip.SipServletRequest;

import com.ibm.sip.util.log.Log;
import com.ibm.sip.util.log.LogMgr;
import com.ibm.sip.util.log.Situation;

/**
 * @author Amir Perlman, Jun 25, 2003
 * Contains a number of conditions and evaluates to true if and only if at least 
 * one contained condition evaluates to true. 
 */
public class Or extends LogicalConnector
{

  	/**
     * Class Logger. 
     */
    private static final LogMgr c_logger = Log.get(Or.class);
     				
	/**
	 * List of conditions that are logicly connected. 
	 */
	private List m_conditions;
	
    /**
     * Constrct an OR condition that operates on the given list of conditions
     * @param conditions
     */
    public Or(List conditions)
	{
		if(c_logger.isTraceDebugEnabled())
        {
        	c_logger.traceDebug(this, "Or" ,
				"Construct New OR Condition, #args: "+ conditions.size());
        }
		
		m_conditions = conditions; 
	}
    
    /**
     * @see com.ibm.ws.sip.container.rules.Condition#evaluate(javax.servlet.sip.SipServletRequest)
     */
    public boolean evaluate(SipServletRequest request)
    {
        if(m_conditions == null || m_conditions.size() == 0)
        {
			if(c_logger.isErrorEnabled())
			{
				Object[] args = { "OR" }; 
	            c_logger.error("error.missing.sub.elements", 
	            				Situation.SITUATION_CREATE, 
	            				args);
			}
			
        	return false; 
        }
        
        boolean rc = false; 
        
        Iterator iter = m_conditions.iterator(); 
        while (iter.hasNext() && !rc) 
        {
        	Condition condition = (Condition) iter.next();
        	rc = rc || condition.evaluate(request);  
        	
        }
        
        return rc;
    }
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer(16);
	
		Iterator iter = m_conditions.iterator();
		buffer.append('('); 
		while (iter.hasNext()) 
		{
			buffer.append(iter.next());
			if(iter.hasNext())
			{
				buffer.append(" OR ");
			}
		}
		buffer.append(')');
		return buffer.toString();  
	}
}
