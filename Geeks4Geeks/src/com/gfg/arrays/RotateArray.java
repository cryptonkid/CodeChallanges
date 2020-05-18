package com.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Rotate Array Given an unsorted array arr[] of size N, rotate it by D elements
 * (counter-clockwise).
 * 
 * Input: The first line of the input contains T denoting the number of
 * testcases. First line of eacg test case contains two space separated
 * elements, N denoting the size of the array and an integer D denoting the
 * number size of the rotation. Subsequent line will be the N space separated
 * array elements.
 * 
 * Output: For each testcase, in a new line, output the rotated array.
 * 
 * User Task: The task is to complete the function rotate() which rotates the
 * array by given D elements. The newline is automatically added by the driver
 * code.
 * 
 * Constraints: 1 <= T <= 200 1 <= N <= 107 1 <= D <= N 0 <= arr[i] <= 105
 * 
 * Example: Input: 2 5 2 1 2 3 4 5 10 3 2 4 6 8 10 12 14 16 18 20
 * 
 * Output: 3 4 5 1 2 8 10 12 14 16 18 20 2 4 6
 * 
 * Explanation : Testcase 1: 1 2 3 4 5 when rotated by 2 elements, it becomes 3
 * 4 5 1 2. Testcase 2: 2 4 6 8 10 12 14 16 18 20 when rotated by 3 elements, it
 * becomes 8 10 12 14 16 18 20 2 4 6.
 ** 
 * For More Input/Output Examples Use 'Expected Output' option **
 * 
 * @author Vivek.Singh
 *
 */
public class RotateArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());

		while (testCases-- > 0) {
			String[] str = br.readLine().split("\\s+");
			int sizeOfArray = Integer.parseInt(str[0]);
			int noOfRoations = Integer.parseInt(str[1]);

			int elements[] = new int[sizeOfArray];
			str = br.readLine().split("\\s+");
			for (int i = 0; i < sizeOfArray; i++)
				elements[i] = Integer.parseInt(str[i]);

			rotateArr(elements, noOfRoations, sizeOfArray);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sizeOfArray; i++)
				sb.append(elements[i] + " ");
			System.out.println(sb);
		}

	}

	/** 
	 * To rotate in place we need to do the following.
	 * Simple and best approach is to 
	 * 1) Divide the Array into 2 parts A with 0 to n-r and B with r elements i.e from n-r to n
	 * 2) Now reverse A and B => ArBr
	 * 3) Now reverse whole Array => (ArBr)r
	 * 
	 *  1. Divide the array two parts: 1,2,3,4 and 5, 6
		2. Reverse first part: 4,3,2,1,5,6
		3. Reverse second part: 4,3,2,1,6,5
		4. Reverse the whole array: 5,6,1,2,3,4
	 *  
	 * @param arr
	 * @param d
	 * @param n
	 */
	static void rotateArr(int arr[], int d, int n)
    {
		//Note : when number of rotations is more than n then
		d = d % n;
		reverse(arr,0,d-1);
		reverse(arr,d,n-1);
		reverse(arr,0,n-1);
    }

	public static void reverse(int arr[], int start, int end) {
		for (int i = start; i < end; i++, end--) {
			int temp = arr[i];
			arr[i] = arr[end];
			arr[end] = temp;
		}
	}
}
