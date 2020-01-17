package ui.movieMain;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Member;
import data.MovieInfo;
import data.MovieRank;
import db.dao.MemberDBManager;
import db.dao.MovieRankDBManager;
import login.loginpop;
import mypage.MyPageFrame;
import ui.ticketing.MovieTicketing;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.JDialog;
import javax.imageio.ImageIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTabbedPane;

public class MoviePosterInfo extends JDialog implements ActionListener {
	MoviePosterInfo dlg;
	ImageIcon imgIconList[], Icon;
	File folder;
	private JPanel contentPane;
	private JPanel panel_27;
	private JPanel panel_26;
	private JLabel lblPotoList;
	private JTextField txtComments;
	private JPanel panel_31;
	private JButton btnPotoLeft;
	private JButton btnPotoRight;
	private JTextArea txtAreaComments;
	public CardLayout cardMgr;

	int l, l1;

	private final static String newline = "\n";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private JLabel movPoter;
	private JTable table;

//	public void showMovie(int sel) {
//		cardMgr.show(movPoter, "mov" + sel);
//	}

	public MoviePosterInfo(MovieInfo mv) {
		setTitle("\uB098\uBA3C\uC800\uC608\uB9E4");

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 150, 828, 635);
		//
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		int num = 0;

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_1.add(panel_6, BorderLayout.EAST);

