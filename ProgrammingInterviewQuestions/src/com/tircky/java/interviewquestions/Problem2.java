package com.tircky.java.interviewquestions;

import java.util.HashSet;

public class Problem2 {

	public static void main(String[] args) {
		
		/*
		 * o/p : 100 :
		 * Explanation : The size of the shortSet will be 100. Java Autoboxing feature has been introduced in JDK 5, so while adding the short to HashSet<Short> it will automatically convert it to Short object. Now “i-1” will be converted to an int while evaluation and after that it will autoboxed to Integer object but there is no Integer object in the HashSet, so it will not remove anything from the HashSet and finally its size will be 100.
		 */
		HashSet shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
			shortSet.add(i);
			shortSet.remove(i - 1);
		}
		System.out.println("Size of shortSet"+shortSet.size());
		
		/**
		 * Here size o/p is 1
		 */
		HashSet<Short> shortSet2 = new HashSet<>();
		for (short i = 0; i < 100; i++) {
			shortSet2.add(i);
			shortSet2.remove((short)(i - 1));
		}
		System.out.println("Size of shortSet2 "+shortSet.size());

	}

}
