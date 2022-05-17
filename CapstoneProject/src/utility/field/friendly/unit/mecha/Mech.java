package utility.field.friendly.unit.mecha;
import core.DrawingSurface;
import processing.core.PApplet;
import screens.Screen;
import processing.core.PImage;

/***
 * 
 * @author tbartwal666
 *
 */

/**
 * 
 * @author tbartwal666
 *
 */
public class Mech implements Controllable {
	
	private float xpos, ypos;
	private int health, movementSpeed;
	private PImage img;
	
	/**
	 * Mech class takes 4 parameters (xCord, yCord, health, movementSpeed)
	 * @param x - xCord
	 * @param y - yCord
	 * @param h - health
	 * @param mS - movementSpeed
	 */
	public Mech(float x, float y, int h, int mS, PImage img) {
		xpos = x;
		ypos = y;
		health = h;
		movementSpeed = mS; 
		this.img = img; 
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
	
	public void draw(DrawingSurface surface) {
		surface.image(img, getX(), getY(), 100, 100);
	}
	/**
	 * Method changes the position of the mech 
	 * @param xposChange - Mech moves to the right 
	 * @param yposChange - Mech moves down 
	 * @param xnegChange - Mech moves to the left
	 * @param ynegChange - Mech moves up 
	 * @param surface - PApplet surface
	 */
	public void changePos(int xposChange, int yposChange,int xnegChange, int ynegChange,DrawingSurface surface) {
		if (surface.isPressed(1)) {
			xpos += xposChange;
		} else if (surface.isPressed(2)) {
			ypos += yposChange;
		} else if (surface.isPressed(3)) {
			xpos -= xnegChange;
		} else if(surface.isPressed(4)) {
			ypos -= ynegChange;
		}
	}

	@Override
	public void performMovement(float changeX, float changeY) {
		
		
	}

	@Override
	public void performFire(float aim) {
		
		
	}
}
