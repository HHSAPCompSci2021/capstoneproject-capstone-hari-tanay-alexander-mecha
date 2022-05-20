package utility.field.projectiles;

import utility.field.FieldObject;
/**
 * The Projectile class is a parent class used for different type of weapons 
 *
 */
public abstract class Projectile {
    
    private int damage; 

    // splash dmg is damage in an area. DOT is damage over time, like burn. 
    private boolean hasSplash, hasDOT; 
    private double velocity; 
    
    private float x, y;
    

    /**
     * Projectile instantiates the 4 parameters 
     * @param x - x coordinate
     * @param y - y coordinate
     * @param damage - damage of weapon 
     * @param v - velocity of projectile 
     */
    public Projectile(float x, float y, int damage, double v) {
        this.x = x;
        this.y = y;
        //TODO Auto-generated constructor stub
        this.damage = damage; 
        velocity = v;
    }
    
    /**
     * Sets the damage of the weapon 
     * @param damage - damage of projectile 
     */
    public void setDamage(int damage) {
    	this.damage = damage;
    }
    /**
     * Sets whether or not projectile does Area Damage
     * @param splash - weapon has splash damage
     */
    public void setHasSplash(boolean splash) {
    	splash = hasSplash;
    }
    /**
     * Sets weapon to have burning damage 
     * @param dot - weapon has damage after intial hit
     */
    public void setHasDot(boolean dot) {
    	dot = hasDOT;
    }
    /**
     * Gets the amount of damage the weapon deals 
     * @return the amount of damage 
     */
    public int getDamage() {
        return damage; 
    }
    /**
     * Gets the amount of damage the splash weapon does
     * @return splash damage 
     */
    public boolean getHasSplash() {
    	return hasSplash;
    }
    /**
     * Gets the amount of damage weapon does after initial hit
     * @return damage of the weapon 
     */
    public boolean getHasDot() {
    	return hasDOT;
    }
    /**
     * Gets the velocity of the projectile 
     * @return velocity of bullet/missile
     */
    public double getVelocity() {
    	return velocity;
    }

    public void changePos(float xChange, float yChange) {
    	x += xChange;
    	y += yChange;
    }
    
    public float getX() {
    	return x;
    }
    
    public float getY() {
    	return y;
    }
}
