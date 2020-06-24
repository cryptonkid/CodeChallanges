package com.app.runnables;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppThread extends Thread{

    @Override
    public void run() {
        
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\cryptonkid\\Desktop\\Exercise Files\\Chapter2\\02_03\\begin\\sample.txt")))){
            String line = null;
            while((line=reader.readLine())!=null){
                System.out.println(Thread.currentThread().getName()+" reading the line: "+line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
