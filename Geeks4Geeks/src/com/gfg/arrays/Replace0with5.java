package com.gfg.arrays;

public class Replace0with5 {
	public static int convertFive(int num) {
		if(num == 0) 
			return 5;
		
		int num2 = 0 ,i = 0;
		
		while(num != 0){
            int digit = num%10;
            if(digit == 0)
                digit = 5;
            if(num < 10) {//last digit
            	num2 = num2 + num*(int)Math.pow(10, i);
            	break;
            }else {
            	num = num/10;
            	num2 = num2 + digit*(int)Math.pow(10, i);
            	i++;
            }
        }
		return num2;
	}
	
	public static void main(String args[]) {
		System.out.println(convertFive(100));
		System.out.println(convertFive(1060));
		
	}
}
