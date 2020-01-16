package ui.movieMain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MovieList.Info;
import a.a.a.j;
import data.Member;
import data.MovieInfo;
import db.dao.MemberDBManager;
import db.dao.MovieDBManager;
import db.util.OracleDBUtil;
import movie.mypage.MyPageFrame;
import ui.admin.Admin;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MovieMainFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cardMgr;
	private static MovieDBManager mMgr;
	public static ArrayList<MovieInfo> mf;
	public static ArrayList<MovieInfo> TOP3mf;
	private CardLayout cardMgr2;
	private ImageIcon Icon;
	// public static ArrayList<JLabel> movieLabelList;
	public static ArrayList<JLabel> movieTOPList;
	JPanel PotoList1;
	JPanel PotoList2;
	JPanel PotoList3;
	JPanel PotoList4;
	JPanel pnCardMovie;
	JPanel pnMovie;
	JLabel movPoto1;
	JLabel movPoto2;
	JLabel movPoto3;
	private String[] movieR;
	MovieInfo mv;
	private int random;
	private JLabel lblMyPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OracleDBUtil.connectDB();
					MovieMainFrame frame = new MovieMainFrame();
					frame.setVisible(true);
//					OracleDBUtil.connectDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		OracleDBUtil.closeDB();
	}
//
//	/**
//	 * Create the frame.
//	 */

	// 트레일러
	public JLabel MovieTrailer(JLabel jl, int random) {
		for (int i = random; i < mf.size(); i++) {
			
				String strURL = mf.get(random).getMoviePoster();
				URL url;
				try {
					url = new URL(strURL);
					Image image = ImageIO.read(url);
					Image changedImg = image.getScaledInstance(350, 500, Image.SCALE_SMOOTH);
					Icon = new ImageIcon(changedImg);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jl = new JLabel(Icon);
			}
		return jl;
	}
	// 동적으로 구현된 공통 핸들러
	public class MovieSelectHandle extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel movMenu = (JLabel) e.getSource();
			for (int i = 0; i < TOP3mf.size(); i++) {
				JLabel mov = movieTOPList.get(i);
				if (movMenu == mov) {
					MovieInfo selMovie = TOP3mf.get(i);
					MoviePosterInfo t1 = new MoviePosterInfo(selMovie);
					t1.setVisible(true);
					t1.setSize(810, 635);
					break;
				}
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel cfMenu = (JLabel) e.getSource();
			cfMenu.setBackground(Color.CYAN);
//				super.mouseEntered(e);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel cfMenu = (JLabel) e.getSource();
			cfMenu.setBackground(Color.YELLOW);
//				super.mouseExited(e);
		}
	}

	//
	//
	public MovieMainFrame() {
//		OracleDBUtil.connectDB();
		setResizable(false);
		setTitle("\uB098\uBA3C\uC800\uC608\uB9E4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel paWest = new JPanel();
		contentPane.add(paWest, BorderLayout.WEST);
		paWest.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		paWest.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		// TODO 라디오 버튼
		JPanel pnMovieTrailer = new JPanel();
		pnMovieTrailer.setBackground(Color.BLACK);
		panel.add(pnMovieTrailer, BorderLayout.CENTER);
		
		JLabel lblMovieTrailer = new JLabel("MovieTrailer");
		lblMovieTrailer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					mv = mf.get(random);
				Runtime runtime = Runtime.getRuntime();
				String URL = mv.getMovieTrailer();
				try {
					// https://www.youtube.com/watch_popup?v=eSEs4B4H-EA
					for (int i = 0; i < mf.size(); i++) {
						if (mv.getMovieNo() == i + 1)
							runtime.exec("C:/Program Files/Internet Explorer/iexplore.exe " + URL);
					}
				} catch (IOException ex) {
					System.out.println("주소가 없거나 올바르지 않습니다.");
				}
			}
		});
		lblMovieTrailer.setForeground(Color.WHITE);
		lblMovieTrailer.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		pnMovieTrailer.add(lblMovieTrailer);
		//
		JButton btnWest = new JButton("\u25C0");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardMgr.previous(pnMovie);
			}
		});
		btnWest.setForeground(Color.WHITE);
		btnWest.setBackground(Color.BLACK);
		btnWest.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnWest.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnWest.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		panel.add(btnWest, BorderLayout.WEST);

		JButton btnEast = new JButton("\u25B6");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardMgr.next(pnMovie);
			}
		});
		btnEast.setBackground(Color.BLACK);
		btnEast.setForeground(Color.WHITE);
		btnEast.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnEast.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnEast.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		panel.add(btnEast, BorderLayout.EAST);
		JPanel pnMovieTitle = new JPanel();
		pnMovieTitle.setBackground(Color.BLACK);
		FlowLayout fl_pnMovieTitle = (FlowLayout) pnMovieTitle.getLayout();
		fl_pnMovieTitle.setHgap(140);
		fl_pnMovieTitle.setAlignment(FlowLayout.LEFT);
		paWest.add(pnMovieTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("Movie");
		lblTitle.setFont(new Font("휴먼엑스포", Font.BOLD, 20));
		lblTitle.setForeground(Color.WHITE);
		pnMovieTitle.add(lblTitle);
		// TODO 영화 카드레이아웃
		mMgr = new MovieDBManager();
		mf = mMgr.movieTitle_selectAll();
		movieTOPList = new ArrayList<JLabel>();

		pnMovie = new JPanel();
		paWest.add(pnMovie, BorderLayout.CENTER);
		cardMgr = new CardLayout(0, 0);
		pnMovie.setLayout(cardMgr);
		//TODO 랜덤으로 카드 뽑기
		random = (int) (Math.random() * 10);

		movPoto1 = new JLabel();
		movPoto2 = new JLabel();
		movPoto3 = new JLabel();
		
		//if(random1 != random2 && random1 != random3)	
		pnMovie.add(MovieTrailer(movPoto1, random), "1");
		
		//if(random2 != random1 && random2 != random3)
		pnMovie.add(MovieTrailer(movPoto2, random), "2");
		
		//if(random3 != random1 && random3 != random2)
		pnMovie.add(MovieTrailer(movPoto3, random), "3");
		
		//
		JPanel paEast = new JPanel();
		contentPane.add(paEast, BorderLayout.CENTER);
		paEast.setLayout(new BorderLayout(301, 0));

		JPanel pnMovieInfo = new JPanel();
		paEast.add(pnMovieInfo, BorderLayout.NORTH);
		pnMovieInfo.setLayout(new BorderLayout(0, 0));

		JPanel pnInfo = new JPanel();
		pnMovieInfo.add(pnInfo, BorderLayout.NORTH);
		pnInfo.setLayout(new BorderLayout(0, 0));

		JPanel pnInfoTitle = new JPanel();
		pnInfoTitle.setBackground(Color.BLACK);
		pnInfo.add(pnInfoTitle, BorderLayout.NORTH);
		pnInfoTitle.setLayout(new BorderLayout(0, 0));

		JPanel pnMyPageLogout = new JPanel();
		pnMyPageLogout.setBackground(Color.BLACK);
		pnInfoTitle.add(pnMyPageLogout, BorderLayout.WEST);
		MemberDBManager mbMgr = new MemberDBManager();
		ArrayList<Member> mbA = mbMgr.selectAllMember();
		Member mb = mbA.get(0);
		
		//int dexNum;
		//if(mb.getMemberID() != "admin") {
		lblMyPage = new JLabel("MyPage");
		//dexNum = 0;
		//} else {
		//lblMyPage = new JLabel("admin");
		//dexNum = 1;
		//}
		lblMyPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//if(dexNum == 0) {
				MyPageFrame mpf = new MyPageFrame();
				mpf.setSize(1000, 600);
				mpf.setVisible(true);
				//} else if(dexNum == 1) {
					//Admin ad = new Admin();
					//ad.setSize(500, 400);
					//ad.setVisible(true);
				//}
			}
		});
		lblMyPage.setForeground(Color.WHITE);
		lblMyPage.setFont(new Font("휴먼엑스포", Font.BOLD, 20));
		pnMyPageLogout.add(lblMyPage);

		JLabel lblNewLabel_3 = new JLabel(" ");
		pnMyPageLogout.add(lblNewLabel_3);

		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("휴먼엑스포", Font.BOLD, 20));
		pnMyPageLogout.add(lblLogout);

		JLabel lblTiketing = new JLabel("\uBE60\uB978\uC608\uB9E4 ");
		lblTiketing.setBackground(Color.DARK_GRAY);
		lblTiketing.setForeground(Color.WHITE);
		lblTiketing.setFont(new Font("휴먼엑스포", Font.BOLD, 20));
		pnInfoTitle.add(lblTiketing, BorderLayout.EAST);

		JPanel pnWestButton = new JPanel();
		pnWestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cardMgr2.previous(pnCardMovie);
			}
		});
		pnWestButton.setBackground(Color.BLACK);
		FlowLayout flowLayout_1 = (FlowLayout) pnWestButton.getLayout();
		flowLayout_1.setVgap(120);
		pnInfo.add(pnWestButton, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("\u25C0");
		lblNewLabel.setForeground(Color.WHITE);
		pnWestButton.add(lblNewLabel);

		JPanel pnEastButton = new JPanel();
		pnEastButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardMgr2.next(pnCardMovie);
			}
		});
		pnEastButton.setBackground(Color.BLACK);
		FlowLayout fl_pnEastButton = (FlowLayout) pnEastButton.getLayout();
		fl_pnEastButton.setVgap(120);
		pnInfo.add(pnEastButton, BorderLayout.EAST);

		JLabel lblNewLabel_1 = new JLabel("\u25B6");
		lblNewLabel_1.setForeground(Color.WHITE);
		pnEastButton.add(lblNewLabel_1);
		// TODO pnCardMovie
		pnCardMovie = new JPanel();
		pnInfo.add(pnCardMovie, BorderLayout.CENTER);
		cardMgr2 = new CardLayout(0, 0);
		pnCardMovie.setLayout(cardMgr2);
		//
		PotoList1 = new JPanel();
		pnCardMovie.add(PotoList1, "card1");
		PotoList1.setLayout(new GridLayout(0, 3, 0, 0));
		//
		PotoList2 = new JPanel();
		pnCardMovie.add(PotoList2, "card2");
		PotoList2.setLayout(new GridLayout(0, 3, 0, 0));
		//
		PotoList3 = new JPanel();
		pnCardMovie.add(PotoList3, "card3");
		PotoList3.setLayout(new GridLayout(0, 3, 0, 0));
		//
		PotoList4 = new JPanel();
		pnCardMovie.add(PotoList4, "card4");
		PotoList4.setLayout(new GridLayout(0, 3, 0, 0));
		//
		JPanel potoPanels[] = { PotoList1, PotoList2, PotoList3, PotoList4 };
		//
		for (int i = 0; i < mf.size(); i++) {
			if (i < 3) {
				MovieInfo mov = mf.get(i);
				Info info = new Info(mov);
				potoPanels[0].add(String.valueOf("card" + mf.get(i)), info);
			} else if (i < 6) {
				MovieInfo mov = mf.get(i);
				Info info = new Info(mov);
				potoPanels[1].add(String.valueOf("card" + mf.get(i)), info);
			} else if (i < 9) {
				MovieInfo mov = mf.get(i);
				Info info = new Info(mov);
				potoPanels[2].add(String.valueOf("card" + mf.get(i)), info);
			} else if (i < 12) {
				MovieInfo mov = mf.get(i);
				Info ads = new Info(mov);
				potoPanels[3].add(String.valueOf("card" + mf.get(i)), ads);
			}
		}
		//
		JPanel pnTOP_INFO = new JPanel();
		paEast.add(pnTOP_INFO, BorderLayout.CENTER);
		pnTOP_INFO.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(2);
		panel_2.setBackground(Color.BLACK);
		pnTOP_INFO.add(panel_2, BorderLayout.WEST);

		JPanel pnTOP = new JPanel();
		pnTOP_INFO.add(pnTOP, BorderLayout.CENTER);
		pnTOP.setLayout(new BorderLayout(0, 0));

		JPanel pnTOP3_Title = new JPanel();
		pnTOP3_Title.setBackground(Color.BLACK);
		FlowLayout fl_pnTOP3_Title = (FlowLayout) pnTOP3_Title.getLayout();
		fl_pnTOP3_Title.setAlignment(FlowLayout.LEFT);
		pnTOP.add(pnTOP3_Title, BorderLayout.NORTH);

		JLabel lblTOP3Title = new JLabel("\uC608\uB9E4 TOP3");
		pnTOP3_Title.add(lblTOP3Title);
		lblTOP3Title.setForeground(Color.WHITE);
		lblTOP3Title.setFont(new Font("휴먼엑스포", Font.BOLD, 20));

		JPanel pnMovieTOP3 = new JPanel();
		pnTOP.add(pnMovieTOP3, BorderLayout.CENTER);
		pnMovieTOP3.setLayout(new GridLayout(0, 3, 0, 0));
		//
		// TODO 평점 순 이미지
		TOP3mf = mMgr.movie_selectMovieRating();
		movieR = mMgr.movie_selectMovieTop3Rating();
		JLabel lblTOP1 = new JLabel();
		JLabel lblTOP2 = new JLabel();
		JLabel lblTOP3 = new JLabel();
		JLabel[] lblTOPS = { lblTOP1, lblTOP2, lblTOP3 };
		MovieSelectHandle movSelectHandle = new MovieSelectHandle();
		for (int i = 0; i < lblTOPS.length; i++) {
			String strURL = movieR[i];
			URL url;
			try {
				url = new URL(strURL);
				Image image = ImageIO.read(url);
				Image changedImg = image.getScaledInstance(250, 230, Image.SCALE_FAST);
				Icon = new ImageIcon(changedImg);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// JLabel lblTOP1 = new JLabel(Icon);

			lblTOPS[i] = new JLabel(Icon);
			lblTOPS[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblTOPS[i].setToolTipText("클릭시 예매 및 상세보기");
			pnMovieTOP3.add(lblTOPS[i]);
			movieTOPList.add(lblTOPS[i]);
			lblTOPS[i].addMouseListener(movSelectHandle);
		}
		OracleDBUtil.closeDB();
	}
	
}
