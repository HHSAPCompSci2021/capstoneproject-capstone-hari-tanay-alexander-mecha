package utility.field.projectiles;

import core.DrawingSurface;

/**
	 * Missile class 
	 *
	 */
public class Missile extends Projectile {

    private int damageOverTime; 
    /**
     * Missile class takes 5 parameters 
     * @param x (location shot from) 
     * @param y (location shot from) 
     * @param damage (amount of AOE damage) 
     * @param damageOverTime (Amount of health decreasing by second) 
     * @param v (velocity) 
     */
    public Missile(float x, float y, int damage, int damageOverTime, double v, DrawingSurface surface) {
        super(x, y, damage, v, surface.loadImage("img/missile.png"));

        this.damageOverTime = damageOverTime; 
        setHasDot(true); 
        setHasSplash(true);
        
    }
    
}
