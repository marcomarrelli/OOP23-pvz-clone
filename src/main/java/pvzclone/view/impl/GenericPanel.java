package pvzclone.view.impl;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Abstract class for Panels, with a pre-setted Constructor.
 */
@SuppressFBWarnings(value = {
        "EI_EXPOSE_REP"
}, justification = "parent is intended to be modified")
public abstract class GenericPanel extends JPanel {
    private static final long serialVersionUID = 1234500000L;

    /** The View Implementation. */
    private final SwingViewImpl parent;

    /** The Image for the Panel's Background. */
    private final Image background;

    /**
     * Panel Constructor.
     * 
     * @param parent           The Application View.
     * @param backgroundSource The Panel Background.
     */
    public GenericPanel(final SwingViewImpl parent, final String backgroundSource) {
        this.parent = parent;
        this.background = new ImageIcon(ClassLoader.getSystemResource(backgroundSource)).getImage();
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setSize(SwingViewImpl.APPLICATION_WIDTH, SwingViewImpl.APPLICATION_HEIGHT);
    }

    /**
     * View Getter. Returns the View (Parent).
     * 
     * @return the view.
     */
    public SwingViewImpl getView() {
        return this.parent;
    }

    /**
     * Background Getter. Returns the BackgroundImage.
     * 
     * @return the background image of the panel.
     */
    public Image getBackgroundImage() {
        return new ImageIcon(this.background.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT))
                .getImage();
    }
}
