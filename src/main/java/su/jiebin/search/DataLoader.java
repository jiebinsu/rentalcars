package su.jiebin.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import su.jiebin.search.controller.AppController;
import su.jiebin.search.entity.*;
import su.jiebin.search.repository.*;

@Component
public class DataLoader implements CommandLineRunner {

  private final VehicleRepository vehicleRepository;
  
  @Autowired
  public DataLoader(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  /*
   * Load JSON Data into database
   */
  @Override
  public void run(String... arg0) throws Exception {

	  Gson gson = new Gson();
	     
	  try 
	  {
		  BufferedReader br = new BufferedReader(new FileReader("src/main/vehicles.json"));
		  Search container = gson.fromJson(br, Search.class);
	
		  AppController controller = new AppController(container);
		  List<Vehicle> listOfVehicles = controller.getListOfVehicles();
		  Iterator<Vehicle> listIterator = listOfVehicles.iterator();
		  
		  while(listIterator.hasNext()) {
			Vehicle newVehicle = listIterator.next();
			this.vehicleRepository.save(newVehicle);
		  }
		
	  } catch(IOException e) {
		  e.printStackTrace();
	  } 

  }

}
