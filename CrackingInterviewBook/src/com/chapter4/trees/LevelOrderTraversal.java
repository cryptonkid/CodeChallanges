package com.chapter4.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class LevelOrderTraversal {

	/**
	 * For level order traversal we will use qeueue
	 * time and space complexity : 0(n)
	 * @param root
	 */
	
	public static void levelOrderTraversal(Node root) {
		Deque<Node> queue = new ArrayDeque<Node>();
		if (root != null)
			queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current != null) {
				System.out.println(current.data);
				if (current.left != null)
					queue.add(root.left);
				if (current.right != null)
					queue.add(root.right);
			}

		}
	}
}
