package com.chapter4.trees;

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
	
	public static int findHeightIterative(Node root) {
		int height = 0;
		if(root == null) {
			return height;
		}
		while(true) {
			if(root.left!= null) {
				height = 0;//todo fill with correct values
				
			}
			else {
				
			}
		}
	}
}
