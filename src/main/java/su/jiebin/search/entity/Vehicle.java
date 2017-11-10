package su.jiebin.search.entity;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import su.jiebin.search.VehicleType;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String sipp;
	private String name;
	private Double price;
	private String supplier;
	private Double rating;
	
	public Vehicle() {}
	
	public Vehicle(String sipp, String name, Double price, 
			String supplier, Double rating) {
		this.sipp = sipp;
		this.name = name;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
	}
	
	public Vehicle(Integer id, String sipp, String name, Double price, 
			String supplier, Double rating) {
		this.id = id;
		this.sipp = sipp;
		this.name = name;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getSipp() {
		return this.sipp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public String getSupplier() {
		return this.supplier;
	}
	
	public Double getRating() {
		return this.rating;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSipp(String sipp) {
		this.sipp = sipp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public String getCarType() {
		String typeCode = String.valueOf(this.sipp.charAt(0));
		String carType = VehicleType.carType.get(typeCode);

		return (carType != null) ? carType : "Undefined";
	}

	public String getDoorType() {
		String typeCode = String.valueOf(this.sipp.charAt(1));
		String doorType = VehicleType.doorType.get(typeCode);
		
		return (doorType != null) ? doorType : VehicleType.carType.get(typeCode);
	}

	public String getTransmissionType() {
		char typeCode = this.sipp.charAt(2);
		String transmissionType;
		
		switch(typeCode) {
			case 'M':
				transmissionType = "Manual";
				break;
			case 'A':
				transmissionType = "Automatic";
				break;
			default:
				transmissionType = "Undefined";
		}
		return transmissionType;
	}
	
	public String getFuelType() {
		char typeCode = this.sipp.charAt(3);
		String acType;
		
		switch(typeCode) {
			case 'N':
				acType = "Petrol";
				break;
			case 'R':
				acType = "Petrol";
				break;
			default:
				acType = "Undefined";
		}
		return acType;
	}

	public String getACType() {
		char typeCode = this.sipp.charAt(3);
		String acType;
		
		switch(typeCode) {
			case 'N':
				acType = "no AC";
				break;
			case 'R':
				acType = "AC";
				break;
			default:
				acType = "Undefined";
		}
		return acType;
	}
	
	public Integer getScore() {
		int total = 0;
		char transmissionType = this.sipp.charAt(2);
		char acType = this.sipp.charAt(3);
		
		total = (transmissionType=='M') ? total+1:total+5;
		total = (acType=='R') ? total+2:total;
		
		return total;
	}
	
	public Double getTotalScore() {
		return this.getRating()+this.getScore();
	}
	
}
