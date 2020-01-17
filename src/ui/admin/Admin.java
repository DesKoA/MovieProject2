/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.admin;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import data.MovieInfo;
import data.Theaters;
import db.dao.MovieDBManager;
import db.dao.TheatersDBManager;
import db.util.OracleDBUtil;
import ui.ticketing.MovieTicketingSeat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * 123
 * @author alfo4-9
 */
public class Admin extends JFrame {
	public int adPersons;
	public int stPersons;
	public String movTitle;
	public CalendarAdmin calFrame = new CalendarAdmin();
	
	public ButtonGroup bgAdult; 
	public ButtonGroup bgStudent;
	public ButtonGroup bg;
	
	public static OracleDBUtil db;
	public MovieDBManager movieMgr;
	public TheatersDBManager thMgr;
	
	public JPanel timeBtPanel;
	
	public JDesktopPane desktop;
	
	public ImageIcon Icon;
	public ImageIcon Icon2; 
	
	public Date movDate;
	
	public LinkedHashMap<String, ArrayList<String>> timeList;
	public LinkedHashMap<String, String[]> timeHashList;
	public ArrayList<String> timeArrayList;
	public ArrayList<Integer> timeArrayWithOutList;
	
	public ArrayList<String> hourList;
	
	public static Admin mov;
	
	public void setFrame() {
		setBounds(0, 0, 500, 400);

		setAlwaysOnTop(false);
		desktop = new JDesktopPane(); // a specialized layered pane
		createFrame(); // create first "window"
		setContentPane(desktop);
	}

	protected void createFrame() {
		setAlwaysOnTop(false);
		// frame.setBounds(470, 30, 260, 370);
		calFrame.setBounds(269, 35, 460, 304); // 364
		calFrame.setVisible(true);
		BasicInternalFrameUI bi = (BasicInternalFrameUI) calFrame.getUI();
		calFrame.setBorder(new LineBorder(Color.BLACK, 1));
		bi.setNorthPane(null);
		desktop.add(calFrame);
		try {
			calFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
			
		}
	}

	/**
	 * Creates new form MovieReservation
	 */
	
	public Admin() {
		CalendarAdmin.mov = this;
		initComponents();
	}
	
