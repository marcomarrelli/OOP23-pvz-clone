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
    private final int width;
    private final int height;

    public MenuPanel(final int width, final int height) {
        this.width= width;
        this.height= height;
        this.setSize(width, height);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 275));
        this.background= new ImageIcon(getClass().getResource(MENU_BACKGROUND)).getImage();
        this.texture= new ImageIcon(getClass().getResource(BUTTON_TEXTURE));

        JButton startButton = new JButton("Start Adventure", this.texture);
        JButton fullButton = new JButton("Full Screen", this.texture);
        JButton exitButton = new JButton("Exit Game", this.texture);

        this.setButton(startButton);
        this.setButton(fullButton);
        this.setButton(exitButton);

        exitButton.addActionListener( e -> System.exit(0));

        this.add(startButton);
        this.add(fullButton);
        this.add(exitButton);
    }

    private void setButton(final JButton button) {
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setPreferredSize(new Dimension(this.width/6, this.height/8));
        button.setFont(new Font(null, Font.BOLD, 16));
        button.setForeground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.background, 0, 0, null);
    }
}
