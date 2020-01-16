package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;

import data.Theaters;
import db.util.OracleDBUtil;

public class TheatersDBManager {
	public Connection con;
	
	public TheatersDBManager() {
		this.con = OracleDBUtil.con;
	}
	
	public TheatersDBManager(Connection con) {
		this.con = con;
	}

	public ArrayList<Theaters> selectOneMovie(String movTitle) {
		if (con != null) {
			String sql = "select * from movie_theaters where movie_title = " + "'" + movTitle + "'";
					// "select m.*, to_char(m.movie_date, 'YYYY-fmMM-DD') as to_date from movie_theaters m where movie_title = " + "'" + movTitle + "'";
			// "select screen_no, screen_name, movie_title, movie_poster, to_char(movie_date, 'YYYY. fmMM. DD') from dual, movie_start, movie_end"+ " from movie_theaters where movie_title = " + "'" + movTitle + "'";
			// String sql = "select * from movie_theaters where movie_title = " + "'" + movTitle + "'";
			// String toCharSql = "select to_char(movie_date, 'YYYY-fmMM-DD') from movie_theaters";
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				ArrayList<Theaters> thList = new ArrayList<>();
				while (rs.next()) {
					int id = rs.getInt(1);
					String scName = rs.getString(2);
					String movieTitle = rs.getString(3);
					String moviePoster = rs.getString(4);
					// String dateStr = String.valueOf(rs.getDate(5));
					// SimpleDateFormat sf = new SimpleDateFormat("YYYY-M-d");
					Date movieDate = rs.getDate(5);
					// Date movieDate = sf.parse(dateStr);
					// System.out.println((sf.format(sf.parse(dateStr))));
					String start = rs.getString(6);
					String end = rs.getString(7);
					Theaters th = new Theaters(id, scName, movieTitle, moviePoster, movieDate, start, end);
					thList.add(th);
				}
				return thList;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}
	
	public String[] selectOneMovieScreenByDate(String movTitle) {
		if (con != null) {
			String sql = "select screen_name from movie_theaters where movie_title=" + "'" + movTitle + "'" + "GROUP BY screen_name, movie_title"; 
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				int count = 0;
				ArrayList<String> list = new ArrayList<>();
				while(rs.next()) {
					count++;
					list.add(rs.getString(1));
				}
				String[] thList = new String[count];
				for (int i = 0; i < thList.length; i++) {
					thList[i] = list.get(i);
				}
				return thList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}
	
	public LinkedHashMap<String, ArrayList<String>> selectOneMovieStartByName(String movTitle, Date movDate) {
		if (con != null) {
			SimpleDateFormat sf = new SimpleDateFormat("YYYYMMDD");
			String dateStr = sf.format(movDate);
			String sql = "select movie_start, screen_name from movie_theaters where movie_title=" + "'" + movTitle + "'"
					+ " and TO_CHAR(movie_date, 'YYYYMMDD')=" + "'" + dateStr + "'" + " order by movie_start asc";
			
			// 각각 관의 대해서 추가.
			ArrayList<String> thList1 = new ArrayList<>();
			ArrayList<String> thList2 = new ArrayList<>();
			ArrayList<String> thList3 = new ArrayList<>();
			ArrayList<String> thList4 = new ArrayList<>();
			ArrayList<String> thList5 = new ArrayList<>();
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				LinkedHashMap<String, ArrayList<String>> thList = new LinkedHashMap<>();
				while (rs.next()) {
					String mvStart = rs.getString(1);
					String scName = rs.getString(2);
					switch (scName) {
					case "1관":
						thList1.add(mvStart);
						break;
					case "2관":
						thList2.add(mvStart);
						break;
					case "3관":
						thList3.add(mvStart);
						break;
					case "4관":
						thList4.add(mvStart);
						break;
					case "5관":
						thList5.add(mvStart);
						break;
					default:
						break;
					}
				}
				if (thList1.size() != 0) thList.put("1관", thList1);
				if (thList2.size() != 0) thList.put("2관", thList2);
				if (thList3.size() != 0) thList.put("3관", thList3);
				if (thList4.size() != 0) thList.put("4관", thList4);
				if (thList5.size() != 0) thList.put("5관", thList5);

				return thList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("통신 오류");
		}
		return null;
	}
	
//	public LinkedHashMap<String, ArrayList<String>> selectOneMovieStartByName(String movTitle, Date movDate) {
//		if (con != null) {
//			SimpleDateFormat sf = new SimpleDateFormat("YYYYMMDD");
//			String dateStr = sf.format(movDate);
//			String grSql = "select screen_name from MOVIE_THEATERS where movie_title=" + "'" + movTitle + "'" // 그룹 sql 
//					+ " and TO_CHAR(movie_date, 'YYYYMMDD')=" + "'" + dateStr + "'" + " group by screen_name order by screen_name";
//			
//			ArrayList<String> scArr = new ArrayList<>();
//			try {
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(grSql);
//				
//				LinkedHashMap<String, ArrayList<String>> thList = new LinkedHashMap<>();
//				while (rs.next()) {
//					scArr.add(rs.getString(1));
//				}
//				
//				String scName = "(";
//				
//				for (int i = 0; i < scArr.size(); i++) {
//					if (i != scArr.size() - 1) scName += "screen_name = '" + scArr.get(i) + "' or "; // or screen_name = '2관'
//					else scName += "screen_name = '" + scArr.get(i) + "')";
//				}
//				
//				String orSql = "select movie_start, screen_name from movie_theaters where movie_title=" + "'" + movTitle + "'"
//						+ " and" + scName + " and TO_CHAR(movie_date, 'YYYYMMDD')=" + "'" + dateStr + "'" + " order by screen_name, movie_start asc";
//				Statement stmt2 = con.createStatement();
//				ResultSet rs2 = stmt2.executeQuery(orSql);
//				ArrayList<String> stListD = new ArrayList<>();
//				int j = 0;
//				while (rs2.next()) {
//					String temp = rs2.getString(2);
//					for (int i = 0; i < scArr.size(); i++) {
//						if (scArr.get(j).equals(temp)) {
//							stListD.add(rs2.getString(1));
//							if (j == scArr.size() - 1) {
//								HashSet<String> hs = new HashSet<String>(stListD);
//								ArrayList<String> stList = new ArrayList<>(hs);
//								Collections.sort(stList);
//								thList.put(scArr.get(j++), stList);
//							}
//							break;
//						} 
//						else if (!scArr.get(j).equals(temp)) {
//							HashSet<String> hs = new HashSet<String>(stListD);
//							ArrayList<String> stList = new ArrayList<>(hs);
//							Collections.sort(stList);
//							thList.put(scArr.get(j++), stList);
//							stListD = new ArrayList<>();
//							if (j < scArr.size()) stListD.add(rs2.getString(1));
//						}
//					}
//				}
//				return thList;
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("통신 오류");
//		}
//		return null;
//	}
	
	public int selectOneScreenNo(String scName, String mvTitle, Date movDate, String movStart) {
		if (con != null) {
			SimpleDateFormat sf = new SimpleDateFormat("YYYYMMDD");
			String dateStr = sf.format(movDate);
			String sql = String.format("select screen_no from movie_theaters where screen_name = '%s' and movie_title = '%s'"
					+ " and TO_CHAR(movie_date, 'YYYYMMDD') = '%s' and movie_start = '%s'", scName, mvTitle, dateStr, movStart);
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					int ret = rs.getInt(1);
					return ret;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			
		}
		return 0;
	}
	
	public ArrayList<Theaters> selectScNameInfo(String scName, Date movDate) {
		if (con != null) {
			String dateStr = new SimpleDateFormat("YYYYMMDD").format(movDate);
			String sql = "select movie_title, screen_name, movie_date, movie_start, movie_end from movie_theaters "
					+ "where screen_name = " + "'" + scName +"'" + " and TO_CHAR(movie_date, 'YYYYMMDD') = "
							+ "'" + dateStr + "' order by screen_name, movie_start asc";
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				ArrayList<Theaters> thList = new ArrayList<>();
				while (rs.next()) {
					Theaters th = new Theaters(0, rs.getString(2), rs.getString(1), null, rs.getDate(3), rs.getString(4), rs.getString(5));
					thList.add(th);
				}
				return thList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("db에러");
		}
		return null;
	}
	
	public ArrayList<String> selectMovieStart(String scName, Date movDate) {
		if (con != null) {
			String dateStr = new SimpleDateFormat("YYYYMMDD").format(movDate);
			String sql = "select movie_start from movie_theaters "
					+ "where screen_name = " + "'" + scName +"'" + " and TO_CHAR(movie_date, 'YYYYMMDD') = "
							+ "'" + dateStr + "' order by movie_start asc";
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				ArrayList<String> thList = new ArrayList<>();
				while (rs.next()) {
					thList.add(rs.getString(1));
				}
				return thList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("db에러");
		}
		return null;
	}
	
	public ArrayList<String> selectMovieEnd(String scName, Date movDate) {
		if (con != null) {
			String dateStr = new SimpleDateFormat("YYYYMMDD").format(movDate);
			String sql = "select movie_end from movie_theaters "
					+ "where screen_name = " + "'" + scName +"'" + " and TO_CHAR(movie_date, 'YYYYMMDD') = "
							+ "'" + dateStr + "' order by movie_start asc";
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				ArrayList<String> thList = new ArrayList<>();
				while (rs.next()) {
					thList.add(rs.getString(1));
				}
				return thList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("db에러");
		}
		return null;
	}
	
	public boolean insertNewScreen(Theaters th) {
		if (con != null) {
			String sql = "insert into movie_theaters values(sc_seq.nextval,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, th.getScreenName());
				pstmt.setString(2, th.getMovieTitle());
				pstmt.setString(3, th.getMoviePoster());
				pstmt.setDate(4, new java.sql.Date(th.getMovieDate().getTime()));
				pstmt.setString(5, th.getMovieStart());
				pstmt.setString(6, th.getMovieEnd());
				int r = pstmt.executeUpdate();
				if (r == 1) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("에러");
		}
		return false;
	}
	
	public static void main(String[] args) {
		OracleDBUtil.connectDB();
		TheatersDBManager thMgr = new TheatersDBManager();
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 0, 24);
		Date tDate = cal.getTime();
		// LinkedHashMap<?, ?> hash = thMgr.selectOneMovieStartByName("백두산", tDate);
		// LinkedHashMap<?, ?> hash = thMgr.selectOneMovieStartByName("백두산", tDate);
		// System.out.println(thMgr.selectScNameInfo("1관", tDate));
		OracleDBUtil.closeDB();
	}
	
}
