package data;

import java.sql.Date;

// ȸ�� 
// ȸ����� ������ ȸ�� ��ȸ��

public class NoMember {

//	private static String memberID; // ���̵�
	private static String memberPW; // ��й�ȣ
	// private int memberGrade;
//	private String memberName; // �̸�
	private String memberEmail; // �̸���
	private Date memberBirth; // ����
	private String memberPhone; // �ڵ��� ��ȣ
	//private String memberFavor; // ��ȣ �¼�(�¼� ���̺�)

//	private Seat st = new Seat();

	public NoMember() {}

	public NoMember(String memberEmail,  String memberPW,  Date memberBirth) {
	//	this.memberID = memberID;
		this.memberPW = memberPW;
	//	this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
	//	this.memberFavor = st.toString();
	}

	public NoMember(String memberEmail, String memberPW,  Date memberBirth,
			String memberPhone) {
//		this.memberID = memberID;
		this.memberPW = memberPW;
	//	this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		//this.memberFavor = memberFavor;
	}


	public static String getMemberPW() {
		return memberPW;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
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



	@Override
	public String toString() {
		return "Member [ memberEmail=" + memberEmail + ", memberPW=" + memberPW +
				", memberBirth=" + memberBirth + ", memberPhone=" + memberPhone	+ "]";
	}

}
