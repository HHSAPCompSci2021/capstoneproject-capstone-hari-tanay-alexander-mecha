package utility.field.projectiles;

public class Bullet extends Projectile {
	
	private float dmg, range;

	public Bullet(float x, float y, int damage, double v) {
		super(x, y, damage, v);
		
	}
	
	public void setDmg(float x) {
		dmg=x;
	}
	
	public void setRange(float y) {
		dmg=y;
	}
	public float getDmg() {
		return dmg;
	}
	
	public float getRange() {
		return range;
	}
	
	
	
	
}
