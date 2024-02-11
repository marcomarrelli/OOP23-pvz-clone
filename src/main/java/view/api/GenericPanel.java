package view.api;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.impl.SwingViewImpl;

/**
 * Abstract class for Panels, with a pre-setted Constructor.
 * 
 * @author Marco Marrelli
 */
public abstract class GenericPanel extends JPanel {
    protected final SwingViewImpl parent;
    protected Image background;
    
    /**
     * Panel Constructor.
     * 
     * @param parent The Application View.
     * @param backgroundSource The Panel Background.
     */
    public GenericPanel(SwingViewImpl parent, String backgroundSource) {
        this.parent = parent;
        this.setBackground(Color.BLACK);
        this.setSize(SwingViewImpl.APPLICATION_WIDTH, SwingViewImpl.APPLICATION_HEIGHT);
        this.background = new ImageIcon(getClass().getResource(backgroundSource)).getImage();
    }
}
