package com.densmore.nestedclasses;

import java.util.ArrayList;

public class Bicycle {

	public int bikeId = 0;
	public static int bikeCount = 0;
	public int seatCount = 0;
	public ArrayList seatList = new ArrayList();

	public Bicycle() {
		bikeId = bikeCount++;
		addSeat("First seat");
	}

	public void addSeat(String seatName) {

		seatList.add(new Bicycle.Seat(seatName));
		seatCount++;

	}

	public String getSeatName(int index) {
		Seat desiredSeat;

		if (index <= seatList.size()) {
			desiredSeat = (Seat) seatList.get(index);
			return desiredSeat.seatName;
		} else {
			return "";
		}

	}

	protected static class Seat {
		public String seatName = "";

		public Seat(String seatName) {
			this.seatName = seatName;

		}

	}

}
