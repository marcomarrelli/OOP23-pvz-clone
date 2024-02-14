package pvzclone.view.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pvzclone.model.api.Entities;
import pvzclone.model.api.Sun;
import pvzclone.model.impl.FieldCell;
import pvzclone.model.impl.Pair;
import pvzclone.view.api.GenericEntity;
import pvzclone.view.api.GenericPanel;

/**
 * Panel used in the Gameplay Section.
 * 
 * @author Marco Marrelli
 */
public class GamePanel extends GenericPanel {
    private static final long serialVersionUID = 1234500002L;

    private static final int ROW_COUNT = 5;
    private static final int COLUMN_COUNT = 9;

    private static final int X_OFFSET = 70;
    private static final int Y_OFFSET = 110;
    private static final int X_MARGIN = 10; // 20/2
    private static final int Y_MARGIN = 15; // 30/2

    private static final String PLANT_CARD = "/images/plantCard.png";
    private static final String SUN_COUNTER_IMAGE = "/images/sunCounter2.jpg";
    private static final String PLANT_IMAGE = "/images/sunCounter.jpg"; // "/images/plantEntity.png";
    private static final String ZOMBIE_IMAGE = "/images/zombieEntity2.png"; // "/images/zombieEntity.png";
    private static final String BULLET_IMAGE = "/images/sunCounter.png"; // "/images/bulletEntity.png";
    private static final String SUN_IMAGE = "/images/sunEntity3.png"; // "/images/sunEntity.png";

    private static final int FIELD_STARTING_X = 220;
    private static final int FIELD_STARTING_Y = 110;

    private static final int CARD_STARTING_X = 40;
    private static final int CARD_STARTING_Y = 50;
    private static final int CARD_WIDTH = 120;
    private static final int CARD_HEIGHT = 75;

    private static final int SUN_COUNTER_STARTING_X = 50;
    private static final int SUN_COUNTER_STARTING_Y = 135;
    private static final int SUN_COUNTER_WIDTH = 104;
    private static final int SUN_COUNTER_HEIGHT = 119;

    private static final int POINTS_STARTING_X = 72;
    private static final int POINTS_STARTING_Y = 217;
    private static final int POINTS_WIDTH = 60;
    private static final int POINTS_HEIGHT = 40;

    private static final int SUN_ENTITY_WIDTH = 140;
    private static final int SUN_ENTITY_HEIGHT = 106;

    /** Field Cell Width. */
    public static final int CELL_WIDTH = X_OFFSET - X_MARGIN;

    /** Field Cell Height. */
    public static final int CELL_HEIGHT = Y_OFFSET - Y_MARGIN;

    private final FieldCell[][] fieldMatrix;

    private final JLabel points;

    private final Set<GenericEntity> entities = new HashSet<>();

    public boolean userIsPlanting = false;

