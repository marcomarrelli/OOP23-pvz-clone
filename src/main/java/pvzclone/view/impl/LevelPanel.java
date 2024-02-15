package pvzclone.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LevelPanel extends GenericPanel {
    private static final int LAYOUT_HGAP = 20;
    private static final int LAYOUT_VGAP = 50;
    private static final String BUTTON_TEXTURE = "/images/tombstoneTexture.jpg";
    private static final Dimension MENU_BUTTON_DIMENSION = new Dimension(
            SwingViewImpl.APPLICATION_WIDTH / 6, SwingViewImpl.APPLICATION_HEIGHT / 8
    );
    private final SwingViewImpl parent;
    private final int levelCount;

    /**
     * Level Panel Constructor.
     * 
     * @param parent           the application's view.
     * @param backgroundSource the background image source.
     * @see {@link GenericPanel}
     */
    public LevelPanel(SwingViewImpl parent, String backgroundSource) {
        super(parent, backgroundSource);
        this.parent = parent;
        this.setLayout(
                new FlowLayout(FlowLayout.CENTER, LAYOUT_HGAP, SwingViewImpl.APPLICATION_HEIGHT / 2 - LAYOUT_VGAP));
        final ImageIcon texture = new ImageIcon(getClass().getResource(BUTTON_TEXTURE));

        this.levelCount = this.parent.getController().getLevelCount();

        if (this.levelCount <= 0) {
            throw new IllegalStateException("There are no valid levels to load!");
        }

        for(int i=0; i<this.levelCount; i++) {
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
    }

    /**
     * Used for {@link pvzclone.view.impl.GenericPanel#update(Graphics)}.
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.getBackgroundImage(), 0, 0, null);
    }
}