	// ÃÊ±âÈ­ 
	public void resetFrame() {
		adPersons = 0;
		stPersons = 0;
		calFrame.showCal();
		calFrame.cleanCal();
		bg.clearSelection();
		movieList.clearSelection();
		bgAdult.clearSelection();
		btnAllot.setEnabled(false);
		timePanel.setVisible(false);
		movieInfoName.setFont(new Font("³ª´®½ºÄù¾î", 0, 20)); // NOI18N
		movieInfoName.setText("¿µÈ­¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä");
		movieInfoName.setForeground(new Color(255, 255, 255));
		movieInfoScreenName.setText("-");
		
		try {
			Image image = ImageIO.read(new File(".\\files\\image\\no_poster.png"));
			Image changedImg = image.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
			movieInfoPoster.setIcon(Icon);
			
			Image image2 = ImageIO.read(new File("./files/image/starRating/star0.png"));
			Image changedImg2 = image2.getScaledInstance(120, 25, Image.SCALE_SMOOTH);
			Icon2 = new ImageIcon(changedImg2);
			movieInfoStar.setIcon(Icon2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// DB¿¡¼­ ¹Þ¾Æ¿À±â
	public void showTableDB(String scName) {
		String[] header = { "Á¦¸ñ", "±ØÀå", "ÀÏÀÚ", "½ÃÀÛ", "Á¾·á"};
		TheatersDBManager thMgr = new TheatersDBManager();
		movDate = new Date(calFrame.date.getTime());
		ArrayList<Theaters> thList = thMgr.selectScNameInfo(scName, movDate);
		Object[][] data = new Object[thList.size()][header.length];
		if (thList.size() != 0) {
			for (int i = 0; i < thList.size(); i++) {
				Theaters row = thList.get(i);
				data[i][0] = row.getMovieTitle();
				data[i][1] = row.getScreenName();
				data[i][2] = row.getMovieDate();
				data[i][3] = row.getMovieStart();
				data[i][4] = row.getMovieEnd();
			}
			DefaultTableModel dtm = new DefaultTableModel(data, header);
			table.setModel(dtm);
			table.getColumnModel().getColumn(0).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(3).setPreferredWidth(70);
			table.getColumnModel().getColumn(4).setPreferredWidth(70);
		} else if (thList.size() == 0) {
			data = new Object[1][1];
			data[0][0] = "¹èÁ¤ÁßÀÎ ¿µÈ­°¡ ¾øÀ½";
			DefaultTableModel dtm = new DefaultTableModel(data, new String[] {"¹èÁ¤ÁßÀÎ ¿µÈ­°¡ ¾øÀ½"});
			table.setModel(dtm);
		}
	}
	
	public ArrayList<String> createHourList() {
		ArrayList<String> ret = new ArrayList<>();
		hourList = new ArrayList<>();
		for (int i = 0; i < 18; i++) {
			int hour = 7;
			String hourStr = String.format("%02d", hour + i);
			hourList.add(hourStr);
			ret.add(hourStr);
		}
		return ret;
	}
	
	/**    
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	public void initComponents() {
		OracleDBUtil.connectDB();
		movieMgr = new MovieDBManager();
		thMgr = new TheatersDBManager();
		Main = new JPanel();
		allotMovie = new JPanel();
		labelMovie = new JLabel();
		timeMin = new JSpinner();
		order = new JPanel();
		ganadaB = new JToggleButton();
		gradeB = new JToggleButton();
		movieListSC = new JScrollPane();
		movieList = new JList<>();
		movieInfo = new JPanel();
		resetRe = new JButton();
		movieInfoPoster = new JLabel();
		movieInfoGrade = new JLabel();
		movieInfoName = new JLabel();
		movieInfoRating = new JLabel();
		movieInfoScreen = new JLabel();
		movieInfoDay = new JLabel();
		movieTimeLabel = new JLabel();
		btnAllot = new JButton();
		eastPanel = new JPanel();
		movieInfoScreenName = new JLabel();
		movieInfoDayName = new JLabel();
		timePanel = new JPanel();
		movieInfoStar = new JLabel();
		selCal = new JPanel();
		calSel = new JLabel();
		timeCb = new JComboBox<>();
		allotMovieTimeTheaters = new JPanel();
		lblSelMovieTime = new JLabel();
		movieTimeLabelName = new JLabel();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));

		Main.setBackground(new Color(255, 255, 255));
		Main.setLayout(new AbsoluteLayout());

		allotMovie.setBackground(new Color(218, 210, 180));
		allotMovie.setBorder(BorderFactory.createEtchedBorder());
		allotMovie.setLayout(new AbsoluteLayout());

		labelMovie.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 0, 18)); // NOI18N
		labelMovie.setForeground(new Color(0, 0, 0));
		labelMovie.setText("\uC601\uD654 \uBC30\uC815");
		allotMovie.add(labelMovie, new AbsoluteConstraints(10, 3, 70, 30));

		Main.add(allotMovie, new AbsoluteConstraints(0, 0, 270, 35));

		order.setBackground(new Color(204, 204, 204));
		order.setLayout(new AbsoluteLayout());
		
		bg = new ButtonGroup();
		
		bg.add(gradeB);
		bg.add(ganadaB);
		
		ganadaB.setBackground(new Color(255, 255, 255));
		ganadaB.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 1, 13)); // NOI18N
		ganadaB.setForeground(new Color(0, 0, 0));
		ganadaB.setText("°¡³ª´Ù¼ø");
		ganadaB.setAlignmentY(0.0F);
		ganadaB.setBorder(null);
		ganadaB.setOpaque(false);
		ganadaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ganadaBActionPerformed(evt);
				resetFrame();
			}
		});
		
		order.add(ganadaB, new AbsoluteConstraints(70, 2, 60, 30));

		gradeB.setBackground(new Color(255, 255, 255));
		gradeB.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 1, 13)); // NOI18N
		gradeB.setForeground(new Color(0, 0, 0));
		gradeB.setText("ÆòÁ¡¼ø");
		gradeB.setAlignmentY(0.0F);
		gradeB.setBorder(null);
		gradeB.setOpaque(false);
		gradeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gradeBActionPerformed(evt);
				resetFrame();
			}
		});
		
		order.add(gradeB, new AbsoluteConstraints(2, 2, 60, 30));

		Main.add(order, new AbsoluteConstraints(0, 34, 268, 35));

		movieListSC.setBackground(new Color(255, 255, 255));
		movieListSC.setAlignmentX(0.0F);
		movieListSC.setAlignmentY(0.0F);

		movieList.setBackground(Color.WHITE);
		movieList.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16)); // NOI18N
		
		movieList.setModel(new AbstractListModel<String>() {
			String[] strings = movieMgr.movie_selectAllTitle(true);
			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		
		// ¿µÈ­ ¸®½ºÆ® Å¬¸¯½Ã ¿µÈ­ Á¤º¸ º¯°æ
		movieList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String selection = movieList.getSelectedValue();
					movTitle = selection;
					movieInfoName.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
					if (selection != null) {
						try {
							calFrame.cleanCal();
							MovieInfo movieInfo = movieMgr.movie_selectOneByTitle(selection);
							movieInfoName.setText(selection + " (" + movieInfo.getMovieTimes() + "ºÐ)");
							String strURL = movieInfo.getMoviePoster();
							URL url = new URL(strURL);
							Image image = ImageIO.read(url);
							Image changedImg = image.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
							Icon = new ImageIcon(changedImg);
							movieInfoPoster.setIcon(Icon);
							movieInfoGrade.setText(String.valueOf(movieInfo.getMovieRating()));
							movieInfoDayName.setText("-");
							float rating = movieInfo.getMovieRating();
							
							String ratingPath = "0";
							if (rating >= 0 && rating < 1.5) ratingPath = "0.5"; 
							else if (rating >= 1.5 && rating < 2.5) ratingPath = "1";
							else if (rating >= 2.5 && rating < 3.5) ratingPath = "1.5";
							else if (rating >= 3.5 && rating < 4.5) ratingPath = "2";
							else if (rating >= 4.5 && rating < 5.5) ratingPath = "2.5";
							else if (rating >= 5.5 && rating < 6.5) ratingPath = "3";
							else if (rating >= 6.5 && rating < 7.5) ratingPath = "3.5";
							else if (rating >= 7.5 && rating < 8.5) ratingPath = "4";
							else if (rating >= 8.5 && rating < 9.5) ratingPath = "4.5";
							else if (rating >= 9.5) ratingPath = "5";
							
							Image image2 = ImageIO.read(new File("./files/image/starRating/star" + ratingPath + ".png"));
							Image changedImg2 = image2.getScaledInstance(120, 25, Image.SCALE_SMOOTH);
							Icon2 = new ImageIcon(changedImg2);
							movieInfoStar.setIcon(Icon2);
							TheatersDBManager thMgr = new TheatersDBManager();
							if (thMgr.selectOneMovie(selection).size() == 0) {
								timePanel.setVisible(false);
							}
							// calFrame.setVisible(true);
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
				}
			}
		});
		
		movieList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		movieListSC.setViewportView(movieList);
		movieListSC.setBorder(new LineBorder(Color.BLACK, 1));
		Main.add(movieListSC, new AbsoluteConstraints(1, 70, 269, 269)); // 10, 3, 180, 30

		movieInfo.setBackground(new Color(45, 45, 45));
		movieInfo.setLayout(new AbsoluteLayout());

		resetRe.setFont(new Font("³ª´®½ºÄù¾î", 1, 15)); // NOI18N
		resetRe.setText("\uBC30\uC815 \uB2E4\uC2DC\uD558\uAE30");
		resetRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFrame();
			}
		});
		movieInfo.add(resetRe, new AbsoluteConstraints(10, 10, 130, 30));
		
		try {
			Image image = ImageIO.read(new File(".\\files\\image\\no_poster.png"));
			Image changedImg = image.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
			movieInfoPoster.setIcon(Icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		movieInfoPoster.setOpaque(true);
		movieInfo.add(movieInfoPoster, new AbsoluteConstraints(40, 60, 200, 250));

		movieInfoGrade.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoGrade.setForeground(new Color(255, 0, 0));
		movieInfo.add(movieInfoGrade, new AbsoluteConstraints(205, 350, -1, -1));
		
		movieInfoName.setFont(new Font("³ª´®½ºÄù¾î", 0, 20)); // NOI18N
		movieInfoName.setForeground(new Color(255, 255, 255));
		movieInfoName.setText("¿µÈ­¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä");
		movieInfo.add(movieInfoName, new AbsoluteConstraints(40, 320, -1, -1));

		movieInfoRating.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoRating.setForeground(new Color(255, 0, 0));
		movieInfoRating.setText("\uD3C9\uC810");
		movieInfo.add(movieInfoRating, new AbsoluteConstraints(40, 350, -1, -1));

		movieInfoScreen.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoScreen.setForeground(new Color(255, 255, 255));
		movieInfoScreen.setText("\uADF9\uC7A5");
		movieInfo.add(movieInfoScreen, new AbsoluteConstraints(40, 380, -1, -1));

		movieInfoDay.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoDay.setForeground(new Color(255, 255, 255));
		movieInfoDay.setText("³¯Â¥");
		movieInfo.add(movieInfoDay, new AbsoluteConstraints(40, 410, -1, -1));
		
		movieTimeLabel.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieTimeLabel.setForeground(new Color(255, 255, 255));
		movieTimeLabel.setText("½Ã°£");
		movieInfo.add(movieTimeLabel, new AbsoluteConstraints(40, 440, -1, -1));

		btnAllot.setFont(new Font("³ª´®½ºÄù¾î", 1, 24)); // NOI18N
		btnAllot.setText("\uBC30\uC815 \uD558\uAE30");
		btnAllot.setOpaque(true);
		btnAllot.setBackground(new Color(255, 255, 255));
		btnAllot.setEnabled(false);
		btnAllot.addActionListener(new ActionListener() {
			// ¹èÁ¤ÇÏ±â
			@Override
			public void actionPerformed(ActionEvent e) {
				MovieInfo movieInfo = movieMgr.movie_selectOneByTitle(movTitle);
				Theaters th = new Theaters(0, movieInfoScreenName.getText(), movTitle, movieInfo.getMoviePoster(), movDate, 
						movieTimeLabelName.getText().substring(0, 5), movieTimeLabelName.getText().substring(8, 13));
				TheatersDBManager thMgr = new TheatersDBManager();
				thMgr.insertNewScreen(th);
				JOptionPane.showMessageDialog(null, "¹èÁ¤ÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
				showTableDB(String.valueOf(cb1.getSelectedItem()));
			}
		});
		movieInfo.add(btnAllot, new AbsoluteConstraints(50, 540, 190, -1));
		
		movieInfoScreenName.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoScreenName.setForeground(new Color(255, 255, 255));
		movieInfoScreenName.setText("-");
		movieInfo.add(movieInfoScreenName, new AbsoluteConstraints(80, 380, -1, -1));

		movieInfoDayName.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoDayName.setForeground(new Color(255, 255, 255));
		movieInfoDayName.setText("-");
		movieInfo.add(movieInfoDayName, new AbsoluteConstraints(80, 410, -1, -1));
		
		movieTimeLabelName.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieTimeLabelName.setForeground(new Color(255, 255, 255));
		movieTimeLabelName.setText("-");
		movieInfo.add(movieTimeLabelName, new AbsoluteConstraints(80, 440, -1, -1));

		Main.add(movieInfo, new AbsoluteConstraints(730, 0, 280, 610));

		selCal.setBackground(new Color(218, 210, 180));
		selCal.setBorder(BorderFactory.createEtchedBorder());
		selCal.setLayout(new AbsoluteLayout());

		calSel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 0, 18)); // NOI18N
		calSel.setForeground(new Color(0, 0, 0));
		calSel.setText("´Þ·Â ¼±ÅÃ");
		selCal.add(calSel, new AbsoluteConstraints(10, 3, 70, 30));

		Main.add(selCal, new AbsoluteConstraints(270, 0, 460, 35));
		
		bgAdult = new ButtonGroup();
		
		allotMovieTimeTheaters.setBackground(new Color(218, 210, 180));
		allotMovieTimeTheaters.setBorder(BorderFactory.createEtchedBorder());
		allotMovieTimeTheaters.setLayout(new AbsoluteLayout());
		
		lblSelMovieTime.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 0, 18)); // NOI18N
		lblSelMovieTime.setForeground(new Color(0, 0, 0));
		lblSelMovieTime.setText("\uBC30\uC815 \uAC00\uB2A5\uD55C \uADF9\uC7A5\uACFC \uC2DC\uAC04");
		allotMovieTimeTheaters.add(lblSelMovieTime, new AbsoluteConstraints(10, 3, 180, 30));
		
		movieInfoStar.setBackground(new Color(255, 255, 255));
		movieInfoStar.setAlignmentY(0.0F);
		try {
			Image image = ImageIO.read(new File("./files/image/starRating/star0.png"));
			Image changedImg = image.getScaledInstance(120, 25, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
			movieInfoStar.setIcon(Icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		movieInfo.add(movieInfoStar, new AbsoluteConstraints(78, 347, 120, 25));
		
		setFrame();
		Main.add(allotMovieTimeTheaters, new AbsoluteConstraints(1, 340, 730, 35));
		timePanel.setBackground(new Color(255, 255, 255));
        // timePanel.setAlignmentX(0.0F);
        // timePanel.setAlignmentY(0.0F);
		timePanel.setBorder(new LineBorder(Color.BLACK, 1));
		// timePanel.setLayout(new GridLayout(1, 0));
		// timePanel.setLayout(new GridLayout(0, 1));
        Main.add(timePanel, new AbsoluteConstraints(1, 375, 728, 235));
        timePanel.setLayout(null);
        timePanel.setVisible(false);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(2, 2, 371, 232);
        timePanel.add(tablePanel);
        tablePanel.setLayout(new BorderLayout(0, 0));
        
        JPanel westPanel = new JPanel();
        tablePanel.add(westPanel, BorderLayout.NORTH);
        westPanel.setLayout(new BorderLayout(0, 0));
        
        north = new JPanel();
        westPanel.add(north);
        north.setLayout(new BorderLayout(0, 0));
        
        wnIn = new JPanel();
        north.add(wnIn, BorderLayout.EAST);
        
        lb1 = new JLabel("\uADF9\uC7A5 \uC120\uD0DD");
        lb1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
        lb1.setHorizontalAlignment(SwingConstants.CENTER);
        wnIn.add(lb1);
        
        cb1 = new JComboBox();
        cb1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnAllot.setEnabled(false);
        		showTableDB(String.valueOf(cb1.getSelectedItem()));
        		createHourList();
        		ArrayList<String> movSHrList = thMgr.selectMovieStart((String)cb1.getSelectedItem(), movDate);
        		ArrayList<String> movEHrList = thMgr.selectMovieEnd((String)cb1.getSelectedItem(), movDate);
        		timeHashList = new LinkedHashMap<>();
        		timeCb.removeAllItems();
        		for (int i = 0; i < movSHrList.size(); i++) {
        			for (int j = 0; j < hourList.size(); j++) {
        				String temp = movSHrList.get(i).substring(0, 2);
        				if (hourList.get(j).equals(temp)) {
        					String[] tempList = new String[2];
        					tempList[0] = movSHrList.get(i);
        					tempList[1] = movEHrList.get(i);
        					timeHashList.put(String.valueOf(j), tempList);
        					break;
        				}
					}
                }
                for (int i = 0; i < hourList.size(); i++) {
					timeCb.addItem(hourList.get(i));
				}
                
        		eastPanel.setVisible(true);
        		cb2.setSelectedItem(cb1.getSelectedItem());
        	}
        	
        	public String getKeyFromValue(LinkedHashMap<String, String[]> map, String[] value) {
				for (String key : map.keySet()) {
					if (map.get(key).equals(value)) {
						return key;
					}
				}
				return "";
			}
        	
        });
        cb1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
        cb1.setModel(new DefaultComboBoxModel(new String[] {"1\uAD00", "2\uAD00", "3\uAD00", "4\uAD00", "5\uAD00"}));
        wnIn.add(cb1);
        
        inTxtLb = new JLabel("\uAC01 \uADF9\uC7A5\uC5D0 \uBC30\uC815\uC911\uC778 \uC601\uD654 \uB9AC\uC2A4\uD2B8");
        inTxtLb.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
        north.add(inTxtLb, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        eastPanel.setBounds(374, 2, 354, 233);
        timePanel.add(eastPanel);
        eastPanel.setLayout(new BorderLayout(0, 0));
        
        eastNorth = new JPanel();
        eastPanel.add(eastNorth, BorderLayout.NORTH);
        eastNorth.setLayout(new BorderLayout(0, 0));
        
        enIn = new JPanel();
        eastNorth.add(enIn, BorderLayout.EAST);
        
        lb2 = new JLabel("\uADF9\uC7A5 \uC120\uD0DD");
        lb2.setHorizontalAlignment(SwingConstants.CENTER);
        lb2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
        enIn.add(lb2);
        
        cb2 = new JComboBox();
        cb2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnAllot.setEnabled(false);
        		timeArrayList = createHourList();
        		showTableDB(String.valueOf(cb2.getSelectedItem()));
        		ArrayList<String> movSHrList = thMgr.selectMovieStart((String)cb2.getSelectedItem(), movDate);
        		ArrayList<String> movEHrList = thMgr.selectMovieEnd((String)cb2.getSelectedItem(), movDate);
        		timeHashList = new LinkedHashMap<>();
        		timeArrayWithOutList = new ArrayList<>();
        		timeCb.removeAllItems();
        		for (int i = 0; i < movSHrList.size(); i++) {
        			String[] tempList = new String[2];
        			String temp = movSHrList.get(i).substring(0, 2);
        			tempList[0] = movSHrList.get(i);
        			tempList[1] = movEHrList.get(i);
        			timeHashList.put(String.valueOf(i), tempList);
        			for (int j = 0; j < hourList.size(); j++) {
        				if (hourList.get(j).equals(temp)) {
        					hourList.remove(j);
                		}
					}
                }
                for (int i = 0; i < hourList.size(); i++) {
					timeCb.addItem(hourList.get(i));
				}
                
                for (int i = 0; i < movSHrList.size(); i++) {
        			for (int j = 0; j < timeArrayList.size(); j++) {
        				String temp = movSHrList.get(i).substring(0, 2);
        				if (timeArrayList.get(j).equals(temp)) {
        					// timeArrayList.add(String.valueOf(j));
        					timeArrayWithOutList.add(j);
        					String[] tempList = new String[2];
        					tempList[0] = movSHrList.get(i);
        					tempList[1] = movEHrList.get(i);
        					timeHashList.put(String.valueOf(j), tempList);
        					break;
        				}
					}
                }
        	}
        	public String getKeyFromValue(LinkedHashMap<String, String[]> map, String[] value) {
				for (String key : map.keySet()) {
					if (map.get(key).equals(value)) {
						return key;
					}
				}
				return "";
			}
        });
        cb2.setModel(new DefaultComboBoxModel(new String[] {"1\uAD00", "2\uAD00", "3\uAD00", "4\uAD00", "5\uAD00"}));
        cb2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
        enIn.add(cb2);
        
        lb3 = new JLabel("\uBC30\uC815\uD560 \uADF9\uC7A5\uACFC \uC2DC\uAC04 \uC120\uD0DD");
        lb3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
        eastNorth.add(lb3, BorderLayout.WEST);
        
        eastCenter = new JPanel();
        eastPanel.add(eastCenter, BorderLayout.CENTER);
        eastCenter.setLayout(null);
        
        timeCb = new JComboBox();
        timeCb.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 22));
        timeCb.setBounds(22, 78, 55, 33);
        eastCenter.add(timeCb);
        
        JLabel lblNewLabel = new JLabel("\uC601\uD654 \uC2DC\uC791 \uC2DC\uAC04 \uC785\uB825");
        lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 25));
        lblNewLabel.setBounds(12, 33, 244, 35);
        eastCenter.add(lblNewLabel);
        
        timeMin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        timeMin.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
        timeMin.setBounds(103, 79, 55, 33);
        eastCenter.add(timeMin);
        
        JButton btnNewButton = new JButton("\uC2DC\uAC04 \uC801\uC6A9");
        btnNewButton.addActionListener(new ActionListener() {
        	// ½Ã°£ Àû¿ë
        	public void actionPerformed(ActionEvent e) {
        		String timeHour = String.valueOf(timeCb.getSelectedItem());
        		String temp = String.valueOf(timeMin.getValue());
        		String timeMinStr = String.format("%02d", Integer.parseInt(temp));
        		
        		MovieInfo mov = movieMgr.movie_selectOneByTitle(movTitle);
				int movHour = (mov.getMovieTimes() / 60);
				int movMin = mov.getMovieTimes() - (movHour * 60);
				
				int sumHour = movHour + Integer.parseInt(timeHour);
				int sumMin = movMin + Integer.parseInt(temp);
				
				if (sumMin >= 60) {
					sumMin -= 60;
					sumHour++;
				}
				if (sumHour >= 24) {
					sumHour -= 24;
				}
				String movHourStr = String.format("%02d", sumHour);
				String movMinStr = String.format("%02d", sumMin);
				
				movieInfoScreenName.setText(String.valueOf(cb2.getSelectedItem()));
				movieTimeLabelName.setText(timeHour + ":" + timeMinStr + " ~ " + movHourStr + ":" + movMinStr);
				btnAllot.setEnabled(true);
			}
        });
        btnNewButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
        btnNewButton.setBounds(170, 78, 97, 33);
        eastCenter.add(btnNewButton);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Main, GroupLayout.PREFERRED_SIZE,
				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Main, GroupLayout.DEFAULT_SIZE,
				GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		
		pack();
		mov = this;
		
	}// </editor-fold>
	
	private void ganadaBActionPerformed(ActionEvent evt) {
		movieList.setModel(new AbstractListModel<String>() {
			String[] strings = movieMgr.movie_selectAllTitle(false);
			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});	
	}

	private void gradeBActionPerformed(ActionEvent evt) {
		movieList.setModel(new AbstractListModel<String>() {
			String[] strings = movieMgr.movie_selectAllTitle(true);
			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			System.setProperty("awt.useSystemAAFontSettings", "on");
			System.setProperty("swing.aatext", "true");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Admin().setVisible(true);
			}
		});
		OracleDBUtil.closeDB();
	}
	
	// ±ØÀå ½Ã°£ ¼±ÅÃ -> ´Þ·ÂÃ¼Å©
	public void setTheaters() {
		Calendar today = Calendar.getInstance();
		// JPanel timeBtPanel = new JPanel();
		timeBtPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		timeList = thMgr.selectOneMovieStartByName(movTitle, movDate);
		String[] keyList = timeList.keySet().toArray(new String[timeList.size()]);
		for (int i = 0; i < keyList.length; i++) {
			JLabel lbt = new JLabel();
			lbt.setVisible(true);
			lbt.setOpaque(true);
			lbt.setBackground(Color.BLACK);
			lbt.setPreferredSize(new Dimension(469, 0));
			ArrayList<String> tempList = timeList.get(keyList[i]);
			JLabel lb = new JLabel(keyList[i]);
			lb.setVisible(true);
			lb.setFont(new Font("³ª´®¹Ù¸¥½ºÄù¾î", 0, 18));
			lb.setPreferredSize(new Dimension(30, 30));
			lb.setLayout(new FlowLayout(FlowLayout.LEFT));
			timeBtPanel.add(lb);
			timeBtPanel.add(lbt);
			JLabel lbt2 = new JLabel();
			lbt2.setVisible(true);
			lbt2.setPreferredSize(new Dimension(469, 0));
			for (int j = 0; j < tempList.size(); j++) {
				int todayHourInt = today.get(Calendar.HOUR_OF_DAY) * 60 + today.get(Calendar.MINUTE);
				int movieDate = Integer.parseInt(tempList.get(j).substring(0, 2)) * 60
						+ Integer.parseInt(tempList.get(j).substring(3, 5));
				JButton btn = new JButton(tempList.get(j));
				btn.setVisible(true);
				
				if (movDate.getDay() == today.getTime().getDay() && todayHourInt >= movieDate) {
					btn.setEnabled(false);
				}
				// btn.setBorder(new EmptyBorder(0, 10, 0, 10));
				btn.setMargin(new Insets(0, 0, 0, 0)); // top left bottom right
				btn.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 0, 12));
				btn.setPreferredSize(new Dimension(65, 30));
				btn.addActionListener(new ActionListener() {
					public String getKeyFromValue(LinkedHashMap<String, ArrayList<String>> map,
							ArrayList<String> value) {
						for (String key : map.keySet()) {
							if (map.get(key).equals(value)) {
								return key;
							}
						}
						return "";
					}

					@Override
					public void actionPerformed(ActionEvent e) {
						movieInfoScreenName.setText(getKeyFromValue(timeList, tempList));
						timeAddMovie();
					}

					// ½Ã°£ ´Ã¸®±â
					public void timeAddMovie() {
						MovieInfo mov = movieMgr.movie_selectOneByTitle(movTitle);
						int hour = Integer.parseInt(btn.getText().substring(0, 2));
						int min = Integer.parseInt(btn.getText().substring(3, 5));
						int movHour = (mov.getMovieTimes() / 60);
						int movMin = mov.getMovieTimes() - (movHour * 60);
						String startTime = String.format("%02d:%02d", hour, min);

						hour += movHour;
						min += movMin;
						if (min >= 60) {
							min -= 60;
							hour++;
						}
						if (hour >= 24) {
							hour -= 24;
						}
						String addTime = String.format("%02d:%02d", hour, min);
					}
				});
				timeBtPanel.add(btn);
			}
			timeBtPanel.add(lbt2);
		}
		timeBtPanel.setBackground(Color.WHITE);
		timeBtPanel.setBorder(null);
		timeBtPanel.setAlignmentX(0);
		timeBtPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));
		// timeBtPanel.setLayout(new GridLayout(5, 3, 5, 5));
		timeBtPanel.setVisible(true);
		timePanel.add(timeBtPanel);
	}
	
	public void setJlistValue(String title) {
		movieList.setSelectedValue(title, false);
	}
	
	// Variables declaration - do not modify
	private JPanel Main;
	private JLabel calSel;
	private JToggleButton ganadaB;
	private JToggleButton gradeB;
	private JButton btnAllot;
	private JLabel labelMovie;
	private JLabel lblSelMovieTime;
	private JPanel movieInfo;
	public JLabel movieInfoDayName;
	public JLabel movieInfoScreenName;
	public JList<String> movieList;
	public JScrollPane movieListSC;
	public JLabel movieInfoGrade;
	public JLabel movieInfoName;
	public JLabel movieInfoRating;
	public JLabel movieInfoScreen;
	public JLabel movieInfoDay;
	public JLabel movieInfoPoster;
	public JLabel movieInfoStar;
	public JComboBox timeCb;
	public JPanel order;
	public JButton resetRe;
	public JPanel selCal;
	public JPanel allotMovie;
	public JPanel allotMovieTimeTheaters;
	public JPanel timePanel;
	private JPanel north;
	public JLabel movieTimeLabel;
	public JLabel movieTimeLabelName;
	private JPanel wnIn;
	private JLabel lb1;
	private JComboBox cb1;
	private JLabel inTxtLb;
	private JTable table;
	private JPanel eastNorth;
	private JPanel enIn;
	private JLabel lb2;
	private JComboBox cb2;
	public JSpinner timeMin;
	private JLabel lb3;
	private JPanel eastCenter;
	public JPanel eastPanel;
}