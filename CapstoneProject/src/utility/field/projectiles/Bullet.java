package utility.field.projectiles;

import core.DrawingSurface;
import processing.core.PImage;

import java.awt.*;

/**
 * Bullet class represents the bullets in the different guns/projectiles
 *
 */
public class Bullet extends Projectile {
	
	private float range;
	private boolean seen;
	private float x, y;
	
	private PImage img;
	
	/**
	 * Bullet class takes 4 parameters
	 * @param x (where bullet shot from)
	 * @param y (where bullet shot from) 
	 * @param damage
	 * @param v (velocity) 
	 */
	public Bullet(float x, float y, int damage, double v) {
		super(x, y, damage, v);
		seen = true;
		DrawingSurface surface = new DrawingSurface();
		img = surface.loadImage("img/bullet.png");
	}
	/**
	 * Set damage for a specific type of bullet
	 * @param x (amount) 
	 */
	public void setDmg(float x) {
		setDamage((int) x);
	}
	/**
	 * Set how far bullet will shoot 
	 * @param y (range) 
	 */
	public void setRange(float y) {
		range = y;
	}
	
	/**
	 * Get Range for a specific type of bullet
	 * @return the range of the bullet
	 */
	public float getRange() {
		return range;
	}
	
	public void fire() {
		x -= 2;
		
		if(x < 5) 
			seen = false;
		
	}
}
