package com.leetcode.problems;

import java.util.LinkedHashMap;
import java.util.Set;

/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

		Examples:
		
		s = "leetcode"
		return 0.
		
		s = "loveleetcode",
		return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqChar {
	
	public int firstUniqChar(String s) {
        int position = -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i =0;i< s.length();i++) {
        	char ch = s.charAt(i);
        	if(!map.containsKey(ch)) {
        		map.put(s.charAt(i), i);
        	}
        	else {
        		map.put(s.charAt(i), -1);
        	}		
        }
        Set<Character> keys = map.keySet();
        for(Character k:keys){
        	int value = map.get(k);
            if(value != -1) {
            	position = value;
            	break;
            }
        }
        return position;   
    }
	// one can even use hashmap also 
	public static void main(String args[]) {
		FirstUniqChar obj = new FirstUniqChar();
		System.out.println(obj.firstUniqChar("leetcode"));
		System.out.println(obj.firstUniqChar("loveleetcode"));
		System.out.println(obj.firstUniqChar("ssbb"));
	}

}

/**
 * Leet code solution
 * class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}
*/