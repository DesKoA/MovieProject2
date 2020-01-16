package movie.seat;

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
							
						}
					});
					
				}
//			}
			
/*			JButton btn01 = new JButton("01");
			btn01.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("01번으로 설정");
				}
			});
			JButton btn02 = new JButton("02");
			btn02.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("02번으로 설정");
				}
			});
			JButton btn03 = new JButton("03");
			btn03.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("03번으로 설정");
				}
			});
			JButton btn04 = new JButton("04");
			btn04.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("04번으로 설정");
				}
			});
			JButton btn05 = new JButton("05");
			btn05.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("05번으로 설정");
				}
			});
			JButton btn06 = new JButton("06");
			btn06.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("06번으로 설정");
				}
			});
			JButton btn07 = new JButton("07");
			btn07.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("07번으로 설정");
				}
			});
			JButton btn08 = new JButton("08");
			btn08.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("08번으로 설정");
				}
			});
			JButton btn09 = new JButton("09");
			btn09.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("09번으로 설정");
				}
			});
			JButton btn10 = new JButton("10");
			btn10.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("10번으로 설정");
				}
			});
			JButton btn11 = new JButton("11");
			btn11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("11번으로 설정");
				}
			});
			JButton btn12 = new JButton("12");
			btn12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("12번으로 설정");
				}
			});
			JButton btn13 = new JButton("13");
			btn13.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("13번으로 설정");
				}
			});
			JButton btn14 = new JButton("14");
			btn14.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("14번으로 설정");
				}
			});
			JButton btn15 = new JButton("15");
			btn15.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("15번으로 설정");
				}
			});
			JButton btn16 = new JButton("16");
			btn16.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("16번으로 설정");
				}
			});
			JButton btn17 = new JButton("17");
			btn17.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("17번으로 설정");
				}
			});
			JButton btn18 = new JButton("18");
			btn18.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("18번으로 설정");
				}
			});
			JButton btn19 = new JButton("19");
			btn19.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("19번으로 설정");
				}
			});
			JButton btn20 = new JButton("20");
			btn20.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("20번으로 설정");
				}
			});
			JButton btn21 = new JButton("21");
			btn21.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("21번으로 설정");
				}
			});
			JButton btn22 = new JButton("22");
			btn22.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("22번으로 설정");
				}
			});
			JButton btn23 = new JButton("23");
			btn23.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("23번으로 설정");
				}
			});
			JButton btn24 = new JButton("24");
			btn24.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("24번으로 설정");
				}
			});
			JButton btn25 = new JButton("25");
			btn25.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("25번으로 설정");
				}
			});
			JButton btn26 = new JButton("26");
			btn26.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("26번으로 설정");
				}
			});
			JButton btn27 = new JButton("27");
			btn27.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("27번으로 설정");
				}
			});
			JButton btn28 = new JButton("28");
			btn28.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("28번으로 설정");
				}
			});
			JButton btn29 = new JButton("29");
			btn29.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("29번으로 설정");
				}
			});
			JButton btn30 = new JButton("30");
			btn30.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("30번으로 설정");
				}
			});
			JButton btn31 = new JButton("31");
			btn31.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("31번으로 설정");
				}
			});
			JButton btn32 = new JButton("32");
			btn32.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("32번으로 설정");
				}
			});
			JButton btn33 = new JButton("33");
			btn33.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("33번으로 설정");
				}
			});
			JButton btn34 = new JButton("34");
			btn34.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("34번으로 설정");
				}
			});
			JButton btn35 = new JButton("35");
			btn35.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("35번으로 설정");
				}
			});
			
			contentPanel.add(btn01);
			contentPanel.add(btn02);
			contentPanel.add(btn03);
			contentPanel.add(btn04);
			contentPanel.add(btn05);
			contentPanel.add(btn06);
			contentPanel.add(btn07);
			contentPanel.add(btn08);
			contentPanel.add(btn09);
			contentPanel.add(btn10);
			contentPanel.add(btn11);
			contentPanel.add(btn12);
			contentPanel.add(btn13);
			contentPanel.add(btn14);
			contentPanel.add(btn15);
			contentPanel.add(btn16);
			contentPanel.add(btn17);
			contentPanel.add(btn18);
			contentPanel.add(btn19);
			contentPanel.add(btn20);
			contentPanel.add(btn21);
			contentPanel.add(btn22);
			contentPanel.add(btn23);
			contentPanel.add(btn24);
			contentPanel.add(btn25);
			contentPanel.add(btn26);
			contentPanel.add(btn27);
			contentPanel.add(btn28);
			contentPanel.add(btn29);
			contentPanel.add(btn30);
			contentPanel.add(btn31);
			contentPanel.add(btn32);
			contentPanel.add(btn33);
			contentPanel.add(btn34);
			contentPanel.add(btn35);
			
		}
		{
			
		}
			JLabel lbl01 = new JLabel("01");
			lbl01.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
					JLabel lbl01 = (JLabel)e.getSource();
					for (int i = 0; i < seatLabelList
									.size(); i++) {
						JLabel mnu = seatLabelList.get(i);
						if( lbl01 == mnu ) {
							Seat seatNum = seatList.get(i);
							System.out.println(seatNum);
							//
						}
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					JLabel lbl01 = (JLabel)e.getSource();
					lbl01.setBackground(Color.BLUE);
					super.mouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					JLabel lbl01 = (JLabel)e.getSource();
					lbl01.setBackground(Color.GREEN);
					super.mouseExited(e);
				}
			});
					
			lbl01.setHorizontalAlignment(SwingConstants.CENTER);
			lbl01.setFont(new Font("굴림", Font.PLAIN, 20));
			contentPanel.add(lbl01);
			
		}
*/		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JLabel lblselSeat = new JLabel("New label");
				buttonPane.add(lblselSeat);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
//				okButton.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent arg0) {
//						int seatNo = new Button(i + "")
//					}
//				});	
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
