package com.chapter4.trees;
import java.util.ArrayList;
import java.util.Stack;

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
		
		Stack<Pair> listOfNodes = new Stack();
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
		while(!listOfNodes.empty()) {
			Pair p = listOfNodes.pop();
				if(p.left.data != p.right.data)
				{
					return false;
				}
				
		}
		
	}
	class Pair{
		Node left;
		Node right;
		
		Pair(Node left,Node right){
			this.left = left;
			this.right = right;
		}
	}
}