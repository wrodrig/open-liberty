/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
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

package com.ibm.ws.jpa.fvt.relationships.manyXone.entities.nooptional.annotation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ibm.ws.jpa.fvt.relationships.manyXone.entities.INoOptEntityA;
import com.ibm.ws.jpa.fvt.relationships.manyXone.entities.INoOptEntityB;

@Entity
public class MONoOptEntityA implements INoOptEntityA {
    /**
     * Entity primary key, an integer id number.
     */
    @Id
    private int id;

    /**
     * Simple data payload for the entity.
     */
    private String name;

    /*
     * Field: noOptional
     *
     * Many to one mapping to an IEntityB-type entity. No override of the foreign key column name.
     *
     * ManyToOne Config Cascade: default no Fetch: default eager Optional: false (reference can not be null).
     *
     * JoinColumn Config (complete default, so no JoinColumn annotation) Name: Default column name.
     */
    @ManyToOne(optional = false)
    private MONoOptEntityB noOptional;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public MONoOptEntityB getNoOptional() {
        return noOptional;
    }

    public void setNoOptional(MONoOptEntityB noOptional) {
        this.noOptional = noOptional;
    }

    @Override
    public INoOptEntityB getNoOptionalField() {
        return getNoOptional();
    }

    @Override
    public void setNoOptionalField(INoOptEntityB b2) {
        setNoOptional((MONoOptEntityB) b2);
    }

    @Override
    public String toString() {
        return "MONoOptEntityA [id=" + id + ", name=" + name + "]";
    }

}
