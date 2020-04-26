package com.leetcode.problems;

/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddNumbersAsLists {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode list3 = null;
		int carry = 0;
		boolean firstflag = true;
		boolean l1complete = false, l2complete = false;

		ListNode temp = new ListNode(carry);
		temp.next = null;

		while (true) {

			if (firstflag) {
				firstflag = false;
				list3 = temp;
			}
			if (!l1complete) {
				temp.val = temp.val + l1.val;
				if (l1.next != null)
					l1 = l1.next;
				else {
					l1complete = true;
				}
			}
			if (!l2complete) {
				temp.val = temp.val + l2.val;
				if (l2.next != null)
					l2 = l2.next;
				else {
					l2complete = true;
				}
			}
			if (temp.val / 10 > 0) {
				temp.val = temp.val % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			if (l2complete && l1complete) {
				break;
			} else {
				temp.next = new ListNode(carry);
			}

		}
		return list3;

	}

}
