package Join;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import data.Member;
import db.dao.MemberDBManager;
//import db.dao.MemberDBMgr;
import db.util.OracleDBUtil;
import login.loginpop;
import main.MainPage;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class join extends JFrame {

	private JPanel contentPane;
	private JTextField idEnter;
	private JPasswordField pwfirst;
	private JPasswordField pwpwField;
	private JTextField emailField;
	private BufferedImage background;
	private JPanel panel_2;
	private JLabel lblStatus;
	private JTextField phone1st;
	protected String memberID;
	protected String memberPW;
	protected String memberName;
	protected String memberEmail;
	protected java.sql.Date memberBirth;
	protected String memberPhone;
	public static OracleDBUtil db;
	private JButton OKButton;
	private JLabel label_id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					join frame = new join();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		OracleDBUtil.closeDB();
	}

	/**
	 * Create the frame.
	 */
	
	public join() {
		OracleDBUtil.connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 537);
		contentPane = new JPanel();
		//불투명
		//contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(88,105,219));//(124, 166, 150));
		panel.setBounds(0, 86, 210, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("\uCC98\uC74C\uD654\uBA74\uC73C\uB85C");
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBackground(new Color(127, 109, 242));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage main = new MainPage();
				main.setVisible(true);
			}
		});
		button.setBounds(19, 50, 133, 35);
		panel.add(button);
		
		JButton button_1 = new JButton("\uBE44\uD68C\uC6D0\uC608\uB9E4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noJoin nojoin = new noJoin();
				nojoin.setVisible(true);
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBackground(new Color(127, 109, 242));
		button_1.setBounds(19, 119, 133, 35);
		panel.add(button_1);
		
		JPanel liftTitle = new JPanel();
		liftTitle.setBackground(new Color(100, 159, 249)); //(98, 140, 150));
		liftTitle.setBounds(0, 0, 210, 86);
		contentPane.add(liftTitle);
		liftTitle.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		ImageIcon icn = new ImageIcon(
//				final String ic = 
						".\\image\\회원가입제목1.png");
						
		panel_2 = new JPanel() {
	   public void paintComponent(Graphics g) {
	    // Approach 1: Dispaly image at at full size
	    g.drawImage(icn.getImage(), 0, 0, null);
	    // Approach 2: Scale image to size of component
	    // Dimension d = getSize();
	    // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	    // Approach 3: Fix the image position in the scroll pane
	    // Point p = scrollPane.getViewport().getViewPosition();
	    // g.drawImage(icon.getImage(), p.x, p.y, null);
	    setOpaque(false);
	    super.paintComponent(g);
	   }
	  };
		
		panel_2.setBounds(294, 10, 669, 86);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel title = new JLabel("\t  \uB098        \uBA3C   \uC800        \uC608   \uB9E4");
		title.setBounds(0, 10, 500, 53);
		panel_2.add(title);
		title.setForeground(new Color(85, 71, 89));
		title.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label.setBounds(53, 22, 108, 37);
		liftTitle.add(label);
		
		
     //   File file = new File("C:\\Users\\alfo4-11\\Desktop\\1차 프로젝트\\티켓보라색.png");
		ImageIcon ic = new ImageIcon(
//		final String ic = 
				".\\image\\티켓보라색1.png");
				
				JPanel centens = new JPanel() {
			   public void paintComponent(Graphics g) {
			    // Approach 1: Dispaly image at at full size
			    g.drawImage(ic.getImage(), 0, 0, null);
			    // Approach 2: Scale image to size of component
			    // Dimension d = getSize();
			    // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
			    // Approach 3: Fix the image position in the scroll pane
			    // Point p = scrollPane.getViewport().getViewPosition();
			    // g.drawImage(icon.getImage(), p.x, p.y, null);
			    setOpaque(false);
			    super.paintComponent(g);
			   }
			  };
		
		//JPanel centens = new JPanel();
//        try {
//            background = ImageIO.read(file);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//		contentPane = new ImagePanel(ic.getImage(), 
//				"bg_cafe.jpg");
    	centens.setBounds(209, 86, 775, 392);
		contentPane.add(centens);
		centens.setLayout(null);
		
		JButton canel = new JButton("\uCDE8\uC18C\uD558\uAE30");
		canel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage main  = new MainPage();
				main.setVisible(true);
			}
		});
		
