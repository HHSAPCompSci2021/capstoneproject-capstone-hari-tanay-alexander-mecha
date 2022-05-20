package utility.field;

import core.DrawingSurface;
import processing.core.PImage;
import java.awt.geom.Rectangle2D; 

public abstract class FieldObject {
    private float mapX, mapY;           // coordinates relative to map. 

    /**
     * Initialize a new field object at <code>Map</code> position <code>x</code>, <code>y</code>. 
     * @param x map x locaiton. 
     * @param y map y location. 
     */
    public FieldObject(float x, float y) {
        mapX = x; 
        mapY = y; 
    }

    /**
     * change position in the map. positive indicates down and right. 
     * @param xChange change in x 
     * @param yChange change in y 
     */
    public void changePos(float xChange, float yChange) {
        mapX += xChange; 
        mapY += yChange; 
    }

    /**
     * get map oriented X position. 
     * @return x 
     */
    public float getX() {
    	return mapX;
    }
    
    /**
     * get map oriented Y position. 
     * @return y
     */
    public float getY() {
    	return mapY;
    }
    
    /**
     * method to draw the specific <code>FieldObject</code>. 
     */
    public void draw(DrawingSurface surface) {
    	
    }

    public Rectangle2D.Float getBoundary() {
        return null; 
    }
}
