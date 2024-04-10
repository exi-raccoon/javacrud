package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	static final String DB_URL = "jdbc:postgresql://localhost:5432/crudjava";
	static final String USER = "postgres";
	static final String PASSWORD = "admin123";

	public static Connection connectToDb() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			if (con != null) {
				System.out.println("Connection established !");
			} else {
				System.out.println("Connection failed !");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

}
