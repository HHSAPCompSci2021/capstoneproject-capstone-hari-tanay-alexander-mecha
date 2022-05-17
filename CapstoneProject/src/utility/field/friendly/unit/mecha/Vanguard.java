package utility.field.friendly.unit.mecha;

import core.DrawingSurface;
import processing.core.PApplet;

/**
 * Vanguard represents a type of Mech 
 *
 */
public class Vanguard extends Mech{
	/**
	 * Vanguard instantiates fields from the super 
	 * @param x
	 * @param y
	 * @param surface
	 */
	public Vanguard(float x, float y, DrawingSurface surface) {
		super(x,y, 1000, 5, surface.loadImage("img/mech1.png"));
		
	}
	/**
	 * Draws Vanguard sprite on to PApplet surface
	 * @param drawer - PApplet surface 
	 */
	public void draw(PApplet drawer) {
		
		drawer.image(drawer.loadImage("img/mech1.png"),getX(), getY()+50,100,100);
	}
	
	
	

}
