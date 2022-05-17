package utility;

import java.awt.Rectangle;

import processing.core.PApplet;
import utility.field.friendly.Allied;

public class HomeBase extends Allied {
	
	private int hp;
	
    public HomeBase(float x, float y, int hitpoints) {
        super(x, y); 
        hp = hitpoints;
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
    
    public void draw(PApplet p) {
    	p.image(p.loadImage("img/base.png"),getX(),getY(),400,300);
    }
}
