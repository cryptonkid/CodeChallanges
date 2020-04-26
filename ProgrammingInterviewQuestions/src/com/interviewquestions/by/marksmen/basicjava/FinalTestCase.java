package com.interviewquestions.by.marksmen.basicjava;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FinalTestCase {

	@Test
	public void finalReferenceChanges() {
		final int i = 42;
		// i = 43; <- uncommenting this line would result in a compiler error
		final List<String> list = new ArrayList<>(20);
		// list = new ArrayList(50); <- uncommenting this line will result in an error
		assertEquals(0, list.size());
		list.add("adding a new value into my list");
		assertEquals(1, list.size());
		list.clear();
		assertEquals(0, list.size());
		}

}
