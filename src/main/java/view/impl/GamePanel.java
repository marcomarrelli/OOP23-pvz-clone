package view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import javafx.event.ActionEvent;
import model.api.Bullet;
import model.api.Entities;
import model.api.Plant;
import model.api.Sun;
import model.api.Zombie;
import model.impl.FieldCell;
import model.impl.Pair;
import view.api.GenericPanel;

/**
 * Panel used in the Gameplay Section.
 * 
 * @author Marco Marrelli
 */
public class GamePanel extends GenericPanel {
    private final int ROW_COUNT = 5;
    private final int COLUMN_COUNT = 9;
    
    private static final int X_OFFSET = 70;
    private static final int Y_OFFSET = 110;
    public static final int X_MARGIN = 10; // 20/2
    public static final int Y_MARGIN = 15; // 30/2

    private final String PLANT_CARD = "/images/plantCard.png";
    private final String PLANT_IMAGE = "/images/sunCounter.jpg"; // "/images/plantEntity.png";
    private final String ZOMBIE_IMAGE = "/images/zombieEntity2.png"; // "/images/zombieEntity.png";
    private final String BULLET_IMAGE = "/images/sunCounter.png"; // "/images/bulletEntity.png";
    private final String SUN_IMAGE = "/images/sunEntity3.png"; // "/images/sunEntity.png";

    public static final int CELL_WIDTH = X_OFFSET-X_MARGIN;
    public static final int CELL_HEIGHT = Y_OFFSET-Y_MARGIN;

    private final int STARTING_X = 220;
    private final int STARTING_Y = 110;

    private final FieldCell[][] fieldMatrix;

    private final Map<Entities, Image> entities = new HashMap<Entities, Image>();
    private final Set<Pair<Image, Pair<Integer, Integer>>> images = new HashSet<Pair<Image, Pair<Integer, Integer>>>();

    Map<Zombie, Image> zombies = new HashMap<>();
    Map<Plant, Image> plants = new HashMap<>();
    Map<Bullet, Image> bullets = new HashMap<>();
    Map<Sun, Image> suns = new HashMap<>();

    /**
     * GamePanel Constructor
     * 
     * @see {@link GenericPanel}
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public GamePanel(SwingViewImpl parent, String backgroundSource) {
        super(parent, backgroundSource);
        
        this.fieldMatrix = new FieldCell[ROW_COUNT][COLUMN_COUNT];
        for(int i=0; i<ROW_COUNT; i++) {
            for(int j=0; j<COLUMN_COUNT; j++) {
                int xCoord = STARTING_X+(X_OFFSET*j); //j == 0 ? STARTING_X+(X_OFFSET*j) : STARTING_X+(X_OFFSET*j)+X_MARGIN;
                int yCoord = i == 0 ? (STARTING_Y+(Y_OFFSET*i)) : (STARTING_Y+(Y_OFFSET*i)+(Y_MARGIN/4));
                
                this.fieldMatrix[i][j] = new FieldCell(new Pair(xCoord, yCoord), FieldCell.CELL_TEXT_INITIALIZER);
                //this.add(this.fieldMatrix[i][j]);
            }
        }

        JButton plantCardButton = new JButton("");
        plantCardButton.setIcon(new ImageIcon(getClass().getResource(PLANT_CARD)));
        plantCardButton.setBounds(40, 50, 120, 75);
        this.add(plantCardButton);

        this.addMouseListener( new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println(e.getX()+" "+e.getY());
                Entities toRemove= null;
                for(var el : entities.entrySet()) {    
                    if(el.getKey() instanceof Sun) {
                        //System.out.println("Sole"+el.getKey().getPosition().getX()+" "+el.getKey().getPosition().getY());
                        if(e.getX()>=el.getKey().getPosition().getX() && e.getX()<=el.getKey().getPosition().getX()+140 &&
                        e.getY()>=el.getKey().getPosition().getY() && e.getY()<=el.getKey().getPosition().getY()+106) {
                            Sun sun= (Sun) el.getKey();
                            sun.kill();
                            toRemove= el.getKey();
                        }   
                    }
                }
                entities.remove(toRemove);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.getBackgroundImage(), 0, 0, null);
        //g2d.drawImage(new ImageIcon(getClass().getResource(PLANT_CARD)).getImage(), 20, 40, getFocusCycleRootAncestor());
        
        this.updateEntities(g2d);
    }

    private void updateEntities(Graphics2D g) {
        this.entities.clear();
        this.entities.entrySet().forEach(e -> this.images.add(new Pair<Image, Pair<Integer, Integer>>(e.getValue(), e.getKey().getPosition())));
        this.entities.keySet().removeIf(e -> !this.getView().getController().getEntities().contains(e));
        this.getView().getController().getEntities().forEach(entity -> this.createEntity(g, entity));
        /*
        for (var ent : entities.entrySet()) {
            if(ent.getKey() instanceof Sun) {
                System.out.println("Sun "+ent.getKey().getPosition().getX()+" "+ent.getKey().getPosition().getY());
            }
        }
        */
    }

    private Image getEntityImage(Entities entity) {
        return switch(entity.getEntityName()) {
            case "Plant" -> new ImageIcon(getClass().getResource(PLANT_IMAGE)).getImage();
            case "Zombie" -> new ImageIcon(getClass().getResource(ZOMBIE_IMAGE)).getImage();
            case "Bullet" -> new ImageIcon(getClass().getResource(BULLET_IMAGE)).getImage();
            case "Sun" -> new ImageIcon(getClass().getResource(SUN_IMAGE)).getImage();
            default -> throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
        };
    }

    private void createEntity(Graphics2D g, Entities entity) {
        this.entities.put(entity, getEntityImage(entity));
        g.drawImage(this.entities.get(entity), entity.getPosition().getX(), entity.getPosition().getY(), this);
    }
}
