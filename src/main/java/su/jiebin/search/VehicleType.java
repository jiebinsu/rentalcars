package su.jiebin.search;

import java.util.HashMap;

public class VehicleType {

	public static HashMap<String, String> carType = new HashMap<String, String>() {
		{
	        put("M", "Mini");
	        put("E", "Economy");
	        put("C", "Compact");
	        put("I", "Intermediate");
	        put("S", "Standard");
	        put("F", "Full size");
	        put("P", "Premium");
	        put("L", "Luxury");
	        put("X", "Special");
		}
	};
	
	public static HashMap<String, String> doorType = new HashMap<String, String>() {
		{
	        put("B", "2 doors");
	        put("C", "4 doors");
	        put("D", "5 doors");
	        put("W", "Estate");
	        put("T", "Convertible");
	        put("F", "SUV");
	        put("P", "Pickup");
	        put("V", "Passenger Van");
		}
	};
	
}
