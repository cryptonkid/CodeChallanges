package com.chapter4.trees;
import java.util.ArrayDeque;
import java.util.Deque;

public class IdenticalTrees{
	public static void main(String args[]) {
		
	}
}

class RecursiveIdenticalTreeSolution {

	public static boolean isIdentical(Node root1,Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		return ((root1 != null && root2 != null) &&
				(root1.data == root2.data) &&
				isIdentical(root1.left,root2.left) &&
				isIdentical(root1.right,root2.right)); 
	}
}
/**
 * One needs to create another data structure to check both nodes together. 
 * @author cryptonkid
 *
 */
class IterativeIdenticalTreeSolution{	
	public static boolean isIdentical(Node root1,Node root2) {
		
		Deque<Pair> listOfNodes = new ArrayDeque<>();
		/*if(root1 == null & root2 != null) { //In this way both conditions are evaluated and not short circuited.
			return false;
		}
		if(root1 != null & root2 == null) {
			return false;
		}
		if(root1== null & root2 == null) {
			return true;
		}*/
		//The above condition can also be written as
		//This is little better in terms of number of char used for code 
		if(root1== null & root2 == null) {
			return true;
		}
		if(root1 == null ) {
			return false;
		}
		if(root2 == null ) {
			return false;
		}
		
		listOfNodes.add(new Pair(root1,root2));
		while(!listOfNodes.isEmpty()) {
			Pair p = listOfNodes.pop();//removeFirst
			Node rightNode = p.right;
			Node leftNode = p.left;
				if(rightNode.data != leftNode.data)
				{
					return false;
				}
			    
				//Add the value to the stack based for the next nodes
				if(rightNode.left != null & leftNode.left != null ) {
					listOfNodes.push(new Pair(rightNode.left,leftNode.left));
				}
				else {
					return false;
				}
				
				if(rightNode.right != null & leftNode.right != null) {
					listOfNodes.push(new Pair(rightNode.right,leftNode.left));
				}else {
					return false;
				}
		}
		return true;
		
	}
	/*
	 * Create pair class as static or declare it in another file.
	 */
	static class Pair{
		Node left;
		Node right;
		
		Pair(Node left,Node right){
			this.left = left;
			this.right = right;
		}
	}
}