package com.chapter4.trees;

import java.util.Stack;

public class InorderTraversal {
	public static void main() {
		
	}
	// preOrder : root left right
	// inOder : left root right
	// postOrder : left right root
	public static void inorderRecursive(Node node) {
		if(node == null)
			return;
		
		if(node.left != null)
			inorderRecursive(node.left);
		
		System.out.println(node.data);
		
		if(node.right != null)
			inorderRecursive(node.right);
	}
	//Please note
	// Iterative function to perform in-order traversal of the tree
	public static void inorderIterative(Node root)
	{
		// create an empty stack
		Stack<Node> stack = new Stack();

		// start from root node (set current node to root node)
		Node curr = root;

		// if current node is null and stack is also empty, we're done
		while (!stack.empty() || curr != null)
		{
			// if current node is not null, push it to the stack (defer it)
			// and move to its left child
			if (curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			else
			{
				// else if current node is null, we pop an element from stack,
				// print it and finally set current node to its right child
				curr = stack.pop();
				System.out.print(curr.data + " ");

				curr = curr.right;
			}
		}
	}
}
