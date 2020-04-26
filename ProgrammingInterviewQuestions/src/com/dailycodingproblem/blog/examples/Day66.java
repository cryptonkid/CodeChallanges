package com.dailycodingproblem.blog.examples;
/**
 * This problem was asked by Square.#66 [Medium]
 * Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's not 50-50 (but also not 0-100 or 100-0). 
 * You do not know the bias of the coin.
 * Write a function to simulate an unbiased coin toss.
 * @author Vivek.Singh
 *
 */
public class Day66 {
	public static void main(String args[]) {
		System.out.println(toss_biased());
	}
	
	
	//Enum are default static and final.
	
	public enum coinSides{
		HEAD("head"),TAIL("tail");
		private String value;
		
		coinSides(String value) {
			this.value = value;
		}
	}
	
	public enum coinSide {
		HEAD, TAIL
	}
	
	private static String toss_biased() {
		
		return null;
	}
}


