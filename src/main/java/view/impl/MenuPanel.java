package view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * 
 * @author Sofia Caberletti
 */
public class MenuPanel extends JPanel {
    private static final String MENU_BACKGROUND = "/images/menuBackground.jpeg";
    private static final String BUTTON_TEXTURE = "/images/tombstoneTexture.jpg";
    private Image background;
    private ImageIcon texture;

    public MenuPanel(final int width, final int height) {

        this.setSize(width, height);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 275));
        this.background= new ImageIcon(getClass().getResource(MENU_BACKGROUND)).getImage();
        this.texture= new ImageIcon(getClass().getResource(BUTTON_TEXTURE));

        JButton startButton = new JButton("Start Adventure", this.texture);
        startButton.setHorizontalTextPosition(JButton.CENTER);
        startButton.setVerticalTextPosition(JButton.CENTER);
        startButton.setPreferredSize(new Dimension(width/6, height/8));
        startButton.setFont(new Font(null, Font.BOLD, 16));
        startButton.setForeground(Color.BLACK);
        this.add(startButton);

        JButton fullButton = new JButton("Full Screen", this.texture);
        fullButton.setHorizontalTextPosition(JButton.CENTER);
        fullButton.setVerticalTextPosition(JButton.CENTER);
        fullButton.setPreferredSize(new Dimension(width/6, height/8));
        fullButton.setFont(new Font(null, Font.BOLD, 16));
        fullButton.setForeground(Color.BLACK);
        this.add(fullButton);

        JButton exitButton = new JButton("Exit Game", this.texture);
        exitButton.setHorizontalTextPosition(JButton.CENTER);
        exitButton.setVerticalTextPosition(JButton.CENTER);
        exitButton.setPreferredSize(new Dimension(width/6, height/8));
        exitButton.setFont(new Font(null, Font.BOLD, 16));
        exitButton.addActionListener( e -> System.exit(0));
        exitButton.setForeground(Color.BLACK);
        this.add(exitButton);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.background, 0, 0, null);
    }
}
