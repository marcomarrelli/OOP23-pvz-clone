package pvzclone.view.api;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JPanel;

import pvzclone.model.api.Entities;
import pvzclone.view.impl.GamePanel;

public abstract class GenericEntity extends JPanel {
    private static final long serialVersionUID = 1234500000L;

    /** The Parent Game Panel. */
    private final GamePanel parent;

    /** The View Implementation. */
    private final Entities entity;

    /** The Image for the Panel's Background. */
    private final Image entityImage;

    private Rectangle dimensions;

    /**
     * Panel Constructor.
     * 
     * @param parent The Application View.
     * @param backgroundSource The Panel Background.
     */
    public GenericEntity(final GamePanel parent, final Entities entity, final Rectangle dimensions, final Image entityImage) {
        this.parent = parent;
        this.entity = entity;
        this.dimensions = dimensions;
        this.entityImage = entityImage;
        
        this.setLayout(null);
        //this.setOpaque(false);
        this.setBounds(entity.getPosition().getX(), entity.getPosition().getY(), (int) dimensions.getWidth(), (int) dimensions.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.entityImage, 0, 0, (int) this.getDimensions().getWidth(), (int) this.getDimensions().getHeight(), null);
    }

    /**
     * View Getter. Returns the View (Parent).
     * 
     * @return the view.
     */
    public GamePanel getView() {
        return this.parent;
    }

    public Entities getEntity() {
        return this.entity;
    }

    public Image getImage() {
        return this.entityImage;
    }

    public Rectangle getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(Rectangle dimensions) {
        this.dimensions = dimensions;
    }

    public boolean collides(GenericEntity other) {
        return other.getDimensions().intersects(this.getDimensions());
    }

    public static boolean collides(GenericEntity first, GenericEntity second) {
        return first.getDimensions().intersects(second.getDimensions());
    }
}
