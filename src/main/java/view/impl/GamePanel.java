package view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import model.api.Bullet;
import model.api.Plant;
import model.api.Sun;
import model.api.Zombie;
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
    
    private static final int X_OFFSET = 70;
    private static final int Y_OFFSET = 110;
    public static final int X_MARGIN = 10; // 20/2
    public static final int Y_MARGIN = 15; // 30/2

    public static final int CELL_WIDTH = X_OFFSET-X_MARGIN;
    public static final int CELL_HEIGHT = Y_OFFSET-Y_MARGIN;

    private final int STARTING_X = 220;
    private final int STARTING_Y = 110;

    private final FieldCell[][] fieldMatrix;

    Map<Zombie, Image> zombies = new HashMap<>();
    Map<Plant, Image> plants = new HashMap<>();
    Map<Bullet, Image> bullets = new HashMap<>();
    Map<Sun, JButton> suns = new HashMap<>();

    /**
     * GamePanel Constructor
     * 
     * @see {@link GenericPanel}
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public GamePanel(SwingViewImpl parent, String backgroundSource) {
        super(parent, backgroundSource);
        
        this.fieldMatrix = new FieldCell[ROW_COUNT][COLUMN_COUNT];
        for(int i=0; i<ROW_COUNT; i++) {
            for(int j=0; j<COLUMN_COUNT; j++) {
                int xCoord = STARTING_X+(X_OFFSET*j); //j == 0 ? STARTING_X+(X_OFFSET*j) : STARTING_X+(X_OFFSET*j)+X_MARGIN;
                int yCoord = i == 0 ? (STARTING_Y+(Y_OFFSET*i)) : (STARTING_Y+(Y_OFFSET*i)+(Y_MARGIN/4));
                
                this.fieldMatrix[i][j] = new FieldCell(new Pair(xCoord, yCoord), FieldCell.CELL_TEXT_INITIALIZER);
                this.add(this.fieldMatrix[i][j]);
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
