package pvzclone.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Panel used in the starting Menu Section.
 */
@SuppressFBWarnings(value = {
        "DM_EXIT",
        "EI_EXPOSE_REP2"
}, justification = "when button exit is clicked it needs to shut down"
        + "parent is intended to be modified")
public class MenuPanel extends GenericPanel {
    private static final long serialVersionUID = 1234500001L;

    private static final int LAYOUT_HGAP = 20;
    private static final int LAYOUT_VGAP = 50;
    private static final String BUTTON_TEXTURE = "images/tombstoneTexture.jpg";
    private static final Dimension MENU_BUTTON_DIMENSION = new Dimension(
            SwingViewImpl.APPLICATION_WIDTH / 6, SwingViewImpl.APPLICATION_HEIGHT / 8);
    private final transient SwingViewImpl parent;

    /**
     * Menu Panel Constructor.
     * 
     * @param parent           the application's view.
     * @param backgroundSource the background image source.
     * @see GenericPanel
     */
    public MenuPanel(final SwingViewImpl parent, final String backgroundSource) {
        super(parent, backgroundSource);
        this.parent = parent;
        this.setLayout(
                new FlowLayout(FlowLayout.CENTER, LAYOUT_HGAP, SwingViewImpl.APPLICATION_HEIGHT / 2 - LAYOUT_VGAP));
        final ImageIcon texture = new ImageIcon(ClassLoader.getSystemResource(BUTTON_TEXTURE));

        final JButton levelButton = new JButton("Choose Level", texture);
        final JButton startButton = new JButton("Start Adventure", texture);
        final JButton exitButton = new JButton("Exit Game", texture);

        this.setButton(levelButton);
        this.setButton(startButton);
        this.setButton(exitButton);

        startButton.setEnabled(false);

        startButton.addActionListener(e -> {
            if (this.parent.getController().getChosenLevel().isPresent()) {
                this.parent.setScene(SwingViewImpl.GAME_PANEL_CONSTRAINT);
                this.parent.getController().callMainloop();
            }
        });
        levelButton.addActionListener(e -> {
            this.parent.setScene(SwingViewImpl.LEVEL_PANEL_CONSTRAINT);
            startButton.setEnabled(true);
        });
        exitButton.addActionListener(e -> {
            final int n = JOptionPane.showConfirmDialog(this, "Do you really want to quit?",
                    "Quitting", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        this.add(levelButton);
        this.add(startButton);
        this.add(exitButton);
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
        button.setFont(new Font(null, Font.BOLD, 16));
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
