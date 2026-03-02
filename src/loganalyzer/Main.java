package loganalyzer;



public class Main {
	public static void main(String[] args) {

	    String filename;

	    if(args.length > 0) {
	        filename = args[0];
	    } else {
	        filename = "log.txt";
	        System.out.println("No file specified. Using default: log.txt");
	    }

	    LogAnalyzer analyzer = new LogAnalyzer();
	    analyzer.readFromFile(filename);
	}
}