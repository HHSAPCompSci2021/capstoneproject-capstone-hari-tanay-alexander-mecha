package utility.field;

import processing.core.PImage;

public abstract class FieldObject {
    protected float xPosition, yPosition; 
    private PImage img;

    public FieldObject(float x, float y) {
        xPosition = x; 
        yPosition = y; 
    }

    public void changePos(float xChange, float yChange) {
        xPosition += xChange; 
        yPosition += yChange; 
    }

    public float getX() {
    	return xPosition;
    }
    
    public float getY() {
    	return yPosition;
    }
}
