package fau.primes;

import java.util.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

class PrimeFactorizationProperties {

	@Property
	boolean all_primes_are_factorized_as_themselves(@ForAll("primes") int aPrime) {
		return Primes.factorsOf(aPrime).equals(Arrays.asList(aPrime));
	}

	@Property
	boolean factors_contain_only_primes(@ForAll @IntRange(min = 2, max = 10000000) int aNumber) {
		return Primes.factorsOf(aNumber).stream().allMatch(this::isPrime);
	}

	@Property
	boolean product_of_primes_is_factorized_to_same_primes(@ForAll("listOfPrimes") List<Integer> primes) {
		primes.sort(Integer::compareTo);
		long product = primes.stream().mapToLong(i -> i).reduce(1, (a, b) -> a * b);
		Assume.that(product <= Integer.MAX_VALUE);

		return Primes.factorsOf((int) product).equals(primes);
	}

	@Provide
	Arbitrary<Integer> primes() {
		return Arbitraries.of( //
				2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, //
				53, 59, 61, 67, 71, 73, 79, 83, 89, 97 //
		);
	}

	@Provide
	Arbitrary<List<Integer>> listOfPrimes() {
		return primes().list().ofMinSize(2).ofMaxSize(10);
	}

	private boolean isPrime(Integer number) {
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 2; i < sqrt; i++)
			if (number % i == 0) return false;
		return true;
	}
}
