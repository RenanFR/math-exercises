package com.gmail.renanfr1047.math;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		new SieveOfEratosthenes().run();
	}

	private static boolean isPrimeNumber(int number) {
		if (number <= 1) {
			return false;
		}
		boolean isDivisibleByOther = IntStream.rangeClosed(number, (int) Math.sqrt(number)).anyMatch(i -> {
			return i != number && number % i == 0;
		});
		return !isDivisibleByOther;
	}

	public void run() {
		List<Integer> numbersToEvaluate = IntStream.rangeClosed(1, 30).boxed()
				.collect(Collectors.toCollection(CopyOnWriteArrayList::new));

		for (Integer number : numbersToEvaluate) {
			if (isPrimeNumber(number)) {
				List<Integer> multiplesOfLastPrime = IntStream.rangeClosed(1, 30).map(n -> n * number).boxed()
						.collect(Collectors.toList());
				numbersToEvaluate.forEach(n -> {
					boolean isDifferentNumber = n != number;
					boolean isMultipleOfLastPrime = multiplesOfLastPrime.contains(n);
					if (isDifferentNumber && isMultipleOfLastPrime) {
						numbersToEvaluate.remove(n);
					}
				});

			} else {
				numbersToEvaluate.remove(number);
			}

		}
		numbersToEvaluate.forEach(n -> {
			System.out.println(n);
		});

	}

}
