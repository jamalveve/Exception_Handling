package tryy.with.resources;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
public class MutlipleResourcesExample {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File("src/main/java/input.txt"));
	             PrintWriter writer = new PrintWriter("src/main/java/output.txt")) {
	            while (scanner.hasNextLine()) {
	                writer.println(scanner.nextLine());
	            }
	        } catch (Exception e) {
	            System.err.println("Exception: " + e.getMessage());
	        }
		System.out.println("process done");
	    }
	}
	  
