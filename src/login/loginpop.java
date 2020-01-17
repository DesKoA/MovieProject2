package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import data.Member;
import db.dao.MemberDBManager;
/*import db.dao.MemberDBMgr;
import ui.member.MemberPasswordMgr;*/
import db.util.OracleDBUtil;
import sun.security.util.Length;
//import ui.member.MemberPasswordMgr;
import ui.movieMain.MovieMainFrame;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class loginpop extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	protected JLabel txtWelcome;
	public static String LOGGED_IN;
	public static int LOGGED_IN_ID;
	public static String resPW;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpop frame = new loginpop();
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
	public loginpop() {
		OracleDBUtil.connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 32, 324, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtWelcome = new JLabel("\uB098 \uBA3C\uC800 \uC608\uBA54");
		txtWelcome.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		txtWelcome.setForeground(Color.LIGHT_GRAY);
		txtWelcome.setBounds(71, 90, 203, 23);
		panel.add(txtWelcome);
		
		JLabel label = new JLabel("\uB098 \uBA3C\uC800 \uC608\uBA54");
		label.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		label.setForeground(SystemColor.textHighlight);
		label.setBounds(71, 10, 126, 31);
		panel.add(label);
		
		JButton btnNewButton_1 = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton_1.setBounds(3, 155, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String login = textField.getText();
				char[] pw = ((JPasswordField) textField_1).getPassword();
				String strPW = new String(pw);
				System.out.println(login+"__"+strPW);
				
				MemberDBManager mbMgr = new MemberDBManager();
				Member foundMb = mbMgr.selectOneMember(login, strPW);
				System.out.println(foundMb);
				if( foundMb == null ) {
					txtWelcome.setText(login+" 회원이 존재하지 않음!");
					//System.out.println("11");
				} else {
					// db에 회원이 존재하면..
					resPW = loginpop.decrypt(foundMb.getMemberPW());
						// 암호화 패스워드 복원... XOR 단순방식
					System.out.println("resPW = " + resPW);						
					//if(strPW.equals(foundMb.getPw())) {
					if(strPW.equals(resPW)) {
						txtWelcome.setText(login+" 회원 로그인 성공!!");
					//	System.out.println("12");
						LOGGED_IN = Member.getMemberID();
						MovieMainFrame mmf = new MovieMainFrame();
						mmf.setSize(1000, 600);
						dispose();
						mmf.setVisible(true);
					} else {
						txtWelcome.setText(login+" 회원 암호 불일치!");
					//	System.out.println("113");
					}
				}
			}
		});
		btnNewButton.setBounds(152, 155, 97, 23);
		panel.add(btnNewButton);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/*
		
		 		btnLoginProc = new JButton("\uB85C\uADF8\uC778");
		btnLoginProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( LOGGED_IN == null ) {
					String login = txtLogin.getText();
					char[] pw = password.getPassword();
					String strPW = new String(pw);
					System.out.println(login+"__"+strPW);
					
					MemberDBMgr mbMgr = new MemberDBMgr();
					Member foundMb = mbMgr.selectOneMember(login);
					if( foundMb == null ) {
						txtWelcome.setText(login+" 회원이 존재하지 않음!");
					} else {
						// db에 회원이 존재하면..
						String resPW = 
							MemberPasswordMgr.decrypt(foundMb.getPw());
							// 암호화 패스워드 복원... XOR 단순방식
						System.out.println("resPW = " + resPW);						
						//if(strPW.equals(foundMb.getPw())) {
						if(strPW.equals(resPW)) {
							txtWelcome.setText(login+" 회원 로그인 성공!!");
							LOGGED_IN = foundMb.getLogin();
							frm.setTitle("MyCaffee :: "+ LOGGED_IN + "로그인 중");
						} else {
							txtWelcome.setText(login+" 회원 암호 불일치!");
						}
					}
				} else {
					txtWelcome.setText(LOGGED_IN+" 로그아웃 됨");
					LOGGED_IN = null;
					frm.setTitle("MyCaffee :: ");	
					//txtLogin.requestFocus();
				}
				checkLOGGED_IN();
			}
		});

		btnLoginProc.setFont(new Font("굴림", Font.BOLD, 18));
		btnLoginProc.setBounds(184, 127, 146, 23);
		panel.add(btnLoginProc);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			*/	
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(12, 46, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(12, 98, 57, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		//textField.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		textField.setBounds(12, 67, 139, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		//textField_1.setText("\uBE44\uBC00\uBC88\uD638");
		textField_1.setBounds(12, 123, 139, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}

	public static String encrypt(String inPW) {
		char xorPW[] = new char[inPW.length()];
		for (int i = 0; i < inPW.length(); i++) {
			int xorC = xor(inPW.charAt(i));
			xorPW[i] = (char) xorC;
		}
		return new String(xorPW);
	}
	public static String decrypt(String dbPW ) {
		char xorPW[] = new char[dbPW.length()];
		for (int i = 0; i < dbPW.length(); i++) {
			int xorC = xor(dbPW.charAt(i));
			xorPW[i] = (char) xorC;
		}
		return new String(xorPW);
	}

	private static int KEY = 0x98765432;
	
	public static int xor(int input) {
		return input ^ KEY;
	}	
//	public void checkLOGGED_IN() {
//		if( LOGGED_IN == null ) {
//			btnLoginProc.setText("로그인");
//			txtLogin.setEnabled(true);
//			password.setEnabled(true);
//			txtLogin.requestFocus();
//		} else {
//			btnLoginProc.setText("로그아웃");
//			txtLogin.setText("");
//			txtLogin.setEnabled(false);
//			password.setText("");
//			password.setEnabled(false);
//		}
//}
}
