package su.jiebin.search;

import java.util.Comparator;

import su.jiebin.search.entity.Vehicle;

public class VehicleComparator {

	//Compare prices in ascending order
	public static Comparator<Vehicle> pricesComparator() {
		return new Comparator<Vehicle>() {
			public int compare(Vehicle a, Vehicle b) {
				int pricesComp = a.getPrice().compareTo(b.getPrice());
			    return ((pricesComp == 0) ? a.getPrice().compareTo(b.getPrice()) : pricesComp);
			}
		};
	}
	
	//Compare ratings in descending order
	public static Comparator<Vehicle> ratingsComparator() {
		return new Comparator<Vehicle>() {
			public int compare(Vehicle a, Vehicle b) {
				int ratingsComp = b.getRating().compareTo(a.getRating());
			    return ((ratingsComp == 0) ? b.getRating().compareTo(a.getRating()) : ratingsComp);
			}
		};
	}
	
	//Compare total score in descending order
	public static Comparator<Vehicle> totalScoreComparator() {
        return new Comparator<Vehicle>() {
        	public int compare(Vehicle a, Vehicle b) {
        		int totalScoreComp = b.getTotalScore().compareTo(a.getTotalScore());
        	    return ((totalScoreComp == 0) ? b.getTotalScore().compareTo(a.getTotalScore()) : totalScoreComp);
        	}
        };
    }
	
}
