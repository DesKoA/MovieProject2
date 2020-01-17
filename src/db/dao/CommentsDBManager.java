package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import data.Member;
import data.MemberComments;
import db.util.OracleDBUtil;

public class CommentsDBManager {
	Connection con;
	
	public CommentsDBManager() {
		this.con = OracleDBUtil.con;
	}
	// 전체 댓글 조회
		public ArrayList<MemberComments> selectAllMember() {
			if (con != null) {
				String sql = "select * from movie_comments";
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					ArrayList<MemberComments> mcList = new ArrayList<>();
					while (rs.next()) {
						MemberComments mb = new MemberComments(rs.getString(1), rs.getString(2), new Date());
						mcList.add(mb);
					}
					return mcList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("DB 통신 오류");
			}
			return null;
		}
//		public boolean  insertNewComments(String com) {
//			if( con != null ) {
//				String sql = "insert into movie_members values(?,?,?,?,?,?,?)";
//				//con.createStatement()
//				try {
//					// 사전 템플릿(포맷) 문장을 준비하고...
//					PreparedStatement pstmt = con.prepareStatement(sql);
//					// 데이터를 채워주고...
//					//pstmt.setOOO(순서번호,타입호환데이터);
//					
//					pstmt.setString(1, mb.getMemberID()); // "홍길동" => '홍길동'
//					pstmt.setString(2, mb.getMemberPW());
//					pstmt.setString(3, mb.getMemberName());
//					pstmt.setString(4, mb.getMemberEmail());
//					pstmt.setDate(5, mb.getMemberBirth());
//					pstmt.setString(6, mb.getMemberPhone());
//					pstmt.setString(7, mb.getMemberFavor());
//					
//					// 실행
//					int r = pstmt.executeUpdate();
//					if( r == 1 ) { // 레코드의 추가 개수
//						System.out.println(mb.getMemberID() +
//								" 회원 가입 성공! - pstmt");
//						return true;
//					} else
//						System.out.println(mb.getMemberID() +
//								" 회원 가입 실패... - pstmt");
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			} else {
//				System.out.println("접속 에러!!");
//			}	
//			return false;
//		} 
}
