package damania.vaadinmongodbweb2;

import com.mongodb.DBCursor;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
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
        final VerticalLayout layout = new VerticalLayout();
        
        //Navigation erstellen
        VerticalLayout navigation = new VerticalLayout();
        Button uc1navi = new Button();
        uc1navi.addClickListener(e->{
            
        });
        navigation.addComponents();
        
        VerticalLayout inhalt = new VerticalLayout();
        
        //Use Case 1
        VerticalLayout uc1 = new VerticalLayout();
        TextField uc1input = new TextField();
        uc1input.setCaption("Geben Sie ein Thema ein, welches Sie interessiert!");
        Button button = new Button("Suche");
        button.addClickListener( e -> {
            uc1.removeAllComponents();
            // load list with values
            List uc1answer = mongo.getQuery1(uc1input.getValue());
            // query over list
            for(int i = 0; i< uc1answer.size(); i++){
                //create and post labels for list elements
                uc1.addComponent(new Label((String) uc1answer.get(i)));
            }
            layout.addComponent(uc1);
            /*
            layout.addComponent(new Label("I got " + mongo.getDocsinCollection() 
                    + " Docs in Store. here They are:"));
            */
        });
        
        
        layout.addComponents(uc1input, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
