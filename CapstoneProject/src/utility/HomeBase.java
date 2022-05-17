package utility;

import java.awt.Rectangle;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;
import utility.field.friendly.Allied;

public class HomeBase extends Allied {
	
	private int hp;
	private PImage img;
	
    public HomeBase(float x, float y, int hitpoints, DrawingSurface surface) {
        super(x, y); 
        hp = hitpoints;
        surface.loadImage("img/base.png");
    }
    
    public float getX() {
    	return getX();
    }
    
    public float getY() {
    	return getY();
    }

    public int getHealth() {
        return hp; 
    }
 
}
