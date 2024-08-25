package tryy.with.resources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.OutputDeviceAssigned;

class CustomSnapshotHandler {

	public static void main(String[] args) {
		SnapshotHandler handler = new SnapshotHandler("src/main/java/snapshot_example.txt");

        try {
            handler.writeContent("Initial content of the file.");
            handler.writeContent("Adding more content to the file.");
            handler.writeContent("One more line added.");

            // Display all snapshots captured
            System.out.println("Snapshots captured:");
            handler.displaySnapshots();

            // Revert to the first snapshot
            handler.revertToSnapshot(0);
            System.out.println("File reverted to the first snapshot.");
            System.out.println("Current File Content:\n" + handler.readContent());

        } catch (IOException e) {
            System.err.println("An IO exception occurred: " + e.getMessage());
        }
    }

}
class SnapshotHandler implements AutoCloseable{

	 private File file;
	    private List<FileSnapshot> snapshots;//empty list of file snapshpt
	    private BufferedWriter writer;  // Added to manage the writer's lifecycle
	    public SnapshotHandler(String filePath) {
	        this.file = new File(filePath);
	        this.snapshots = new ArrayList<>();
	    }
	 // Method to write content to the file
	    public void writeContent(String content) throws IOException {
	    	  if (writer == null) {
	              writer = new BufferedWriter(new FileWriter(file, true)); // Append mode
	          }
	    	  writer.write(content) ;
	    	  writer.newLine();
	        captureSnapshot(); // Capture a snapshot after writing
	    }
	    // Method to read content from the file
	    public String readContent() throws IOException {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append(System.lineSeparator());
	            }
	        }
	        return content.toString();
	    }
	    //once that is writen to the file calling this to-> what it read from and ading to the emoty snapshot
	    private void captureSnapshot() throws IOException {
	        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
	        String content = readContent();
	        snapshots.add(new FileSnapshot(timestamp, content));
	    }
	    // Method to display all snapshots
	    public void displaySnapshots() {
	        for (FileSnapshot snapshot : snapshots) {
	            System.out.println("Timestamp: " + snapshot.timestamp);
	            System.out.println("Content:\n" + snapshot.content);
	            System.out.println("----------------------------");
	        }
	    }

	    // Method to revert to a specific snapshot by index
	    public void revertToSnapshot(int index) throws IOException {
	        if (index < 0 || index >= snapshots.size()) {
	            throw new IllegalArgumentException("Invalid snapshot index.");
	        }
	        String content = snapshots.get(index).content;
	        writeContent(content); // Write the snapshot back to the file
	    }
	    private static class FileSnapshot {
	        String timestamp;
	        String content;

	        FileSnapshot(String timestamp, String content) {
	            this.timestamp = timestamp;
	            this.content = content;
	        }
	    }
	    @Override
	    public void close() throws IOException {
	        if (writer != null) {
	            writer.close(); // Close the writer if it was opened
	        }
	    }

	

	
}
