package mypage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import data.Reserve1;
import db.dao.ReserveDBMgr;
import db.util.OracleDBUtil;
import db.util.OracleDBUtil1;
import login.loginpop;
import main.MainPage;
import mypage.ImagePanel;
import mypage.MyPageFrame;
import ui.movieMain.MovieMainFrame;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
		lblMVInfoP.setFont(new Font("����", Font.ITALIC, 25));
		lblMVInfoP.setBounds(12, 21, 199, 30);
		panel_3.add(lblMVInfoP);
		
		JLabel lblLogout = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginpop.LOGGED_IN= null;
				JOptionPane.showMessageDialog( null, "�α� �ƿ� �Ǿ����ϴ�");
				dispose();
				MainPage mp = new MainPage();
				mp.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogout.setForeground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogout.setForeground(Color.black);
			}
		});
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("����", Font.ITALIC, 25));
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
		lblMP.setFont(new Font("���� ���", Font.BOLD, 30));
		lblMP.setHorizontalAlignment(SwingConstants.CENTER);
		
		//JPanel panel_5 = new JPanel();
		ImageIcon ticket = new ImageIcon("./images/Ƽ�� ����.jpg");
		
		ImagePanel ticketImg = new ImagePanel(ticket.getImage(), "Ƽ�� ����.jpg");
		ticketImg.setBounds(233, 110, 749, 451);
		panel.add(ticketImg);
		ticketImg.setLayout(null);
		
		JLabel lblMvTitle = new JLabel("New label");
		lblMvTitle.setFont(new Font("����", Font.PLAIN, 30));
		lblMvTitle.setBounds(102, 38, 486, 87);
		ticketImg.add(lblMvTitle);
		
		JLabel lblReveNum = new JLabel("New label");
		lblReveNum.setFont(new Font("����", Font.PLAIN, 20));
		lblReveNum.setBounds(102, 165, 239, 39);
		ticketImg.add(lblReveNum);
		
		JLabel lblMvDate = new JLabel("New label");
		lblMvDate.setFont(new Font("����", Font.PLAIN, 20));
		lblMvDate.setBounds(102, 220, 239, 39);
		ticketImg.add(lblMvDate);
		
		JLabel lblScrNum = new JLabel("New label");
		lblScrNum.setFont(new Font("����", Font.PLAIN, 20));
		lblScrNum.setBounds(397, 165, 191, 39);
		ticketImg.add(lblScrNum);
		
		JLabel lblSeatNum = new JLabel("New label");
		lblSeatNum.setFont(new Font("����", Font.PLAIN, 20));
		lblSeatNum.setBounds(397, 210, 191, 50);
		ticketImg.add(lblSeatNum);
		
		JLabel lblMemID = new JLabel("New label");
		lblMemID.setFont(new Font("����", Font.PLAIN, 20));
		lblMemID.setBounds(102, 281, 239, 63);
		ticketImg.add(lblMemID);
		
		JLabel lblPayMoney = new JLabel("New label");
		lblPayMoney.setFont(new Font("����", Font.PLAIN, 20));
		lblPayMoney.setBounds(102, 368, 239, 58);
		ticketImg.add(lblPayMoney);
		
		JLabel lblStartT = new JLabel("New label");
		lblStartT.setFont(new Font("����", Font.PLAIN, 16));
		lblStartT.setBounds(397, 288, 191, 50);
		ticketImg.add(lblStartT);
		
		JLabel lblEndT = new JLabel("New label");
		lblEndT.setFont(new Font("����", Font.PLAIN, 16));
		lblEndT.setBounds(397, 367, 191, 63);
		ticketImg.add(lblEndT);
		
		ReserveDBMgr rvMgr = new ReserveDBMgr();
		//fff = rvMgr.selectSeat();
		
		ArrayList<Reserve1> rvList = rvMgr.reveResult(loginpop.LOGGED_IN);

//		for (Reserve1 reserve1 : rvList) {
//			System.out.println(reserve1.toString());
//		}
		for (int i = 0; i < rvList.size(); i++) {
			Reserve1 reserve1 = rvList.get(i);
			System.out.println(reserve1.toString());
			
		}
		if (rvList.size() != 0) {
		Reserve1 test1 = rvList.get(0);
			lblMvTitle.setText("��ȭ����: " + test1.getMovieTitle());
			lblReveNum.setText("���Ź�ȣ: " + (String.valueOf(test1.getReserveNo())));
			lblMvDate.setText("�󿵳�¥: " + (String.valueOf(test1.getMovieDate())));
			lblScrNum.setText("�󿵰�: " + (String.valueOf(test1.getScreenNo())) + "��");
			lblSeatNum.setText("�ο�: \r\n" + (String.valueOf(test1.getSeatNo())) + "��");
			lblMemID.setText("���̵�: " + test1.getMemberID());
			lblPayMoney.setText("������ �ݾ�: " + (String.valueOf(test1.getReserveMoney()) + " ��"));
			lblStartT.setText("��ȭ���۽ð�: " + (String.valueOf(test1.getMovieStart())));
			lblEndT.setText("��ȭ����ð�: " + (String.valueOf(test1.getMovieEnd())));
		} else if (rvList.size() == 0) {
			lblMvTitle.setText("��ȭ����: " + "���� ����");
			lblReveNum.setText("���Ź�ȣ: " + "���� ����");
			lblMvDate.setText("�󿵳�¥: " + "���� ����");
			lblScrNum.setText("�󿵰�: " + "���� ����");
			lblSeatNum.setText("�ο�: \r\n" + "���� ����");
			lblMemID.setText("���̵�: " + "���� ����");
			lblPayMoney.setText("������ �ݾ�: " + "���� ����");
			lblStartT.setText("��ȭ���۽ð�: " + "���� ����");
			lblEndT.setText("��ȭ����ð�: " + "���� ����");
		}
	}
}
