package com.learndp.unboundedknapsack.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RodCutting {
	/**
	 * https://practice.geeksforgeeks.org/problems/rod-cutting/0
	 * 
	 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Input:
First line consists of T test cases. First line of every test case consists of n, denoting the size of array. Second line of every test case consists of price of ith length piece.

Output:
For each testcase, in a new line, print a single line output consists of maximum price obtained.

Constraints:
1 <= T <= 100
1 <= n <= 100
1 <= Ai <= 100

Example:
Input:
1
8
1 5 8 9 10 17 17 20
Output:
22

** For More Input/Output Examples Use 'Expected Output' option **
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases-- > 0) {
			int rodLength =  Integer.parseInt(br.readLine());
			String str[] = br.readLine().split("\\s+");
			int price[] = new int[rodLength];
			for(int i = 0;i < rodLength; i++){
				   price[i] = Integer.parseInt(str[i]);
			}
			System.out.println(rodCutting(price,rodLength));
		}*/
		System.out.println(rodCutting(new int[] {1,5,8,9,10,17,17,20},8));
		
	}
	/**
	 * This is same as unbounded knapsack.
	 * AS the same length can be cut again and again to increas the value.
	 *  Here 
	 *  	W <==>     rodLength
	 *  	wt[] <==>  various rod lengths from 0 to totalRoadLength 
	 * 		val[] <==> various profit lengths.
	 * 
	 * @param price
	 * @param length
	 * @return
	 */
	public static int rodCutting(int price[],int length) {
		int dp[][] = new int[length+1][length+1];
		int variouslen[] = new int[length];
		for(int i=0;i<length;i++) {
			variouslen[i] = i+1;
		}
		for(int i=0;i<length+1;i++) {
			for(int j=0;j<length+1;j++) {
				if(i ==0||j==0) {
					dp[i][j] = 0;
				}
				else {
					if(variouslen[i-1] > j)
						dp[i][j] =  dp[i-1][j];
					else
					dp[i][j] = Math.max(price[i-1] + dp[i][j-variouslen[i-1]], 
													dp[i-1][j]);
				}
			}
		}
		return dp[length][length];
	}
	

}
