package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import MovieProject.data.Member;
import data.Member;
import data.MovieInfo;
import db.util.OracleDBUtil;
import login.loginpop;

public class MemberDBManager {
	Connection con;
	public MemberDBManager() {
		this.con = OracleDBUtil.con;
	}
	
	public MemberDBManager(Connection con) {
		this.con = con;
	}
	// ȸ�� (���ڵ�) ����
	public boolean  insertNewMember(Member mb) {
		if( mb == null ) {
			System.out.println("�Է� ȸ����ü null!");
			return false;
		}
		if( con != null ) {
			String sql = "insert into movie_members values(?,?,?,?,?,?,?)";
			//con.createStatement()
			try {
				// ���� ���ø�(����) ������ �غ��ϰ�...
				PreparedStatement pstmt = con.prepareStatement(sql);
				// �����͸� ä���ְ�...
				//pstmt.setOOO(������ȣ,Ÿ��ȣȯ������);
				
				pstmt.setString(1, mb.getMemberID()); // "ȫ�浿" => 'ȫ�浿'
				pstmt.setString(2, mb.getMemberPW());
				pstmt.setString(3, mb.getMemberName());
				pstmt.setString(4, mb.getMemberEmail());
				pstmt.setDate(5, mb.getMemberBirth());
				pstmt.setString(6, mb.getMemberPhone());
				pstmt.setString(7, mb.getMemberFavor());
				
				// ����
				int r = pstmt.executeUpdate();
				if( r == 1 ) { // ���ڵ��� �߰� ����
					System.out.println(mb.getMemberID() +
							" ȸ�� ���� ����! - pstmt");
					return true;
				} else
					System.out.println(mb.getMemberID() +
							" ȸ�� ���� ����... - pstmt");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("���� ����!!");
		}	
		return false;
	} 
	
	// ȸ�� �α��� �ߺ� üũ
	public int isDuplicatedMember(String login) {
		if( con != null ) // ���� �����϶���... 
		{
			String sql = 
				"select * from"
				+ " c_members where login = '"+login+"'";
			try {
				Statement stmt 
						= con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				//while(rs.next()) { // ������ڵ尡 �ִ���?
				if( rs.next() == true ) {
					return 1;
				} else {					
					System.out.println(login + " ��밡���� login��!");
					return 0;
				}
			} catch (SQLException e) {				
				e.printStackTrace();
				return 2;
			}
		} else {
			System.out.println("���� ����!!");
			return 3;
		}
	}

	// ȸ�� �Ѹ� ��ȸ - login�� ��ġ�ϴ� ȸ��
	// ���ڵ带 ������ Member �����ͷ� ��Ƽ� ����
	public Member selectOneMember(String login, String pw) {
		if( con != null ) // ���� �����϶���... 
		{
			String sql = 
				"select * from movie_members where member_id = ? and member_pw = ?";
			System.out.println(login);
			System.out.println(pw);
			String pwpwpw = loginpop.encrypt(pw);
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, login);
				pstmt.setString(2, pwpwpw);
				ResultSet rs = pstmt.executeQuery();
				//while(rs.next()) { // ������ڵ尡 �ִ���?
				if( rs.next() == true ) {
		//			boolean mbGender	= rs.getInt("gender") == 0;
//						= (rs.getInt("gender") 
//						== 0) ? true: false;
					Member mb = new Member(
							rs.getString("member_ID"), 
							rs.getString("member_PW"), 
							rs.getString("member_Name"), 
							rs.getString("member_Email"), 
							rs.getDate("member_Birth"), 
							rs.getString("member_Phone"), 
							rs.getString("member_Favor")
);
					System.out.println(mb);
					return mb;
				} 
			} catch (SQLException e) {				
				e.printStackTrace();
				
			}
		} else {
			System.out.println("���� ����!!");			
		}
		return null;
	}
	// ��ü ȸ�� ��ȸ
	public ArrayList<Member> selectAllMember() {
		if (con != null) {
			String sql = "select * from movie_members";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				ArrayList<Member> mbList = new ArrayList<>();
				while (rs.next()) {
					Member mb = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7));
					mbList.add(mb);
				}
				return mbList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����");
		}
		return null;
	}
}

