package pvzclone.view.impl;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import pvzclone.controller.api.Controller;
import pvzclone.model.impl.Pair;

/**
 * Cell used in Game Panel for placing Plants Entities.
 * The center of the cell is saved and its bounds will be calculated
 * using the constants declared inside {@link GamePanel}
 * 
 * @see {@link GamePanel}
 * @author Marco Marrelli
 */
public class FieldCell extends JButton {
    private static final long serialVersionUID = 1234500005L;

    /** Cell Text Initializer, used for {@link JButton#JButton(String)}. */
    public static final String CELL_TEXT_INITIALIZER = "";

    private final GamePanel parent;
    private final Pair<Integer, Integer> coord;
    private final Color hoverColor = new Color(225, 215, 235);
    private final Border hoverBorder = new LineBorder(hoverColor, 3);
    private boolean hasPlant;
    private final Controller controller;

    /**
     * Field Cell Constructor.
     * 
     * @param coord     the central coordinate of the Cell.
     * @param text      the text of the button.
     * @param parent    the parente panel.
     * @param controller is the controller of the game.
     */
    public FieldCell(final GamePanel parent, final Pair<Integer, Integer> coord, final String text,
            final Controller controller) {
        super(text);

        this.parent = parent;

        this.setEnabled(false);
        this.coord = coord;

        this.setBounds(coord.getX(), coord.getY(), GamePanel.CELL_WIDTH, GamePanel.CELL_HEIGHT);
        this.setOpaque(false);
        this.setBorder(hoverBorder);
        this.setBorderPainted(false);
        this.setFocusPainted(false);

        this.freeCell();

        this.addMouseListener(new FieldCellListener(this));

        this.controller = controller;
    }

    /**
     * Frees the cell from a Plant.
     */
    private void freeCell() {
        this.hasPlant = false;
    }

    /**
     * Set a plant to the cell.
     */
    protected void setPlant(/* Entity plant */) {
        this.hasPlant = true;
        this.setBorderPainted(false);
        this.parent.userIsPlanting = false;
        this.parent.hideGrid();
        controller.newPlant(coord);
    }

    /**
     * Set a plant to the cell.
     * 
     * @param isHovered if the content area should be filler or not.
     */
    protected void cellHover(final boolean isHovered) {
        if (this.hasPlant()) {
            this.setBorderPainted(false);
        } else {
            this.setBorderPainted(isHovered);
        }
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
