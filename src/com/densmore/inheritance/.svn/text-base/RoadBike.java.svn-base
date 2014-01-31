package com.densmore.inheritance;

public class RoadBike extends Bicycle{

	public int tireWidth;

	// the MountainBike subclass has one
	// constructor
	public RoadBike(int tireWidth, int startCadence, int startSpeed,
			int startGear) {
		super(startCadence, startSpeed, startGear);
		this.tireWidth = tireWidth;
	}

	// the MountainBike subclass adds
	// one method
	public void setTireWidth(int newValue) {
		tireWidth = newValue;
	}

	public void printDetails() {
		super.printDetails();
		System.out.println("Tire width: " + tireWidth);
	}

	public String toString(){
		return ("RoadBike class - G" + gear + " C" + cadence + " S" + speed + " T" + tireWidth);
	}
	
}