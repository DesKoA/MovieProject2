package ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.LineBorder;

import data.Theaters;
import db.dao.TheatersDBManager;

public class CalendarAdmin extends JInternalFrame { // CalendarDataManager의 GUI + 메모기능 + 시계
	static final int CAL_WIDTH = 7;
	final static int CAL_HEIGHT = 6;
	public static int target;
	public int calDates[][] = new int[CAL_HEIGHT][CAL_WIDTH];
	public boolean tbb = false;
	Date date;
	int calYear;
	int calMonth;
	int calDayOfMon;
	public static int targetDay;
	final int calLastDateOfMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static Admin mov;
	int calLastDate;
	Calendar today = Calendar.getInstance();
	Calendar cal;

	public void makeCalData(Calendar cal) {
		// 1일의 위치와 마지막 날짜를 구함
		int calStartingPos = (cal.get(Calendar.DAY_OF_WEEK) + 7 - (cal.get(Calendar.DAY_OF_MONTH)) % 7) % 7;
		if (calMonth == 1)
			calLastDate = calLastDateOfMonth[calMonth] + leapCheck(calYear);
		else
			calLastDate = calLastDateOfMonth[calMonth];
		// 달력 배열 초기화
		for (int i = 0; i < CAL_HEIGHT; i++) {
			for (int j = 0; j < CAL_WIDTH; j++) {
				calDates[i][j] = 0;
			}
		}
		// 달력 배열에 값 채워넣기
		for (int i = 0, num = 1, k = 0; i < CAL_HEIGHT; i++) {
			if (i == 0)
				k = calStartingPos;
			else
				k = 0;
			for (int j = k; j < CAL_WIDTH; j++) {
				if (num <= calLastDate)
					calDates[i][j] = num++;
				if (calMonth == today.get(Calendar.MONTH) && calYear == today.get(Calendar.YEAR)
						&& calDates[i][j] == today.get(Calendar.DAY_OF_MONTH)) {
					if (dateButs[i][j] != null && dateButs[i][j].isEnabled()) {
						dateButs[i][j].setBorderPainted(true);
						dateButs[i][j].setBorder(new LineBorder(Color.BLUE, 3));
						dateButs[i][j].setToolTipText("Today");
					}
				} else if (dateButs[0][0] != null) {
					dateButs[i][j].setBorderPainted(false);
				}
			}
		}
	}

	private int leapCheck(int year) { // 윤년인지 확인하는 함수
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return 1;
		else
			return 0;
	}

	public void moveMonth(int mon) { // 현재달로 부터 n달 전후를 받아 달력 배열을 만드는 함수(1년은 +12, -12달로 이동 가능)
		calMonth += mon;
		if (calMonth > 11)
			while (calMonth > 11) {
				calYear++;
				calMonth -= 12;
			}
		else if (calMonth < 0)
			while (calMonth < 0) {
				calYear--;
				calMonth += 12;
			}
		cal = new GregorianCalendar(calYear, calMonth, calDayOfMon);
		makeCalData(cal);
	}

	public void setToday() {
		calYear = today.get(Calendar.YEAR);
		calMonth = today.get(Calendar.MONTH);
		calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
		makeCalData(today);
	}

	JPanel calOpPanel;
	JButton todayBut;
	JLabel todayLab;
	JButton lYearBut;
	JButton lMonBut;
	JLabel curMMYYYYLab;
	JButton nMonBut;
	JButton nYearBut;
	ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();

	JPanel calPanel;
	JButton weekDaysName[];
	JButton dateButs[][] = new JButton[6][7];
	listenForDateButs lForDateButs = new listenForDateButs();

	// JPanel frameSubPanelEast;
	JPanel frameSubPanelWest;

	JLabel selectedDate;

	final String WEEK_DAY_NAME[] = { "일", "월", "화", "수", "목", "금", "토" };

//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				new MemoCalendarStatic();
//			}
//		});
//	}
	
	public void cleanCal() {
		for (int i = 0; i < CAL_HEIGHT; i++) {
			for (int j = 0; j < CAL_WIDTH; j++) {
				dateButs[i][j].setBorder(null);
			}
		}
		setToday();
	}

