package db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.Reserve;
import db.util.OracleDBUtil;

public class ReserveDBManager {
public Connection con;
	
	public ReserveDBManager() {
		this.con = OracleDBUtil.con;
	}
	
	public ReserveDBManager(Connection con) {
		this.con = con;
	}
	
	public boolean insertReserve(Reserve rev) {
		if (con != null) {
			String sql = "insert into MOVIE_RESERVE values(rev_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, rev.getReserveNo());
				pstmt.setString(2, rev.getMovieTitle());
				pstmt.setString(3, rev.getMemberID());
				pstmt.setInt(4, rev.getScreenNo());
				pstmt.setDate(5, new java.sql.Date(rev.getMovieDate().getTime()));
				pstmt.setString(6, rev.getMovieStart());
				pstmt.setString(7, rev.getMovieEnd());
				String temp = "";
				int[] stArr = rev.getSeatNo();
				for (int i = 0; i < stArr.length; i++) {
					if (i != stArr.length - 1) temp += stArr[i] + ",";
					else temp += stArr[i];
				}
				System.out.println(temp);
				pstmt.setString(8, temp);
				pstmt.setInt(9, rev.getReserveAdult());
				pstmt.setInt(10, rev.getReserveStudent());
				pstmt.setInt(11, rev.getReserveMoney());
				pstmt.setDate(12, new java.sql.Date(rev.getReserveDay().getTime()));
				int r = pstmt.executeUpdate();
				if (r == 1) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			
		}
		return false;
	}
}
