package org.hbrs.nosql.mongoweb.model;

import org.hbrs.nosql.mongoweb.gui.views.UseCase1;
import org.hbrs.nosql.mongoweb.gui.views.UseCase2;

/**
 * Created by Jan Eric Müller (aka Saso) on 20.12.2016.
 */
public enum UseCase
{
    UC1 ( "Use Case 1", UseCase1.class ),
    UC2 ( "Use Case 2", UseCase2.class ),
    UC3 ( "Use Case 3", UseCase1.class ),
    UC4 ( "Use Case 4", UseCase1.class ),
    UC5 ( "Use Case 5", UseCase1.class ),
    UC6 ( "Use Case 6", UseCase1.class ),
    UC7 ( "Use Case 7", UseCase1.class ),
    ;
    
    private String name;
    private Class  view;
    
    UseCase( String name, Class view )
    {
        this.name = name;
        this.view = view;
    }
    
    public String getName()
    {
        return ( name );
    }
    
    public Class getView()
    {
        return view;
    }
}
