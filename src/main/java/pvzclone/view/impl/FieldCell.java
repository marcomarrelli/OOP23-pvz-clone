package pvzclone.view.impl;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import pvzclone.controller.api.Controller;
import pvzclone.model.impl.Pair;

/**
 * Cell used in Game Panel for placing Plants Entities.
 * Its bounds are declared inside {@link GamePanel}
 * 
 * @see GamePanel
 */
@SuppressFBWarnings(value = {
        "EI_EXPOSE_REP2"
}, justification = "Parent is Intended to be Modified.")
public class FieldCell extends JButton {
    private static final long serialVersionUID = 1234500005L;

    /** Cell Text Initializer, used for {@link JButton#JButton(String)}. */
    public static final String CELL_TEXT_INITIALIZER = "";

    private final transient Pair<Integer, Integer> coord;
    private final transient Controller controller;

    /** The Game Panel (the parent). */
    private final GamePanel parent;

    /** The Color for the Hover on the Cell. */
    private final Color hoverColor = new Color(225, 215, 235);

    /** The Border Settings for the Hover on the Cell. */
    private final Border hoverBorder = new LineBorder(hoverColor, 3);

    /** If the Cell has a Plant or Not. */
    private boolean hasPlant;

    /**
     * Field Cell Constructor.
     * 
     * @param coord      the central coordinate of the Cell.
     * @param text       the text of the button.
     * @param parent     the parent panel.
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
        this.parent.userPlantingStatus(false);
        this.parent.hideGrid();
        controller.newPlant(coord);
    }

    /**
     * Set a plant to the cell.
     * 
     * @param isHovered if the content area should be filled or not.
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
