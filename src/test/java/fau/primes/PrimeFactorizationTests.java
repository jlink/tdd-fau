package fau.primes;

import java.util.*;

import org.junit.jupiter.api.*;

class PrimeFactorizationTests {

	// Delete all tests and PrimeFactorizationProperties before demo

	@Test
	void primes() {
		assertPrimeFactors(2, Arrays.asList(2));
		assertPrimeFactors(3, Arrays.asList(3));
		assertPrimeFactors(103, Arrays.asList(103));
	}

	@Test
	void powersOfPrimes() {
		assertPrimeFactors(4, Arrays.asList(2, 2));
		assertPrimeFactors(27, Arrays.asList(3, 3, 3));
		assertPrimeFactors(121, Arrays.asList(11, 11));
	}

	@Test
	void factorsOfMixedMultiplesAreSorted() {
		assertPrimeFactors(12, Arrays.asList(2, 2, 3));
		assertPrimeFactors(30030, Arrays.asList(2, 3, 5, 7, 11, 13));
	}

	private void assertPrimeFactors(int number, List<Integer> expectedFactors) {
		Assertions.assertEquals(expectedFactors, Primes.factorsOf(number));
	}
}
