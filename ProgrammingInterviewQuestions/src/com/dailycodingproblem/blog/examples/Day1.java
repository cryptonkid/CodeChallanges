package com.dailycodingproblem.blog.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * This problem was recently asked by Google. Given a list of numbers and a
 * number k, return whether any two numbers from the list add up to k. For
 * example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 * 
 * @author Vivek.Singh
 *
 */

public class Day1 {

	public static void main(String[] args) throws IOException {

		System.out.println("Inside main method. ");
		

		/*
		 * BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); int
		 * arr[] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		 */

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input array");
		String lines = scanner.nextLine();
		String[] strs = lines.trim().split("\\s+");
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int i = 1;
		for (String input : strs) {
			int number = Integer.parseInt(input); 
			list.add(number);
			//value,location
			map.put(number,i++);
		}
		int count = list.size();
		System.out.println("Enter the input sum");
		int sum = scanner.nextInt();

		//System.out.println("sum :" + sum + "List" + list.size());

		for (int i1 = 0; i1 < count; i1++) {
			int num = list.get(i1);
			int pairNum = sum - num;
			System.out.println("Num "+ num +"pairNum "+pairNum);
			if (map.containsKey(pairNum)) {
				int location = (map.get(pairNum));
				System.out.println("pair founded at ("+ (i1+1) + "," + location +")");
			}
		}
	}
}
/*
 * Need to reduce memory footprint and improve for solution pair.
 * Inside main method. 
Enter the input array
10 20 30 40 50
Enter the input sum
60
pairNum50
pair founded at (1,5)
pairNum40
pair founded at (2,4)
pairNum30
pair founded at (3,3)
pairNum20
pair founded at (4,2)
pairNum10
pair founded at (5,1)
 
 */
