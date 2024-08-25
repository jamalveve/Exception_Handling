package tryy.with.resources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

//Temporaty file handler
//once the data over delete it
public class CustomResourcesExample {
	public static void main(String[] args) {
		TemporaryFileHandler tempfile = new TemporaryFileHandler("Temporary_File.txt");
		try {
			File testFile = new File("Temporary_File.txt");
			if (testFile.createNewFile()) {
				System.out.println("File created: " + testFile.getName());
			} else {
				System.out.println("File already exists.");
				System.out.println("-------Entering to DB------");
			}
		} catch (IOException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}

		System.out.println("welcome to the DB");
//		try {
//			tempfile.writeintoFile("hello I am fine");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		tempfile.display();
	}

}

class TemporaryFileHandler implements AutoCloseable {
	// to read and wrie we need one file first
	private File file;
//to store it we need one collection
//wwe will choose set so that it avoids duplicate
	private Set<Database> db;
//waht we need to store the date and data
	BufferedWriter br_writer;

	class Database {
		String date_time;
		String data;

		Database(String date_time, String data) {
			this.date_time = date_time;
			this.data = data;
		}
	}

	TemporaryFileHandler(String filepath) {
		this.file = new File(filepath);
		this.db = new HashSet<>();
	}

	// lets write something in to the file
	public void writeintoFile(String data) throws IOException {
		if (br_writer != null) {
			br_writer = new BufferedWriter(new FileWriter(file, true));

		}
		br_writer.write(data);
		br_writer.newLine();
		storeDataintoDB();
	}

//read the file
	public String readintoFile() throws IOException {
		StringBuilder data = new StringBuilder();
		 try (BufferedReader br_reader = new BufferedReader(new FileReader(file))) {
		// fetching the data in to content
		String content;
		while ((content = br_reader.readLine()) != null) {
			data.append(content).append(System.lineSeparator());
		}
		 }

		return data.toString();
	}
//store it

	private void storeDataintoDB() throws IOException {
		String date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
		String data = readintoFile();
		db.add(new Database(date_time, data));
	}

	// display
	public void display() {
		for (Database stored : db) {
			System.out.println("------------------------------------------");
			System.out.println("Time_Stamp:" + stored.date_time);
			System.out.println("Data:" + stored.data);

		}
	}
	// once reached the days of 31 delete the content where the data stored

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

}
