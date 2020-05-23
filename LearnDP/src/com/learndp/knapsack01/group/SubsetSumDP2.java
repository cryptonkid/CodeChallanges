package com.learndp.knapsack01.group;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * 
 * 
 * Given a set of non-negative integers, and a value sum.
 * Determine if there is a subset of the given set with sum equal to given sum.
 * 
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True  
 * There is a subset (4, 5) with sum 9.
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.


 * @author Vivek.Singh
 *
 */
public class SubsetSumDP2 {

	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int testCases = Integer.parseInt(br.readLine());
		System.out.println(findPartition(new int[] {1,2,3},3));
		//System.out.println(findPartition(new int[] {478,757,314,471,729,100,459,618}, 8));
		
		
	}
	/**
	 * Similarity to knapsack01 : 
	 * 	KnapsackCapacity = Sum
	 *  weight array = input array of elements. 
	 *  Remove all the places where value array was used and keep
	 *  
	 * when arr[] : no elements    : sum = 0 is it possible : False
	 * when arr[] : no elements    : sum = 1 is it possible : False
	 * i.e. when n = 0 return false
	 * 
	 * when arr[]    : no  elements      : sum = 0 is it possible : True i.e. empty set.
	 * when arr[1]   : one element       : sum = 0 is it possible : True i.e. empty set.
	 * when arr[1,2] : two elements      : sum = 0 is it possible : True i.e. empty set.
	 * 
	 * i.e. when sum = 0 return true
	 * @return
	 */
	public boolean recursiveSubsetSum(int input[], int sum , int n) {
		if(n == 0 )
			return false;
		if(sum == 0)
			return true;
		else if( input[n] > sum ) {
			return recursiveSubsetSum(input, sum, n-1); //do not include the number.
		}
		else {
			//As math.max is for value but now we are trying of find if the sum exist or not. 
			return (recursiveSubsetSum(input, sum-input[n], n-1) || recursiveSubsetSum(input, sum, n-1) );
		}
		
	}
	
	/**
	 * Top Down approach : 
	 * 1) create an array of size n+1, sum+1
	 */
	public boolean topDownSubsetSum(int arr[],int sum,int n) {
		boolean dp[][] = new boolean[n+1][sum+1];
		for(int i = 0;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				if(i == 0)
					dp[i][j] = false;
				if(j == 0)
					dp[i][j] = true;
				else if(arr[i] > j)//j not sum 
					dp[i][j] = false;
				else
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
			}
		}
		return dp[n+1][sum+1];
	}
	/**
	 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/ 
	 * Here final sum is not given .
	 * @param a
	 * @param n
	 * @return
	 */
	public static boolean findPartition(int[] a, int n) {
        int sum = 0;
        for(int i =0 ;i<n;i++)
         sum = sum + a[i];
        if(sum%2 != 0)
            return false;
        else{
            //(sum/2) is the target : similar to weight/KanpsackCapacity .
            sum = sum/2;
            boolean dp[][] = new boolean[n+1][sum+1];
            for(int i =0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    if(i == 0 || j == 0 ) {
                    	if(i == 0)
                            dp[i][j] = false;
                           if(j == 0)
                            dp[i][j] = true;
                    }
                    else {
                    	if(a[i-1] > j)
                            dp[i][j] = false;
                        else
                            dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
                    }   
                }
            }
            return dp[n][sum];
        }
	}
	
}
