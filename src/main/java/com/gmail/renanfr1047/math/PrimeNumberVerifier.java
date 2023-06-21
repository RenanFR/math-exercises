package com.gmail.renanfr1047.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberVerifier {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			PrimeNumberVerifier primeNumberVerifier = new PrimeNumberVerifier();
			primeNumberVerifier.log("Type the number to check if it is prime: ");
			Integer numberToCheck = Integer.parseInt(scanner.nextLine());
			primeNumberVerifier.run(numberToCheck);
		}
	}

	public void run(Integer numberToCheck) {
		List<Integer> firstFewPrimeNumbersList = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23));
		Integer maximumPrimeNumberSample = firstFewPrimeNumbersList.get(firstFewPrimeNumbersList.size() - 1);
		if (numberToCheck <= maximumPrimeNumberSample) {
			log("Sorry We are only checking numbers above %d", maximumPrimeNumberSample);
			return;

		}
		Integer two = firstFewPrimeNumbersList.get(0);
		Integer numberDividedByPrime = numberToCheck / two;
		Integer remainderOfNumberDividedByPrime = numberToCheck % two;
		firstFewPrimeNumbersList.remove(two);
		boolean isPrimeNumber = false;

		checkPrimeNumberLoop: while (remainderOfNumberDividedByPrime != 0) {
			for (Integer primeNumber : firstFewPrimeNumbersList) {
				numberDividedByPrime = numberToCheck / primeNumber;
				remainderOfNumberDividedByPrime = numberToCheck % primeNumber;
				boolean finishedChecking = numberDividedByPrime <= primeNumber || remainderOfNumberDividedByPrime == 0;
				isPrimeNumber = finishedChecking && remainderOfNumberDividedByPrime != 0;
				if (finishedChecking) {
					break checkPrimeNumberLoop;
				}
			}

		}
		log("%d is %s", numberToCheck, isPrimeNumber ? "prime" : "not prime");
	}

	public void log(String message, Object... args) {
		System.out.printf(message, args);
	}

}
