/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hbrs.nosql.mongoweb.gui.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import org.hbrs.nosql.mongoweb.db.MongoDBConnector;
import org.hbrs.nosql.mongoweb.model.UseCase;

/**
 * @author Franz
 */
public class UseCase3 extends AbstractUseCase
{
    @Override
    protected void setUp()
    {
        //Add your Vaadin Coding here ;)
        //MongoDB Connector
        MongoDBConnector mongo = new MongoDBConnector();
        
        VerticalLayout uc3 = new VerticalLayout();
        
        TextField uc3input = new TextField();
        
        uc3input.setCaption( "Geben Sie ein Thema ein, welches Sie interessiert!" );
        
        Button button = new Button( "Suche" );
        
        button.addClickListener( e ->
                                 {
                                     uc3.removeAllComponents();
                                     // load list with values
                                     List uc3answer = mongo.getQuery3( uc3input.getValue() );
                                     // query over list
                                     for ( int i = 0; i < uc3answer.size(); i++ )
                                     {
                                         //create and post labels for list elements
                                         uc3.addComponent( new Label( (String)uc3answer.get( i ) ) );
                                     }
                                     addComponent( uc3 );
                                 } );
        addComponents( uc3input, button );
        setMargin( true );
        setSpacing( true );
    }
    
    @Override
    protected UseCase getUseCase()
    {
        return ( UseCase.UC3 );
    }
}
