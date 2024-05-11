package listener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Person;

/**
 * Application Lifecycle Listener implementation class MainListener
 *
 */
@WebListener
public class MainListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MainListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application = sce.getServletContext();
    	String path = application.getRealPath("/WEB-INF/data/new_sample.csv");
    	System.out.println("oooo");
    	List<Person> list = new ArrayList<>();
    	try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"))){
    		String line = null;
    		
    		while((line = br.readLine()) != null) {
    			String[] params =line.split(".");
    			Person person = new Person(params[0],params[1],params[2],params[3]);
    			list.add(person);
    		}
    	}catch(IOException e) {
    		
    	}
    	
    	application.setAttribute("list", list);

    	
    }
	
}
