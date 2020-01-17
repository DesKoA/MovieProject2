package mypage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import MovieList.Info;
import data.MovieInfo;
import data.MovieRank;
import db.dao.MovieDBManager;
import db.dao.MovieRankDBManager;
import mypage.ImagePanel;
import mypage.MyPageFrame;
import ui.movieMain.MovieMainFrame;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class BookMarkFrame extends JFrame {
	public static ArrayList<MovieInfo> mf;
	private JPanel contentPane;
	private ImagePanel contentPaneIg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMarkFrame frame = new BookMarkFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookMarkFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./images/movie-symbol-of-video-camera_icon-icons.com_72981.png"));
		setTitle("\uB098 \uBA3C\uC800 \uC608\uB9E4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 223, 571);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setLayout(null);
		
		JLabel lblTitle = new JLabel("\uB098 \uBA3C\uC800 \uC608\uB9E4");
		lblTitle.setBounds(5, 30, 213, 41);
		lblTitle.setForeground(new Color(255, 255, 255));
		panel_1.add(lblTitle);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 35));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblmyPage = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		lblmyPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("마이페이지로");
				MyPageFrame myPage = new MyPageFrame();
				myPage.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblmyPage.setForeground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblmyPage.setForeground(Color.black);
			}
		});
		lblmyPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblmyPage.setFont(new Font("굴림", Font.ITALIC, 25));
		lblmyPage.setBounds(5, 171, 213, 47);
		panel_1.add(lblmyPage);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 51, 51));
		panel_3.setBounds(0, 99, 223, 472);
		panel_1.add(panel_3);
		
		JLabel lblMVInfoP = new JLabel("\uC601\uD654\uC815\uBCF4 \uD398\uC774\uC9C0");
		lblMVInfoP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MovieMainFrame mmf = new MovieMainFrame();
				mmf.setSize(1000, 600);
				mmf.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMVInfoP.setForeground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMVInfoP.setForeground(Color.black);
			}
		});
		lblMVInfoP.setHorizontalAlignment(SwingConstants.CENTER);
		lblMVInfoP.setFont(new Font("굴림", Font.ITALIC, 25));
		lblMVInfoP.setBounds(12, 21, 199, 30);
		panel_3.add(lblMVInfoP);
		
		JLabel label_2 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.ITALIC, 25));
		label_2.setBounds(5, 135, 213, 47);
		panel_3.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 994, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("textHighlight"));
		panel_2.setBounds(223, 0, 770, 100);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMP = new JLabel("\uC88B\uC544\uC694 \uD55C \uC601\uD654");
		lblMP.setBounds(233, 28, 305, 41);
		lblMP.setForeground(Color.BLUE);
		panel_2.add(lblMP);
		lblMP.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblMP.setHorizontalAlignment(SwingConstants.CENTER);
		
//		JPanel panel_4 = new JPanel();
//		panel_4.setBounds(547, 0, 223, 107);
//		panel_2.add(panel_4);
//		panel_4.setLayout(null);
//		panel_4.setBackground(Color.PINK);
//		
//		JLabel label_3 = new JLabel("minmin\uB2D8");
//		label_3.setBounds(31, 0, 192, 97);
//		panel_4.add(label_3);
//		label_3.setFont(new Font("굴림", Font.PLAIN, 35));
		
//		JPanel like1 = new JPanel();
		
		MovieRankDBManager mvRank = new MovieRankDBManager();
		ArrayList<MovieRank> mvRankList = mvRank.selectAllRank();
		for (int i = 0; 1 < mvRankList.size(); i++) {
			MovieRank mvR = mvRankList.get(i);
		}
		
		
		ImageIcon frozen = new ImageIcon("./images/poster/겨울왕국2.jpg");

		ImagePanel like1 = new ImagePanel(frozen.getImage(), "겨울왕국2.jpg");
//		like1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				System.out.println("마우스클릭");
//			}
//		});

		MovieDBManager mMgr = new MovieDBManager();
		mf = mMgr.movieTitle_selectAll();
		
		
		
		like1.setBounds(285, 178, 653, 383);
		like1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(like1);
		like1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		like1.add(panel_4, "name_9119555991400");
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		for (int i = 0; i < mf.size(); i++) {
			MovieInfo mov = mf.get(i);
			Info info = new Info(mov);
			
			panel_4.add(String.valueOf("card" + mf.get(i)), info);
		}
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_4.add(lblNewLabel_2);
		//like1.setLayout(null);
		
	//	JPanel like2 = new JPanel();
		
//		ImageIcon ctDown = new ImageIcon("./images/poster/카운트다운.jpg");
//	//	contentPaneIg = new ImagePanel(ctDown.getImage(), "카운트다운.PNG");
//		ImagePanel like2 = new ImagePanel(ctDown.getImage(), "카운트다운.jpg");
//		
//		like2.setBounds(518, 225, 150, 213);
//		like2.setBorder(new EmptyBorder(5, 5, 5, 5));
//		like2.setLayout(new BorderLayout(0, 0));
//		panel.add(like2);
//		//like2.setLayout(null);
//		
//		ImageIcon ford = new ImageIcon("./images/poster/포드v페라리.jpg");
//		
//		ImagePanel like3 = new ImagePanel(ford.getImage(), "포드v페라리.jpg");
//		
//		like3.setBounds(754, 223, 150, 214);
//		like3.setBorder(new EmptyBorder(5, 5, 5, 5));
//		like3.setLayout(new BorderLayout(0, 0));
//		panel.add(like3);
		
		
		JLabel lblLike = new JLabel("\uC88B\uC544\uC694");
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setFont(new Font("굴림", Font.PLAIN, 18));
		lblLike.setBounds(285, 147, 68, 21);
		panel.add(lblLike);
	}
}
