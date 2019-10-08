package com.chapter4.trees;

public class ModifiedNode implements Comparable<ModifiedNode>{
	ModifiedNode left;
	ModifiedNode right;
	int value;
	int height;
	int level;
	int hightOrder;
	
	
	
	@Override
	public int compareTo(ModifiedNode o) {
		return 0;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + hightOrder;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + level;
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + value;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModifiedNode other = (ModifiedNode) obj;
		if (height != other.height)
			return false;
		if (hightOrder != other.hightOrder)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (level != other.level)
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	
	
	
	
}
