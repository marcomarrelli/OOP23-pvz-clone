package model.impl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mouse Event Listener for the {@link FieldCell} Component
 * 
 * @see {@link FieldCell}
 * @author Marco Marrelli
 */
public class FieldCellListener implements MouseListener {
    /**
     * Field Cell Listener Constructor.
     */
    public FieldCellListener() {

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
        
    }

    @Override
    public void mouseEntered(MouseEvent e) { /* To Be Implemented Soon ... Hover: ON */ }

    @Override
    public void mouseExited(MouseEvent e) { /* To Be Implemented Soon ... Hover: OFF */ }
}