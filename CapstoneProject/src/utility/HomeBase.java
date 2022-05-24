package utility;

import java.awt.Rectangle;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import utility.field.friendly.Allied;

/**
 * The home base class and its defined properties are here
 * @author alexyue
 *
 */
public class HomeBase extends Allied {
	
    private PImage graphic; 

    public HomeBase(float x, float y, int health, DrawingSurface surface, float width, float height) {
        super(x, y, health, width, height); 
        graphic = surface.loadImage("img/base.png");
    }
    
    @Override
    /**
     * do nothing, since you cannot change the position of the HomeBase
     */
    public void changePos(float xChange, float yChange) {
        // DO NOTHING 
    }

    /**
     * draw the base onto the screen
     */
    public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
        surface.imageMode(PConstants.CENTER);
        surface.image(graphic, adjustedX, adjustedY, getWidth(), getHeight()); 
    }
}
