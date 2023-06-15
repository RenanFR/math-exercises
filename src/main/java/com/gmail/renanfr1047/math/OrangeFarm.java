package com.gmail.renanfr1047.math;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OrangeFarm {

	int threeDaysProduction;
	int differenceBetweenSmallestAndBiggestProduction;

	public static void main(String[] args) {

		new OrangeFarm().run();
	}

	public void run() {
		int monday = 3265;
		int tuesday = 4127;
		int wednesday = 2987;
		threeDaysProduction = monday + tuesday + wednesday;

		String firstMessage = "Three days production: " + threeDaysProduction;
		log(firstMessage);

		OptionalInt biggestProduction = IntStream.of(monday, tuesday, wednesday).max();
		OptionalInt lowestProduction = IntStream.of(monday, tuesday, wednesday).min();

		differenceBetweenSmallestAndBiggestProduction = biggestProduction.getAsInt() - lowestProduction.getAsInt();
		String secondMessage = "Difference between smallest and biggest production: "
				+ differenceBetweenSmallestAndBiggestProduction;
		log(secondMessage);
	}

	public void log(String message) {
		System.out.println(message);
	}

}
