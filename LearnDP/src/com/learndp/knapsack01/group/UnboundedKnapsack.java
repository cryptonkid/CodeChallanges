package com.learndp.knapsack01.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnboundedKnapsack {
	/**
	 * Kanpsack With Duplicate Weights.
	 * Given weights and values related to n items and the maximum capacity allowed for these items.
	 *  What is the maximum value we can achieve if we can pick any weights any number of times for a total allowed weight of W?

Input:
The first line of input contains an integer denoting the number of test cases. Then T test cases follow .
Each test case contains two integers N and W denoting the number of items and the total allowed weight.
In the next two lines are space separated values of the array denoting values of the items (val[]) and their weights (wt[]) respectively.

Output:
For each test case, in a new line, print the  maximum value which we can achieve if we can pick any weights any number of times for a bag of size W.

Constraints:
1 <= T <= 100
1 <= N, W <= 103
1 <= wt[], val[] <= 100

Example:
Input:
2
2 3
1 1 // val[]
2 1 // wt[]
4 8
1 4 5 7
1 3 4 5
Output:
3
11

** For More Input/Output Examples Use 'Expected Output' option **
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases-- > 0) {
		    String str[] = br.readLine().split("\\s+");
			int n = Integer.parseInt(str[0]);
			int W = Integer.parseInt(str[1]);
			int wt[] = new int[n];
			int val[] = new int[n];
			str = br.readLine().split("\\s+");
			for(int i = 0;i < n; i++){
			   val[i] = Integer.parseInt(str[i]);
			}
			str = br.readLine().split("\\s+");
			for(int i = 0;i < n; i++){
			   wt[i] = Integer.parseInt(str[i]);
			}
		    System.out.println(maxValueUnboundedKnapsack(wt,val,n,W));
		}*/
		System.out.println(maxValueUnboundedKnapsack(new int[] {2,1},new int[] {1,1},2,3));
		System.out.println(maxValueUnboundedKnapsack(new int[] {1,1},new int[] {2,1},4,8));
		
	}
	/** 
	 * Find is the maximum value when weights can be duplicated.
	 * :TopDown Approach:  Logic is similar to that of knapsack.
	 *  Here the weight will get processed only when you don't pick it. 
	 *  i.e. 
	 *  knapsack(n)        ---> If you  pick weight(n) --> then don't add the value(n) --> go to next weight pick from remaining n-1 weights             --> dp[i-1][j-wt[i-1]]
	 *  UnboundKnapsack(n) ---> If you  pick weight(n) --> then Re-add    the value(n) --> re-pick the same weight (don't go to the remaining n weights) --> dp[i  ][j-wt[i-1]]
	 *  				
	 */
	public static int maxValueUnboundedKnapsack(int wt[],int val[],int n,int W) {
		int dp[][] = new int[n+1][W+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<W+1;j++) {
				if(i == 0 || j==0) {
					dp[i][j] = 0; 
				}
				else 
				{ 
					if(wt[i-1] > j) {
						dp[i][j] = dp[i-1][j]; 
					}
					else {
						//Note: the value of i in accepting the solution.
						dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]],
														dp[i-1][j]);
					}
				}
			}
		}//End of i loop
		for (int[] row : dp) 
            System.out.println(Arrays.toString(row)); 
		return dp[n][W];
	}

}
