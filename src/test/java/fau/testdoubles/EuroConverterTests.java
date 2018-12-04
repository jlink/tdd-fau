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
}
