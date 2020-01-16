package movie.mypage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import movie.like.BookMarkFrame;
import movie.seat.SeatFrame;
import movie.ticket.TicketInfoFrame;
import ui.movieMain.MovieMainFrame;

import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class MyPageFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageFrame frame = new MyPageFrame();
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
	public MyPageFrame() {
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
		lblTitle.setFont(new Font("±¼¸²", Font.BOLD, 35));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 51, 51));
		panel_3.setBounds(0, 99, 223, 472);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
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
		lblMVInfoP.setBounds(12, 21, 199, 30);
		panel_3.add(lblMVInfoP);
		lblMVInfoP.setFont(new Font("±¼¸²", Font.ITALIC, 25));
		lblMVInfoP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("±¼¸²", Font.ITALIC, 25));
		label.setBounds(5, 71, 213, 47);
		panel_3.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 994, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(223, 0, 770, 100);
		panel.add(panel_2);
		panel_2.setBackground(new Color(255, 127, 80));
		panel_2.setLayout(null);
		
		JLabel lblMP = new JLabel("\uB9C8 \uC774 \uD398 \uC774 \uC9C0");
		lblMP.setBounds(289, 21, 194, 41);
		panel_2.add(lblMP);
		lblMP.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblMP.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(223, 99, 770, 472);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblTicketInfo = new JLabel("\uC608\uB9E4 \uC815\uBCF4");
		lblTicketInfo.setBounds(80, 180, 135, 76);
		panel_5.add(lblTicketInfo);
		lblTicketInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketInfo.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		
		JLabel lblSeatSet = new JLabel("\uC88C\uC11D \uC124\uC815");
		lblSeatSet.setBounds(290, 180, 135, 76);
		panel_5.add(lblSeatSet);
		lblSeatSet.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeatSet.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		
		JLabel lblBookMark = new JLabel("\uC88B\uC544\uC694 \uD55C \uC601\uD654");
		lblBookMark.setBounds(482, 160, 223, 118);
		panel_5.add(lblBookMark);
		lblBookMark.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookMark.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		lblBookMark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblBookMark.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBookMark.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ºü¸¥ ¿¹¸Å ÁÂ¼® ¼±ÅÃ");
				BookMarkFrame bk = 
						new BookMarkFrame();
				bk.setVisible(true);	
			}
		});
		lblSeatSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblSeatSet.setForeground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSeatSet.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ºü¸¥ ¿¹¸Å ÁÂ¼® ¼±ÅÃ");
				SeatFrame seatSet = 
						new SeatFrame();
				seatSet.setVisible(true);	
			}
		});
		lblTicketInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblTicketInfo.setForeground(Color.cyan);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTicketInfo.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("¿¹¸Å Á¤º¸ È®ÀÎ");
				TicketInfoFrame tkInfo = 
						new TicketInfoFrame();
				tkInfo.setVisible(true);	
			}
		});
	}
}
