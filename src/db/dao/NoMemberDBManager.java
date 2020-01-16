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
	// ȸ�� (���ڵ�) ����
	public boolean  insertNewMember(Member mb) {
		if( mb == null ) {
			System.out.println("�Է� ȸ����ü null!");
			return false;
		}
		if( con != null ) {
			String sql = "insert into movie_nomembers values(?,?,?,?,?,?,?)";
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
	
	public static String LOGGED_IN = null; // �α��� �� ������
	public static int LOGGED_IN_NUMBER = 0; // ȸ�� ���ڵ� id
	// ȸ�� �α��� ����
	public static boolean memberLogin(
			String login, String pw) {
		if( login == null || login.isEmpty() 
				|| pw == null || pw.isEmpty() ) {
			System.out.println("�α��� �Է� ����.");
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
						// ���� ����... ȸ������ ���!
						LOGGED_IN = login;
						LOGGED_IN_NUMBER = rs.getInt("id"); 		
						System.out.println(login + " ���� �α��� ����!");
						// ���������� �� �̵�??
						return true;
					} else {
						System.out.println("��ȣ�� Ʋ���ϴ�.");
						return false;
					}
				} else {
					System.out.println("���Ե��� �ʾҽ��ϴ�.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����");
		}		
		return false;
	}
	// ȸ�� �Ѹ� ��ȸ - login�� ��ġ�ϴ� ȸ��
	// ���ڵ带 ������ Member �����ͷ� ��Ƽ� ����
	public Member selectOneMember(String login, String pw) {
		if( con != null ) // ���� �����϶���... 
		{
			String sql = 
				"select * from movie_nomembers where login = ? and pw = ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, login);
				pstmt.setString(2, pw);
				ResultSet rs = pstmt.executeQuery();
				//while(rs.next()) { // ������ڵ尡 �ִ���?
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
					System.out.println(login + " ��밡���� login��!");
					
				}
			} catch (SQLException e) {				
				e.printStackTrace();
				
			}
		} else {
			System.out.println("���� ����!!");			
		}
		return null;
	}
	
}

