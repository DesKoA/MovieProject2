package data;

import java.sql.Date;

// ȸ�� 
// ȸ����� ������ ȸ�� ��ȸ��

public class Member {

	private static String memberID; // ���̵�
	private String memberPW; // ��й�ȣ
	// private int memberGrade;
	private String memberName; // �̸�
	private String memberEmail; // �̸���
	private Date memberBirth; // ����
	private String memberPhone; // �ڵ��� ��ȣ
	private String memberFavor; // ��ȣ �¼�(�¼� ���̺�)

	private Seat st = new Seat();

	public Member() {}

	public Member(String memberID, String memberPW, String memberName, String memberEmail, Date memberBirth,
			String memberPhone) {
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberFavor = st.toString();
	}

	public Member(String memberID, String memberPW, String memberName, String memberEmail, Date memberBirth,
			String memberPhone, String memberFavor) {
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberFavor = memberFavor;
	}

	public static String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberFavor() {
		return memberFavor;
	}

	public void setMemberFavor(String memberFavor) {
		this.memberFavor = memberFavor;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberPW=" + memberPW + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + ", memberBirth=" + memberBirth + ", memberPhone=" + memberPhone
				+ ", memberFavor=" + memberFavor + "]";
	}

}
