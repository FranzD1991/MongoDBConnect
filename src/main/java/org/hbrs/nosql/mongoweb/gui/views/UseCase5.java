/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hbrs.nosql.mongoweb.gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.hbrs.nosql.mongoweb.gui.components.TopPanel;
import org.hbrs.nosql.mongoweb.model.UseCase;

/**
 * @author Franz
 */
public class UseCase5 extends VerticalLayout implements View
{
    @Override
    public void enter( ViewChangeListener.ViewChangeEvent viewChangeEvent )
    {
        setUp();
    }
    
    private void setUp()
    {
        this.addComponent( new TopPanel() );
        
        Label title = new Label( UseCase.UC5.name() );
        this.addComponent( title );
        
        setMargin( true );
        setSpacing( true );
    }
}
