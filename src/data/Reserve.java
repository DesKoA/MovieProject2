package data;

import java.util.Date;

// ����

public class Reserve {
	private int reserveIndex; // ���� �ε��� ��ȣ(�ڵ�����)
	private String reserveNo; // ���Ź�ȣ ex) 123-XA-WIN
	private String movieTitle; // ��ȭ ����(��ȭ ���̺�)
	private String memberID; // ȸ�� ���̵�(ȸ�� ���̺�)
	private int screenNo; // �󿵰� ��ȣ(�󿵰� ���̺�)
	private Date movieDate; // ����(�󿵰� ���̺�)
	private String movieStart; // �󿵽��۽ð�(�󿵰� ���̺�)
	private String movieEnd; // ������ð�(�󿵰� ���̺�)
	private int[] seatNo; // �¼���ȣ(�¼� ���̺�)
	private int reserveAdult; // ���μ�
	private int reserveStudent; // �л���
	private int reserveMoney; // ���� �ݾ�
	private int reserveDis; // ���αݾ�
	private Date disDay; // ���γ�¥
	private Date reserveDay; // ������

	private MovieInfo mov = new MovieInfo();
	private Member mb = new Member();
	private Theaters th = new Theaters();

	public Reserve() {}
	
	public Reserve(int reserveIndex, String reserveNo, String movieTitle, String memberID, int screenNo, Date movieDate,
			String movieStart, String movieEnd, int[] seatNo, int reserveAdult, int reserveStudent, int reserveMoney,
			Date reserveDay) {
		super();
		this.reserveIndex = reserveIndex;
		this.reserveNo = reserveNo;
		this.movieTitle = movieTitle;
		this.memberID = memberID;
		this.screenNo = screenNo;
		this.movieDate = movieDate;
		this.movieStart = movieStart;
		this.movieEnd = movieEnd;
		this.seatNo = seatNo;
		this.reserveAdult = reserveAdult;
		this.reserveStudent = reserveStudent;
		this.reserveMoney = reserveMoney;
		this.reserveDay = reserveDay;
	}



	public Reserve(int reserveIndex, String reserveNo, int reserveAdult, int reserveStudent, int reserveMoney, int reserveDis, Date disDay,
			Date reserveDay) {
		this.reserveIndex = reserveIndex;
		this.reserveNo = reserveNo;
		this.movieTitle = mov.getMovieTitle();
		this.memberID = mb.getMemberID();
		this.screenNo = th.getScreenNo();
		this.movieDate = th.getMovieDate();
		this.movieStart = th.getMovieStart();
		this.movieEnd = th.getMovieEnd();
		this.reserveAdult = reserveAdult;
		this.reserveStudent = reserveStudent;
		this.reserveMoney = reserveMoney;
		this.reserveDis = reserveDis;
		this.disDay = disDay;
		this.reserveDay = reserveDay;
	}

	public Reserve(int reserveIndex, String reserveNo, String movieTitle, String memberID, int screenNo, Date movieDate, String movieStart,
			String movieEnd, int[] seatNo, int reserveAdult, int reserveStudent, int reserveMoney, int reserveDis,
			Date disDay, Date reserveDay) {
		this.reserveIndex = reserveIndex;
		this.reserveNo = reserveNo;
		this.movieTitle = movieTitle;
		this.memberID = memberID;
		this.screenNo = screenNo;
		this.movieDate = movieDate;
		this.movieStart = movieStart;
		this.movieEnd = movieEnd;
		this.seatNo = seatNo;
		this.reserveAdult = reserveAdult;
		this.reserveStudent = reserveStudent;
		this.reserveMoney = reserveMoney;
		this.reserveDis = reserveDis;
		this.disDay = disDay;
		this.reserveDay = reserveDay;
	}
	
	public int getReserveIndex() {
		return reserveIndex;
	}

	public void setReserveIndex(int reserveIndex) {
		this.reserveIndex = reserveIndex;
	}


	public String getReserveNo() {
		return reserveNo;
	}

	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieStart() {
		return movieStart;
	}

	public void setMovieStart(String movieStart) {
		this.movieStart = movieStart;
	}

	public String getMovieEnd() {
		return movieEnd;
	}

	public void setMovieEnd(String movieEnd) {
		this.movieEnd = movieEnd;
	}

	public int[] getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int[] seatNo) {
		this.seatNo = seatNo;
	}

	public int getReserveAdult() {
		return reserveAdult;
	}

	public void setReserveAdult(int reserveAdult) {
		this.reserveAdult = reserveAdult;
	}

	public int getReserveStudent() {
		return reserveStudent;
	}

	public void setReserveStudent(int reserveStudent) {
		this.reserveStudent = reserveStudent;
	}

	public int getReserveMoney() {
		return reserveMoney;
	}

	public void setReserveMoney(int reserveMoney) {
		this.reserveMoney = reserveMoney;
	}

	public int getReserveDis() {
		return reserveDis;
	}

	public void setReserveDis(int reserveDis) {
		this.reserveDis = reserveDis;
	}

	public Date getDisDay() {
		return disDay;
	}

	public void setDisDay(Date disDay) {
		this.disDay = disDay;
	}

	public Date getReserveDay() {
		return reserveDay;
	}

	public void setReserveDay(Date reserveDay) {
		this.reserveDay = reserveDay;
	}

	@Override
	public String toString() {
		return "Reserve [reserveIndex=" + reserveIndex + ", reserveNo=" + reserveNo + ", movieTitle=" + movieTitle
				+ ", memberID=" + memberID + ", screenNo=" + screenNo + ", movieDate=" + movieDate + ", movieStart="
				+ movieStart + ", movieEnd=" + movieEnd + ", seatNo=" + seatNo + ", reserveAdult=" + reserveAdult
				+ ", reserveStudent=" + reserveStudent + ", reserveMoney=" + reserveMoney + ", reserveDis=" + reserveDis
				+ ", disDay=" + disDay + ", reserveDay=" + reserveDay + ", mov=" + mov + ", mb=" + mb + ", th=" + th
				+ "]";
	}
	
}
