package com.gmail.renanfr1047.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TelevisionInstallmentsTest {
	
	@DisplayName("Ensure expected interest was charged")
	@Test
	void ensureCorrectReply() {
		TelevisionInstallments televisionInstallments = new TelevisionInstallments();
		TelevisionInstallments televisionInstallmentsSpy = Mockito.spy(televisionInstallments);
		televisionInstallmentsSpy.run();
		
		int expectedRawInterest = 306;
		int actualRawInterest = televisionInstallmentsSpy.rawInterest;
		assertEquals(expectedRawInterest, actualRawInterest,
                "The value of rawInterest should be 306");
		
		verify(televisionInstallmentsSpy, Mockito.times(1)).log("Interest charged was: 306");
	}

}
