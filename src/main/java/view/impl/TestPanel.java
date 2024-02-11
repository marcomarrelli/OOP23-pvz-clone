package view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;

import view.api.GenericPanel;

public class TestPanel extends GenericPanel {
    public TestPanel(SwingViewImpl parent, String backgroundSource) {
        super(parent, backgroundSource);
        System.out.println("MIAO " + parent.getScene());
        System.out.println("MIAO " + background);
    }

    public SwingViewImpl getParentView() {
        return this.parent;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.background, 0, 0, null);
    }
}
