package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	// 모든 좋아요 
	public ArrayList<MovieRank> selectAllRank(String login) {
	if (con != null) {
		String sql = "select * from movie_Rank where member_id = " + "'" + login + "'";
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
	// 좋아요 넣기
	public boolean insertMovieFavor(MovieRank mr) {
			if( con != null ) {
				String sql = "insert into movie_rank values(rank_seq.nextval,?,?,?,?)";
				//con.createStatement()
				try {
					// 사전 템플릿(포맷) 문장을 준비하고...
					PreparedStatement pstmt = con.prepareStatement(sql);
					// 데이터를 채워주고...
					//pstmt.setOOO(순서번호,타입호환데이터);
					
					pstmt.setString(1, mr.getMovieTitle()); // "홍길동" => '홍길동'
					pstmt.setString(2, mr.getMemberID());
					pstmt.setString(3, String.valueOf(mr.isRatingScore()));
					pstmt.setString(4, mr.getRatingContent());
					
					// 실행
					int r = pstmt.executeUpdate();
					if( r == 1 ) { // 레코드의 추가 개수
						System.out.println(mr.getMemberID() +
								" 좋아요했습니다");
						return true;
					} else
						System.out.println(mr.getMemberID() +
								" 좋아요 하지 못했습니다");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("접속 에러!!");
			}	
			return false;
	}
	
}
