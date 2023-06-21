package com.gmail.renanfr1047.math;

import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PrimeNumberVerifierTest {

	public static final List<Integer> PRIME_NUMBERS_ABOVE_23 = Collections
			.unmodifiableList(Arrays.asList(29, 31, 37, 41, 43, 47, 53, 59, 61, 67));

	public static final List<Integer> NON_PRIME_NUMBERS = Collections
			.unmodifiableList(Arrays.asList(24, 25, 26, 28, 30, 32, 33, 34, 35, 36));

	@DisplayName("Check if the logic of verifying prime numbers is correct")
	@Test
	void ensureCorrectReply() {
		PrimeNumberVerifier primeNumberVerifier = new PrimeNumberVerifier();
		PrimeNumberVerifier primeNumberVerifierSpy = Mockito.spy(primeNumberVerifier);
		PRIME_NUMBERS_ABOVE_23.forEach(primeNumber -> {
			primeNumberVerifierSpy.run(primeNumber);
			verify(primeNumberVerifierSpy, Mockito.times(1)).log("%d is %s", primeNumber, "prime");
		});
		NON_PRIME_NUMBERS.forEach(primeNumber -> {
			primeNumberVerifierSpy.run(primeNumber);
			verify(primeNumberVerifierSpy, Mockito.times(1)).log("%d is %s", primeNumber, "not prime");
		});
	}

}
