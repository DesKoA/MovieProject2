package data;

import java.util.Date;

// 상영관

public class Theaters {

	private int screenNo; // 상영관 번호
	private String screenName; // 상영관 이름
	private String movieTitle; // 영화 제목(영화 클래스)
	private String moviePoster; // 영화 포스터(영화 테이블)
	private Date movieDate; // 상영일
	private String movieStart; // 상영시작시간
	private String movieEnd; // 상영종료시간
	
	private MovieInfo mov = new MovieInfo();

	public Theaters() {}

	public Theaters(int screenNo, String screenName, Date movieDate, String movieStart, String movieEnd) {
		this.screenNo = screenNo;
		this.screenName = screenName;
		this.movieTitle = mov.getMovieTitle();
		this.moviePoster = mov.getMoviePoster();
		this.movieDate = movieDate;
		this.movieStart = movieStart;
		this.movieEnd = movieEnd;
	}

	public Theaters(int screenNo, String screenName, String movieTitle, String moviePoster, Date movieDate,
			String movieStart, String movieEnd) {
		this.screenNo = screenNo;
		this.screenName = screenName;
		this.movieTitle = movieTitle;
		this.moviePoster = moviePoster;
		this.movieDate = movieDate;
		this.movieStart = movieStart;
		this.movieEnd = movieEnd;
	}

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
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

	@Override
	public String toString() {
		return "Theaters [screenNo=" + screenNo + ", screenName=" + screenName + ", movieTitle=" + movieTitle
				+ ", moviePoster=" + moviePoster + ", movieDate=" + movieDate + ", movieStart=" + movieStart
				+ ", movieEnd=" + movieEnd + "]";
	}

}
