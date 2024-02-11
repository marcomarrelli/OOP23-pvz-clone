package view.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class GamePanel extends JPanel {
    private static final String GAME_BACKGROUND = "/images/gameField.jpeg";
    Image background;

    public GamePanel(final int width, final int height) {
        this.setSize(width, height);
        this.setBackground(Color.BLACK);
        this.background = new ImageIcon(getClass().getResource(GAME_BACKGROUND)).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.background, 0, 0, null);
    }
}
