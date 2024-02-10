package view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MenuPanel extends JPanel {

    private static final String MENU_BACKGROUND = "/images/menuBackground.jpeg";
    Image background;

    public MenuPanel(final int width, final int height) {
        setSize(width, height);
        this.background= new ImageIcon(MENU_BACKGROUND).getImage();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2D= (Graphics2D) g;
        g2D.drawImage(background, 0, 0, null);

    }

}
