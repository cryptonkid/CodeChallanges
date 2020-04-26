package com.dailycodingproblem.blog.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This problem was asked by Uber.
 * Given an array of integers, return a new array such that each element at index i of the new array
 *  is the product of all the numbers in the original array except the one at i.
 *  For example, if our input was [1, 2, 3, 4, 5], 
 *  the expected output would be [120, 60, 40, 30, 24]. 
 *  If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *  Follow-up: what if you can't use division?
 * 
 * @author Vivek.Singh
 *
 */
public class Day2 {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> input = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] consoleInput = null;
		
		if(!str.isEmpty())
			 consoleInput = br.readLine().split(" ");
		int noofInputs = consoleInput.length;
		
		for(int i=0;i< noofInputs;i++) {
			input.add(Integer.parseInt(consoleInput[i]));
		}
		
		List<Integer> output1 = withDivision(input);
		List<Integer> output2 = withoutDivision(input);

	}
	
	private static ArrayList<Integer> withDivision(ArrayList<Integer> input) {
		return null;
	}
	
	private static ArrayList<Integer> withoutDivision(ArrayList<Integer> input){
		return null;
	}

}
