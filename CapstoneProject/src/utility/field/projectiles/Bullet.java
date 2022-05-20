package utility.field.projectiles;

import core.DrawingSurface;

import java.awt.*;

/**
 * Bullet class represents the bullets in the different guns/projectiles
 *
 */
public class Bullet extends Projectile {
	
	private float dmg, range;
	private boolean seen;
	private float x = getX(), y = getY();
	
	/**
	 * Bullet class takes 4 parameters
	 * @param x (where bullet shot from)
	 * @param y (where bullet shot from) 
	 * @param damage
	 * @param v (velocity) 
	 */
	public Bullet(float x, float y, int damage, double v, DrawingSurface surface) {
		super(x, y, damage, v, surface.loadImage("img/bullet.png"));
		seen = true;
	}
	/**
	 * Set damage for a specific type of bullet
	 * @param x (amount) 
	 */
	public void setDmg(float x) {
		dmg=x;
	}
	/**
	 * Set how far bullet will shoot 
	 * @param y (range) 
	 */
	public void setRange(float y) {
		dmg=y;
	}
	/**
	 * Get Damage for a specific type of bullet
	 * @return amount of damage
	 */
	public float getDmg() {
		return dmg;
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
