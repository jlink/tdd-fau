package fau.stack;

import java.util.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copied over from JUnit 5 repository
 */
@DisplayName("A stack")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StackTestCase {

	Stack<Object> stack;

	@Test
	void is_instantiated_using_its_noarg_constructor() {
		new Stack<>();
	}

	@Nested
	class A_new_stack {

		@BeforeEach
		void createNewStack() {
			stack = new Stack<>();
		}

		@Test
		void is_empty() {
			assertTrue(stack.isEmpty());
		}

		@Test
		void throws_an_EmptyStackException_when_popped() {
			assertThrows(EmptyStackException.class, () -> stack.pop());
		}

		@Test
		void throws_an_EmptyStackException_when_peeked() {
			assertThrows(EmptyStackException.class, () -> stack.peek());
		}

		@Nested
		class After_pushing_an_element_to_an_empty_stack {

			String anElement = "an element";

			@BeforeEach
			void pushAnElement() {
				stack.push(anElement);
			}

			@Test
			void the_stack_is_no_longer_empty() {
				assertFalse(stack.isEmpty());
			}

			@Test
			void pop_returns_that_element_and_leaves_an_empty_stack() {
				assertEquals(anElement, stack.pop());
				assertTrue(stack.isEmpty());
			}

			@Test
			void peek_returns_that_element_without_removing_it_from_the_stack() {
				assertEquals(anElement, stack.peek());
				assertFalse(stack.isEmpty());
			}
		}
	}
}
