package pvzclone.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Panel used to choose the level at the start of the application.
 * 
 * @author Sofia Caberletti.
 */

@SuppressFBWarnings(value = {
        "EI_EXPOSE_REP2"
}, justification = "parent is intended to be modified")
public class LevelPanel extends GenericPanel {
    private static final long serialVersionUID = 1234500003L;

    private static final int FONT_SIZE = 24;
    private static final int LAYOUT_HGAP = 20;
    private static final int LAYOUT_VGAP = 50;
    private static final String BUTTON_TEXTURE = "src/main/resources/images/tombstoneTexture.jpg";
    private static final Dimension MENU_BUTTON_DIMENSION = new Dimension(
            SwingViewImpl.APPLICATION_WIDTH / 6, SwingViewImpl.APPLICATION_HEIGHT / 8);
    private final transient SwingViewImpl parent;

    /**
     * Level Panel Constructor.
     * 
     * @param parent           the application's view.
     * @param backgroundSource the background image source.
     * @see GenericPanel
     */
    public LevelPanel(final SwingViewImpl parent, final String backgroundSource) {
        super(parent, backgroundSource);
        this.parent = parent;
        final int levelCount = this.parent.getController().getLevelCount();

        if (levelCount <= 0) {
            throw new IllegalStateException("There are no valid levels to load!");
        }

        this.setLayout(new FlowLayout(FlowLayout.CENTER, LAYOUT_HGAP,
                SwingViewImpl.APPLICATION_HEIGHT / 2 - LAYOUT_VGAP));
        final ImageIcon texture = new ImageIcon(BUTTON_TEXTURE);

        for (int i = 0; i < levelCount; i++) {
            final int numberOfTheLevel = i;
            final JButton button = new JButton(String.valueOf(numberOfTheLevel + 1), texture);
            this.setButton(button);
            button.addActionListener(e -> {
                this.parent.getController().chooseLevel(numberOfTheLevel);
                this.parent.setScene(SwingViewImpl.MENU_PANEL_CONSTRAINT);
            });
            this.add(button);
        }
    }

    /**
     * Sets a Button's settings.
     * 
     * @param button the chosen button.
     */
    private void setButton(final JButton button) {
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setPreferredSize(MENU_BUTTON_DIMENSION);
        button.setFont(new Font(this.getFont().getName(), Font.BOLD, FONT_SIZE));
        button.setForeground(Color.BLACK);
    }

    /**
     * Used for {@link pvzclone.view.impl.GenericPanel#update(Graphics)}.
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        if (g instanceof Graphics2D) {
            final Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(this.getBackgroundImage(), 0, 0, null);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
