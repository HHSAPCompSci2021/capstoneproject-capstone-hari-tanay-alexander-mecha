package utility.field.friendly.unit.mecha;
import processing.core.PApplet;

public class Mech {
	
	private float xpos, ypos;
	private int health, movementSpeed;
	
	public Mech(float x, float y, int h, int mS) {
		xpos = x;
		ypos = y;
		health = h;
		movementSpeed = mS;
	}
	
	public float getX() {
		return xpos;
	}
	
	public float getY() {
		return ypos;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMovementSpeed() {
		return movementSpeed;
	}
	
	public void draw() {
		
	}
	
	public void changePos(int change) {
		if(keyPressed) {
			
		}
	}
}
