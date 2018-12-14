package fau.primes;

import java.util.*;

public class Primes {
	public static List<Integer> factorsOf(int number) {
		List<Integer> factors = new ArrayList<>();
		for (int prime = 2; prime <= number; prime++) {
			while (number % prime == 0) {
				factors.add(prime);
				number = number / prime;
			}
		}

		return factors;
	}
}
