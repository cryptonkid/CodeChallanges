package com.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Max and Second Max
Given an array arr[] of size N of positive integers which may have duplicates. The task is to find maximum and second maximum from the array, and both of them should be distinct, so If no second max exists, then second max will be -1.

Input Format:
First line of input contains number of testcases T. For each testcase, first line of input contains size of array N, next line contains array elements.

Output Format:
For each testcase, print the maximum and second maximum from the array. IF no second max exists, print "-1" for second max.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= arr[i] <= 106

User Task:
The task is to complete the function largestAndSecondLargest(), which should print maximum and second maximum element from the array.

Example:
Input:
3
5
1 2 3 4 5
3
2 1 2
2
5 5

Output:
5 4
2 1
5 -1

Explanation:
Testcase 1: From the given array elements, 5 is the largest and 4 is the second largest.
Testcase 2: From the given array elements, 2 is the largest and 1 is the second largest.
Testcase 3: From the given array elements, 5 is the largest and -1 is the second largest.

 

** For More Input/Output Examples Use 'Expected Output' option **
 */
public class MaxnSecondMax {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		while(testCases > 0) {
			int sizeOfArray = Integer.parseInt(br.readLine());
			
			int arr[] = new int[sizeOfArray];
			
			String line = br.readLine();
			String[] elements = line.split("\\s+");
			
			for(int index = 0;index<sizeOfArray;index++)
				arr[index] = Integer.parseInt(elements[index]);
			
			ArrayMax obj = new ArrayMax();
			obj.largestAndSecondLargest(sizeOfArray,arr);
		}
	}	
}
//User function Template for Java

//Solution class to implement function largestAndSecondLargest
class ArrayMax{
 
 // Function to find largest and second largest element in the array
 static void largestAndSecondLargest(int sizeOfArray, int arr[]){
     
     int max = Integer.MIN_VALUE;
     int max2 = Integer.MIN_VALUE;
     for(int i = 0;i<sizeOfArray;i++) {
    	 if(arr[i] > max) {
    		 max2 = max;
    		 max = arr[i];
    	 }
    	 //Value should not be repeating.
    	 else if(arr[i] > max2 && arr[i] != max) {
    		 max2 = arr[i];
    	 }
     }
     if(max2 == Integer.MIN_VALUE) 
    	 max2 = -1;
     
     System.out.println(max + " " + max2);
 }
}
