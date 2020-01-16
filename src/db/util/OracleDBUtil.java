package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBUtil {
	public static final String USER = "java";
	public static final String PW = "1234";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";

	public static Connection con;

	public static void connectDB() {
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL, USER, PW);
			System.out.println("DB Connect");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeDB() {
		if (con != null) {
			try {
				con.close();
				System.out.println("DB Close");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		connectDB();
		closeDB();
	}
	
}
