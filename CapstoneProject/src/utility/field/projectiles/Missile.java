package utility.field.projectiles;

public class Missile extends Projectile {

    private int damageOverTime; 

    public Missile(float x, float y, int damage, int damageOverTime, double v) {
        super(x, y, damage, v);

        this.damageOverTime = damageOverTime; 
        setHasDot(true); 
        setHasSplash(true);
        
    }
    
}
