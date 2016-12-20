package org.hbrs.nosql.mongoweb.model;

import org.hbrs.nosql.mongoweb.gui.views.UseCase1;

/**
 * Created by Jan Eric Müller (aka Saso) on 20.12.2016.
 */
public enum UseCase
{
    UC1 ( UseCase1.class ),
    UC2 ( UseCase1.class ),
    ;
    private Class clazz;
    
    UseCase( Class clazz )
    {
        this.clazz = clazz;
    }
    
    public Class getView()
    {
        return clazz;
    }
}
