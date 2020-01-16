package data;

public class Movie {
	private int id;
	private String name;
	private String imgPath;
	private String MovieInfo;
	
	public Movie() {
	}
	
	public Movie(int id, String name, String imgPath, String movieInfo) {
		super();
		this.id = id;
		this.name = name;
		this.imgPath = imgPath;
		this.MovieInfo = movieInfo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getMovieInfo() {
		return MovieInfo;
	}

	public void setMovieInfo(String movieInfo) {
		this.MovieInfo = movieInfo;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", imgPath=" + imgPath + ", MovieInfo=" + MovieInfo + "]";
	}
}
