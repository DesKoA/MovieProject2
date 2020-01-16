package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import MovieProject.data.Member;
import data.Member;
import db.util.OracleDBUtil;

public class NoMemberDBManager {
	static Connection con;
	public NoMemberDBManager() {
		this.con = OracleDBUtil.con;
	}
	
	public NoMemberDBManager(Connection con) {
		this.con = con;
	}
	// 회원 (레코드) 생성
	public boolean  insertNewMember(Member mb) {
		if( mb == null ) {
			System.out.println("입력 회원객체 null!");
			return false;
		}
		if( con != null ) {
			String sql = "insert into movie_nomembers values(?,?,?,?,?,?,?)";
			//con.createStatement()
			try {
				// 사전 템플릿(포맷) 문장을 준비하고...
				PreparedStatement pstmt = con.prepareStatement(sql);
				// 데이터를 채워주고...
				//pstmt.setOOO(순서번호,타입호환데이터);
				
				pstmt.setString(1, mb.getMemberID()); // "홍길동" => '홍길동'
				pstmt.setString(2, mb.getMemberPW());
				pstmt.setString(3, mb.getMemberName());
				pstmt.setString(4, mb.getMemberEmail());
				pstmt.setDate(5, mb.getMemberBirth());
				pstmt.setString(6, mb.getMemberPhone());
				pstmt.setString(7, mb.getMemberFavor());
				
				// 실행
				int r = pstmt.executeUpdate();
				if( r == 1 ) { // 레코드의 추가 개수
					System.out.println(mb.getMemberID() +
							" 회원 가입 성공! - pstmt");
					return true;
				} else
					System.out.println(mb.getMemberID() +
							" 회원 가입 실패... - pstmt");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("접속 에러!!");
		}	
		return false;
	} 
	
	// 회원 로그인 중복 체크
	public int isDuplicatedMember(String login) {
		if( con != null ) // 접속 상태일때만... 
		{
			String sql = 
				"select * from"
				+ " c_members where login = '"+login+"'";
			try {
				Statement stmt 
						= con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				//while(rs.next()) { // 결과레코드가 있느냐?
				if( rs.next() == true ) {
					return 1;
				} else {					
					System.out.println(login + " 사용가능한 login임!");
					return 0;
				}
			} catch (SQLException e) {				
				e.printStackTrace();
				return 2;
			}
		} else {
			System.out.println("접속 에러!!");
			return 3;
		}
	}
	
	public static String LOGGED_IN = null; // 로그인 된 계정명
	public static int LOGGED_IN_NUMBER = 0; // 회원 레코드 id
	// 회원 로그인 인증
	public static boolean memberLogin(
			String login, String pw) {
		if( login == null || login.isEmpty() 
				|| pw == null || pw.isEmpty() ) {
			System.out.println("로그인 입력 오류.");
			return false;
		}
		if( con != null ) {
			String sql = 
				"select * from members "
				+ "where login = ?";
			try {
				PreparedStatement pstmt 
					= con.prepareStatement(sql);
				pstmt.setString(1, login);
				ResultSet rs = pstmt.executeQuery();
				if( rs.next() ) {
					if(pw.equals(rs.getString("password"))) {
						// 인증 성공... 회원정보 기억!
						LOGGED_IN = login;
						LOGGED_IN_NUMBER = rs.getInt("id"); 		
						System.out.println(login + " 계정 로그인 성공!");
						// 마이페이지 등 이동??
						return true;
					} else {
						System.out.println("암호가 틀립니다.");
						return false;
					}
				} else {
					System.out.println("가입되지 않았습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}		
		return false;
	}
	// 회원 한명 조회 - login일 일치하는 회원
	// 레코드를 가져와 Member 데이터로 담아서 리턴
	public Member selectOneMember(String login, String pw) {
		if( con != null ) // 접속 상태일때만... 
		{
			String sql = 
				"select * from movie_nomembers where login = ? and pw = ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, login);
				pstmt.setString(2, pw);
				ResultSet rs = pstmt.executeQuery();
				//while(rs.next()) { // 결과레코드가 있느냐?
				if( rs.next() == true ) {
					boolean mbGender	= rs.getInt("gender") == 0;
//						= (rs.getInt("gender") 
//						== 0) ? true: false;
					Member mb = new Member(
							rs.getString("memberID"), 
							rs.getString("memberPW"), 
							rs.getString("memberName"), 
							rs.getString("memberEmail"), 
							rs.getDate("memberBirth"), 
							rs.getString("memberPhone"), 
							rs.getString("memberFavor")
);
					System.out.println(mb);
					return mb;
				} else {					
					System.out.println(login + " 사용가능한 login임!");
					
				}
			} catch (SQLException e) {				
				e.printStackTrace();
				
			}
		} else {
			System.out.println("접속 에러!!");			
		}
		return null;
	}
	
}

