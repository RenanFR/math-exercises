package com.gmail.renanfr1047.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrangeFarmTest {

	@DisplayName("Ensure orange farm question answer is correct")
	@Test
	void ensureCorrectReply() {
		OrangeFarm orangeFarm = new OrangeFarm();
		OrangeFarm orangeFarmSpy = Mockito.spy(orangeFarm);
		orangeFarmSpy.run();
		
		int expectedThreeDaysProduction = 10379;
		int actualThreeDaysProduction = orangeFarmSpy.threeDaysProduction;
		assertEquals(expectedThreeDaysProduction, actualThreeDaysProduction,
                "The value of threeDaysProduction should be 10379");
		
		int expectedDifferenceBetweenSmallestAndBiggestProduction = 1140;
		int actualDifferenceBetweenSmallestAndBiggestProduction = orangeFarmSpy.differenceBetweenSmallestAndBiggestProduction;
		assertEquals(expectedDifferenceBetweenSmallestAndBiggestProduction, actualDifferenceBetweenSmallestAndBiggestProduction,
				"The value of differenceBetweenSmallestAndBiggestProduction should be 1140");
		
		verify(orangeFarmSpy, Mockito.times(1)).log("Three days production: 10379");
		verify(orangeFarmSpy, Mockito.times(1)).log("Difference between smallest and biggest production: 1140");
	}

}