		JButton btnMyPage = new JButton("MyPage");
		btnMyPage.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnMyPage.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnMyPage.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnMyPage.setBackground(Color.BLACK);
		btnMyPage.setForeground(Color.WHITE);
		btnMyPage.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		btnMyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "MyPage로 이동합니다");
				MyPageFrame mpf = new MyPageFrame();
				mpf.setSize(1000, 600);
				mpf.setVisible(true);
			}
		});
		panel_6.add(btnMyPage);

		JButton btnHome = new JButton("Home");
		btnHome.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnHome.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnHome.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnHome.setBackground(Color.BLACK);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_6.add(btnHome);

		JLabel lblNewLabel = new JLabel("");
		panel_6.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_1.add(panel_4, BorderLayout.WEST);
		JButton btnTicketing = new JButton("\uC608\uB9E4\uD558\uAE30");
		btnTicketing.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnTicketing.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnTicketing.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnTicketing.setBackground(Color.BLACK);
		btnTicketing.setForeground(Color.WHITE);
		btnTicketing.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		btnTicketing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(contentPane, "예매 하시겠습니까?", "메시지",
						JOptionPane.OK_CANCEL_OPTION, 1);

				if (result == JOptionPane.OK_OPTION) {
					// TODO 예매 페이지로 이동
					JOptionPane.showMessageDialog(contentPane, "예매 페이지로 이동합니다");
					if (num == 0) {
						MovieTicketing Mt = new MovieTicketing();
						System.out.println(mv.getMovieTitle());
						Mt.setVisible(true);
						Mt.setJlistValue(mv.getMovieTitle());
					}
				} else if (result == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(contentPane, "취소하였습니다");
					// 예매 페이지로 이동하겠습니다
				}
			}
		});

		JLabel lblNewLabel_4 = new JLabel("");
		panel_4.add(lblNewLabel_4);
		panel_4.add(btnTicketing);

		JButton btnQickTicketing = new JButton("\uBE60\uB978\uC608\uB9E4");
		btnQickTicketing.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnQickTicketing.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnQickTicketing.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnQickTicketing.setBackground(Color.BLACK);
		btnQickTicketing.setForeground(Color.WHITE);
		btnQickTicketing.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		btnQickTicketing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				int result = JOptionPane.showConfirmDialog(contentPane, "예매를 확인하시겠습니까?", "예매하였습니다",
				int result = JOptionPane.showConfirmDialog(contentPane, "빠른예매를 하시겠습니까?", "메시지",
						JOptionPane.OK_CANCEL_OPTION, 1);
				if (result == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(contentPane, "빠른예매를 했습니다");
				} else if (result == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(contentPane, "예매를 취소했습니다");
				}
			}
		});
		panel_4.add(btnQickTicketing);

		JButton btnFavor = new JButton("\u2661 \uC88B\uC544\uC694");
		btnFavor.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnFavor.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnFavor.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnFavor.setBackground(Color.BLACK);
		btnFavor.setForeground(Color.WHITE);
		btnFavor.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		btnFavor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(contentPane, "영화를 북마크 하시겠습니까?", "메시지",
						JOptionPane.OK_CANCEL_OPTION, 1);
				if (result == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(contentPane, "영화를 북마크했습니다");
					String login = loginpop.LOGGED_IN;
					MovieRank mr = new MovieRank(0, mv.getMovieTitle(), login, '1', null);
					MovieRankDBManager mrMgr = new MovieRankDBManager();
					mrMgr.insertMovieFavor(mr);
					
				} else if (result == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(contentPane, "북마크를 취소했습니다");
				}
			}

		});
		panel_4.add(btnFavor);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_3.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_7.add(tabbedPane, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("\uC601\uD654 \uC815\uBCF4", null, scrollPane_1, null);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		scrollPane_1.setPreferredSize(new Dimension(400, 105));
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"제목 : "+mv.getMovieTitle()},
				{"장르 : "+mv.getMovieGenre()},
				{"감독 : "+mv.getMovieDirector()},
				{"출현 : "+mv.getMovieActors()},
				{"등급 : "+mv.getMovieGrade()},
				{"시간 : "+mv.getMovieTimes()},
			},
			new String[] {
				""
			}
		));
		table.setShowVerticalLines(false); // 테이블 선 안보이게 하기
		table.setShowHorizontalLines(false); // 테이블 선 안보이게 하기
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\uC904\uAC70\uB9AC", null, panel, null);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.BLACK);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea txtrA = new JTextArea();
		txtrA.setText(mv.getMovieContent());
		panel.add(txtrA);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_10.getLayout();
		flowLayout_2.setVgap(3);
		panel_10.setBackground(Color.BLACK);
		panel_9.add(panel_10, BorderLayout.SOUTH);
		// TODO 포스터 화면
		ArrayList<MovieInfo> movlist = MovieMainFrame.mf;
		for (int i = 0; i < movlist.size(); i++) {
			MovieInfo mf = movlist.get(i);
			if (mv.getMovieNo() == i + 1)
				if (i < 4) {
					String strURL = mf.getMoviePoster();
					URL url;
					try {
						url = new URL(strURL);
						Image image = ImageIO.read(url);
						Image changedImg = image.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
						Icon = new ImageIcon(changedImg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (i < 8) {
					String strURL = mf.getMoviePoster();
					URL url;
					try {
						url = new URL(strURL);
						Image image = ImageIO.read(url);
						Image changedImg = image.getScaledInstance(350, 450, Image.SCALE_FAST);
						Icon = new ImageIcon(changedImg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (i < 12) {
					String strURL = mf.getMoviePoster();
					URL url;
					try {
						url = new URL(strURL);
						Image image = ImageIO.read(url);
						Image changedImg = image.getScaledInstance(350, 450, Image.SCALE_FAST);
						Icon = new ImageIcon(changedImg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}
		movPoter = new JLabel(Icon);
		
		panel_9.add(movPoter, BorderLayout.WEST);
		cardMgr = new CardLayout(140, 0);
		// movPoter.setLayout(cardMgr);
		//
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));

		JPanel panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));

		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_12.getLayout();
		flowLayout.setHgap(3);
		panel_12.setBackground(Color.BLACK);
		panel_13.add(panel_12, BorderLayout.WEST);

		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));

		JPanel panel_15 = new JPanel();
		panel_14.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(new BorderLayout(0, 0));

		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.BLACK);
		FlowLayout flowLayout_4 = (FlowLayout) panel_18.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_16.add(panel_18, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("\uD3EC\uD1A0");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		panel_18.add(lblNewLabel_1);

		JPanel panel_19 = new JPanel();
		panel_16.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel();
		panel_19.add(panel_17, BorderLayout.SOUTH);
		panel_17.setLayout(new BorderLayout(0, 0));

		txtComments = new JTextField();
		txtComments.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		txtComments.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtComments.setForeground(Color.BLACK);
				String guide = "댓글 입력해주세요...";
				String mbField = txtComments.getText();
				if (guide.equals(mbField))
					txtComments.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				String guide = "댓글 입력해주세요...";
				String mbField = txtComments.getText();
				if (mbField.isEmpty()) {
					txtComments.setText(guide);
					txtComments.setForeground(Color.LIGHT_GRAY);
				} else if (guide.equals(guide))
					txtComments.setForeground(Color.LIGHT_GRAY);
			}
		});
		txtComments.setText("\uB313\uAE00 \uC785\uB825\uD574\uC8FC\uC138\uC694...");
		txtComments.setForeground(Color.LIGHT_GRAY);
		txtComments.setHorizontalAlignment(SwingConstants.LEFT);
		panel_17.add(txtComments, BorderLayout.CENTER);
		txtComments.setColumns(30);

		JButton btnComments = new JButton("\uD55C\uC904\uD3C9\uC4F0\uAE30");
		btnComments.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnComments.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnComments.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnComments.setBackground(Color.BLACK);
		btnComments.setForeground(Color.WHITE);
		btnComments.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		btnComments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnComments)) {
					String text = txtComments.getText(); //DB받음	
					SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
					Date time = new Date();
					String time1 = format1.format(time);
					MemberDBManager mbMgr = new MemberDBManager();
					loginpop loginIdPw = new loginpop();
					String login = loginIdPw.LOGGED_IN;
					String pw = loginIdPw.resPW;
					
					Member mb = mbMgr.selectOneMember(login, pw);
					String Id = mb.getMemberID();
					String comments = Id+"님의 댓글 " + text +" "+ time1 + newline;
					// commentsDB에 저장
					txtAreaComments.append(comments);	
					txtComments.selectAll();
					txtAreaComments.setCaretPosition(txtAreaComments.getDocument().getLength());
				}
				txtComments.setText("댓글 입력해주세요...");
				txtComments.setForeground(Color.LIGHT_GRAY);
			}

		});
		panel_17.add(btnComments, BorderLayout.EAST);

		JPanel panel_20 = new JPanel();
		panel_19.add(panel_20, BorderLayout.CENTER);
		panel_20.setLayout(new BorderLayout(0, 0));

		JPanel panel_21 = new JPanel();
		panel_20.add(panel_21, BorderLayout.SOUTH);
		panel_21.setLayout(new GridLayout(1, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_21.add(scrollPane);

		txtAreaComments = new JTextArea();
		txtAreaComments.setFont(new Font("휴먼엑스포", Font.BOLD, 15));
		txtAreaComments.setEditable(false);
		txtAreaComments.setRows(4);
		scrollPane.setViewportView(txtAreaComments);

		JPanel panel_22 = new JPanel();
		panel_20.add(panel_22, BorderLayout.CENTER);
		panel_22.setLayout(new BorderLayout(0, 0));

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout_3 = (FlowLayout) panel_23.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_22.add(panel_23, BorderLayout.SOUTH);

		JLabel lblComments = new JLabel("\uD55C\uC904\uD3C9");
		lblComments.setForeground(Color.WHITE);
		lblComments.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		panel_23.add(lblComments);

		JPanel panel_24 = new JPanel();
		panel_22.add(panel_24, BorderLayout.CENTER);
		panel_24.setLayout(new BorderLayout(0, 0));

		JPanel panel_28 = new JPanel();
		panel_24.add(panel_28, BorderLayout.CENTER);
		panel_28.setLayout(new BorderLayout(0, 0));

		panel_26 = new JPanel();
		panel_28.add(panel_26, BorderLayout.CENTER);
		panel_26.setLayout(new BorderLayout(0, 0));

		panel_27 = new JPanel();
		panel_27.setBackground(Color.BLACK);
		panel_26.add(panel_27, BorderLayout.SOUTH);
		panel_27.setLayout(new BorderLayout(0, 0));

		JPanel panel_25 = new JPanel();
		panel_25.setBackground(Color.BLACK);
		panel_27.add(panel_25, BorderLayout.WEST);
		// 버튼 이벤트
		btnPotoLeft = new JButton("\u25C0");
		btnPotoLeft.setBackground(Color.BLACK);
		btnPotoLeft.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnPotoLeft.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnPotoLeft.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnPotoLeft.setForeground(Color.WHITE);

		panel_25.add(btnPotoLeft);
		btnPotoRight = new JButton("\u25B6");
		btnPotoRight.setBackground(Color.BLACK);
		btnPotoRight.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnPotoRight.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnPotoRight.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnPotoRight.setForeground(Color.WHITE);
		panel_25.add(btnPotoRight);

		JPanel panel_30 = new JPanel();
		panel_30.setBackground(Color.BLACK);
		panel_27.add(panel_30, BorderLayout.EAST);

		// TODO 동영상
		JButton btnMovieLink = new JButton("\uC608\uACE0\uD3B8 \uB3D9\uC601\uC0C1 \uB9C1\uD06C");
		btnMovieLink.setBackground(Color.BLACK);
		btnMovieLink.setBorderPainted(false); // 버튼 외각선을 없애준다.
		btnMovieLink.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnMovieLink.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		btnMovieLink.setForeground(Color.WHITE);
		panel_30.add(btnMovieLink);
		btnMovieLink.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		btnMovieLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();
				String URL = mv.getMovieTrailer();
				try {
					// https://www.youtube.com/watch_popup?v=eSEs4B4H-EA
					for (int i = 0; i < movlist.size(); i++) {
						if (mv.getMovieNo() == i + 1)
							runtime.exec("C:/Program Files/Internet Explorer/iexplore.exe " + URL);
					}
				} catch (IOException ex) {
					System.out.println("주소가 없거나 올바르지 않습니다.");
				}
			}
		});
		btnPotoRight.addActionListener(this);
		btnPotoLeft.addActionListener(this);

		JPanel panel_32 = new JPanel();
		panel_26.add(panel_32, BorderLayout.CENTER);
		panel_32.setLayout(new BorderLayout(0, 0));
		JPanel poto = new JPanel();
		panel_32.add(poto, BorderLayout.CENTER);
		poto.setLayout(new BorderLayout(0, 0));
		//
		
		// 포토존
		panel_31 = new JPanel();
		poto.add(panel_31, BorderLayout.CENTER);
		panel_31.setLayout(new BorderLayout(0, 0));
		// System.out.println(movlist);
		for (int j = 0; j < movlist.size(); j++) {
			// System.out.println(i);
			int index = j + 1;
			String file[] = { "./image/MoviePosters/MoviePoster" + index };
			// System.out.println(file[i]);
			if (mv.getMovieNo() == j + 1)
				folder = new File(file[0]);
			// System.out.println(folder);
		}
		ArrayList<String> imgList = new ArrayList<>();
		int count = 0;
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
			} else {
				imgList.add(String.valueOf(fileEntry));
				count++;
			}
		}
		imgIconList = new ImageIcon[count];
		for (int k = 0; k < imgIconList.length; k++) {
			imgIconList[k] = new ImageIcon(imgList.get(k));
		}

		for (int q = 0; q < imgIconList.length; q++) {
			Image tempImg = imgIconList[q].getImage();
			Image changeImg = tempImg.getScaledInstance(485, 225, Image.SCALE_FAST);
			imgIconList[q] = new ImageIcon(changeImg);
		}

		lblPotoList = new JLabel("", JLabel.CENTER);
		panel_31.add(lblPotoList, BorderLayout.CENTER);
		lblPotoList.setIcon(imgIconList[0]);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPotoLeft) {
			if (l == 0) {
				JOptionPane.showMessageDialog(lblPotoList, "처음 이미지 입니다");
			} else {
				l = l - 1;
				lblPotoList.setIcon(imgIconList[l]);
			}
		}

		if (e.getSource() == btnPotoRight) {
			if (l == imgIconList.length - 1) {
				JOptionPane.showMessageDialog(lblPotoList, "마지막 이미지 입니다");
			} else {
				l = l + 1;
				lblPotoList.setIcon(imgIconList[l]);
			}
		}
	}
}
