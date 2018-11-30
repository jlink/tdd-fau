package fau.junit5;

import org.junit.jupiter.api.*;

class UnexpectedExceptionTest {
	@Test
	void unexpectedException() throws Exception {
		new java.io.FileWriter("x:/unknownFile");
	}
}