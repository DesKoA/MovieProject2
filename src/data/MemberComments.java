package data;

import java.util.Date;

public class MemberComments {
	private String memberID;
	private String comments;
	private Date comDate;

	@Override
	public String toString() {
		return "MemberComments [memberID=" + memberID + ", comments=" + comments + ", comDate=" + comDate + "]";
	}

	public MemberComments() {
		
	}
	
	public MemberComments(String memberID, String comments, Date comDate) {
		super();
		this.memberID = memberID;
		this.comments = comments;
		this.comDate = comDate;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	
	
}