    /**
     * Game Panel Constructor.
     * 
     * @param parent the application's view.
     * @param backgroundSource the background image source.
     * @see {@link GenericPanel}
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public GamePanel(final SwingViewImpl parent, final String backgroundSource) {
        super(parent, backgroundSource);

        this.fieldMatrix = new FieldCell[ROW_COUNT][COLUMN_COUNT];
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                final int xCoord = FIELD_STARTING_X + (X_OFFSET * j);
                final int yCoord = i == 0
                    ? FIELD_STARTING_Y + (Y_OFFSET * i)
                    : FIELD_STARTING_Y + (Y_OFFSET * i) + (Y_MARGIN / 4);

                this.fieldMatrix[i][j] = new FieldCell(this, new Pair(xCoord, yCoord), FieldCell.CELL_TEXT_INITIALIZER);
                this.add(this.fieldMatrix[i][j]);
            }
        }

        final JButton plantCardButton = new JButton();
        plantCardButton.setIcon(new ImageIcon(getClass().getResource(PLANT_CARD)));
        plantCardButton.setBounds(CARD_STARTING_X, CARD_STARTING_Y, CARD_WIDTH, CARD_HEIGHT);
        plantCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userIsPlanting = !userIsPlanting;
            }
        });
        this.add(plantCardButton);

        this.points = new JLabel("0", SwingConstants.CENTER);
        this.points.setBounds(POINTS_STARTING_X, POINTS_STARTING_Y, POINTS_WIDTH, POINTS_HEIGHT);
        this.points.setFont(new Font("Arial", Font.BOLD, 16));
        this.points.setForeground(Color.BLACK);
        this.add(this.points);

        final JLabel sunCounterImage = new JLabel();
        sunCounterImage.setIcon(new ImageIcon(getClass().getResource(SUN_COUNTER_IMAGE)));
        sunCounterImage.setBounds(SUN_COUNTER_STARTING_X, SUN_COUNTER_STARTING_Y, SUN_COUNTER_WIDTH, SUN_COUNTER_HEIGHT);
        this.add(sunCounterImage);
        
        //this.addMouseListener(new MouseListener() {
        //    @Override
        //    public void mouseClicked(final MouseEvent e) {
        //        Entities toRemove = null;
        //        
        //        if(userIsPlanting) return;
//
        //        for (final var el : entities.entrySet()) {
        //            if (el.getKey() instanceof Sun
        //            && e.getX() >= el.getKey().getPosition().getX()
        //            && e.getX() <= el.getKey().getPosition().getX() + SUN_ENTITY_WIDTH
        //            && e.getY() >= el.getKey().getPosition().getY()
        //            && e.getY() <= el.getKey().getPosition().getY() + SUN_ENTITY_HEIGHT) {
        //                final Sun sun = (Sun) el.getKey();
        //                sun.kill();
        //                toRemove = el.getKey();
        //                parent.getController().getWorld().getGame().getGameState().incSunScore();
        //                points.setText(String.valueOf(parent.getController().getWorld().getGame().getGameState().getSunScore())); 
        //            }
        //        }
        //        entities.remove(toRemove);
        //    }
//
        //    @Override
        //    public void mousePressed(final MouseEvent e) { }
//
        //    @Override
        //    public void mouseReleased(final MouseEvent e) { }
//
        //    @Override
        //    public void mouseEntered(final MouseEvent e) { }
//
        //    @Override
        //    public void mouseExited(final MouseEvent e) { }
        //});
    }

    /**
     * Used for {@link pvzclone.view.api.GenericPanel#update(Graphics)}.
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.getBackgroundImage(), 0, 0, null);

        this.updateEntities(g2d);
    }

    /**
     * Funzione dedicata all'update delle entità fornite dal Controller.
     * 
     * @param g Graphics Component
     */
    private void updateEntities(final Graphics2D g) {
        this.entities.forEach(e -> this.remove(e));
        this.entities.removeIf(e -> !this.getView().getController().getEntities().contains(e.getEntity()));
        this.getView().getController().getEntities().forEach(entity -> this.createEntity(g, entity));
    }

    /**
     * Restituisce l'immagine affiliata all'entità.
     * 
     * @param entity Entità da cui prelevare l'immagine
     * @return l'immagine dell'entità.
     */
    private Image getEntityImage(final Entities entity) {
        return switch (entity.getEntityName()) {
            case "Plant" -> new ImageIcon(getClass().getResource(PLANT_IMAGE)).getImage();
            case "Zombie" -> new ImageIcon(getClass().getResource(ZOMBIE_IMAGE)).getImage();
            case "Bullet" -> new ImageIcon(getClass().getResource(BULLET_IMAGE)).getImage();
            case "Sun" -> new ImageIcon(getClass().getResource(SUN_IMAGE)).getImage();
            default -> throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
        };
    }

    /**
     * Crea un'entità graficamente.
     * 
     * @param g Graphics Component.
     * @param entity entità da "disegnare".
     */
    private void createEntity(final Graphics2D g, final Entities entity) {
        final GenericEntity temp;

        switch (entity.getEntityName()) {
            case "Plant" ->temp = new SunEntity(this, entity, new Rectangle(50, 50), getEntityImage(entity));
            case "Zombie" -> temp = new SunEntity(this, entity, new Rectangle(50, 50), getEntityImage(entity));
            case "Bullet" -> temp = new SunEntity(this, entity, new Rectangle(50, 50), getEntityImage(entity));
            case "Sun" -> temp = new SunEntity(this, entity, new Rectangle(100, 100), getEntityImage(entity));
            default -> throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
        }

        this.entities.add(temp);
        this.add(temp);
    }
}
