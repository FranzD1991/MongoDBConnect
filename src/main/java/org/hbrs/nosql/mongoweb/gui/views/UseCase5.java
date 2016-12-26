/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hbrs.nosql.mongoweb.gui.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import org.hbrs.nosql.mongoweb.db.MongoDBConnector;
import org.hbrs.nosql.mongoweb.model.UseCase;

/**
 * @author Franz
 */
public class UseCase5 extends AbstractUseCase
{
    @Override
    protected void setUp()
    {
        //Add your Vaadin Coding here ;)
        //MongoDB Connector
        MongoDBConnector mongo = new MongoDBConnector();
        
        VerticalLayout uc5 = new VerticalLayout();
        
        Button button = new Button( "Unternehmen suchen" );
        
        button.addClickListener( e ->
                                 {
                                     uc5.removeAllComponents();
                                     // load list with values
                                     List uc5answer = mongo.getQuery5();
                                     // query over list
                                     for ( int i = 0; i < uc5answer.size(); i++ )
                                     {
                                         //create and post labels for list elements
                                         uc5.addComponent( new Label( (String)uc5answer.get( i ) ) );
                                     }
                                     addComponent( uc5 );
                                 } );
        
        
        addComponents( button );
        setMargin( true );
        setSpacing( true );
    }
    
    @Override
    protected UseCase getUseCase()
    {
        return ( UseCase.UC5 );
    }
}
