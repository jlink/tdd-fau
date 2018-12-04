package fau.testdoubles;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EuroConverterTests {

	@Test
	void euroAmountWithMockito() {
		RateProvider mockProvider = mock(RateProvider.class);
		when(mockProvider.getRate("CHF", "EUR")).thenReturn(2.0);
		EuroConverter converter = new EuroConverter(mockProvider);
		assertEquals(6.0, converter.euroAmount(3.0, "CHF"), 0.001);
		//not really necessary here:
		verify(mockProvider).getRate("CHF", "EUR");
	}

	@Nested
	class CollaborationTests {

		@Test
		void callsRateProviderWithForeignCurrencyFirstAndEuroSecond() {
			RateProvider mockProvider = mock(RateProvider.class);
			EuroConverter converter = new EuroConverter(mockProvider);
			converter.euroAmount(3.0, "CHF");
			verify(mockProvider).getRate("CHF", "EUR");
		}

		@Test
		void handlesZeroRate() {
			RateProvider mockProvider = mock(RateProvider.class);
			when(mockProvider.getRate("XYZ", "EUR")).thenReturn(0.0);
			EuroConverter converter = new EuroConverter(mockProvider);
			assertEquals(0.0, converter.euroAmount(1.0, "XYZ"));
		}

		@Test
		void handlesMaximumAllowedRate() {
			RateProvider mockProvider = mock(RateProvider.class);
			when(mockProvider.getRate("XYZ", "EUR")).thenReturn(1000000000.0);
			EuroConverter converter = new EuroConverter(mockProvider);
			assertEquals(2000000000.0, converter.euroAmount(2.0, "XYZ"));
		}

		@Test
		void handlesIllegalArgumentException() {
			RateProvider mockProvider = mock(RateProvider.class);
			when(mockProvider.getRate("XYZ", "EUR")).thenThrow(new IllegalArgumentException());
			EuroConverter converter = new EuroConverter(mockProvider);
			assertEquals(0.0, converter.euroAmount(3.0, "XYZ"));
		}

	}


}
