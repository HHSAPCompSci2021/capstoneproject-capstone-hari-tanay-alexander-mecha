package utility.field;

public abstract class Projectile {
	private float dmg;
	
	public abstract void draw();
	
	public abstract void changePos(float xChange, float yChange);
}
