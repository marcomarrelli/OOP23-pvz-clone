package model.impl;

import java.awt.Color;
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
    private final Color HOVER_COLOR = new Color(225, 215, 235);

    private boolean hasPlant;

    /**
     * Field Cell Constructor.
     * 
     * @param coord The central coordinate of the Cell.
     */
    public FieldCell(Pair<Integer, Integer> coord, String text) {
        super(text);
        this.coord = coord;
        
        this.setBounds(coord.getX(), coord.getY(), GamePanel.CELL_WIDTH, GamePanel.CELL_HEIGHT);
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);

        this.freeCell();

        this.addMouseListener(new FieldCellListener(this));
    }

    /**
     * Frees the cell from a Plant.
     */
    protected void freeCell() {
        this.hasPlant = false;
        this.setContentAreaFilled(false);
    }

    /**
     * Set a plant to the cell.
     */
    protected void setPlant() {
        this.hasPlant = true;
        this.setContentAreaFilled(true);
        this.setBackground(Color.BLACK);//new Color(0, 0, 0, 0));
    }

    /**
     * Set a plant to the cell.
     */
    protected void cellHover(boolean isHovered) {
        this.setBackground(HOVER_COLOR);
        this.setContentAreaFilled(isHovered);
    }

    /**
     * Has the cell a plant?
     * 
     * @return if the cell has already a plant.
     */
    protected boolean hasPlant() {
        return this.hasPlant;
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
