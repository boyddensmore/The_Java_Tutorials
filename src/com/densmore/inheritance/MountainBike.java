package com.densmore.inheritance;

public class MountainBike extends Bicycle {

	// the MountainBike subclass adds
	// one field
	public int seatHeight;

	// the MountainBike subclass has one
	// constructor
	public MountainBike(int startSeatHeight, int startCadence, int startSpeed,
			int startGear) {
		super(startCadence, startSpeed, startGear);
		seatHeight = startSeatHeight;
	}

	// the MountainBike subclass adds
	// one method
	public void setHeight(int newValue) {
		seatHeight = newValue;
	}

	public void printDetails() {
		super.printDetails();
		System.out.println("Seat Height: " + seatHeight);
	}
	
	public String toString(){
		return ("MountainBike class - G" + gear + " C" + cadence + " S" + speed + " H" + seatHeight);
	}
}