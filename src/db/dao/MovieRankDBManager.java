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
	// ��� ���ƿ� 
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
		System.out.println("DB ��� ����");
	}
	return null;
	}
	// ���ƿ� �ֱ�
	public boolean insertMovieFavor(MovieRank mr) {
			if( con != null ) {
				String sql = "insert into movie_rank values(rank_seq.nextval,?,?,?,?)";
				//con.createStatement()
				try {
					// ���� ���ø�(����) ������ �غ��ϰ�...
					PreparedStatement pstmt = con.prepareStatement(sql);
					// �����͸� ä���ְ�...
					//pstmt.setOOO(������ȣ,Ÿ��ȣȯ������);
					
					pstmt.setString(1, mr.getMovieTitle()); // "ȫ�浿" => 'ȫ�浿'
					pstmt.setString(2, mr.getMemberID());
					pstmt.setString(3, String.valueOf(mr.isRatingScore()));
					pstmt.setString(4, mr.getRatingContent());
					
					// ����
					int r = pstmt.executeUpdate();
					if( r == 1 ) { // ���ڵ��� �߰� ����
						System.out.println(mr.getMemberID() +
								" ���ƿ��߽��ϴ�");
						return true;
					} else
						System.out.println(mr.getMemberID() +
								" ���ƿ� ���� ���߽��ϴ�");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("���� ����!!");
			}	
			return false;
	}
	
}
