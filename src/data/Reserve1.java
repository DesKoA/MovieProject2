package data;

import java.util.Date;

public class Reserve1 {
	public static final int MEMBER = 0;
	public static final int NOT_MEMBER = 1;
	public static final String[] IS_MEMBER = { "회원", "비회원" };
	
	private int reserveNo;
	private String movieTitle;
	private String memberID;
	private int screenNo;
	private Date movieDate;
	private String movieStart;
	private String movieEnd;
	private int seatNo;
	private int reserveAdult;
	private int reserveStudent;
	private int reserveMoney;
	private Date reserveDay;
	private String imgPath;
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
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
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
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
	public Date getReserveDay() {
		return reserveDay;
	}
	public void setReserveDay(Date reserveDay) {
		this.reserveDay = reserveDay;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public static int getMember() {
		return MEMBER;
	}
	public static int getNotMember() {
		return NOT_MEMBER;
	}
	public static String[] getIsMember() {
		return IS_MEMBER;
	}
	@Override
	public String toString() {
		return "Reserve [reserveNo=" + reserveNo + ", movieTitle=" + movieTitle + ", memberID=" + memberID
				+ ", screenNo=" + screenNo + ", movieDate=" + movieDate + ", movieStart=" + movieStart + ", movieEnd="
				+ movieEnd + ", seatNo=" + seatNo + ", reserveAdult=" + reserveAdult + ", reserveStudent="
				+ reserveStudent + ", reserveMoney=" + reserveMoney + ", reserveDay=" + reserveDay + ", imgPath="
				+ imgPath + "]";
	}
	
	public Reserve1() {}
	public Reserve1(int reserveNo, String movieTitle, String memberID, int screenNo, Date movieDate, String movieStart,
			String movieEnd, int seatNo, int reserveAdult, int reserveStudent, int reserveMoney, Date reserveDay,
			String imgPath) {
		super();
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
		this.imgPath = imgPath;
	}
	
	
	
}
