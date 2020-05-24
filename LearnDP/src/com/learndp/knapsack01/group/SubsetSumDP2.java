package com.learndp.knapsack01.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

/**
 * Subset Sum Problem
Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both subsets is same or not.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Each test case consists of two lines. First-line contains 'N', representing the number of elements in the set and the second line contains the elements of the set.

Output:
For each test case, print YES if the partition is possible, otherwise print NO.

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N)

User Task:
You don't need to read input or print output, taking inputs and printing is done by the driver code. Your task is to complete the findPartition() function and return true if the given set can be partitioned into two subsets such that the sum of elements in both subsets is equal, else return false.

Constraints:
1 <= T <= 100
1 <= N <= 100
0 <= arr[i] <= 1000

Example:
Input:
2
4
1 5 11 5
3
1 3 5 
Output:
YES
NO

Explanation:
Testcase 1: There exists two subsets such that {1, 5, 5} and {11}.
 * @author Vivek.Singh
 *
 */
public class SubsetSumDP2 {

	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCases = Integer.parseInt(br.readLine());
//		while(testCases-- > 0) {
//			
//		}
		
		//System.out.println(findEqualSumPartitionSetExists(new int[] {1,2,3},3));
		//System.out.println(findEqualSumPartitionSetExists(new int[] {478,757,314,471,729,100,459,618}, 8));
		System.out.println("============ If Subset exist with sum of 3 ==============");
		System.out.println(topDownIsSubsetSumExists(new int[] {1,2,3},3,3));
		System.out.println("============ Count of Subsets of sum 3 ==============");
		System.out.println(countNoOfSubSets(new int[] {1,2,3},3,3));
		
		
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
	public boolean recursiveIsSubsetSumExists(int input[], int sum , int n) {
		if(n == 0 )
			return false;
		if(sum == 0)
			return true;
		else if( input[n] > sum ) {
			return recursiveIsSubsetSumExists(input, sum, n-1); //do not include the number.
		}
		else {
			//As math.max is for value but now we are trying of find if the sum exist or not. 
			return (recursiveIsSubsetSumExists(input, sum-input[n], n-1) || recursiveIsSubsetSumExists(input, sum, n-1) );
		}
		
	}
	
	/**
	 * Top Down approach : 
	 * 1) create an array of size n+1, sum+1
	 * Time complexity:  (n*W) i.e. W is weight/Sum and n is number of elements in a set. 
	 */
	public static boolean topDownIsSubsetSumExists(int arr[],int sum,int n) {
		boolean dp[][] = new boolean[n+1][sum+1];
		for(int i = 0;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				if(i==0 || j == 0) {
					if(i == 0)
						dp[i][j] = false;
					if(j == 0)
						dp[i][j] = true;
				}
				else {
					if(arr[i-1] > j)//j not sum
						dp[i][j] = false;
					else
						dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				}
			}
		}
		for (boolean[] row : dp) 
            System.out.println(Arrays.toString(row));
		return dp[n][sum];
	}
	
	/*
	 * Function to find number of Subset with a given sum in a set
	 * Logic : It is same as the if subset sum exists. As every true
	 * 	will lead to addition of count.
	 */
	public static int countNoOfSubSets(int []a,int sum, int n) {
		int dp[][] = new int[n+1][sum+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i == 0 || j ==0) {
					if(i == 0)
						dp[i][j]=0;
					if(j==0)
						dp[i][j] = 1 ; //null set (null set is part of every set)
				}
				else {
					if(a[i-1] > j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j-a[i-1]] + dp[i-1][j];
				}
			}
		}
		for (int[] row : dp) 
            System.out.println(Arrays.toString(row)); 
		return dp[n][sum];
	}
	 
	/**
	 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/ 
	 * Here final sum is not given . //Equal sum Partition
	 * 1) sum of all the elements must be even : one can then divide the partition into 2 equal partitions. 
	 * 2) then find if the sum of half of sum of all the elements exists in the set or not
	 * 		Just like isSubsetSumExists.
	 * @param a
	 * @param n
	 * @return
	 */
	public static boolean findEqualSumPartitionSetExists(int[] a, int n) {
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
        }//End of else
        
	}//end of findPartition 

}