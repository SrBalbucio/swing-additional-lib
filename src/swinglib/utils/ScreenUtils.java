package swinglib.utils;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ScreenUtils {
	
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private static GraphicsDevice device = graphics.getDefaultScreenDevice();

    /**
     * Use esse método para pegar uma Dimensão para Window baseada na ScreenSize
     * Exemplo: Você quer uma janela com metade do tamanho da tela, use esse método com o int 2
     * @param i
     * @return
     */
    public static Dimension getSizeBeforeTheScreen(int i){
        Dimension dimension = new Dimension((screenSize.width / i), (screenSize.height / i));
        return dimension;
    }
    

    /**
     * Use este método para deixar um frame em Tela Cheia (alguns frames podem ficar bugados)
     * @param frame Frame a deixar em fullscreen
     */
    public static void setFullScreen(JFrame frame) {
    	device.setFullScreenWindow(frame);
    }

}
