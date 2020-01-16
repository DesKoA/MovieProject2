package data;

public class Seat1 {
	private int seatNo;
	private int screenNo;
	private char seatRow;
	private int seatCol;
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	public char getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(char seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatCol() {
		return seatCol;
	}
	public void setSeatCol(int seatCol) {
		this.seatCol = seatCol;
	}
	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", screenNo=" + screenNo + ", seatRow=" + seatRow + ", seatCol=" + seatCol
				+ "]";
	}
	
	public Seat1() {}
	public Seat1(int seatNo, int screenNo, char seatRow, int seatCol) {
		super();
		this.seatNo = seatNo;
		this.screenNo = screenNo;
		this.seatRow = seatRow;
		this.seatCol = seatCol;
	}
	
	
}
