package movie.like;

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

import movie.mypage.ImagePanel;
import movie.mypage.MyPageFrame;
import ui.movieMain.MovieMainFrame;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;

public class BookMarkFrame extends JFrame {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblTitle.setFont(new Font("����", Font.BOLD, 35));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblmyPage = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		lblmyPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("������������");
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
		lblmyPage.setFont(new Font("����", Font.ITALIC, 25));
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
				MovieMainFrame mf2 = new MovieMainFrame();
				mf2.setSize(1000, 600);
				mf2.setVisible(true);
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
		lblMVInfoP.setFont(new Font("����", Font.ITALIC, 25));
		lblMVInfoP.setBounds(12, 21, 199, 30);
		panel_3.add(lblMVInfoP);
		
		JLabel label_2 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("����", Font.ITALIC, 25));
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
		lblMP.setFont(new Font("���� ���", Font.BOLD, 30));
		lblMP.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
//		JPanel like1 = new JPanel();
		ImageIcon frozen = new ImageIcon("./images/poster/�ܿ�ձ�2.jpg");

		ImagePanel like1 = new ImagePanel(frozen.getImage(), "�ܿ�ձ�2.jpg");
		like1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("���콺Ŭ��");
			}
		});

		like1.setBounds(285, 223, 150, 215);
		like1.setBorder(new EmptyBorder(5, 5, 5, 5));
		like1.setLayout(new BorderLayout(0, 0));
		panel.add(like1);
		//like1.setLayout(null);
		
	//	JPanel like2 = new JPanel();
		
		ImageIcon ctDown = new ImageIcon("./images/poster/ī��Ʈ�ٿ�.jpg");
	//	contentPaneIg = new ImagePanel(ctDown.getImage(), "ī��Ʈ�ٿ�.PNG");
		ImagePanel like2 = new ImagePanel(ctDown.getImage(), "ī��Ʈ�ٿ�.jpg");
		
		like2.setBounds(518, 225, 150, 213);
		like2.setBorder(new EmptyBorder(5, 5, 5, 5));
		like2.setLayout(new BorderLayout(0, 0));
		panel.add(like2);
		//like2.setLayout(null);
		
		ImageIcon ford = new ImageIcon("./images/poster/����v���.jpg");
		
		ImagePanel like3 = new ImagePanel(ford.getImage(), "����v���.jpg");
		
		like3.setBounds(754, 223, 150, 214);
		like3.setBorder(new EmptyBorder(5, 5, 5, 5));
		like3.setLayout(new BorderLayout(0, 0));
		panel.add(like3);
		
		
		JLabel lblLike = new JLabel("\uC88B\uC544\uC694");
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setFont(new Font("����", Font.PLAIN, 18));
		lblLike.setBounds(285, 170, 68, 21);
		panel.add(lblLike);
	}
}
