package swinglib.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.swing.JPanel;

import swinglib.utils.ImageUtils;

public class JImage extends JPanel {

	private Image image;
	private boolean center;
	private boolean blur = false;

	public JImage(BufferedImage img, boolean center) {
		image = ImageUtils.getImage(img);
		this.center = center;
	}

	public JImage(InputStream stream, boolean center) {
		try {
			image = ImageUtils.getImage(stream);
			this.center = center;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JImage(String path, boolean center) {
		image = Toolkit.getDefaultToolkit().getImage(path);
		this.center = center;
	}
	
	public void setBlur(boolean blur) {
		this.blur = blur;
	}
	
	public boolean getBlur() {
		return blur;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setBackground(new Color(0, 0, 0, 0));
		if (image != null) {
			if (!center) {
				g2.drawImage(image, 0, 0, this);
			} else {
				g2.drawImage(image, (this.getWidth() / 2 - (image.getWidth(this) / 2)),
						(this.getHeight() / 2 - (image.getHeight(this) / 2)), this);
			}
		}

	}
}
