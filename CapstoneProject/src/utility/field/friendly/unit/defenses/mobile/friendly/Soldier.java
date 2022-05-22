package utility.field.friendly.unit.defenses.mobile.friendly;
import java.util.ArrayList;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import utility.field.enemy.Enemy;
import utility.field.friendly.MobileUnit; 
import java.awt.geom.Rectangle2D; 

public class Soldier extends MobileUnit {

	private PImage graphic, left, right; 
	// private static String graphicPathRight = "CapstoneProject\\img\\tank_pointing_right.png"; 
	// private static String graphicPathLeft = "CapstoneProject\\img\\tank_pointing_left.png"; 
	// TODO get graphics 

	public Soldier(float x, float y, float health, float width, float height, float moveSpeed, float damage, DrawingSurface surface) {
		super(x, y, health, width, height, moveSpeed, damage); 

		left = surface.loadImage("CapstoneProject\\img\\solder_looking_left.png"); 
		right = surface.loadImage("CapstoneProject\\img\\solder_looking_right.png"); 

		graphic = right; 
	}
	
	/**
	 * Draw the solder. 
	 * @param surface game window 
	 * @param adjustedX adjusted x value based on view coordinates. 
	 * @param adjustedY adjusted y value based on view coordinates. 
	 */
	public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
		surface.imageMode(PConstants.CENTER); 
		surface.image(graphic, adjustedX, adjustedY, getWidth(), getHeight()); 
	}
	
	/**
	 * change the position of the Soldier by increment. 
	 * @param xChange change in x position 
	 * @param yChange change in y position 
	 */
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
	 * automatically makes controls possible for <code>Soldier</code>. 
	 * @param enemiesList list that contains all active enemies. 
	 */
	public void auto(ArrayList<Enemy> enemiesList) {
		
		/**
		 * similar to tank. NOTE. 
		 * go through all enemeis, and look for one which is currently targeting `HomeBase'
		 * 		if attacking HomeBase --- tank will move towards it and attack it. 
		 * else: 
		 * 		go through all enemies and move and attack the nearest enemy. 
		 */
	}

	/**
	 * return a boundring rect that represents the boundary of the rectangle. 
	 * @return Rectangle2D.Float rectangle. 
	 */
	public Rectangle2D.Float getBoundary() {
		return new Rectangle2D.Float(
			getX() - (getWidth()/2), 
			getY() - (getHeight()/2), 
			getWidth(), 
			getHeight()
		); 
	}
}
