package utility.field;

import java.awt.geom.Rectangle2D;

import core.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage; 

/**
 * class to represent Inanimate objects on the field. (ex- trees, boulders, etc)
 */
public class Inanimate extends FieldObject {
    
    private Rectangle2D.Float boundingRect; 
    private PImage graphic; 

    /**
     * construct an inanimate object, final
     * @param x map center x coordinate. 
     * @param y map center y coordinate. 
     * @param width width 
     * @param height height
     */
    public Inanimate(float x, float y, float width, float height, PImage image) {
        super(x, y); 
        boundingRect = new Rectangle2D.Float(
            x - (width / 2), 
            y - (height / 2), 
            width, 
            height
        ); 
        graphic = image; 
    }

    @Override
    public Rectangle2D.Float getBoundary() {
        return boundingRect; 
    }

    @Override
    public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
        surface.imageMode(PConstants.CENTER); 
        surface.image(graphic, adjustedX, adjustedY); 
    }
}
