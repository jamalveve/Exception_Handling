//package tryy.with.resources;
//
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//
//public class EnhancedTrywithResourceJava9 {
//
////try this with java 9
//	    public static void main(String[] args) {
//	        final Scanner scanner = new Scanner(new File("src.main/java/input.txt"));
//	        try (PrintWriter writer = new PrintWriter("output.txt")) {
//	            while (scanner.hasNextLine()) {
//	                writer.println(scanner.nextLine());
//	            }
//	        } catch (Exception e) {
//	            System.err.println("Exception: " + e.getMessage());
//	        }
//	    }
//
//}
