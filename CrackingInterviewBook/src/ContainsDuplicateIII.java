/**
 * LeetCode : https://leetcode.com/problems/contains-duplicate-iii/
 * 
 * @author viveksingh
 *
 */
public class ContainsDuplicateIII {

	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[] {1, 2, 3,1},3,0));
		
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		return false;
	}

}
/**
 * Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] 
 * is at most t and t
 * he absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false 
 */
