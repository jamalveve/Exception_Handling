package tryy.with.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatBaseLeakExample {

	public static void main(String[] args) {
		System.out.println("--------------try with finally--------------");
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "user", "password");
			Statement stmt = conn.createStatement();
			stmt.executeQuery("SELECT * FROM table");
			// Potential exception thrown here
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close(); // This might be skipped if an exception is encountered
				} catch (SQLException e) {
					System.err.println("Failed to close the connection.");
				}
			}
		}

		System.out.println("----------------try with Respurces---------------");
		try (Connection conns = DriverManager.getConnection("jdbc:mysql://localhost/db", "user", "password");
				Statement stmt = conn.createStatement()) {
			stmt.executeQuery("SELECT * FROM table");
			// Any exception thrown here will ensure resources are closed
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
		}
	}

}
