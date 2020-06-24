package com.app.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.runnables.AppThread;

public class TestRunnable {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\cryptonkid\\Desktop\\Exercise Files\\Chapter2\\02_03\\begin\\sample.txt")))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + " reading the line: " + line);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        //How executor interface is used.
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }
}
