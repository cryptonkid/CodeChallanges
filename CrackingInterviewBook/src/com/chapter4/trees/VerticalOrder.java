package com.chapter4.trees;

import java.util.PriorityQueue;

/**
 * This algorithm is used to traverse the binary tree in height and level order.
 * Algorithm:
 * 1) print all the nodes of the tree in vertical order from top to bottom and coloum by coloum 
 * 2) If 2 nodes are at same coloum and same row then order will be from left to right
 * video link: https://www.youtube.com/watch?v=PQKkr036wRc
 * @author cryptonkid
 *
 */
/**
 * 3) the vertical order of 
 * @param root
 */
public class VerticalOrder {
	
	PriorityQueue<verticalNode> queue = new PriorityQueue<verticalNode>();
	public void printVerticalOrder(verticalNode root) {
		printVerticalOrder(root, 0);
		while(!queue.isEmpty()) {
			verticalNode node = queue.poll();
			System.out.println(node.filterValue + " ");
		}
	}
	
	private void printVerticalOrder(verticalNode node, int level) {
		if(node == null)
			return;
		node.level = level;
        queue.add(node);
        printVerticalOrder(node.left, level - 1);
        printVerticalOrder(node.right, level + 1);
	}
	
}
/**
 * for root hd = 0
 * left node hd = hd -1;
 * right node hd = hd +1
 * @author cryptonkid
 * Note: we have implemented comparable interface so list can be ordered directly.
 */
class verticalNode implements Comparable<verticalNode>{
	verticalNode left;
	verticalNode right;
	int height;
	int level;
	int filterValue;
	int horizotalDistance;//this will just store the value 
	
	
	@Override
	public int compareTo(verticalNode o) {
		this.filterValue =  this.level - o.level;
		if(filterValue == 0) {
			filterValue = this.height - o.height;
		}
		return filterValue;
	}
	
	
}

