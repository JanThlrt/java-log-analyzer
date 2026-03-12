# Java Log Analyzer

A simple command-line tool written in Java that analyzes application log files and generates useful statistics about system behavior and performance.

The tool parses log entries, counts log levels, identifies repeated error messages, and analyzes response times to detect slow requests.

## Features

- Parses application log files
- Counts log levels (INFO, WARNING, ERROR)
- Detects and aggregates repeated error messages
- Calculates response time statistics
- Identifies slow requests (>300 ms)
- Generates a summary of system performance

## Technologies

- Java
- File I/O (BufferedReader)
- HashMap for error aggregation
- Basic string parsing

## Example Log File

Example log.txt:


INFO Request completed in 120ms  
INFO Request completed in 95ms  
WARNING Request completed in 410ms  
ERROR Database connection failed  
ERROR Database connection failed  
ERROR Timeout while calling API  
INFO Request completed in 280ms  
WARNING Request completed in 350ms  


## Example Output


Log Summary  
INFO: 3  
WARNING: 2  
ERROR: 3  

Performance Summary  
Average response time: 251 ms  
Max response time: 410 ms  
Slow requests (>300 ms): 2  

Error Summary  
Database connection failed: 2  
Timeout while calling API: 1  



## Installation

Clone the repository:


git clone https://github.com/JanThlrt/java-log-analyzer.git

  cd java-log-analyzer


Compile the project:  


javac Main.java LogAnalyzer.java  


## Usage

Run the program with a log file:  


java Main log.txt  


If no file is specified, the program will use log.txt by default.  

## Project Structure

java-log-analyzer
|
|- Main.java
|- LogAnalyzer.java
|- log.txt
|- README.md


## Purpose of the Project

This project was created to practice:

- Java file processing
- Log parsing and pattern detection
- Error aggregation using data structures
- Basic performance monitoring
- Building small command-line tools

## Possible Improvements

Future improvements could include:

- Exporting results to CSV
- Visualizing log statistics
- Supporting multiple log formats
- Adding command-line options