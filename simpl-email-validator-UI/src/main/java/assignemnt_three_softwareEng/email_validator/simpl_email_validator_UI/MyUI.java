package assignemnt_three_softwareEng.email_validator.simpl_email_validator_UI;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 * 
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        emailValidator emailvalid = new emailValidator();
        
        final TextField input = new TextField();
        input.setCaption("Put your Email Here:");

        
        Button button = new Button("Click Me");
        button.addClickListener( e -> {
        	int status = emailvalid.validateThEmail(input.getValue());
        	String passed;	
        	if(status == 4)
        		passed = " a valid Input";
        	else 
        		passed = " an Invalid Input";
        			
        			 layout.addComponent(new Label("Thanks your input is " + passed));
        });
        
        
        
        
//        Button button = new Button("button")
//        //emailvalid.validateThEmail(input.getValue()));
//        button.addClickListener( e -> {
//            layout.addComponent(new Label("Thanks " + emailvalid.validateThEmail(input.getValue())
//                    + ", it works!"));
//        }));
//        
        layout.addComponents(input, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
