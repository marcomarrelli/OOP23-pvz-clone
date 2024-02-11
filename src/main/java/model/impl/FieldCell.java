package model.impl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldCell implements MouseListener {
    private final Pair<Integer, Integer> coord;

    public FieldCell(Pair<Integer, Integer> coord) {
        this.coord = coord;
    }

    /**
     * @see {@link FieldCell#muouseReleased()}
     */
    @Override
    public void mouseClicked(MouseEvent e) { }

    /**
     * @see {@link FieldCell#muouseReleased()}
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
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    public Pair<Integer, Integer> getCoord() {
        return this.coord;
    }
}
