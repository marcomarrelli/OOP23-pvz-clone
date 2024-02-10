package view.impl;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.api.View;

public class SwingViewImpl implements View {

    private JFrame frame;
    private JPanel panel;

    public SwingViewImpl(int width, int height) {
        frame = new JFrame("PVZ clone");
        frame.setSize(width, height);
        frame.setMinimumSize(new Dimension(width,height));
        frame.setResizable(false);
        panel= new MenuPanel(width, height);
        frame.setVisible(true);
    }


    @Override
    public void setScene(JPanel scene) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setScene'");
    }

    @Override
    public JPanel getScene() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScene'");
    }

    @Override
    public void update(JPanel scene) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
