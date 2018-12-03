package fau.leapyear;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Stolen from Kevlin Henneys talk "Structure and Interpretation of Test  Cases"
 * https://vimeo.com/289852238
 */

class Leap_year_spec {

	@Nested
	class A_year_is_a_leap_year {

		@Test
		void if_it_is_divisible_by_four_but_not_by_100() {
			assertAll(
					() -> assertTrue(isLeapYear(4)),
					() -> assertTrue(isLeapYear(1984)),
					() -> assertTrue(isLeapYear(2016))
			);
		}

		@Test
		void if_it_is_divisible_by_400() {
			assertAll(
					() -> assertTrue(isLeapYear(400)),
					() -> assertTrue(isLeapYear(2000)),
					() -> assertTrue(isLeapYear(2400))
			);
		}

	}

	@Nested
	class A_year_is_not_a_leap_year {

		@Test
		void if_it_is_not_divisible_by_four() {
			assertAll(
					() -> assertFalse(isLeapYear(1)),
					() -> assertFalse(isLeapYear(42)),
					() -> assertFalse(isLeapYear(2018)),
					() -> assertFalse(isLeapYear(2019))
			);
		}

		@Test
		void if_it_is_divisible_by_100_but_not_by_400() {
			assertAll(
					() -> assertFalse(isLeapYear(100)),
					() -> assertFalse(isLeapYear(1900)),
					() -> assertFalse(isLeapYear(2100))
			);
		}
	}

	private static boolean isLeapYear(int year) {
		return year % 4 == 0
					   && year % 100 != 0
					   || year % 400 == 0;
	}

}
