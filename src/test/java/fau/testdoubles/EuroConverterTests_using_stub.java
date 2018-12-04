package fau.testdoubles;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EuroConverterTests_using_stub {
	@Test
	void euroAmount() {
		RateProvider provider = new RateProviderStub();
		EuroConverter converter = new EuroConverter(provider);
		assertEquals(6.0, converter.euroAmount(3.0, "CHF"), 0.001);
	}

	static class RateProviderStub implements RateProvider {
		@Override
		public double getRate(String fromCurrency, String toCurrency) {
			return 2.0;
		}
	}

	@Test
	void unknownCurrencyIsConvertedToZeroEuros() {
		RateProvider provider = (from, to) -> {
			throw new IllegalArgumentException();
		};
		EuroConverter converter = new EuroConverter(provider);
		assertEquals(0.0, converter.euroAmount(3.0, "XYZ"));
	}
}
