/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hbrs.nosql.mongoweb.gui.views;

import com.mongodb.AggregationOutput;
import com.mongodb.DBObject;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import org.hbrs.nosql.mongoweb.db.MongoDBConnector;
import org.hbrs.nosql.mongoweb.model.UseCase;

/**
 * @author Franz
 */
public class UseCase6 extends AbstractUseCase
{
    @Override
    protected void setUp()
    {
        //Add your Vaadin Coding here ;)
        //MongoDB Connector
        MongoDBConnector mongo = new MongoDBConnector();
        
        VerticalLayout uc6 = new VerticalLayout();
        
        Button button = new Button( "Welcher Professor hat die meisten Arbeiten unterstützt?" );
        
        button.addClickListener( e ->
                                 {
                                     uc6.removeAllComponents();
                                     // load list with values
                                     AggregationOutput uc6answer = mongo.getQuery6();
                                     // query over list
                                     for (DBObject place : uc6answer.results()) {
                                         if(place.get("_id").equals(""));else uc6.addComponent( new Label( place.get("_id")+": "+place.get("Anzahl")) );
                                     }
                                     addComponent( uc6 );
                                 } );
        
        
        addComponents( button );
        setMargin( true );
        setSpacing( true );
    }
    
    @Override
    protected UseCase getUseCase()
    {
        return ( UseCase.UC6 );
    }
}
