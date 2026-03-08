package loganalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {

	 	private int infoCount = 0;
	    private int errorCount = 0;
	    private int warningCount = 0;
	    private int slowRequestCount = 0;
	    private int totalResponseTime = 0;
	    private int responseTimeCount = 0;
	    private int maxResponseTime = 0;
	    
	    private Map<String, Integer> errorMessages = new HashMap<>();
	    
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
	        } else if (line.contains("WARNING")) {
	            warningCount++;
	        } else if (line.contains("ERROR")) {
	            errorCount++;
	            processErrorMessage(line);
	        }

	        processResponseTime(line);
	    }

	    private void processErrorMessage(String line) {
	        String message = line.replaceFirst("ERROR\\s*", "").trim();

	        if (message.isEmpty()) {
	            message = "Unknown error";
	        }

	        errorMessages.put(message, errorMessages.getOrDefault(message, 0) + 1);
	    }

	    private void processResponseTime(String line) {
	        if (line.contains("in ") && line.contains("ms")) {
	            try {
	                int start = line.indexOf("in ") + 3;
	                int end = line.indexOf("ms", start);

	                String numberPart = line.substring(start, end).trim();
	                int responseTime = Integer.parseInt(numberPart);

	                totalResponseTime += responseTime;
	                responseTimeCount++;

	                if (responseTime > maxResponseTime) {
	                    maxResponseTime = responseTime;
	                }

	                if (responseTime > 300) {
	                    slowRequestCount++;
	                }

	            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
	                System.out.println("Could not parse response time from line: " + line);
	            }
	        }
	    }

	    private void printSummary() {
	        System.out.println("\nLog Summary");
	        System.out.println("INFO: " + infoCount);
	        System.out.println("WARNING: " + warningCount);
	        System.out.println("ERROR: " + errorCount);

	        if (responseTimeCount > 0) {
	            double averageResponseTime = (double) totalResponseTime / responseTimeCount;

	            System.out.println("\nPerformance Summary");
	            System.out.println("Average response time: " + String.format("%.2f", averageResponseTime) + " ms");
	            System.out.println("Max response time: " + maxResponseTime + " ms");
	            System.out.println("Slow requests (>300 ms): " + slowRequestCount);

	            if (slowRequestCount > 0) {
	                System.out.println("WARNING: High number of slow requests detected.");
	            }
	        }

	        if (!errorMessages.isEmpty()) {
	            System.out.println("\nError Summary");
	            for (Map.Entry<String, Integer> entry : errorMessages.entrySet()) {
	                System.out.println(entry.getKey() + ": " + entry.getValue());
	            }
	        }
	    }
	
	
}
