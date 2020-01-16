package data;

// 영화 평가

public class MovieRank {
	private int ratingNo; // 번호(자동증가)
	private String movieTitle; // 영화 제목(영화 테이블)
	private String memberID; // 회원 아이디(회원 테이블)
	private char ratingScore; // 좋아요
	private String ratingContent; // 내용
	
	private MovieInfo mov = new MovieInfo();
	private Member mb = new Member();
	
	public MovieRank() {}
	
	public MovieRank(int ratingNo, char ratingScore, String ratingContent) {
		this.ratingNo = ratingNo;
		this.movieTitle = mov.getMovieTitle();
		this.memberID = mb.toString();
		this.ratingScore = ratingScore;
		this.ratingContent = ratingContent;
	}

	public MovieRank(int ratingNo, String movieTitle, String memberID, char ratingScore, String ratingContent) {
		this.ratingNo = ratingNo;
		this.movieTitle = movieTitle;
		this.memberID = memberID;
		this.ratingScore = ratingScore;
		this.ratingContent = ratingContent;
	}

	public int getRatingNo() {
		return ratingNo;
	}

	public void setRatingNo(int ratingNo) {
		this.ratingNo = ratingNo;
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

	public char isRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(char ratingScore) {
		this.ratingScore = ratingScore;
	}
	
	public String getRatingContent() {
		return ratingContent;
	}

	public void setRatingContent(String ratingContent) {
		this.ratingContent = ratingContent;
	}

	@Override
	public String toString() {
		return "MovieRank [ratingNo=" + ratingNo + ", movieTitle=" + movieTitle + ", memberID=" + memberID
				+ ", ratingScore=" + ratingScore + ", ratingContent=" + ratingContent + "]";
	}
	
}
