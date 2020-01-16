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
	// util화 할때 properties 이용하여 설정할 예정
			public static final String USER = "movie";
			public static final String PW = "1230";
			public static final String URL
				// 	= "jdbc:oracle:thin:@192.168.0.1:1521:xe"
				//= "jdbc:oracle:thin:@127.0.0.1:1521:xe"
				= "jdbc:oracle:thin:@localhost:1521:xe";
				// = "jdbc:oracle:thin:@192.168.0.247:1521:xe"				 
				//= "jdbc:oracle:thin:@주소:포트:xe"
				//= "jdbc:oracle:thin:@주소:포트:orcl"
			public static final String DRIVER_NAME 
				= "oracle.jdbc.driver.OracleDriver";
			 		// ojdbc6.jar
			
			public static Connection con;
			
			public static void connectDB() {
				try {
					// 드라이버 클래스를 미리 메모리에 로딩
					Class
					  .forName( DRIVER_NAME );						
//					Connection con 
					con = DriverManager.getConnection(
							URL, USER, PW);
					System.out.println("DB서버 접속 성공!");
				} catch( ClassNotFoundException e ) {
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("DB서버 접속 실패!");
					e.printStackTrace();
				}
			}
			
			// DB 서버 연결 종료
			public static void closeDB() {
				if (con != null) { // 현재 연결된 상태라면..
					try {
						con.close();
						System.out.println("DB 종료 성공!!");
					} catch (SQLException e) {				
						System.out.println("DB 종료 실패!!");
						e.printStackTrace();
					}
				}
			} 
		public static void main(String[] args) {
			connectDB();
			closeDB();
		}

}
