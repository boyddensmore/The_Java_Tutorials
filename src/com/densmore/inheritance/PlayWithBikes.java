package com.densmore.inheritance;

public class PlayWithBikes {

	private static final int startCadence = 3;
	private static final int startSeatHeight = 2;
	private static final int startSpeed = 21;
	private static final int startGear = 1;
	private static final int tireWidth = 13;
	

	public static void main(String[] args) {
		
		Bicycle bikeOne = new Bicycle(startCadence, startSpeed, startGear);
		
		MountainBike bikeTwo = new MountainBike(startSeatHeight, startCadence,
				startSpeed, startGear);
		
		RoadBike bikeThree = new RoadBike(tireWidth, startCadence, startSpeed, startGear);

		RoadBike bikeFour = bikeThree;
		
		bikeOne.printDetails();
		System.out.println();
		
		bikeTwo.printDetails();
		System.out.println();
		
		bikeThree.printDetails();
		
		System.out.println();
		System.out.println(bikeOne.toString());
		System.out.println(bikeTwo.toString());
		System.out.println(bikeThree.toString());
		System.out.println(bikeFour.toString());
		
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
