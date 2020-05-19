package com.learndp.knapsack01.group;

public class Knapsack01 {

	public static void main(String[] args) {
		Knapsack01 k = new Knapsack01();
		
		int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        //int r = k.recursiveKnapsack(wt,val, 30,wt.length-1); //causes stack over flow. 
        //System.out.println(r);
        
        int val1[] = {4,5,1};
        int wt1[] = {1,2,3};
        int r1 = k.recursiveKnapsack( wt1,val1, 4, wt1.length);
        System.out.println(r1);
        
        int val2[] = {4,5,6};
        int wt2[] = {1,2,3};
        int r2 = k.recursiveKnapsack(wt2, val2, 3, wt2.length);
        System.out.println(r2);
        
        /**
         * Memonization
         */
        int dp[][] = new int[wt.length][30];
        int dp1[][] = new int[wt1.length][4];
        int dp2[][] = new int[wt2.length][3];
        k.bottomUpKnapsack(wt, val, 30, wt.length, dp);
        k.bottomUpKnapsack(wt1, val1, 4, wt1.length, dp1);
        k.bottomUpKnapsack(wt2, val2, 3, wt2.length, dp2);
       /**
        * TopDown Approach
        */
        k.topDownKnapsack01(wt, val, 30, wt.length);
        k.topDownKnapsack01(wt1, val1, 4, wt1.length);
        k.topDownKnapsack01(wt2, val2, 3, wt2.length);
        

	}
	//Start from last element by seeing the base condition.
	public int recursiveKnapsack(int weights[],int values[],int knapsackCapacity,int n) {
		if(n == 0 || knapsackCapacity <= 0)
			return 0;
		if(weights[n-1] > knapsackCapacity)
			return recursiveKnapsack(weights, values, knapsackCapacity, n-1);//Do not consider the weight.
		else
			return Math.max(values[n-1] + recursiveKnapsack(weights, values, knapsackCapacity-weights[n-1], n-1), //Include the weight 
										 recursiveKnapsack(weights, values, knapsackCapacity, n-1));//Donot include the weight.
		
	}
	
	/*
	* memonization: recursive + storing value.
	* 
	* Subproblem is for each KnapsackCapacity to add the weight or not (n)
	* subsubproblem is to when knapsackCapacity can be 0/1/2/3/.../maximumKnapsackCapacity (w) 
	* 
	* hence : array[n+1][w+1] for memonization.
	* In Java instance/class array[][] default initialized to zero.
	* In C use memset function to default intialize. 
	*/ 
	
	public int bottomUpKnapsack(int weights[],int values[],int knapsackCapacity,int n,int dp[][]) {
		if(n == 0 || knapsackCapacity <= 0)
			return 0;
		//Memonization logic.
		if (dp[n][knapsackCapacity] != 0 )
			return dp[n][knapsackCapacity];
		if(weights[n-1] > knapsackCapacity)
			return dp[n][knapsackCapacity] = recursiveKnapsack(weights, values, knapsackCapacity, n-1); //Add the store logic. 
		else
			return dp[n][knapsackCapacity]= Math.max(values[n-1] + recursiveKnapsack(weights, values, knapsackCapacity-weights[n-1], n-1), //Include the weight 
										 recursiveKnapsack(weights, values, knapsackCapacity, n-1));//Donot include the weight.
		
	}
	/** Note: Come with solution using Map **/
	
	public int topDownKnapsack01(int weights[],int values[],int knapsackCapacity,int n) {
		int dp[][] = new int[n+1][knapsackCapacity+1];
		
		for(int i=0; i< n+1 ;i++) {
			for(int j=0; j < knapsackCapacity+1 ;j++) {
				if(i == 0 || j ==0) {
					dp[i][j] = 0;
					continue;
				}
				if(weights[i] > knapsackCapacity) {
					dp[i][j] = dp[i-1][j];
				}
				else
					dp[i][j] = Math.max(values[i]+dp[i-1][j-weights[i-1]],
										dp[i-1][j-weights[i-1]]); //note : how weights value is being subtracted from j as j is now knapsackCapacity.
			}
		}
		return dp[n][knapsackCapacity];
	}
	
	
}
