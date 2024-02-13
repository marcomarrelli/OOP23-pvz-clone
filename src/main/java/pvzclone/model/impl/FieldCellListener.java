package pvzclone.model.impl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mouse Event Listener for the {@link FieldCell} Component.
 * 
 * @see {@link FieldCell}
 * @author Marco Marrelli
 */
public class FieldCellListener implements MouseListener {
    private final FieldCell parent;

    /**
     * Field Cell Listener Constructor.
     * 
     * @param parent the associated {@link FieldCell}
     */
    public FieldCellListener(final FieldCell parent) {
        this.parent = parent;
    }

    /**
     * @see {@link FieldCellListener#muouseReleased()}
     */
    @Override
    public void mouseClicked(final MouseEvent e) { }

    /**
     * @see {@link FieldCellListener#muouseReleased()}
     */
    @Override
    public void mousePressed(final MouseEvent e) { }

    /**
     * Click and Press Event.
     * 
     * @author Marco Marrelli
     */
    @Override
    public void mouseReleased(final MouseEvent e) {
        if (this.parent.hasPlant()) {
            return;
        }
        this.parent.setPlant();
    }

    /**
     * When the mouse enters the fieldCell, HoverEvent = true.
     */
    @Override
    public void mouseEntered(final MouseEvent e) {
        hoverHandler(true);
    }

    /**
     * When the mouse enters the fieldCell, HoverEvent = true.
     */
    @Override
    public void mouseExited(final MouseEvent e) {
        hoverHandler(false);
    }

    /**
     * Sets the hover status to the parent FieldCell.
     * 
     * @param hover hover status.
     */
    private void hoverHandler(final boolean hover) {
        if (this.parent.hasPlant()) {
            return;
        }
        this.parent.cellHover(hover);
    }
}
