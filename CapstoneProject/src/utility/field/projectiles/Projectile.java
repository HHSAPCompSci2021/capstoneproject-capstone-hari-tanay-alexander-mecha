package utility.field.projectiles;

import core.DrawingSurface;
import utility.field.FieldObject;
import utility.field.Inanimate;
import java.awt.Point; 
/**
 * The Projectile class is a parent class used for different type of weapons 
 *
 */
public abstract class Projectile extends FieldObject {
    
    private float damage, velocity; 
    protected float range, angle; 
    protected String source; 

    /**
     * constrctor which creates a new projectile. 
     * @param x current map position. 
     * @param y current map position. 
     * @param velocity speed of <code>Projectile</code> 
     * @param damage damage of <code>Projectile</code> 
     * @param range range of <code>Projectile</code> 
     * @param angle angle of <code>Projectile</code> 
     * @param source describes what object shot the <code>Projectile</code> 
     */
    public Projectile(float x, float y, float velocity, float damage, float range, float angle, String source) {
        super(x, y); 
        this.velocity = velocity; 
        this.damage = damage; 
        this.range = range; 
        this.angle = angle; 
        this.source = source; 
    }

    @Override
    public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
        return; 
    }
    
    /**
     * get the damage value of the projectile. 
     * @return damage 
     */
    public float getDamage() {
        return damage; 
    }
    
    /**
     * return the velocity of the particle, should not change later. 
     * @return velocity of projectile. 
     */
    public float getVelocity() {
        return velocity; 
    }

    public Point getPosition() {
        return new Point((int)this.getX(), (int)(this.getY())); 
    }

}
