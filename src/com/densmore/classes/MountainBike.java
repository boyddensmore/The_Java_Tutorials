package com.densmore.classes;

import java.util.ArrayList;
import java.util.List;

public class MountainBike extends Bicycle {

	// the MountainBike subclass adds
	// one field
	private int seatHeight;
	private List<BikeRider> bikeRiders = new ArrayList<BikeRider>();
	
	class BikeRider {
		private String riderName;
		
		public BikeRider(String newRiderName) {
			this.riderName = newRiderName;
		}
		
		public void setRiderName(String newRiderName) {
			riderName = newRiderName;
		}
		
		public String getRiderName() {
			return riderName;
		}
		
	}
	
	// the MountainBike subclass has one
	// constructor
	public MountainBike(int startSeatHeight, int startCadence, int startSpeed,
			int startGear, String... startingBikeRider) {
		super(startCadence, startSpeed, startGear);
		seatHeight = startSeatHeight;
		
		for (String newRiderName : startingBikeRider) {
			bikeRiders.add(new BikeRider(newRiderName));
		}
	}

	// the MountainBike subclass adds
	// one method
	public void setSeatHeight(int newValue) {
		seatHeight = newValue;
	}

	public void printDetails() {
		super.printDetails();
		System.out.println("Seat Height: " + seatHeight);
	}
	
	public String toString(){
		String riderNames = "\n";

		riderNames = riderNames + "Rider Count: " + bikeRiders.size() + "\n";
		
		for (int riderIndex = 0; riderIndex < bikeRiders.size(); riderIndex++) {
			riderNames = riderNames + "Rider " + (riderIndex + 1) + ": " + bikeRiders.get(riderIndex).getRiderName() +"\n";
		}
		
		return ("MountainBike class - G" + gear + " C" + cadence + " S" + speed + " H" + seatHeight + riderNames);
	}
	
	public int RiderCount() {
		return bikeRiders.size();
	}
	
	public BikeRider RiderName(int riderNumber) {
		try {
			return bikeRiders.get(riderNumber);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public String[] GetRiderNames() {
		String[] riderNames;
		
		riderNames = new String[bikeRiders.size()];

		try {
			for (int riderIndex = 0; riderIndex < bikeRiders.size(); riderIndex++) {
				riderNames[riderIndex] = bikeRiders.get(riderIndex).getRiderName();
			}
			return riderNames;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
}








