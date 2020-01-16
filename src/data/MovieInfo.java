package data;

// 영화 정보
public class MovieInfo {
	private int movieNo; // 번호 (자동증가)
	private String movieTitle; // 제목
	private String moviePoster; // 포스터 (이미지 경로)
	private String movieTrailer; // 예고편 (동영상 경로)
	private String movieContent; // 줄거리
	private int movieTimes; // 상영시간
	private float movieRating; // 평가점수
	private String movieGenre; // 장르
	private String movieDirector; // 감독
	private String movieActors; // 배우들
	private int movieGrade; // 상영등급

	public MovieInfo() {}

	public MovieInfo(int movieNo, String movieTitle, String moviePoster, String movieTrailer, String movieContent,
			int movieTimes, float movieRating, String movieGenre, String movieDirector, String movieActors,
			int movieGrade) {
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.moviePoster = moviePoster;
		this.movieTrailer = movieTrailer;
		this.movieContent = movieContent;
		this.movieTimes = movieTimes;
		this.movieRating = movieRating;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.movieActors = movieActors;
		this.movieGrade = movieGrade;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
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

	public String getMovieTrailer() {
		return movieTrailer;
	}

	public void setMovieTrailer(String movieTrailer) {
		this.movieTrailer = movieTrailer;
	}

	public String getMovieContent() {
		return movieContent;
	}

	public void setMovieContent(String movieContent) {
		this.movieContent = movieContent;
	}

	public int getMovieTimes() {
		return movieTimes;
	}

	public void setMovieTimes(int movieTimes) {
		this.movieTimes = movieTimes;
	}

	public float getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieActors() {
		return movieActors;
	}

	public void setMovieActors(String movieActors) {
		this.movieActors = movieActors;
	}

	public int getMovieGrade() {
		return movieGrade;
	}

	public void setMovieGrade(int movieGrade) {
		this.movieGrade = movieGrade;
	}

	@Override
	public String toString() {
		return "MovieInfo [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", moviePoster=" + moviePoster
				+ ", movieTrailer=" + movieTrailer + ", movieContent=" + movieContent + ", movieTimes=" + movieTimes
				+ ", movieRating=" + movieRating + ", movieGenre=" + movieGenre + ", movieDirector=" + movieDirector
				+ ", movieActors=" + movieActors + ", movieGrade=" + movieGrade + "]";
	}

}
