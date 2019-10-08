package com.chapter4.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Thee are multiple solutions : 
 * 1) is store every level first in the hash map & print it lowest key order.
 * 2)
 * 
 * @author cryptonkid
 *
 */
public class ReverselevelTraversal {
	/**
	 * Algorithm :
	 * Traverse in level order and store in hashmap 
	 * then print the map in highest key first order.
	 * @param root
	 */
	public static void reverselevelTraversal(Node root) {
		HashMap<Integer,Node> levelMap = new HashMap<Integer, Node>();
		
		if(root == null)
			return;
		
		Deque<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		
		int level = 0;
		while (!queue.isEmpty()) {
			int nodeCount = queue.size();
			while(nodeCount -- > 0) { //adding all the nodes per level then going to other level
				Node current = queue.poll();
				if (current != null) {
					if(current.left != null)
						levelMap.put(level, current.left);
					if(current.right != null)
						levelMap.put(level,current.right);
					
				}	
			}
		}
	}
	
	
}
