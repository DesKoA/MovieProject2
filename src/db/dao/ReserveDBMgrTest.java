package db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Member;
import data.Reserve1;
import data.Seat1;
import db.util.OracleDBUtil;
import db.util.OracleDBUtil1;

public class ReserveDBMgrTest {
	Connection con;
	public ReserveDBMgrTest() {
		this.con = OracleDBUtil.con;
	}
	
	public ArrayList<Reserve1> reveResult(String login) {
		
		if( con != null ) {
			ArrayList<Seat1> stList = new ArrayList<Seat1>();
			
			try {
				
				String sql = "select * from movie_reserve where member_id ='"+ login +"'";
				
//				if( ID.getMemberID().equals("minmin")) {
//					String sql = "select * from movie_reserve where member_id = 'minmin'";
//				}
//				else if( ID.getMemberID().equals("alswns")) {
//					String sql = "select * from movie_reserve where member_id = 'alswns'";
//				}
//				else if( ID.getMemberID().equals("ioiooioi")) {
//					String sql = "select * from movie_reserve where member_id = 'ioiooioi'";
//				}
//				else if( ID.getMemberID().equals("chanwo5")) {
//					String sql = "select * from movie_reserve where member_id = 'chanwo5'";
//				}
//				else if( ID.getMemberID().equals("ohoh")) {
//					String sql = "select * from movie_reserve where member_id = 'ohoh'";
//				}
//				else if( ID.getMemberID().equals("mygood")) {
//					String sql = "select * from movie_reserve where member_id = 'mygood'";
//				}
//				else if( ID.getMemberID().equals("jojogo")) {
//					String sql = "select * from movie_reserve where member_id = 'jojogo'";
//				}
				
				
//				switch (ID.getMemberID()) {
//				case "minmin":
//					 sql += " 'minmin'";
//					break;
//
//				case "alswns":
//					sql = "select * from movie_reserve where member_id = 'alswns'";
//					break;
//					
//				case "ioiooioi":
//					 sql = "select * from movie_reserve where member_id = 'ioiooioi'";
//					break;
//					
//				case "chanwo5":
//					 sql = "select * from movie_reserve where member_id = 'chanwo5'";
//					break;
//	
//				case "ohoh":
//					 sql = "select * from movie_reserve where member_id = 'ohoh'";
//					break;
//					
//				case "mygood":
//					 sql = "select * from movie_reserve where member_id = 'mygood'";
//					break;
//					
//				case "jojogo":
//					 sql = "select * from movie_reserve where member_id = 'jojogo'";
//					break;
//					
//					
//					
//				default:
//					break;
//				}
				
				Statement stmt =  con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				ArrayList<Reserve1> rvList = new ArrayList<Reserve1>();
				
				 
				while ( rs.next() ) {
					int RESERVE_NO = rs.getInt("RESERVE_NO");
					
				//	System.out.println(RESERVE_NO);
					String MOVIE_TITLE = rs.getString("MOVIE_TITLE");
				//	System.out.println(MOVIE_TITLE);
					String MEMBER_ID = rs.getString("MEMBER_ID");
				//	System.out.println(MEMBER_ID);
					int SCREEN_NO = rs.getInt("SCREEN_NO");
				//	System.out.println(SCREEN_NO);
					Date MOVIE_DATE = rs.getDate("MOVIE_DATE");
				//	System.out.println(MOVIE_DATE);
					String MOVIE_START = rs.getString("MOVIE_START");
				//	System.out.println(MOVIE_START);
					String MOVIE_END = rs.getString("MOVIE_END");
				//	System.out.println(MOVIE_END);
					// int SEAT_NO = rs.getInt("SEAT_NO");
				//	System.out.println(SEAT_NO);
					int RESERVE_ADULT = rs.getInt("RESERVE_ADULT");
				//.out.println(RESERVE_ADULT);
					int RESERVE_STUDENT = rs.getInt("RESERVE_STUDENT");
				//	System.out.println(RESERVE_STUDENT);
					int RESERVE_MONEY = rs.getInt("RESERVE_MONEY");
				//	System.out.println(RESERVE_MONEY);
					Date RESERVE_DAY = rs.getDate("RESERVE_DAY");
				//.out.println(RESERVE_DAY);
					
					Reserve1 rv = new Reserve1(RESERVE_NO, MOVIE_TITLE, MEMBER_ID, SCREEN_NO, MOVIE_DATE, MOVIE_START, MOVIE_END, RESERVE_ADULT + RESERVE_STUDENT, RESERVE_ADULT, RESERVE_STUDENT, RESERVE_MONEY, RESERVE_DAY, "");
					
					rvList.add(rv);
						
				}
				
				System.out.println("예매개수" + rvList.size());
				return rvList;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return null;
		
	}
}
