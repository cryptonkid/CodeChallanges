package com.chapter4.trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, print its nodes level by level in spiral order.
 *  i.e. all nodes present at level 1 should be printed first from left to right, 
 *  followed by nodes of level 2 right to left,
 *   followed by nodes of level 3 from left to right and so on.
 *  In other words, odd levels should be printed from left to right and..
 *  
 *  Space & time Complexity :0(n)
 *  
 * @author cryptonkid
 *
 */

public class SpiralTreeTraversal {
	public void Spiral(Node root) {
		int level = 0;
		Deque<Node> queue = new ArrayDeque<Node>();
		
		if(root != null) {
			queue.add(root);
		}
		
		while(!queue.isEmpty()) {
			int nodestoprocess = queue.size();
			while (nodestoprocess > 0) {
				nodestoprocess--;
				Node current = queue.poll();
				System.out.println(current.data);
				if(current != null) {
					if(level % 2 == 0 ) {
						if(current.right != null)
							queue.add(current.right);
						if(current.left != null)
							queue.add(current.left);
					}
					else {
					if(current.left != null)
						queue.add(current.left);
					if(current.right != null)
						queue.add(current.right);
					}
				}
			}
		}
		
	}
}
