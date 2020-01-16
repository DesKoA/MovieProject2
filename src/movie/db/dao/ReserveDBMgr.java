package movie.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Member;
import data.Reserve1;
import data.Seat1;
import movie.db.util.OracleDBUtil;

public class ReserveDBMgr {
	Connection con;
	public ReserveDBMgr() {
		this.con = OracleDBUtil.con;
	}
	
	public ArrayList<Reserve1> reveResult() {
		
		Member ID = new Member();
		ID.setMemberID("minmin");
		
		if( con != null ) {
			ArrayList<Seat1> stList = new ArrayList<Seat1>();
			
			try {
				
				String sql = "select * from movie_reserve where member_id ='"+ID.getMemberID()+"'";
				
				System.out.println(sql);
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
				
				while ( rs.next() ) {
					int RESERVE_NO = rs.getInt("RESERVE_NO");
					System.out.println(RESERVE_NO);
					String MOVIE_TITLE = rs.getString("MOVIE_TITLE");
					System.out.println(MOVIE_TITLE);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return null;
		
	}
}
