package com.leetcode.problems;
/**
 * Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 * @author Vivek.Singh
 *
 */
public class MajorityElement {
	
    public int majorityElement_failed(int[] nums) {
     //Solution will be same as counting sort for positive number. 
    	int count[] = new int[] {0,0,0,0,0,0,0,0,0,0};
    	int returnValue = 0;
        int len = nums.length;
        for(int i=0;i<len;i++) {
        	count[nums[i]] ++;
        }
        int max = len/2;
        for(int i=0;i<10;i++) {
        	if(count[i] > max) {
        		returnValue = i;
        	}
        }
        return returnValue;
    }
    //BoyerMoor startegy : Assumption is there exist number with count more than n/2. 
    public int majorityElement(int[] nums) {
         
       	int max = 0;
       	int count = 0;
       	int len = nums.length;
       	for(int i=0;i<len;i++) {
       		if(count == 0) {
       			max = nums[i];
       			count ++;
       		}
       		else if(max == nums[i]) {
        	   count ++;
           }
       		else {
       			count--;
       		}
       	}   
       	return max;
      }
	public static void main(String args[]) {
		MajorityElement m = new MajorityElement();
		System.out.println(m.majorityElement(new int[] {2,2,1,1,1,2,2}));
		System.out.println(m.majorityElement(new int[] {3,2,3}));
		System.out.println(m.majorityElement(new int[] {1}));
		System.out.println(m.majorityElement(new int[] {10,9,9,9,10}));
		System.out.println(m.majorityElement(new int[] {3,3,4}));
	}
}
