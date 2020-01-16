package data;

import java.sql.Date;

// 회원 
// 회원등급 관리자 회원 비회원

public class NoMember {

//	private static String memberID; // 아이디
	private static String memberPW; // 비밀번호
	// private int memberGrade;
//	private String memberName; // 이름
	private String memberEmail; // 이메일
	private Date memberBirth; // 생일
	private String memberPhone; // 핸드폰 번호
	//private String memberFavor; // 선호 좌석(좌석 테이블)

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
