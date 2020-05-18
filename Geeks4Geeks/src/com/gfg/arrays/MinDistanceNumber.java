package com.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Minimum distance between two numbers
You are given an array A, of N elements. 
You need to find minimum distance between given two integers x and y. 
** Added by me : In the given array i

Distance: The distance (index-based) between two elements of the array.

Input Format:
The first line of input contains an integer T, denoting the number of test cases. 
Then T test cases follow. Each test case consists of three lines. 
The first line of each test case contains an integer N denoting size array. 
Then in the next line are N space separated values of the array A.
 The last line of each test case contains two integers  x and y.

Output Format:
For each test case, print the required answer .

Your Task:
Your task is to complete the function minDist which returns  an integer denoting the minimum distance between two integers x and y in the array. If no such distance is possible then return -1.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A, x, y <= 105

Example:
Input:
2
4
1 2 3 2
1 2
7
86 39 90 67 84 66 62 
42 12
Output:
1
-1
Explanation:
Testcase1: x = 1 and y = 2. There are two distances between x and y, which are 1 and 3 out of which the minDistance between x and y is 1.
Testcase2: x = 42 and y = 12. We return -1 as the x and y don't exist in the array.

Another sample data: 

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Explanation:
number of elements between 3 and 6 / 6 and 3 is  : 4  
{(3), 5, 4, 2, (6), 5, 6, (6), 5, 4, 8, (3)}
<--------------->          <-------------->
      4                           4


** For More Input/Output Examples Use 'Expected Output' option *
 * @author Vivek.Singh
 *
 */
public class MinDistanceNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		while(testCases-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String str[] = br.readLine().trim().split("\\s+");
			long[] a = new long[n];
			for(int i=0;i<n;i++) a[i] = Long.parseLong(str[i]);
			String [] xy = br.readLine().trim().split(" ");
			long x = Long.parseLong(xy[0]);
			long y = Long.parseLong(xy[1]);
			System.out.println(minDist(a, n, x, y));
		}
		
	}
	public static long minDist(long arr[], long n, long x, long y) {
		long min = Long.MAX_VALUE;
		int prev = -1;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i] == x ) {
				int curr = i;
				if(prev == -1)
					prev = curr;
				else if(arr[prev] == x)
					prev = curr;
				else {
					min = Math.min(min,curr - prev);
					prev = curr;
				}
			}
			if(arr[i] == y) {
				int curr = i;
				if(prev == -1)
					prev = curr;
				else if(arr[prev] == y)
					prev = curr;
				else {
					min = Math.min(min,curr - prev);
					prev = curr;
				}
			}
		}
		if(min == Long.MAX_VALUE)
			min = -1;
		return min;   
    }
}