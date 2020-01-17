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
	// ��ü ��� ��ȸ
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
				System.out.println("DB ��� ����");
			}
			return null;
		}
//		public boolean  insertNewComments(String com) {
//			if( con != null ) {
//				String sql = "insert into movie_members values(?,?,?,?,?,?,?)";
//				//con.createStatement()
//				try {
//					// ���� ���ø�(����) ������ �غ��ϰ�...
//					PreparedStatement pstmt = con.prepareStatement(sql);
//					// �����͸� ä���ְ�...
//					//pstmt.setOOO(������ȣ,Ÿ��ȣȯ������);
//					
//					pstmt.setString(1, mb.getMemberID()); // "ȫ�浿" => 'ȫ�浿'
//					pstmt.setString(2, mb.getMemberPW());
//					pstmt.setString(3, mb.getMemberName());
//					pstmt.setString(4, mb.getMemberEmail());
//					pstmt.setDate(5, mb.getMemberBirth());
//					pstmt.setString(6, mb.getMemberPhone());
//					pstmt.setString(7, mb.getMemberFavor());
//					
//					// ����
//					int r = pstmt.executeUpdate();
//					if( r == 1 ) { // ���ڵ��� �߰� ����
//						System.out.println(mb.getMemberID() +
//								" ȸ�� ���� ����! - pstmt");
//						return true;
//					} else
//						System.out.println(mb.getMemberID() +
//								" ȸ�� ���� ����... - pstmt");
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			} else {
//				System.out.println("���� ����!!");
//			}	
//			return false;
//		} 
}
