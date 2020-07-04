package org.vivek.design.com.parkinglot.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the simple parking lot problem" );
        	readInputFile(args[0]);
        return;
    }
    public static void readInputFile(String filePath) {
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(filePath));
    		String str = br.readLine();
    		if ( !"create_parking_lot".equals(str.toLowerCase() ) ) {
    			
    		}
    		while((str = br.readLine()) != null) {
    			// TODO: Need to be able to add newcommands & should store all the commands 'string' in a constant file
    					
    			switch(str.toLowerCase()) {
    			case ('') :
    				break;
    			case ('park'):
    				break;
    			case ('park'):
    				break;
    			case('park'):
    				break;
    			}
    		}
    	}
    	catch(IOException ex) {
    		ex.printStackTrace();
    	}
    	
    }
}
