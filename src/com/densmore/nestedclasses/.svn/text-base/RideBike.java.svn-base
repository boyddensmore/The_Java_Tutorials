package com.densmore.nestedclasses;

public class RideBike {


	public static void main(String[] args) {
		
		Bicycle bikeOne = new Bicycle();
	
		System.out.println("Bike count: " + Bicycle.bikeCount);
		
		System.out.println("Bike ID: " + bikeOne.bikeId);
		
		System.out.println(bikeOne.seatCount);
		
		bikeOne.addSeat("Second seat!");
		bikeOne.addSeat("Third seat!");
		bikeOne.addSeat("Fourth seat!");
		bikeOne.addSeat("Fifth seat!");
		bikeOne.addSeat("Sixth seat!");
		
		for (int currentSeat=0; currentSeat < bikeOne.seatCount; currentSeat++) {
			
//			System.out.println("Bike 1, seat " + currentSeat + ": " + bikeOne.seats[currentSeat].seatName);
			
			System.out.println("Bike 1, seat " + currentSeat + ": " + bikeOne.getSeatName(currentSeat));
		}

	}

}
