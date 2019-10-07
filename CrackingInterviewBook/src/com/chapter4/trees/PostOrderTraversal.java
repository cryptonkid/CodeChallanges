package com.chapter4.trees;

import java.util.Stack;

public class PostOrderTraversal {
	public static void main() {
		
	}
	/** 
	 * Simple recursive solution.
	 * @param root
	 */
	public static void postOrderRecursive(Node root) {
		if(root == null)
			return;
		postOrderRecursive(root.left);
		postOrderIterative(root.right);
		System.out.println(root.data);
	}
	/**
	 * Trick: Stack again nodes of In-order to reverse the In-order to get postOrder 
	 * for Post order : we need two stacks:
	 * 	input stack and output stack.
	 * @param root
	 */
	public static void postOrderIterative(Node root) {
		if(root == null)
			return;
		
		Stack<Node> inOrderStack = new Stack<Node>();
		inOrderStack.add(root);
		
		Stack<Node> postOrderStack = new Stack<Node>();
		while(!inOrderStack.isEmpty()) {
			Node top = inOrderStack.pop();
			postOrderStack.add(top);
			inOrderStack.add(top.left);
			inOrderStack.add(top.right);			
		}
		
		// As all the nodes have been traversed. "PostOrderStack"
		// now contains all the nodes in proper order just pop and print the node in the same order.
		
		while(!postOrderStack.isEmpty())
			System.out.println(postOrderStack.pop().data);
	}
}
