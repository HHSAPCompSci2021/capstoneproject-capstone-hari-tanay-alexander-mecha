package utility.field.friendly.unit.defenses.immobile.friendly;

import java.util.ArrayList;

import core.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PImage;
import utility.field.enemy.Enemy;
import utility.field.friendly.DefenseUnit;

public class CannonArtillery extends DefenseUnit {

	private PImage graphic; 

	public CannonArtillery(float x, float y, float health, float width, float height, PImage image) {
		super(x, y, health, width, height); 
		graphic = image; 
	}

	/**
	 * draw the cannon 
	 * TODO, finish javadoc here. 
	 */
	public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
		surface.imageMode(PConstants.CENTER); 
		surface.image(graphic, adjustedX, adjustedY, getWidth(), getHeight());
	}
	
	/**
	 * no movement is necessary for this class. 
	 */
	public void changePos(float xChange, float yChange) {
		// DO NOTHING. 
	}

	public void attack(ArrayList<Enemy> enemies) {
		
	}
}
