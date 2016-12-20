/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hbrs.nosql.mongoweb.gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.hbrs.nosql.mongoweb.db.MongoDBConnector;
import org.hbrs.nosql.mongoweb.gui.components.TopPanel;

import java.util.List;

/**
 *
 * @author Franz
 */
public class UseCase1 extends VerticalLayout implements View
{
    @Override
    public void enter( ViewChangeListener.ViewChangeEvent viewChangeEvent )
    {
        setUp();
    }
    
    private void setUp()
    {
        this.addComponent( new TopPanel() );
        
        MongoDBConnector mongo = new MongoDBConnector();
        //DBCursor cursor = mongo.getAllDBObjectsFromCollection();
        /*
        List answer = mongo.getQuery1("Konzeption");
        String output="Anzahl an Prüfern: "+answer.size();
        for(int i = 0; i< answer.size(); i++){
            output=output + "|||" + answer.get(i);
        }
        while(cursor.hasNext()){
            output = output +" ||| "+ cursor.next().toString();
        }
        Label dokumentenliste = new Label(output);
        */
        
        //Navigation erstellen
        VerticalLayout navigation = new VerticalLayout();
        Button uc1navi    = new Button();
        uc1navi.addClickListener(e->{
        
        });
        navigation.addComponents();
        
        VerticalLayout inhalt = new VerticalLayout();
        
        //Use Case 1
        VerticalLayout uc1      = new VerticalLayout();
        TextField uc1input = new TextField();
        uc1input.setCaption("Geben Sie ein Thema ein, welches Sie interessiert!");
        Button button = new Button("Suche");
        button.addClickListener( e -> {
            uc1.removeAllComponents();
            // load list with values
            List uc1answer = mongo.getQuery1( uc1input.getValue());
            // query over list
            for(int i = 0; i< uc1answer.size(); i++){
                //create and post labels for list elements
                uc1.addComponent(new Label( (String) uc1answer.get( i)));
            }
            addComponent(uc1);
            /*
            layout.addComponent(new Label("I got " + mongo.getDocsinCollection()
                    + " Docs in Store. here They are:"));
            */
        });
        
        
        addComponents(uc1input, button);
        setMargin(true);
        setSpacing(true);
    }
}
