package MovieList;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.MovieInfo;
import ui.movieMain.MovieMainFrame;
import ui.movieMain.MoviePosterInfo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Info extends JLabel {
	private MovieInfo mo;
	private ImageIcon Icon;
	private ImageIcon Icon2;
	private Image image2;
	/**
	 * Create the panel.
	 */
	public Info(MovieInfo mo) {
		this.mo = mo;
		setLayout(new BorderLayout(0, 0));
		// TODO 영화 리스트
		
		String strURL = mo.getMoviePoster();
		//System.out.println(strURL);
		try {
			URL url = new URL(strURL);
			Image image = ImageIO.read(url);
			Image changedImg = image.getScaledInstance(200, 235, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel lblPosterImage = new JLabel(Icon);
		lblPosterImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<MovieInfo> mf = MovieMainFrame.mf;
				if(e.getSource() == lblPosterImage) {
					for (int i = 0; i < mf.size(); i++) {
						if(mo.getMovieNo() == i+1) {
							MovieInfo selNum = mf.get(i);
							MoviePosterInfo movInfo = new MoviePosterInfo(selNum);
							movInfo.setVisible(true);
						}
					}
				}
			}
		});
		lblPosterImage.setToolTipText("\uD074\uB9AD\uC2DC \uC608\uB9E4 \uBC0F \uC0C1\uC138\uBCF4\uAE30");
		lblPosterImage.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPosterImage);
		// TODO 영화 평점
		float rating = mo.getMovieRating();
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
		try {
			image2 = ImageIO.read(new File("./files/image/starRating/star" + ratingPath + ".png"));
			Image changedImg2 = image2.getScaledInstance(95, 25, Image.SCALE_SMOOTH);
			Icon2 = new ImageIcon(changedImg2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel lblRating = new JLabel(Icon2);
		lblRating.setOpaque(true);
		lblRating.setBackground(Color.BLACK);
		lblRating.setText("평점 "+mo.getMovieRating());
		lblRating.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		lblRating.setForeground(Color.WHITE);
		//lblRating.setIcon(Icon2);
		add(lblRating, BorderLayout.SOUTH);
		
		
	}

}
