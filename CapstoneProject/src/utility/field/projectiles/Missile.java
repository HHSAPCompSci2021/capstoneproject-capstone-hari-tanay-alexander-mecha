package utility.field.projectiles;

public class Missile extends Projectile {

    private int damageOverTime; 

    public Missile(float x, float y, int damage, int damageOverTime) {
        super(x, y, damage);

        this.damageOverTime = damageOverTime; 
        this.hasDOT = true; 
        this.hasSplash = true; 
    }
    
}
