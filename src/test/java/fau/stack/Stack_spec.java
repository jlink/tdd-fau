package fau.stack;

import java.util.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Stack_spec {

	Stack<Object> stack;

	@Test
	void A_stack_is_instantiated_using_its_noarg_constructor() {
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
	}

	@Nested
	class An_empty_stack {

		@BeforeEach
		void createEmptyStack() {
			stack = new Stack<>();
		}

		@Test
		void throws_an_EmptyStackException_when_popped() {
			assertThrows(EmptyStackException.class, () -> stack.pop());
		}

		@Test
		void throws_an_EmptyStackException_when_peeked() {
			assertThrows(EmptyStackException.class, () -> stack.peek());
		}

		@Test
		void acquires_depth_by_retaining_a_pushed_item() {
			int depth = stack.size();
			stack.push("first element");
			assertEquals(depth + 1, stack.size());
		}

	}

	@Nested
	class A_non_empty_stack {

		String anElement = "an element";

		@BeforeEach
		void pushAnElement() {
			stack = new Stack<>();
			stack.push(anElement);
		}

		@Test
		void is_no_longer_empty() {
			assertFalse(stack.isEmpty());
		}

		@Test
		void returns_last_pushed_item_when_popped_and_removes_it_from_stack() {
			assertEquals(anElement, stack.pop());
			assertTrue(stack.isEmpty());
		}

		@Test
		void returns_last_pushed_item_when_peeked() {
			assertEquals(anElement, stack.peek());
			assertFalse(stack.isEmpty());
		}

		@Test
		void acquires_more_depth_when_another_item_is_pushed() {
			int depth = stack.size();
			stack.push("another element");
			assertEquals(depth + 1, stack.size());
		}
	}
}
