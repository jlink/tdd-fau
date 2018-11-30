package fau.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EuroTest {

	private Euro two;

	@BeforeEach
	void initialize() {
		two = new Euro(2.00);
	}

	@Test
	void amount() {
		Euro two = new Euro(2.00);
		assertTrue(two.getAmount() == 2.00);
	}

	@Test
	void adding() {
		Euro sum = two.plus(two);
		assertEquals(new Euro(4.00), sum);
		assertEquals(new Euro(2.00), two);
	}

	@Test
	void cannotCreateNegativeEuroAmount() {
		assertThrows(IllegalArgumentException.class, () -> {
			final double NEGATIVE_AMOUNT = -2.00;
			new Euro(NEGATIVE_AMOUNT);
		});
	}
}