package loganalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Log Analyzer started");
    }
    
    
    public void readFromFile() {
    	try(BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
    		String line;
    		while((line = reader.readLine()) != null) {
    			System.out.println(line);
    		}
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    
}