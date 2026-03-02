package loganalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogAnalyzer {

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
	    		System.out.println("Log file could not be read.");
	    	    System.out.println("Make sure 'log.txt' is in the project folder.");
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
