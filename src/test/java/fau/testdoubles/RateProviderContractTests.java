package fau.testdoubles;

import org.junit.jupiter.api.*;

class RateProviderContractTests {

	interface RateProviderContract {

		RateProvider createProvider();

		@Test
		default void throws_IAE_for_unknown_currency() { }

		@Test
		default void throws_IAE_for_same_currency() { }

		@Test
		default void valid_rate_always_above_0() { }

		@Test
		default void valid_rate_always_below_1e9() { }

	}

	@Nested
	class WebcrawlingProviderContractTests implements RateProviderContract {
		@Override
		public RateProvider createProvider() {
			return new WebcrawlingRateProvider();
		}
	}

	@Nested
	class DatabaseProviderContractTests implements RateProviderContract {
		@Override
		public RateProvider createProvider() {
			return new DatabaseRateProvider();
		}
	}
}