	public CalendarAdmin() { // 구성요소 순으로 정렬되어 있음. 각 판넬 사이에 빈줄로 구별
		setToday();

		// mainFrame = new JFrame(title);
		// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainFrame.setSize(430, 380);
		// mainFrame.setLocationRelativeTo(null);
		// mainFrame.setResizable(false);
		// mainFrame.setIconImage(icon.getImage());
		// try {
		// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//
		// LookAndFeel Windows 스타일 적용
		// SwingUtilities.updateComponentTreeUI(mainFrame);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		calOpPanel = new JPanel();
		todayBut = new JButton("T");
		todayBut.setToolTipText("Today");
		todayBut.setFocusable(false);
		todayBut.addActionListener(lForCalOpButtons);
		todayLab = new JLabel(today.get(Calendar.YEAR) + "년 " + (today.get(Calendar.MONTH) + 1) + "월 "
				+ today.get(Calendar.DAY_OF_MONTH) + "일");
		lYearBut = new JButton("<<");
		lYearBut.setToolTipText("Previous Year");
		lYearBut.setFocusable(false);
		lYearBut.addActionListener(lForCalOpButtons);
		lMonBut = new JButton("<");
		lMonBut.setToolTipText("Previous Month");
		lMonBut.setFocusable(false);
		lMonBut.addActionListener(lForCalOpButtons);
		curMMYYYYLab = new JLabel("<html><table width=100><tr><th><font size=5>" + ((calMonth + 1) < 10 ? "&nbsp;" : "")
				+ (calMonth + 1) + " / " + calYear + "</th></tr></table></html>");
		nMonBut = new JButton(">");
		nMonBut.setToolTipText("Next Month");
		nMonBut.setFocusable(false);
		nMonBut.addActionListener(lForCalOpButtons);
		nYearBut = new JButton(">>");
		nYearBut.setToolTipText("Next Year");
		nYearBut.setFocusable(false);
		nYearBut.addActionListener(lForCalOpButtons);
		calOpPanel.setLayout(new GridBagLayout());
		GridBagConstraints calOpGC = new GridBagConstraints();
		calOpGC.gridx = 1;
		calOpGC.gridy = 1;
		calOpGC.gridwidth = 2;
		calOpGC.gridheight = 1;
		calOpGC.weightx = 1;
		calOpGC.weighty = 1;
		calOpGC.insets = new Insets(5, 5, 0, 0);
		calOpGC.anchor = GridBagConstraints.WEST;
		calOpGC.fill = GridBagConstraints.NONE;
		calOpPanel.add(todayBut, calOpGC);
		calOpGC.gridwidth = 3;
		calOpGC.gridx = 2;
		calOpGC.gridy = 1;
		calOpPanel.add(todayLab, calOpGC);
		calOpGC.anchor = GridBagConstraints.CENTER;
		calOpGC.gridwidth = 1;
		calOpGC.gridx = 1;
		calOpGC.gridy = 2;
		calOpPanel.add(lYearBut, calOpGC);
		calOpGC.gridwidth = 1;
		calOpGC.gridx = 2;
		calOpGC.gridy = 2;
		calOpPanel.add(lMonBut, calOpGC);
		calOpGC.gridwidth = 2;
		calOpGC.gridx = 3;
		calOpGC.gridy = 2;
		calOpPanel.add(curMMYYYYLab, calOpGC);
		calOpGC.gridwidth = 1;
		calOpGC.gridx = 5;
		calOpGC.gridy = 2;
		calOpPanel.add(nMonBut, calOpGC);
		calOpGC.gridwidth = 1;
		calOpGC.gridx = 6;
		calOpGC.gridy = 2;
		calOpPanel.add(nYearBut, calOpGC);

		calPanel = new JPanel();
		weekDaysName = new JButton[7];
		for (int i = 0; i < CAL_WIDTH; i++) {
			weekDaysName[i] = new JButton(WEEK_DAY_NAME[i]);
			weekDaysName[i].setBorderPainted(false);
			weekDaysName[i].setContentAreaFilled(false);
			weekDaysName[i].setForeground(Color.WHITE);
			if (i == 0)
				weekDaysName[i].setBackground(new Color(200, 50, 50));
			else if (i == 6)
				weekDaysName[i].setBackground(new Color(50, 100, 200));
			else
				weekDaysName[i].setBackground(new Color(150, 150, 150));
			weekDaysName[i].setOpaque(true);
			weekDaysName[i].setFocusPainted(false);
			calPanel.add(weekDaysName[i]);
		}

		for (int i = 0; i < CAL_HEIGHT; i++) {
			for (int j = 0; j < CAL_WIDTH; j++) {
				dateButs[i][j] = new JButton();
				dateButs[i][j].setBorderPainted(false);
				dateButs[i][j].setContentAreaFilled(false);
				dateButs[i][j].setBackground(Color.WHITE);
				dateButs[i][j].setOpaque(true);
				dateButs[i][j].addActionListener(lForDateButs);
				dateButs[i][j].setEnabled(true);
				dateButs[i][j].setFocusPainted(false);
				calPanel.add(dateButs[i][j]);
			}
		}

		calPanel.setLayout(new GridLayout(0, 7, 2, 2));
		calPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

		showCal(); // 달력을 표시

//		selectedDate = new JLabel("<Html><font size=3>" + (today.get(Calendar.MONTH) + 1) + "/"
//				+ today.get(Calendar.DAY_OF_MONTH) + "/" + today.get(Calendar.YEAR) + "&nbsp;(Today)</html>",
//				SwingConstants.LEFT);
//		selectedDate.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

		frameSubPanelWest = new JPanel();
		Dimension calOpPanelSize = calOpPanel.getPreferredSize();
		calOpPanelSize.height = 70;
		calOpPanel.setPreferredSize(calOpPanelSize);

		// frameSubPanelWest.setLayout(new BorderLayout());
		// frameSubPanelWest.setLayout(new FlowLayout(FlowLayout.LEADING));
		// frameSubPanelWest.setLayout(new AbsoluteLayout());
		// BorderLayout border = new BorderLayout();
		frameSubPanelWest.setLayout(new BorderLayout());
		frameSubPanelWest.add(calOpPanel, BorderLayout.NORTH);
		frameSubPanelWest.add(calPanel, BorderLayout.CENTER);
		add(frameSubPanelWest);
		pack();
		setVisible(true);
		// BorderLayout layout =
		// (BorderLayout)frameSubPaneJDesktopPanelWest.getLayout();
		// frameSubPanelWest.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		// frameSubPanelWest.remove(layout.getLayoutComponent(BorderLayout.SOUTH));
		// frameSubPanelWest.add(calOpPanel, new AbsoluteConstraints(100, 0, 300, 100));
		// frameSubPanelWest.add(calPanel, new AbsoluteConstraints(30, 70, 400, 285));

//		Dimension frameSubPanelWestSize = frameSubPanelWest.getPreferredSize();
//		frameSubPanelWestSize.width = 380;
//		frameSubPanelWest.setPreferredSize(frameSubPanelWestSize);

		// setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(0, 0, 200, 300);
		// this.add(frameSubPanelEast);
		// this.add(frameSubPanelWest);
		setVisible(true);

		focusToday(); // 현재 날짜에 focus를 줌 (mainFrame.setVisible(true) 이후에 배치해야함)
	}

