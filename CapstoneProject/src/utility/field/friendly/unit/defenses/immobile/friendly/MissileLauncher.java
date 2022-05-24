package utility.field.friendly.unit.defenses.immobile.friendly;

import core.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import utility.field.friendly.DefenseUnit;

/**
 * The class of the missile launcher; missiles are fired in a splash-attack mechanism
 * @author alexyue
 *
 */
public class MissileLauncher extends DefenseUnit {

	private PImage graphic; 

	public MissileLauncher(float x, float y, float health, float width, float height, PImage image) {
		super(x, y, health, width, height); 
		graphic = image; 
	}
	
	/**
	 * Draws the missile launcher on screen by coordinate
	 */
	public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
		surface.image(graphic, adjustedX, adjustedY, getWidth(), getHeight()); 
	}
	
	public void changePos(float xChange, float yChange) {
		// Do nothing, this is stationary object. 
	}
}
