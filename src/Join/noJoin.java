package Join;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import db.util.OracleDBUtil;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
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
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class noJoin extends JFrame {

	private JPanel contentPane;
	private JTextField pwField;
	private JTextField pwpwField;
	private JTextField emailField;
	private JLabel lblStatus;
	private BufferedImage background;
	private JPanel panel_2;
	private JTextField phone1st;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					noJoin frame = new noJoin();
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
	
	public noJoin() {
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
		panel.setBackground(new Color(219,93,92)); //(88,105,219));//(124, 166, 150));
		panel.setBounds(0, 86, 210, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton fstbutton = new JButton("\uCC98\uC74C\uD654\uBA74\uC73C\uB85C");
		fstbutton.setFont(new Font("굴림", Font.BOLD, 15));
		fstbutton.setBackground(new Color(219, 86, 114));
		fstbutton.setBounds(19, 50, 133, 35);
		panel.add(fstbutton);
		
		JButton nojoinBtn = new JButton("\uAC00\uC785\uD558\uAE30");
		nojoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		nojoinBtn.setFont(new Font("굴림", Font.BOLD, 15));
		nojoinBtn.setBackground(new Color(219, 86, 114));
		nojoinBtn.setBounds(19, 119, 133, 35);
		panel.add(nojoinBtn);
		
		JPanel liftTitle = new JPanel();
		liftTitle.setBackground(new Color(249,127,105));//(100, 159, 249)); //(98, 140, 150));
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
		
		panel_2.setBounds(294, 10, 680, 86);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel title = new JLabel("  \uBE44   \uD68C   \uC6D0   \uC815   \uBCF4   \uC785   \uB825");
		title.setBounds(0, 10, 511, 53);
		panel_2.add(title);
		title.setForeground(new Color(85, 71, 89));
		title.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setFont(new Font("돋움", Font.BOLD, 21));
		label.setBounds(54, 10, 108, 37);
		liftTitle.add(label);

		ImageIcon ic = new ImageIcon(
//		final String ic = 
				".\\image\\티켓분홍색1.png");
				
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
    	centens.setBounds(211, 86, 775, 392);
		contentPane.add(centens);
		centens.setLayout(null);
		
		JButton canel = new JButton("\uCDE8\uC18C\uD558\uAE30");
		canel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel email = new JLabel("\uC774\uBA54\uC77C");
		email.setBounds(141, 40, 140, 25);
		centens.add(email);
		email.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
		emailField = new JTextField();
		emailField.setBounds(151, 75, 169, 30);
		centens.add(emailField);
		emailField.setColumns(10);
		
		JLabel pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pw.setBounds(141, 159, 140, 25);
		centens.add(pw);
		pw.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
		pwField = new JPasswordField();
		pwField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwField.setBackground(Color.yellow);
			}
			@Override
			public void focusLost(FocusEvent e) {
				pwField.setBackground(Color.white);
			}
		});
		pwField.setColumns(8);
		pwField.setBounds(151, 194, 116, 25);
		centens.add(pwField);
		pwField.setColumns(10);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(141, 236, 148, 15);
		centens.add(lblStatus);
		
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
						String pw1 = new String(((JPasswordField) pwField).getPassword());
						System.out.println("pw1: " + pw1);
						if (pw1.isEmpty()) {
							lblStatus.setForeground(Color.RED);
						//	lblStatus.setText("첫번째 암호 입력하세요!");
							pwField.requestFocusInWindow();
						}
					}
					@Override
					public void focusLost(FocusEvent e) {
						pwpwField.setBackground(Color.white);				
						String pw1 = new String(((JPasswordField) pwField).getPassword());
						String pw2 = new String(((JPasswordField) pwpwField).getPassword());
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
		phone.setBounds(391, 40, 140, 25);
		centens.add(phone);
		phone.setFont(new Font("한컴돋움", Font.BOLD, 20));
		
		phone1st = new JTextField();
		phone1st.setColumns(4);
		phone1st.setBounds(401, 75, 175, 25);
		centens.add(phone1st);
		canel.setBackground(new Color(123, 104, 238));
		
		canel.setBounds(509, 287, 90, 23);
		centens.add(canel);
		
		JButton OKButton = new JButton("\uC608\uB9E4\uD558\uAE30");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				cal.set(Integer.parseInt(String.valueOf(yy.getValue())), Integer.parseInt(String.valueOf(mm.getValue())), Integer.parseInt(String.valueOf(dd.getValue())));
				Date date = cal.getTime();
			}
		});
		OKButton.setBounds(401, 287, 97, 23);
		centens.add(OKButton);
		OKButton.setOpaque(true); //투명화
		OKButton.setForeground(UIManager.getColor("CheckBox.shadow"));
		OKButton.setBackground(new Color(123, 104, 238));
	}
}
