package su.jiebin.search.controller;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import su.jiebin.search.VehicleComparator;
import su.jiebin.search.entity.Search;
import su.jiebin.search.entity.Vehicle;

public class AppController {

	private List<Vehicle> listOfVehicles;
	private Iterator<Vehicle> listIterator;
	
	public AppController(Search container) {
		this.listOfVehicles = container.getSearch().getVehicleList();
	}
	
	public List<Vehicle> getListOfVehicles() {
		return this.listOfVehicles;
	}
	
	/*
	 * Print a list of all the cars, in ascending price order, in the following format:
	 * {Vehicle name} – {Price}
	 */
	public void printAllCarPrices() {
		Collections.sort(listOfVehicles, VehicleComparator.pricesComparator());
		
		listIterator = listOfVehicles.iterator();
		while(listIterator.hasNext()) {
			Vehicle newVehicle = listIterator.next();
			System.out.println(newVehicle.getName()+" - "+newVehicle.getPrice());
		}
	}
	
	/*
	 * Calculate specification of the vehicles based on their SIPP 
	 * 
	 * Print the specification out using the following format:
	 * {Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con}
	 */
	public void printAllSpecifications() {
		listIterator = listOfVehicles.iterator();
		while(listIterator.hasNext()) {
			Vehicle newVehicle = listIterator.next();
			System.out.println(newVehicle.getName()+" - "
					+newVehicle.getSipp()+" - "+newVehicle.getCarType()
					+" - "+newVehicle.getDoorType()+" - "+newVehicle.getTransmissionType()
					+" - "+newVehicle.getFuelType()+" - "+newVehicle.getACType());
		}
	}
	
	/*
	 * Print out the highest rated supplier per car type, descending order, in the following format:
	 * {Vehicle name} – {Car type} – {Supplier} – {Rating}
	 */
	public void printAllRatings() {
		Collections.sort(listOfVehicles, VehicleComparator.ratingsComparator());
		
		listIterator = listOfVehicles.iterator();
		while(listIterator.hasNext()) {
			Vehicle newVehicle = listIterator.next();
			System.out.println(newVehicle.getName()+" - "
					+newVehicle.getSipp()+" - "+newVehicle.getCarType()
					+" - "+newVehicle.getSupplier()+" - "+newVehicle.getRating());
		}
	}
	
	/*
	 * Give each vehicle a score based on the breakdown, then combine this score with the suppliers rating. 
	 * 
	 * Print out a list of vehicles, ordered by the sum of the scores in descending order, in the following format:
	 * {Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}
	 */
	public void printAllSummary() {
		Collections.sort(listOfVehicles, VehicleComparator.totalScoreComparator());
		
		listIterator = listOfVehicles.iterator();
		while(listIterator.hasNext()) {
			Vehicle newVehicle = listIterator.next();
			System.out.println(newVehicle.getName()+" - "
					+newVehicle.getSipp()+" - "+newVehicle.getScore()
					+" - "+newVehicle.getRating()+" - "+newVehicle.getTotalScore());
		}
	}
	
}
