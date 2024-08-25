package tryy.with.resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreventResourceLeaksEx {
//so to avoid this we can go for try with resources
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/main/java/input.txt"));
			String line;
			List<String> lines = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				lines.add(line);
				// while we are trying to write in on somewr
				// // High memory usage could lead to OutOfMemoryError
			}
			throw new RuntimeException("exception came");
		} catch (Exception e) {
//			System.in.println(e.printStackTrace());
		} finally {
			// here we are using finally to close
			// if an exception is thrown before reaching the br.close() statement in the
			// finally block,
//			the BufferedReader remains open, resulting in a resource leak.
			if (br != null) {
				try {
//					5)//manually throwing 
					if (true) { // This condition simulates a failure scenario
						throw new IOException("Simulated failure while closing");
					}
					// reall tie scenarion may be like
//					 1) wrong file name we are givng in the bufferreader to read 
//					 2)bcz of outofmemory error happened in line numbet 19
//					 3)Thread Interruption
//					 4)StackOverflowErro

					br.close();// This will never be reached
					System.out.println("buffer reader closed");
				} catch (Exception e) {
					System.out.println("file not able to close");
				}
			}
		}
	}

}
