package mypage;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Seat1;

import java.awt.Toolkit;
import java.awt.GridLayout;
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

	public static ArrayList<Seat1> seatList = new ArrayList<>();
	public ArrayList<JLabel> seatLabelList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
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
	public static int selDay = 0;
	
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
//			@Override
//			public void mouseClicked(MouseEvent e) {
				for (int i = 1; i < seatLim; i++) {
					JButton day = new JButton(i + "");
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
					});
					
				}
				
		{
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
	}
}
