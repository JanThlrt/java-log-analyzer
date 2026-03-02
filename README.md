# Java Log Analyzer

A simple Java console tool that analyzes log files and counts occurrences of log levels such as INFO, ERROR, and WARNING.

## Features

* Reads log files line by line
* Counts INFO, ERROR and WARNING messages
* Accepts a filename as program argument
* Shows a summary report
* Handles missing files gracefully

## How to Run

1. Clone the repository
2. Open in Eclipse
3. Run `Main.java` as a Java Application

You can optionally specify a file name:

```
java Main example-log.txt
```

If no filename is given, the program will automatically use `log.txt`.

## Example Output

```
Log Summary
INFO: 3
ERROR: 2
WARNING: 1
```

## Example Log File

Create a file called `example-log.txt` in the project directory:

```
INFO User login: Max
INFO File uploaded
ERROR Database connection failed
INFO Logout
ERROR Timeout
WARNING Disk space low
```

## Concepts Used

* Object-Oriented Programming (OOP)
* File I/O with BufferedReader
* Exception handling (try-catch)
* String processing
* Command line arguments
# java-log-analyzer