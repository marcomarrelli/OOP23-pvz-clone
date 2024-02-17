package pvzclone.view.impl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Mouse Event Listener for the {@link FieldCell} Component.
 * 
 * @see FieldCell
 */

@SuppressFBWarnings(value = {
        "EI_EXPOSE_REP2"
}, justification = "parent is intended to be modified")

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
     * @see FieldCellListener#mouseReleased(MouseEvent)
     */
    @Override
    public void mouseClicked(final MouseEvent e) {
    }

    /**
     * @see FieldCellListener#mouseReleased(MouseEvent)
     */
    @Override
    public void mousePressed(final MouseEvent e) {
    }

    /**
     * Click and Press Event.
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
