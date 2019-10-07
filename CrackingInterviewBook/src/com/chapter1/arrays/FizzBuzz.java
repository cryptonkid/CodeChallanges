package com.chapter1.arrays;

public class FizzBuzz {

    private static final String fizz = "Fizz"; 
    private static final String buzz = "Buzz";
    
    public String[] fizzBuzz(int n) {
        String[] output = new String[n];
        int i = 1;
        while (i <= n ){
            if((i%5==0) & (i%3 == 0))
                output[i-1] = fizz+buzz;
            else if(i%5 == 0)
                output[i-1] = buzz;
            else if(i%3 == 0)
                output[i-1] = fizz;
            else
                output[i-1] = i+"";
            i++;
        }
        return output;
    }
}