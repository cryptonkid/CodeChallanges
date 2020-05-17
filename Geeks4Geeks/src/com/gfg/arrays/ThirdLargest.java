package com.gfg.arrays;

public class ThirdLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Use a genric logic as kth smallest number
	 */
	
	long thirdLargest(Long a[])
    {
     int length = a.length;
	 if(length <3 ){
	     return -1;
	 }
	     Long first = a[0];
		 Long second = Long.MIN_VALUE;
		 long third = Long.MIN_VALUE;
		  for(int i=1;i<length;i++) {
			    if(a[i] > first){
	                third = second;
	                second = first;
	                first = a[i];
	            }
	            else if(a[i] > second){
	                third = second;
	                second = a[i];
	            }
	            else if(a[i]>third){
	                third = a[i];
	            }
		  }
	 return third;
	}
	/** 
	 * Using priority Queue aka Min Heap
	 */
	

}
