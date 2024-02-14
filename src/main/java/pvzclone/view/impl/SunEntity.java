package pvzclone.view.impl;

import java.awt.Image;
import java.awt.Rectangle;

import pvzclone.model.api.Entities;
import pvzclone.view.api.GenericEntity;

public class SunEntity extends GenericEntity {

    public SunEntity(GamePanel parent, Entities entity, Rectangle dimensions, Image entityImage) {
        super(parent, entity, dimensions, entityImage);
    }
}
