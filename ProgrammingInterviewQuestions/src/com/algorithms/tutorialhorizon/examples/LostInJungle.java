package com.algorithms.tutorialhorizon.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *  
 * @author Vivek.Singh
 *
 */
/**
 * Objective: Given a number N, write an algorithm to find the maximum number of steps it takes to transform (1, N) to 1 using Collatz Conjecture. 
 * The Collatz conjecture is a conjecture in mathematics which states that no matter what value of Positive Number N, If the below sequence is followed then the sequence will always reach 1.
 *	If N is even, then do N = N/2
 * If N is odd then do N = 3*N+1
 * If N is 1 then stop else keep performing step 1 and step 2.
 * 
 *  Sample input : N = 20
 *  
 */
/**
 * asked in airtel payment bank mettle code
 * @author Vivek.Singh
 *
 */
public class LostInJungle {
	public static void main(String args[]) {
		try {
				int maxSteps = 0;
				int maxValue = 0;
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int testCases = Integer.parseInt(br.readLine());
				while(testCases-- > 0) {
					int n = Integer.parseInt(br.readLine());
					HashMap<Integer, Integer> map = new HashMap<>();
					int steps = new LostInJungle().collatz(n,map);
					if(maxSteps < steps) {
						maxSteps = Math.max(maxSteps, steps);
						maxValue = n;
					}
				}				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int collatz(int n, HashMap<Integer,Integer> map) {
		if (n < 2)
			return 1;
		if(map.containsKey(n))
			return map.get(n);
		else if (n/2 == 0) {
			int value = collatz(n/2,map)+1;
			map.put(n, value);
			return map.get(n);//return value
		}
		else {
			int value = collatz(3*n+1,map)+1;
			map.put(n, value);
			return map.get(n);
		}
	}
	 
}
