package com.chapter4.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Note: In order to delete first all child has to be deleted even before the
 * parent gets deleted
 * i.e. postORDER
 * @author cryptonkid
 *
 */
public class DeleteBinaryTree {

	public static void main() {

	}

	public static void deleteBTRecursive(Node root) {
		if(root == null)
			return;
		if(root.left != null)
			deleteBTRecursive(root.left);
		if(root.right != null)
			deleteBTRecursive(root.right);
		root = null;
	}

	public static void deleteBTIterative(Node root) {
		Stack<Node> stack = new Stack<Node>();
		if(root != null) {
			stack.add(root);
		}
		while(stack.isEmpty()) {
			if(stack.peek() != null) {
					Node tempNode = stack.pop();
					if(tempNode.left != null)
						stack.add(tempNode.left);
					if(tempNode.right != null)
						stack.add(tempNode.right);
			}
		}
	}
}
