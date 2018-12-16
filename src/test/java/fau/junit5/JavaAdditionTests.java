package fau.junit5;

import org.junit.jupiter.api.*;

class JavaAdditionTests {

	// Delete all test methods before demo

	@Test
	void intsCanBeAdded() {
		int sum = 5 + 6;
		Assertions.assertEquals(11, sum);
		Assertions.assertEquals(-13, 3 + 7 + (-23));
	}

	@Test
	void doublesCanBeAdded() {
		double aTenth = 0.1;
		double sum = aTenth + aTenth + aTenth;
		Assertions.assertEquals(0.3, sum, 0.001);
	}
}
