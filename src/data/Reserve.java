package data;

import java.util.Date;

// 예약

public class Reserve {
	private int reserveIndex; // 예약 인덱스 번호(자동증가)
	private String reserveNo; // 예매번호 ex) 123-XA-WIN
	private String movieTitle; // 영화 제목(영화 테이블)
	private String memberID; // 회원 아이디(회원 테이블)
	private int screenNo; // 상영관 번호(상영관 테이블)
	private Date movieDate; // 상영일(상영관 테이블)
	private String movieStart; // 상영시작시간(상영관 테이블)
	private String movieEnd; // 상영종료시간(상영관 테이블)
	private int[] seatNo; // 좌석번호(좌석 테이블)
	private int reserveAdult; // 성인수
	private int reserveStudent; // 학생수
	private int reserveMoney; // 예약 금액
	private int reserveDis; // 할인금액
	private Date disDay; // 할인날짜
	private Date reserveDay; // 예약일

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
