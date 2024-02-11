package model.impl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * Mouse Event Listener for the {@link FieldCell} Component
 * 
 * @see {@link FieldCell}
 * @author Marco Marrelli
 */
public class FieldCellListener implements MouseListener {
    private final FieldCell parent;
    
    /**
     * Field Cell Listener Constructor.
     */
    public FieldCellListener(FieldCell parent) {
        this.parent = parent;
    }

    /**
     * @see {@link FieldCellListener#muouseReleased()}
     */
    @Override
    public void mouseClicked(MouseEvent e) { }

    /**
     * @see {@link FieldCellListener#muouseReleased()}
     */
    @Override
    public void mousePressed(MouseEvent e) { }

    /**
     * Click and Press Event
     * 
     * @author Marco Marrelli
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if(this.parent.hasPlant()) {
            return;
        }
        this.parent.setPlant();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hoverHandler(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hoverHandler(false);
    }

    private void hoverHandler(boolean hover) {
        if(this.parent.hasPlant()) {
            return;
        }
        this.parent.cellHover(hover);
    }
}