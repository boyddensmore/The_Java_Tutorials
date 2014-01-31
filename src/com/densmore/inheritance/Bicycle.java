package com.densmore.inheritance;

//public class Bicycle extends BaseVehicle {
public class Bicycle {

	// the Bicycle class has
	// three fields
	public int cadence;
	public int gear;
	public int speed;

	// the Bicycle class has
	// one constructor
	public Bicycle(int startCadence, int startSpeed, int startGear) {
		gear = startGear;
		cadence = startCadence;
		speed = startSpeed;
	}

	// the Bicycle class has
	// four methods
	public void setCadence(int newValue) {
		cadence = newValue;
	}

	public void setGear(int newValue) {
		gear = newValue;
	}

	public void applyBrake(int decrement) {
		if (speed - decrement > 0) {
			speed -= decrement;
		} else {
			speed = 0;
		}
	}

	public void speedUp(int increment) {
		speed += increment;
	}

	public void printDetails() {
		System.out.println("Gear: " + gear);
		System.out.println("Cadence: " + cadence);
		System.out.println("Speed: " + speed);
	}

	public String toString() {
		return ("Bicycle class - G" + gear + " C" + cadence + " S" + speed);
	}

}
