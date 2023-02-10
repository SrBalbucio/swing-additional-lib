package swinglib.components;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;

import javax.swing.JPanel;

import swinglib.utils.ImageUtils;

public class JPanelWithBackground extends JPanel{
	
    private Image backgroundImage;

    public JPanelWithBackground(InputStream file, boolean blur) {
        backgroundImage = blur ? ImageUtils.addBlur(file) : ImageUtils.getImage(file);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0,this.getWidth(), this.getHeight(), this);
    }

}
