package model.impl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import view.impl.GamePanel; // Used for JavaDoc

/**
 * Cell used in Game Panel for placing Plants Entities.
 * The center of the cell is saved and its bounds will be calculated
 * using the constants declared inside {@link GamePanel}
 * 
 * @see {@link GamePanel}
 * @author Marco Marrelli
 */
public class FieldCell extends JButton {
    private final Pair<Integer, Integer> coord;
    public static final String CELL_TEXT_INITIALIZER = "";

    /**
     * Field Cell Constructor.
     * 
     * @param coord The central coordinate of the Cell.
     */
    public FieldCell(Pair<Integer, Integer> coord, String text) {
        super(text);
        this.coord = coord;
        
        this.setBounds(coord.getX(), coord.getY(), GamePanel.CELL_WIDTH, GamePanel.CELL_HEIGHT);
        this.setButtonInvisible();

        this.addMouseListener(new FieldCellListener());
    }

    private void setButtonInvisible() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
    }
    /**
     * Returns the center coordinate of the FieldCell.
     * 
     * @return The center coordinate of the Cell
     */
    public Pair<Integer, Integer> getCoord() {
        return this.coord;
    }
}