	private void focusToday() {
		if (today.get(Calendar.DAY_OF_WEEK) == 1)
			dateButs[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK) - 1].requestFocusInWindow();
		else
			dateButs[today.get(Calendar.WEEK_OF_MONTH) - 1][today.get(Calendar.DAY_OF_WEEK) - 1].requestFocusInWindow();
	}

	public void showCal() {
		for (int i = 0; i < CAL_HEIGHT; i++) {
			for (int j = 0; j < CAL_WIDTH; j++) {
				String fontColor = "black";
				if (j == 0)
					fontColor = "red";
				else if (j == 6)
					fontColor = "blue";
				// dateButs[i][j].setText("<html><font size='4' color=" + fontColor + ">" +
				// calDates[i][j] + "</font></html>");
				dateButs[i][j].setText("<html><font style='font-family: 고딕' size='5' color=" + fontColor + ">"
						+ calDates[i][j] + "</font></html>");
				dateButs[i][j].removeAll();
				if (calMonth == today.get(Calendar.MONTH) && calYear == today.get(Calendar.YEAR)
						&& calDates[i][j] == today.get(Calendar.DAY_OF_MONTH)) {
					if (dateButs[i][j].isEnabled()) {
						dateButs[i][j].setBorderPainted(true);
						dateButs[i][j].setBorder(new LineBorder(Color.BLUE, 3));
						dateButs[i][j].setToolTipText("Today");
					} 
				}

				if (calDates[i][j] == 0)
					dateButs[i][j].setVisible(false);
				else
					dateButs[i][j].setVisible(true);
			}
		}
	}

	private class ListenForCalOpButtons implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == todayBut) {
				tbb = true;
				setToday();
				lForDateButs.actionPerformed(e);
				focusToday();
				showCal();
				mov.timePanel.removeAll();
			}
			if (e.getSource() == lYearBut) {
				moveMonth(-12);
				showCal();
			} else if (e.getSource() == lMonBut) {
				moveMonth(-1);
			} else if (e.getSource() == nMonBut) {
				moveMonth(1);
			} else if (e.getSource() == nYearBut) {
				moveMonth(12);
			}

			showCal();
			curMMYYYYLab.setText("<html><table width=100><tr><th><font size=5>" + ((calMonth + 1) < 10 ? "&nbsp;" : "")
					+ (calMonth + 1) + " / " + calYear + "</th></tr></table></html>");
		}
	}

	// 달력 리스너
	public class listenForDateButs implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int k = 0, l = 0;
			for (int i = 0; i < CAL_HEIGHT; i++) {
				for (int j = 0; j < CAL_WIDTH; j++) {
					if (e.getSource() == dateButs[i][j]) {
						k = i;
						l = j;

						String dateStr = calYear + "-" + (calMonth + 1) + "-" + calDates[i][j];
						date = Date.valueOf(dateStr);
						dateButs[i][j].setBorderPainted(true);
						dateButs[i][j].setBorder(new LineBorder(Color.RED, 3));
						mov.movieInfoDayName.setText(calYear + "년 " + (calMonth + 1) + "월 " + calDates[i][j] + "일");
						// !!! InternalFrameDemo.dayLb.setText(String.valueOf(calDates[i][j])); !!!
						mov.timePanel.setVisible(true);
						mov.eastPanel.setVisible(false);
						mov.showTableDB("1관");
					} else {
						dateButs[i][j].setBorderPainted(false);
						dateButs[i][j].setBorder(null);
					}
				}
			}

			if (!(k == 0 && l == 0))
				calDayOfMon = calDates[k][l]; // today버튼을 눌렀을때도 이 actionPerformed함수가 실행되기 때문에 넣은 부분
		}

	}

}