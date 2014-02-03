package com.densmore.classes;

public class PlayWithBikes {

	private static final int startCadence = 3;
	private static final int startSeatHeight = 2;
	private static final int startSpeed = 21;
	private static final int startGear = 1;
	private static final int tireWidth = 13;
	
	private static String[] riderNames;

	public static void main(String[] args) {
		
//		Bicycle bikeOne = new Bicycle(startCadence, startSpeed, startGear);
		
//		MountainBike bikeTwo = new MountainBike(startSeatHeight, startCadence, startSpeed, startGear);
		
		MountainBike bikeTwoB = new MountainBike(startSeatHeight, startCadence, startSpeed, startGear, "Boyd", "Leah");
		
//		RoadBike bikeThree = new RoadBike(tireWidth, startCadence, startSpeed, startGear);

//		RoadBike bikeFour = bikeThree;
		
//		bikeOne.printDetails();
//		System.out.println();
		
		System.out.println("Bike 2B Details");
		bikeTwoB.printDetails();
		
		System.out.println();
		System.out.println("Bike 2B toString()");
		System.out.println(bikeTwoB.toString() + "\n");

		
		System.out.println("Rider names from GetRiderNames");
		riderNames = bikeTwoB.GetRiderNames();
		
		for (String riderName : riderNames) {
			System.out.println(riderName);
		}
		
//		bikeThree.printDetails();
		
//		System.out.println("Bike 1");
//		System.out.println(bikeOne.toString() + "\n");
//		System.out.println("Bike 2");
//		System.out.println(bikeTwo.toString() + "\n");
//		System.out.println("Bike 3");
//		System.out.println(bikeThree.toString() + "\n");
//		System.out.println("Bike 4");
//		System.out.println(bikeFour.toString() + "\n");
		
//		bikeOne.speedUp(5);
//		System.out.println("bikeOne speed: " + bikeOne.speed);
//		bikeOne.applyBrake(2);
//		System.out.println("bikeOne speed: " + bikeOne.speed);
//		bikeOne.applyBrake(2);
//		System.out.println("bikeOne speed: " + bikeOne.speed);
//		bikeOne.applyBrake(2);
//		System.out.println("bikeOne speed: " + bikeOne.speed);
		
	}

}
