package utility.field.projectiles;
	
/**
 * Bullet class represents the bullets in the different guns/projectiles
 *
 */
public class Bullet extends Projectile {
	
	private float dmg, range;
	/**
	 * Bullet class takes 4 parameters
	 * @param x (where bullet shot from)
	 * @param y (where bullet shot from) 
	 * @param damage
	 * @param v (velocity) 
	 */
	public Bullet(float x, float y, int damage, double v) {
		super(x, y, damage, v);
		
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
	
	
	
	
}
