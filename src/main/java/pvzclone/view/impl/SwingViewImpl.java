package pvzclone.view.impl;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pvzclone.controller.api.Controller;
import pvzclone.view.api.View;

/**
 * Implementation of the View.
 * 
 * @author Sofia Caberletti, Marco Marrelli
 */
public final class SwingViewImpl implements View {
    /** Application Width. */
    public static final int APPLICATION_WIDTH = 1000;

    /** Application Height. */
    public static final int APPLICATION_HEIGHT = 700;

    /** Application Title. */
    public static final String APPLICATION_TITLE = "Plants Vs Zombies";

    /** Menu Panel's Textual Constraint. */
    public static final String MENU_PANEL_CONSTRAINT = "MENU";

    /** Game Panel's Textual Constraint. */
    public static final String GAME_PANEL_CONSTRAINT = "GAME";

    /** Menu Panel's Background Image Source. */
    private static final String MENU_BACKGROUND = "/images/menuBackground.jpeg";

    /** Game Panel's Background Image Source. */
    private static final String GAME_BACKGROUND = "/images/gameBackground.png";

    /** Application Resizable Capability. */
    private static final boolean IS_APPLICATION_RESIZABLE = false;

    private final Controller controller;
    private final CardLayout sceneManager = new CardLayout();
    private final JPanel panel;
    private String currentConstraint = "";
    private final JFrame frame;

    /**
     * View Implementation Constructor.
     * 
     * @param controller the Application's Controller.
     */
    public SwingViewImpl(final Controller controller) {
        this.controller = controller;
        this.frame = new JFrame(APPLICATION_TITLE);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        this.frame.setLocationRelativeTo(null);
        this.frame.setMinimumSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));
        this.frame.setResizable(IS_APPLICATION_RESIZABLE);

        this.panel = new JPanel(sceneManager);
        this.panel.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        this.panel.add(new MenuPanel(this, MENU_BACKGROUND), MENU_PANEL_CONSTRAINT);
        this.panel.add(new GamePanel(this, GAME_BACKGROUND), GAME_PANEL_CONSTRAINT);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    /**
     * Returns the Application's {@link Controller}.
     * 
     * @return the Application's {@link Controller}.
     */
    @Override
    public Controller getController() {
        return this.controller;
    }

    /**
     * Sets a new Scene.
     * 
     * @param scene the scene constraint to be setted.
     */
    @Override
    public void setScene(final String scene) {
        this.sceneManager.show(this.panel, scene);
        this.currentConstraint = scene;
    }

    /**
     * Returns the actual scene.
     * 
     * @return the current scene.
     */
    @Override
    public JPanel getScene() {
        return this.panel;
    }

    /**
     * Returns the actual scene constraint.
     * 
     * @return the current scene constraint.
     */
    @Override
    public String getSceneConstraint() {
        return this.currentConstraint;
    }

    /**
     * Updates the View.
     * 
     * @see {@link pvzclone.view.impl.GenericPanel#paintComponents(java.awt.Graphics)}
     */
    @Override
    public void update() {
        this.panel.repaint();
    }

    @Override
    public JFrame getFrame() {
        return this.frame;
    }
}
