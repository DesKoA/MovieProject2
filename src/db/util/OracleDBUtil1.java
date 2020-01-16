package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;

public class OracleDBUtil1 {
	// utilȭ �Ҷ� properties �̿��Ͽ� ������ ����
			public static final String USER = "movie";
			public static final String PW = "1230";
			public static final String URL
				// 	= "jdbc:oracle:thin:@192.168.0.1:1521:xe"
				//= "jdbc:oracle:thin:@127.0.0.1:1521:xe"
				= "jdbc:oracle:thin:@localhost:1521:xe";
				// = "jdbc:oracle:thin:@192.168.0.247:1521:xe"				 
				//= "jdbc:oracle:thin:@�ּ�:��Ʈ:xe"
				//= "jdbc:oracle:thin:@�ּ�:��Ʈ:orcl"
			public static final String DRIVER_NAME 
				= "oracle.jdbc.driver.OracleDriver";
			 		// ojdbc6.jar
			
			public static Connection con;
			
			public static void connectDB() {
				try {
					// ����̹� Ŭ������ �̸� �޸𸮿� �ε�
					Class
					  .forName( DRIVER_NAME );						
//					Connection con 
					con = DriverManager.getConnection(
							URL, USER, PW);
					System.out.println("DB���� ���� ����!");
				} catch( ClassNotFoundException e ) {
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("DB���� ���� ����!");
					e.printStackTrace();
				}
			}
			
			// DB ���� ���� ����
			public static void closeDB() {
				if (con != null) { // ���� ����� ���¶��..
					try {
						con.close();
						System.out.println("DB ���� ����!!");
					} catch (SQLException e) {				
						System.out.println("DB ���� ����!!");
						e.printStackTrace();
					}
				}
			} 
		public static void main(String[] args) {
			connectDB();
			closeDB();
		}

}
