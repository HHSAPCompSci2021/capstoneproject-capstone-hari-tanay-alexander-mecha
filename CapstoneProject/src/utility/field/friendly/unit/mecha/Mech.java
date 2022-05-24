package utility.field.friendly.unit.mecha;
import java.lang.reflect.WildcardType;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PConstants;
import screens.Screen;
import utility.field.FieldObject;
import utility.field.friendly.Allied;
import utility.field.projectiles.Projectile;
import processing.core.PImage; 
import java.awt.Point; 

/**
 * Superclass for all starter mechs
 * @author tbartwal666 
 */
public abstract class Mech extends Allied {
	
	protected PImage currentImage, left, right; 
	private float moveSpeed, damage; 
	
	/**
	 * Mech class takes 4 parameters (xCord, yCord, health, movementSpeed)
	 * @param x - xCord
	 * @param y - yCord
	 * @param h - health
	 * @param mS - movementSpeed
	 */
	public Mech(float x, float y, float width, float height, float health, float mS, float damage) { 
		super(x, y, health, width, height); 
		this.moveSpeed = mS; 
		this.damage = damage; 
	}	
	
	/**
	 * Draws all mechs to the screen
	 * @param surface the specified screen on which it is drawn on
	 * @param x x-coord
	 * @param y y-coord
	 */
	public void draw(DrawingSurface surface, int x, int y) {
		surface.imageMode(PConstants.CENTER);
		surface.image(currentImage, x, y, getWidth(), getHeight()); 
	}

	/**
	 * Gets the damage per hit value
	 * @return the hp damage value
	 */
	public float getDamage() {
		return damage; 
	}
	
	/**
	 * Method changes the position of the mech 
	 */
	public void performMovement(int xChange, int yChange) {
		setXPosition(getX() + (xChange * moveSpeed)); 
		setYPosition(getY() + (yChange * moveSpeed)); 

		if (xChange > 0) {
			currentImage = right; 
		} else if (xChange < 0) {
			currentImage = left; 
		}
	}

	 /**
     * This method allows us to fire and aim weapon  
     * @param aim sensitivity 
     */
	public abstract Projectile performFire(Point mouseLocation); 
	
	/**
	 * method called to reset the stats of the <code>Mech</code> when it hovers over the base. 
	 */
	public abstract void refill(); 
}
