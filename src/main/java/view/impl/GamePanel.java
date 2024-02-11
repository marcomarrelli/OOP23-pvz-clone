package view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import view.api.GenericPanel;

/**
 * Panel used in the Gameplay Section.
 * 
 * @author Marco Marrelli
 */
public class GamePanel extends GenericPanel {
    private final int ROW_COUNT = 5;
    private final int COLUMN_COUNT = 9; 
    
    private final int X_OFFSET = 70;
    private final int Y_OFFSET = 110;
    private final int X_MARGIN = 20;
    private final int Y_MARGIN = 30;

    private final int CELL_WIDTH = X_OFFSET-X_MARGIN;
    private final int CELL_HEIGHT = Y_OFFSET-Y_MARGIN;

    private final int STARTING_X = 225;
    private final int STARTING_Y = 120;

    /**
     * GamePanel Constructor
     * 
     * @see {@link GenericPanel}
     */
    public GamePanel(SwingViewImpl parent, String backgroundSource) {
        super(parent, backgroundSource);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.background, 0, 0, null);
    }
}
