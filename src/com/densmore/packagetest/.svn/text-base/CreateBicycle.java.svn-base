package com.densmore.packagetest;

import com.densmore.inheritance.MountainBike;

//Example of importing only a single static.
//This would be used by the println at the bottom.
//import static java.lang.Math.PI;

//Example of importing all statics from a package.
//This would be used by the println at the bottom.
import static java.lang.Math.*;


public class CreateBicycle {

	private static final int startSeatHeight = 4, startCadence = 0, startSpeed = 0, startGear = 0;
	
	public static void main(String[] args) {
		
		MountainBike bikeOne = new MountainBike(startSeatHeight, startCadence, startSpeed, startGear);
		
		bikeOne.speedUp(12);
		bikeOne.applyBrake(6);
		bikeOne.applyBrake(2);
		
		bikeOne.printDetails();
		
		System.out.println(PI);
		
	}

}
