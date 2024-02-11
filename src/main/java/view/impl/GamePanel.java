package view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import model.impl.FieldCell;
import model.impl.Pair;
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
    private final int X_MARGIN = 20/2;
    private final int Y_MARGIN = 30/2;

    private final int CELL_WIDTH = X_OFFSET-X_MARGIN;
    private final int CELL_HEIGHT = Y_OFFSET-Y_MARGIN;

    private final int STARTING_X = 225;
    private final int STARTING_Y = 120;

    private FieldCell[][] fieldMatrix = new FieldCell[ROW_COUNT][COLUMN_COUNT];


    /**
     * GamePanel Constructor
     * 
     * @see {@link GenericPanel}
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public GamePanel(SwingViewImpl parent, String backgroundSource) {
        super(parent, backgroundSource);
        
        for(int i=0; i<ROW_COUNT; i++) {
            for(int j=0; j<COLUMN_COUNT; j++) {
                fieldMatrix[i][j] = new FieldCell(new Pair(i, j));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.background, 0, 0, null);
    }
}
