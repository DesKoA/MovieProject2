package mypage;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import data.Seat1;
import db.dao.MemberDBManager;
import db.util.OracleDBUtil;
import login.loginpop;

import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectSeatDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JButton seatBtn[][] = new JButton[10][10];
	public static ArrayList<Seat1> seatList = new ArrayList<>();
	public ArrayList<JLabel> seatLabelList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OracleDBUtil.connectDB();
			SelectSeatDialog dialog = new SelectSeatDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public static ArrayList<Seat1> seat = new ArrayList<>();
	
//	public void prepareSeatList() {
//		int seatLim = 36;
//		for (int i = 1; i < seatLim; i++) {
//			JButton btnSeatNum = new JButton();
//					System.out.printf("%d", i++);
//				}
//		
//		final String[] seatNum = {
//				"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"
//				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
//				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
//				"31", "32", "33", "34", "35"
//		};
//		
//		for (int j = 0; j < seatNum.length; j++) {
//			
//		}
//		
//	}
	ArrayList<JButton> daylist;
	public static String selDay ="";
	
	public SelectSeatDialog() {
		final int seatLim = 101;
		daylist = new ArrayList<JButton>();
		setIconImage(Toolkit.getDefaultToolkit().getImage("./icons/status_online.png"));
		setTitle("\uBE60\uB978 \uC608\uB9E4 \uC88C\uC11D \uC124\uC815");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(10, 10, 0, 0));
		{
			for (char c = 'A'; c <= 'J'; c++) {
	        	int i = c - 'A';
				for (int j = 0; j < 10; j++) {
					seatBtn[i][j] = new JButton();
					seatBtn[i][j].setVisible(true);
					seatBtn[i][j].setMargin(new Insets(0, 0, 0, 0));
					seatBtn[i][j].setText(c + "" + (j + 1));
					seatBtn[i][j].setToolTipText(c + "" + (j + 1));
					seatBtn[i][j].setFont(new Font("나눔바른고딕", 1, 15));
					seatBtn[i][j].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton btn = (JButton) e.getSource();
						//	int seatNo = new Button(i + "").get
							System.out.println(btn.getText());
							selDay = btn.getText();
							
						}
					});
					contentPanel.add(seatBtn[i][j]);
					daylist.add(seatBtn[i][j]);
					}
				}
			}
		
			/*
			char c = 'A';
			int j = 1;
				for (int i = 1; i < seatLim; i++) {
					JButton day = new JButton(i + "");
					day.setToolTipText(c+""+ j );
					c += 1;
					j++;
					if( i % 10 == 0 ) {
						c = 'A';
						j = 1;
					}
					contentPanel.add(day);
					daylist.add(day);
					
					
					day.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton btn = (JButton) e.getSource();
						//	int seatNo = new Button(i + "").get
							System.out.println(btn.getText());
							selDay = Integer.parseInt(btn.getText());
							
						}
					});*/
					
				
				
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JLabel lblselSeat = new JLabel("설정값 없음");
				//lblselSeat.setText();
				buttonPane.add(lblselSeat);
			
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					//	int seatNo = new Button(i + "")
						lblselSeat.setText(selDay + "번으로 설정");
						MemberDBManager mbMgrb= new MemberDBManager();
						mbMgrb.seatUpdate(selDay, loginpop.LOGGED_IN);
;						
					}
				});	
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

