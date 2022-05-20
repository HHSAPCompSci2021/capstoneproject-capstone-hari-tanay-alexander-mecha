package utility.field.friendly.unit.defenses.mobile.friendly;

import java.util.ArrayList;

import core.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import utility.field.enemy.Enemy;
import utility.field.friendly.MobileUnit;

public class Tanks extends MobileUnit {
	
	private PImage graphic, left, right; 
	private static String graphicPathRight = "CapstoneProject\\img\\tank_pointing_right.png"; 
	private static String graphicPathLeft = "CapstoneProject\\img\\tank_pointing_left.png"; 

	public Tanks(float x, float y, float health, float width, float height, float moveSpeed, float damage, DrawingSurface surface) {
		super(x, y, health, width, height, moveSpeed, damage); 
		
		left = surface.loadImage(graphicPathLeft); 
		right = surface.loadImage(graphicPathRight); 

		graphic = right; 
	}

	/**
	 * draw the Tank on the screen. 
	 * @param surface game screen window 
	 * @param adjustedX actual x position adjusted to view coordinates. 
	 * @param adjustedY actual y position adjusted to view coordinates. 
	 */
	public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
		surface.imageMode(PConstants.CENTER); 
		surface.image(graphic, adjustedX, adjustedY, getWidth(), getHeight());
	}
	
	
	public void changePos(float xChange, float yChange) {
		setXPosition(getX() + xChange);
		setYPosition(getY() + yChange);

		if (xChange > 0) {
			graphic = right; 
		} else if (xChange < 0) {
			graphic = left; 
		}
	}

	/**
	 * automatic control for the tank. Called in draw loop and performs intended behavior. 
	 */
	public void auto(ArrayList<Enemy> enemiesList) {

		/**
		 * go through all enemeis, and look for one which is currently targeting `HomeBase'
		 * 		if attacking HomeBase --- tank will move towards it and attack it. 
		 * else: 
		 * 		go through all enemies and move and attack the nearest enemy. 
		 */
	}
}
