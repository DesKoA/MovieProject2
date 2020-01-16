package db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Member;
import data.MovieInfo;
import data.MovieRank;
import db.util.OracleDBUtil;

public class MovieRankDBManager {
	Connection con;
	public MovieRankDBManager() {
		this.con = OracleDBUtil.con;
	}
	
	public MovieRankDBManager(Connection con) {
		this.con = con;
	}
	public ArrayList<MovieRank> selectAllRank() {
	if (con != null) {
		String sql = "select * from movie_Rank";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<MovieRank> mrList = new ArrayList<>();
			while (rs.next()) {
				MovieRank mr = new MovieRank(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).charAt(0), rs.getString(5));
				System.out.println(mr);
				mrList.add(mr);
			}
			return mrList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} else {
		System.out.println("DB 통신 오류");
	}
	return null;
	}
}
