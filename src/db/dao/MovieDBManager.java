package db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.MovieInfo;
import db.util.OracleDBUtil;
import ui.movieMain.MovieMainFrame;

public class MovieDBManager {
//	public static final String USER = "java";
//	public static final String PW = "1234";
//	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";

	public Connection con;
	
	public MovieDBManager() {
		this.con = OracleDBUtil.con;
	}

	public MovieDBManager(Connection con) {
		this.con = con;
	}
	
//	public void connectDB() {
//		try {
//			Class.forName(DRIVER_NAME);
//			con = DriverManager.getConnection(URL, USER, PW);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void closeDB() {
//		if (con != null) {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	// 영화 목록 ArrayList
	public ArrayList<MovieInfo> movie_selectAll() {
		if (con != null) {
			String sql = "select * from movie_info";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				ArrayList<MovieInfo> mvList = new ArrayList<>();
				while (rs.next()) {
					MovieInfo tp = new MovieInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getInt(11));
					System.out.println(tp);
					mvList.add(tp);
				}
				return mvList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}
	// 영화 제목 목록 ArrayList
	public ArrayList<MovieInfo> movieTitle_selectAll() {
		if (con != null) {
			String sql = "select * from movie_info order by movie_no asc";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				ArrayList<MovieInfo> mvList = new ArrayList<>();
				while (rs.next()) {
					MovieInfo tp = new MovieInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getInt(11));
				mvList.add(tp);	
				}
				return mvList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}
	//영화 평점 조회
	public ArrayList<MovieInfo> movie_selectMovieRating() {
		if(con != null) {
			String sql = "select * from movie_info order by movie_rating desc";
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					ArrayList<MovieInfo> mvList = new ArrayList<>();
					while (rs.next()) {
						MovieInfo tp = new MovieInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9),
								rs.getString(10), rs.getInt(11));
								mvList.add(tp);	
					}
					return mvList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("DB 통신 오류");
			}
			return null;
	}
	// 영화 TOP3 평점 조회
		public String[] movie_selectMovieTop3Rating() {
			if(con != null) {
				String sql = "select movie_poster from movie_info order by movie_rating desc";
				String countSql = "select count(movie_poster) from movie_info";
					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(countSql);
						int count = 0;
						if (rs.next())
							count = rs.getInt(1);
							String[] mvRList = new String[count];
							ResultSet rs2 = stmt.executeQuery(sql);
						int i = 0;
						//MainFrame2.TOP3mf.clear();
						while (i < 3 && rs2.next()) {
							mvRList[i++] = rs2.getString(1);// movie_poster
//							int movieNo = rs.getInt("movie_no");
//							String movieTitle = rs.getString("movie_title");
//							String moviePoster = rs.getString("movie_poster");
//							String movieTrailer = rs.getString("movie_trailer");
//							String movieContent = rs.getString("movie_content");
//							int movieTimes = rs.getInt("movie_time");
//							float movieRating = rs.getFloat("movie_rating");
//							String movieGenre = rs.getString("movie_genre");
//							String movieDirector = rs.getString("movie_director");
//							String movieActors = rs.getString("movie_actors");
//							int movieGrade = rs.getInt("movie_grade");
//							MovieInfo e = new MovieInfo(movieNo, movieTitle, moviePoster, movieTrailer, movieContent, movieTimes, movieRating, movieGenre, movieDirector, movieActors, movieGrade);
//							MainFrame2.TOP3mf.add(e);
						}
						return mvRList;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("DB 통신 오류");
				}
				return null;
		}
	// 영화 제목 출력 true면 평점 false면 가나다순
	public String[] movie_selectAllTitle(boolean b) {
		if (con != null) {
			String order = b ? "movie_rating desc" : "movie_title asc";
			String countSql = "select count(movie_title) from movie_info";
			String sql = "select movie_title from movie_info order by " + order;
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(countSql);
				int count = 0;
				if (rs.next())
					count = rs.getInt(1);

				String[] mvList = new String[count];

				ResultSet rs2 = stmt.executeQuery(sql);
				int i = 0;
				while (rs2.next()) {
					mvList[i++] = rs2.getString(1);
				}
				return mvList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}

	// 영화 제목에 맞는 한개의 영화 정보 가져오기
	public MovieInfo movie_selectOneByTitle(String movTitle) {
		if (con != null) {
			String sql = "select * from movie_info where movie_title = " + "'" + movTitle + "'";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				if (rs.next()) {
					int id = rs.getInt(1);
					String title = rs.getString(2);
					String poster = rs.getString(3);
					String trailer = rs.getString(4);
					String content = rs.getString(5);
					int times = rs.getInt(6);
					float rating = rs.getFloat(7);
					String genre = rs.getString(8);
					String director = rs.getString(9);
					String actors = rs.getString(10);
					int grade = rs.getInt(11);

					MovieInfo movieInfo = new MovieInfo(id, title, poster, trailer, content, times, rating, genre, director, actors, grade);
					return movieInfo;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}

}
