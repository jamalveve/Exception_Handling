package tryy.with.resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderExample {
	public static void main(String[] args) {
		
		
	        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/example.txt"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch(IOException e) {
	            System.err.println("IOException: " + e.getMessage());
	        }
	    }
}
