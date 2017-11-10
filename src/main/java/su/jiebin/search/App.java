package su.jiebin.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;

import su.jiebin.search.controller.AppController;
import su.jiebin.search.entity.Search;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		
		/*
		 * Part 1 - Loading JSON File and manipulate and print data
		 */
		Gson gson = new Gson();
	     
	    try 
	    {
	    	BufferedReader br = new BufferedReader(new FileReader("src/main/vehicles.json"));
	    	Search container = gson.fromJson(br, Search.class);
		
	    	AppController controller = new AppController(container);
			
			controller.printAllCarPrices();
			controller.printAllSpecifications();
			controller.printAllRatings();
			controller.printAllSummary();
			
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	    
	    /*
	     * Part 2 - REST API using Spring Boot
	     */
	    
		SpringApplication.run(App.class, args);
	}
}
