package loganalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Log Analyzer started");
        new Main().readFromFile("log.txt");
    }
    
    private int infoCount = 0;
    private int errorCount = 0;
    private int warningCount = 0;
    
    public void readFromFile(String filename) {
    	try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
    		String line;
    		while((line = reader.readLine()) != null) {
    			processLine(line);
    		}
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	printSummary();
    }
    
    private void processLine(String line) {
    	if (line.contains("INFO")) {
    		infoCount++;
    	}
    	
    	if (line.contains("ERROR")) {
    		errorCount++;
    	}
    	
    	if (line.contains("WARNING")) {
    		warningCount++;
    	}
    }
    
    private void printSummary() {
        System.out.println("\nLog Summary");
        System.out.println("INFO: " + infoCount);
        System.out.println("ERROR: " + errorCount);
        System.out.println("WARNING: " + warningCount);
    }
    
}