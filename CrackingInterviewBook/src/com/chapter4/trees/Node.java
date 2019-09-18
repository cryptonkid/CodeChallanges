package com.chapter4.trees;

public class Node {
	Node left;
	Node right;
	int data;
	
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}

	public synchronized final Node getLeft() {
		return left;
	}

	public synchronized final void setLeft(Node left) {
		this.left = left;
	}

	public synchronized final Node getRight() {
		return right;
	}

	public synchronized final void setRight(Node right) {
		this.right = right;
	}

	public synchronized final int getData() {
		return data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Node)) {
			return false;
		}
		Node other = (Node) obj;
		if (data != other.data) {
			return false;
		}
		if (left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!left.equals(other.left)) {
			return false;
		}
		if (right == null) {
			if (other.right != null) {
				return false;
			}
		} else if (!right.equals(other.right)) {
			return false;
		}
		return true;
	}
	
	
}
