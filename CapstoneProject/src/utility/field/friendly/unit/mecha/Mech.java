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
	
	/**
	 * Gets x coordinate of the Mech
	 * @return x coordinate
	 */
	public float getX() {
		return xpos;
	}
	/**
	 * Gets y coordinate of the Mech 
	 * @return y coordinate
	 */
	public float getY() {
		return ypos;
	}
	/**
	 * Gets the health of the mech 
	 * @return health 
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Gets the movement speed of the mech 
	 * @return movement speed 
	 */
	public int getMovementSpeed() {
		return movementSpeed;
	}
	/**
	 * Draws mech sprite on to drawingSurface
	 * @param surface of PApplet 
	 */
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

	/**
	 * This method performs the movement of the different types of mechs
	 * @param changeX - allows to move x to the right or to the left 
	 * @param changeY- allows to move y to the right or to the left 
	 */
	public void performMovement(float changeX, float changeY) {
		
		
	}

	 /**
     * This method allows us to fire and aim weapon  
     * @param aim sensitivity 
     */
	public void performFire(float aim) {
		
		
	}
}
