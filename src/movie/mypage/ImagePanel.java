package movie.mypage;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image bgImg;
	private String imgPath;
	private int w;
	private int h;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if( this.bgImg != null ) {
			g.drawImage(this.bgImg, 0, 0, this);
		}
	}
	
	public Image getBgimg() {
		return bgImg;
	}

	public void setBgimg(Image bgimg) {
		this.bgImg = bgimg;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public ImagePanel() {

	}

	public ImagePanel(Image img) {
		bgImg = img;
	}
	
	public ImagePanel(Image img, String imgPath) {
		bgImg = img;
		this.imgPath = imgPath;
		this.w = bgImg.getWidth(this);
		this.h = bgImg.getHeight(this);
		System.out.println("ImagePanel:: w = " + w + ", h = " + h );
	}
}
