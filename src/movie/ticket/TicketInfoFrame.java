package movie.ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import movie.db.dao.ReserveDBMgr;
import movie.db.util.OracleDBUtil;
import movie.mypage.MyPageFrame;
import ui.movieMain.MovieMainFrame;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicketInfoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OracleDBUtil.connectDB();
					TicketInfoFrame frame = new TicketInfoFrame();
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
	public TicketInfoFrame() {
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
		lblTitle.setFont(new Font("±º∏≤", Font.BOLD, 35));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblmyPage = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		lblmyPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("∏∂¿Ã∆‰¿Ã¡ˆ∑Œ");
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
		lblmyPage.setFont(new Font("±º∏≤", Font.ITALIC, 25));
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
		lblMVInfoP.setFont(new Font("±º∏≤", Font.ITALIC, 25));
		lblMVInfoP.setBounds(12, 21, 199, 30);
		panel_3.add(lblMVInfoP);
		
		JLabel lblLogout = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("±º∏≤", Font.ITALIC, 25));
		lblLogout.setBounds(5, 135, 213, 47);
		panel_3.add(lblLogout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 994, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(32, 178, 170));
		panel_2.setBounds(223, 0, 770, 100);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMP = new JLabel("\uC608\uB9E4 \uC815\uBCF4");
		lblMP.setBounds(248, 21, 273, 41);
		lblMP.setForeground(Color.CYAN);
		panel_2.add(lblMP);
		lblMP.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		lblMP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(547, 0, 223, 107);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(Color.PINK);
		
		JLabel label_2 = new JLabel("minmin\uB2D8");
		label_2.setBounds(31, 0, 192, 97);
		panel_4.add(label_2);
		label_2.setFont(new Font("±º∏≤", Font.PLAIN, 35));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(233, 110, 749, 451);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		ReserveDBMgr rvMgr = new ReserveDBMgr();
		//fff = rvMgr.selectSeat();
		rvMgr.reveResult();
	}
}
