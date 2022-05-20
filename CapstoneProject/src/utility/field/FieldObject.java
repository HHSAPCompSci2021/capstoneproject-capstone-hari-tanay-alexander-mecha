package utility.field;

import core.DrawingSurface;
import processing.core.PImage;
import java.awt.geom.Rectangle2D; 

public abstract class FieldObject {
    private float centerX, centerY;           // coordinates relative to map. 

    /**
     * Initialize a new field object at <code>Map</code> position <code>x</code>, <code>y</code>. 
     * @param x map x locaiton. - defines center of the object. 
     * @param y map y location. - defines center of the object. 
     */
    public FieldObject(float x, float y) {
        centerX = x; 
        centerY = y; 
    }

    /**
     * change position in the map. positive indicates down and right. 
     * @param xChange change in x 
     * @param yChange change in y 
     */
    public void changePos(float xChange, float yChange) {
        centerX += xChange; 
        centerY += yChange; 
    }

    /**
     * get map oriented X position. 
     * @return x 
     */
    public float getX() {
    	return centerX;
    }

    /**
     * set a new X position individually relative to map. 
     * @return new x position. 
     */
    public void setXPosition(float newXPos) {
        centerX = newXPos; 
    }
    
    /**
     * get map oriented Y position. 
     * @return y
     */
    public float getY() {
    	return centerY;
    }

    /**
     * set a new X position individually relative to map. 
     * @return new x position. 
     */
    public void setYPosition(float newYPos) {
        centerY = newYPos; 
    }
    
    /**
     * method to draw the specific <code>FieldObject</code>. 
     * this will use adjusted values, since the <code>DrawingSurface</code> view is different from appearance due to map structure. 
     * @param surface 
     * @param adjustedX
     * @param adjustedY
     */
    public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
    	
    }

    /**
     * get the bounding rectangle of the specific <code>FieldObject</code>
     * @return an instance of Rectangle2D.Float specifying the boundary of the <code>FieldObject</code> 
     */
    public Rectangle2D.Float getBoundary() {
        return null; 
    }
}
