package view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.api.GenericPanel;


/**
 * Panel used in the starting Menu Section.
 * 
 * @author Sofia Caberletti
 */
public class MenuPanel extends GenericPanel {
    
    private static final String BUTTON_TEXTURE = "/images/tombstoneTexture.jpg";
    private ImageIcon texture;

    public MenuPanel(SwingViewImpl parent, String backgroundSource) {
        super(parent, backgroundSource);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, (SwingViewImpl.APPLICATION_HEIGHT/2)-50));
        this.texture= new ImageIcon(getClass().getResource(BUTTON_TEXTURE));

        JButton startButton = new JButton("Start Adventure", this.texture);
        JButton fullButton = new JButton("Full Screen", this.texture);
        JButton exitButton = new JButton("Exit Game", this.texture);

        this.setButton(startButton);
        this.setButton(fullButton);
        this.setButton(exitButton);

        startButton.addActionListener( e -> {
            parent.setScene(SwingViewImpl.GAME_PANEL_CONSTRAINT);
            parent.getController().mainLoop();
        });
        exitButton.addActionListener( e -> System.exit(0));

        this.add(startButton);
        this.add(fullButton);
        this.add(exitButton);
    }

    private void setButton(final JButton button) {
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setPreferredSize(new Dimension(SwingViewImpl.APPLICATION_WIDTH/6, SwingViewImpl.APPLICATION_HEIGHT/8));
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
