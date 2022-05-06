package utility.field.friendly.unit.mecha;
import core.DrawingSurface;
import processing.core.PApplet;
import screens.Screen;

public class Mech implements Controllable {
	
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
	
	public void changePos(int change, DrawingSurface surface) {
		if (surface.isPressed(1)) {
			// do something if keycode 1 is pressed 
		} else if (surface.isPressed(2)) {
			// do other stuff. TODO get other. 
		}
	}

	@Override
	public void performMovement(float changeX, float changeY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void performFire(float aim) {
		// TODO Auto-generated method stub
		
	}
}
