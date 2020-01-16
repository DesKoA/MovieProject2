package data;

// �¼�
public class Seat {
	private int seatNo; // �¼� ��ȣ
	private int screenNo; // �󿵰� ��ȣ(�󿵰� Ŭ����)
	private char seatRow; // �¼� ��
	private int seatCol; // �¼� ��
	private String memberID; // 

	private Theaters th = new Theaters();
	
	public Seat() {}

	public Seat(int seatNo, char seatRow, int seatCol) {
		this.seatNo = seatNo;
		this.screenNo = th.getScreenNo();
		this.seatRow = seatRow;
		this.seatCol = seatCol;
	}

	public Seat(int seatNo, int screenNo, char seatRow, int seatCol, String memberID) {
		this.seatNo = seatNo;
		this.screenNo = screenNo;
		this.seatRow = seatRow;
		this.seatCol = seatCol;
		this.memberID = memberID;
	}

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
	
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", screenNo=" + screenNo + ", seatRow=" + seatRow + ", seatCol=" + seatCol
				+ "]";
	}

}
