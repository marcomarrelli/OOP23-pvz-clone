package pvzclone.view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import pvzclone.model.api.Entities;
import pvzclone.model.api.Sun;
import pvzclone.model.impl.FieldCell;
import pvzclone.model.impl.Pair;
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

    private static final int SUN_ENTITY_WIDTH = 140;
    private static final int SUN_ENTITY_HEIGHT = 106;

    /** Field Cell Width. */
    public static final int CELL_WIDTH = X_OFFSET - X_MARGIN;

    /** Field Cell Height. */
    public static final int CELL_HEIGHT = Y_OFFSET - Y_MARGIN;

    private final FieldCell[][] fieldMatrix;

    private final Map<Entities, Image> entities = new HashMap<>();
    private final Set<Pair<Image, Pair<Integer, Integer>>> images = new HashSet<>();

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

                this.fieldMatrix[i][j] = new FieldCell(new Pair(xCoord, yCoord), FieldCell.CELL_TEXT_INITIALIZER);
                this.add(this.fieldMatrix[i][j]);
            }
        }

        final JButton plantCardButton = new JButton();
        plantCardButton.setIcon(new ImageIcon(getClass().getResource(PLANT_CARD)));
        plantCardButton.setBounds(CARD_STARTING_X, CARD_STARTING_Y, CARD_WIDTH, CARD_HEIGHT);
        this.add(plantCardButton);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                Entities toRemove = null;
                for (final var el : entities.entrySet()) {
                    if (el.getKey() instanceof Sun
                    && e.getX() >= el.getKey().getPosition().getX()
                    && e.getX() <= el.getKey().getPosition().getX() + SUN_ENTITY_WIDTH
                    && e.getY() >= el.getKey().getPosition().getY()
                    && e.getY() <= el.getKey().getPosition().getY() + SUN_ENTITY_HEIGHT) {
                        final Sun sun = (Sun) el.getKey();
                        sun.kill();
                        toRemove = el.getKey();
                    }
                }
                entities.remove(toRemove);
            }

            @Override
            public void mousePressed(final MouseEvent e) { }

            @Override
            public void mouseReleased(final MouseEvent e) { }

            @Override
            public void mouseEntered(final MouseEvent e) { }

            @Override
            public void mouseExited(final MouseEvent e) { }
        });
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

    private void updateEntities(final Graphics2D g) {
        this.entities.clear();
        this.entities.entrySet().forEach(
            e -> this.images.add(new Pair<Image, Pair<Integer, Integer>>(e.getValue(), e.getKey().getPosition()))
        );
        this.entities.keySet().removeIf(e -> !this.getView().getController().getEntities().contains(e));
        this.getView().getController().getEntities().forEach(entity -> this.createEntity(g, entity));
    }

    private Image getEntityImage(final Entities entity) {
        return switch (entity.getEntityName()) {
            case "Plant" -> new ImageIcon(getClass().getResource(PLANT_IMAGE)).getImage();
            case "Zombie" -> new ImageIcon(getClass().getResource(ZOMBIE_IMAGE)).getImage();
            case "Bullet" -> new ImageIcon(getClass().getResource(BULLET_IMAGE)).getImage();
            case "Sun" -> new ImageIcon(getClass().getResource(SUN_IMAGE)).getImage();
            default -> throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
        };
    }

    private void createEntity(final Graphics2D g, final Entities entity) {
        this.entities.put(entity, getEntityImage(entity));
        g.drawImage(this.entities.get(entity), entity.getPosition().getX(), entity.getPosition().getY(), this);
    }
}
