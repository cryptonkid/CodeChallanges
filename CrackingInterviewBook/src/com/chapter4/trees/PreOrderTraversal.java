package com.chapter4.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderTraversal {
	public static void main() {
		
	}
	
	public void preOrderRecursive(Node root) {
		if(root == null )
			return;
		System.out.println(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}
	//We will use queue for preorder
	public void preOrderIterative(Node root) {
		if(root == null)
			return;
		Deque<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp = queue.peek();
			System.out.println(temp.data);
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
			queue.remove();
		}
	}
}
