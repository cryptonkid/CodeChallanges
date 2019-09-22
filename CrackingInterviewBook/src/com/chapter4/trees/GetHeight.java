package com.chapter4.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 
 * @author cryptonkid
 *
 */
public class GetHeight {
	public static int findHeightRecursive(Node root) {
		if(root == null)
			return 0;
		int height = ((findHeightRecursive(root.left)+1)>(findHeightRecursive(root.right)+1)?(findHeightRecursive(root.left)+1):(findHeightRecursive(root.right)+1));
		return height;
	}
	//Iterative solution: One need to do the level order traversal.  
	public static int findHeightIterative(Node root) {
		int height =0;
		if(root == null)
			return height;
		Deque<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while(true) {
			
			int noOfNodeOnCurrentLevel = queue.size();
			if(noOfNodeOnCurrentLevel == 0)
				return height;
			
			// Dequeue all nodes of current level and Enqueue all 
            // nodes of next level 
			while(noOfNodeOnCurrentLevel > 0) {
				Node tempNode = queue.peek();
				if(tempNode != null) {
					queue.remove();
					if(tempNode.left != null)
						queue.add(tempNode.left);
					if(tempNode.right != null)
						queue.add(tempNode.right);
				}
				noOfNodeOnCurrentLevel--;
			}
			height++;//Increase the height.
		}
	}
}
