package swinglib.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageUtils {
	public static Image getImage(InputStream stream) {
		try {
			return Toolkit.getDefaultToolkit().createImage(ImageIO.read(stream).getSource());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Image getImage(File file) {
		try {
			return Toolkit.getDefaultToolkit().createImage(ImageIO.read(file).getSource());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Image getImage(BufferedImage b) {
		return Toolkit.getDefaultToolkit().createImage(b.getSource());
	}

	public static BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}
		BufferedImage buff = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D gr = buff.createGraphics();
		gr.drawImage(img, 0, 0, null);
		gr.dispose();
		return buff;
	}

	public static Image setFitCenter(Image img, int w, int h) {
		BufferedImage buf = toBufferedImage(img);
		return buf.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	}

	public static Image roundImage(Image img, int radius) {
		int w = img.getWidth(null);
		int h = img.getHeight(null);
		BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = output.createGraphics();

		g2.setComposite(AlphaComposite.Src);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.WHITE);
		g2.fill(new RoundRectangle2D.Float(0, 0, w, h, radius, radius));

		g2.setComposite(AlphaComposite.SrcAtop);
		g2.drawImage(img, 0, 0, null);

		g2.dispose();
		return Toolkit.getDefaultToolkit().createImage(output.getSource());
	}

	public static Image addBlur(Image img) {
		return addBlur(toBufferedImage(img));
	}

	public static Image addBlur(InputStream stream) {
		try {
			return addBlur(ImageIO.read(stream));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Image addBlur(BufferedImage input) {
		try {
			BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), BufferedImage.TYPE_INT_RGB);

			int i = 0;
			int max = 400, rad = 10;
			int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
			Color color[] = new Color[max];

			int x = 1, y = 1, x1, y1, ex = 5, d = 0;

			for (x = rad; x < input.getHeight() - rad; x++) {
				for (y = rad; y < input.getWidth() - rad; y++) {
					for (x1 = x - rad; x1 < x + rad; x1++) {
						for (y1 = y - rad; y1 < y + rad; y1++) {
							color[i++] = new Color(input.getRGB(y1, x1));
						}
					}

					i = 0;
					for (d = 0; d < max; d++) {
						if (color[d] != null) {
							a1 = a1 + color[d].getAlpha();
						}
					}

					a1 = a1 / (max);
					for (d = 0; d < max; d++) {
						if (color[d] != null) {
							r1 = r1 + color[d].getRed();
						}
					}

					r1 = r1 / (max);
					for (d = 0; d < max; d++) {
						if (color[d] != null) {
							g1 = g1 + color[d].getGreen();
						}
					}

					g1 = g1 / (max);
					for (d = 0; d < max; d++) {
						if (color[d] != null) {
							b1 = b1 + color[d].getBlue();
						}
					}

					b1 = b1 / (max);
					int sum1 = (a1 << 24) + (r1 << 16) + (g1 << 8) + b1;
					output.setRGB(y, x, (int) (sum1));
				}
			}
			return Toolkit.getDefaultToolkit().createImage(output.getSource());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