/*
 * 		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(pnMovieInfo, "Logout 하시겠습니까?", "이용해 주셔서 감사합니다.",
						JOptionPane.OK_CANCEL_OPTION, 1);

				if (result == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.CANCEL_OPTION) {
					// JOptionPane.showMessageDialog(pnMovieInfo, "취소하였습니다");
				}
			}
		});
 */
		
		JLabel id = new JLabel("\uC544\uC774\uB514");
		id.setBounds(141, 38, 140, 25);
		centens.add(id);
		id.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
				
				idEnter = new JTextField();
				idEnter.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						idEnter.setForeground(Color.BLACK);
						String guide = "아이디를 입력해주세요";
						String mbField = idEnter.getText();
						if (guide.equals(mbField))
							idEnter.setText("");
					}
					@Override
					public void focusLost(FocusEvent e) {
						String guide = "아이디를 입력해주세요";
						String mbField = idEnter.getText();
						if (mbField.isEmpty()) {
							idEnter.setText(guide);
							idEnter.setForeground(Color.LIGHT_GRAY);
						} else if (guide.equals(guide))
							idEnter.setForeground(Color.LIGHT_GRAY);
					}
				});
				idEnter.setText("아이디를 입력해주세요");
				idEnter.setForeground(Color.LIGHT_GRAY);
				idEnter.setHorizontalAlignment(SwingConstants.LEFT);
				//panel_17.add(idEnter, BorderLayout.CENTER);
				idEnter.setColumns(30);
				idEnter.setBounds(151, 75, 116, 25);
				centens.add(idEnter);
				//idEnter.setText("\uC544\uC774\uB514 \uC785\uB825");
				idEnter.setColumns(10);
		//?? frame.getContentPane().add(canel); 
		
		JButton idCheck = new JButton("\uC911\uBCF5\uD655\uC778");
		idCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemberDBManager mbMgr = new MemberDBManager();
				String login = idEnter.getText();
				int dup = mbMgr.isDuplicatedMember(login);
				String errMsg = null;
				switch (dup) {
				case 0:
					// 로그인 이름이 중복되지 않았다
					OKButton.setEnabled(true);
					label_id.setForeground(Color.blue);
					label_id.setText("로그인명 사용가능!!");
					JOptionPane.showMessageDialog( contentPane, "로그인명 사용가능합니다.");
					break;
				case 1: errMsg = "로그인명 중복발견!!";
				JOptionPane.showMessageDialog( contentPane, "로그인명 중복!");
				label_id.setForeground(Color.red);
				label_id.setText("로그인명 중복!!");
				break;
				case 2: if( errMsg == null )  
							errMsg = "DB 예외!!";
				break;
				case 3: if( errMsg == null )
							errMsg = "통신 예외!!";
				label_id.setForeground(Color.red);
				label_id.setText(errMsg);
				break;
				default:
					break;
				}
				
				// 중복되면 ...
			
			}
		});
		idCheck.setForeground(new Color(240, 248, 255));
		idCheck.setBackground(new Color(47, 79, 79));
		idCheck.setBounds(228, 102, 90, 23);
		centens.add(idCheck);
		idCheck.setBorderPainted(false);
		
		label_id = new JLabel("");
		label_id.setBounds(209, 41, 148, 15);
		centens.add(label_id);
		
		JLabel email = new JLabel("\uC774\uBA54\uC77C");
		email.setBounds(391, 38, 140, 25);
		centens.add(email);
		email.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
		emailField = new JTextField();
		emailField.setBounds(401, 75, 199, 25);
		centens.add(emailField);
		emailField.setColumns(10);
		
		JLabel pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pw.setBounds(141, 159, 140, 25);
		centens.add(pw);
		pw.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
		pwfirst = new JPasswordField();
		pwfirst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwfirst.setBackground(Color.yellow);
			}
			@Override
			public void focusLost(FocusEvent e) {
				pwfirst.setBackground(Color.white);
			}
		});
		pwfirst.setColumns(8);
		pwfirst.setBounds(151, 194, 116, 25);
		centens.add(pwfirst);
		pwfirst.setColumns(10);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(141, 236, 148, 15);
		centens.add(lblStatus);
		
