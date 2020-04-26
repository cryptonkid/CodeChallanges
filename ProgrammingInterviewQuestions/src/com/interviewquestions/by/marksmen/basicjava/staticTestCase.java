package com.interviewquestions.by.marksmen.basicjava;

import static org.junit.Assert.*;

import org.junit.Test;

public class staticTestCase {

	public static class ExampleClass {
		public static int EXAMPLE_VALUE = 6;
	}

	@Test
	public void staticVariableAccess() {
		assertEquals(ExampleClass.EXAMPLE_VALUE, 6);
		ExampleClass c1 = new ExampleClass();
		ExampleClass c2 = new ExampleClass();
		c1.EXAMPLE_VALUE = 22; // permitted, but not recommended
		assertEquals(ExampleClass.EXAMPLE_VALUE, 22);
		assertEquals(c2.EXAMPLE_VALUE, 22);
	}

}
