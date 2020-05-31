package com.learndp.unboundedknapsack.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * 
 * Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'M' denoting the size of array. The second line contains M space-separated integers A1, A2, ..., AN denoting the elements of the array. The third line contains an integer 'N' denoting the cents.

Output:
Print number of possible ways to make change for N cents.

Constraints:
1 ≤ T ≤ 50
1 ≤ N ≤ 300
1 ≤ A[i] ≤ 300

Example:
Input:
2
3
1 2 3
4
4
2 5 3 6
10

Output:
4
5

Explanation:
Testcase 1: The possiblities are as such: {1, 1, 1, 1}, {1, 1, 2}, {1, 3}, {2, 2}.

** For More Input/Output Examples Use 'Expected Output' option **
 * @author Vivek.Singh
 *
 */
public class CoinChangeMaximumNoWays {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while(testCases-- > 0) {
		    int N = Integer.parseInt(br.readLine());
			String str[] = br.readLine().split("\\s+");
			int coinsval[] = new int[N];
			for(int i = 0;i < N; i++){
				   coinsval[i] = Integer.parseInt(str[i]);
			}
			int sum =  Integer.parseInt(br.readLine());
			System.out.println(maximumCoinChange(coinsval,sum,N));
		}
		System.out.println(maximumCoinChange(new int[] {2, 5, 3, 6},10,4));
	}
	
	/**
	 * This problem is similar to count of subset problem in SubsetSumDP2.java : countNoOfSubSets
	 * @param coin
	 * @param sum
	 * @return
	 */
	public static int maximumCoinChange(int coinValue[],int sum,int noOfCoins) {
		//int noOfCoins = coinValue.length;
		int dp[][] = new int[noOfCoins+1][noOfCoins+1];
		for(int i=0;i<noOfCoins+1;i++) {
			for(int j=0;j<noOfCoins+1;j++) {
				if(i==0 || j==0) {
					if(i==0)
						dp[i][j] = 0;
					if(j == 0)
						dp[i][j] = 1;
				}
				else {
					if(coinValue[i-1] > sum)
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = dp[i][j-coinValue[i-1]]+ dp[i-1][j];
				}
			}
		}
		return dp[noOfCoins][noOfCoins];
	}
}