//		pwpwField = new JTextField();
//		pwpwField.setBounds(364, 195, 116, 21);
//		centens.add(pwpwField);
//		pwpwField.setColumns(10);
		
		JLabel pwpw = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pwpw.setBounds(391, 159, 140, 25);
		centens.add(pwpw);
		pwpw.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
			//	pwFirst.setForeground(Color.LIGHT_GRAY);
			//	pwFirst.setFont(new Font("굴림", Font.BOLD, 16));
		
				
				pwpwField = new JPasswordField();
				pwpwField.setBounds(401, 194, 116, 25);
				centens.add(pwpwField);
				pwpwField.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						pwpwField.setBackground(Color.yellow);
						String pw1 = new String(pwfirst.getPassword());
						System.out.println("pw1: " + pw1);
						if (pw1.isEmpty()) {
							lblStatus.setForeground(Color.RED);
						//	lblStatus.setText("첫번째 암호 입력하세요!");
							pwfirst.requestFocusInWindow();
						}
					}
					@Override
					public void focusLost(FocusEvent e) {
						pwpwField.setBackground(Color.white);				
						String pw1 = new String(pwfirst.getPassword());
						String pw2 = new String(pwpwField.getPassword());
						System.out.println("pw2: " + pw2);
						if (pw2.isEmpty()) {
							lblStatus.setForeground(Color.RED);
					//		lblStatus.setText("두번째 암호 입력하세요!");
						} else {
							// 4자 길이?
							if( pw1.equals(pw2) ) {
								lblStatus.setForeground(Color.BLUE);
								lblStatus.setText("암호 일치");
							} else {
								lblStatus.setForeground(Color.RED);
								lblStatus.setText("암호 불일치!");
							}
						}
					}
				});
		
		JLabel yymmdd = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		yymmdd.setBounds(141, 261, 140, 25);
		centens.add(yymmdd);
		yymmdd.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
		/*
		 *  SimpleDateFormat sf = new SimpleDateFormat("YYYYMMDD");
			String dateStr = sf.format(movDate);
		 */
		JSpinner yy = new JSpinner();
		yy.setModel(new SpinnerListModel(new String[] {"1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980"}));
		yy.setBounds(151, 299, 59, 22);
		centens.add(yy);
		
		JSpinner mm = new JSpinner();
		mm.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		mm.setBounds(209, 299, 40, 22);
		centens.add(mm);
		
		JSpinner dd = new JSpinner();
		dd.setModel(new SpinnerNumberModel(new Integer(15), null, null, new Integer(1)));
		dd.setBounds(248, 299, 41, 22);
		centens.add(dd);
		
		JLabel phone = new JLabel("\uC804\uD654\uBC88\uD638");
		phone.setBounds(387, 261, 140, 25);
		centens.add(phone);
		phone.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
		phone1st = new JTextField();
		phone1st.setColumns(4);
		phone1st.setBounds(402, 296, 140, 21);
		centens.add(phone1st);
		canel.setBackground(new Color(123, 104, 238));
		
		canel.setBounds(243, 331, 90, 23);
		centens.add(canel);
		
		OKButton = new JButton("\uB4F1\uB85D\uD558\uAE30");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String dateStr = sf.format(yy.getValue()+(String)mm.getValue()+dd.getValue());
				Calendar cal = Calendar.getInstance();
				cal.set(Integer.parseInt(String.valueOf(yy.getValue())), Integer.parseInt(String.valueOf(mm.getValue())), Integer.parseInt(String.valueOf(dd.getValue())));
				Date date = cal.getTime();
				// 이름 추가해주세요
				String encPw = new String(pwfirst.getPassword());
				encPw = loginpop.encrypt(encPw);
				
				Member mb = new Member(idEnter.getText(),encPw, "test", emailField.getText(), new java.sql.Date(date.getTime()), phone1st.getText(), null);
				MemberDBManager mbMgr = new MemberDBManager();
				mbMgr.insertNewMember(mb) ;
				JOptionPane.showMessageDialog( contentPane, "회원 가입 되었습니다. 로그인 화면으로 이동합니다.");
				dispose();
				loginpop loginp = new loginpop();
				loginp.setVisible(true);
			}
		});
		OKButton.setBounds(434, 331, 97, 23);
		centens.add(OKButton);
		OKButton.setOpaque(true); //투명화
		OKButton.setForeground(UIManager.getColor("CheckBox.shadow"));
		OKButton.setBackground(new Color(123, 104, 238));
		

	}
}
