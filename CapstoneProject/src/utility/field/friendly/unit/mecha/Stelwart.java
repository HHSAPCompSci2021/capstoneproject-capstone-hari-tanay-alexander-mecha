package utility.field.friendly.unit.mecha;

import java.awt.Point;
import java.util.ArrayList;

import javax.xml.namespace.QName;

import org.w3c.dom.ranges.Range;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;
import utility.field.FieldObject;
import utility.field.enemy.Enemy;
import utility.field.projectiles.Projectile;
/**
 * Class represents Stelwart a type of Mech 
 * @author tbartwal666
 *
 */
public class Stelwart extends Mech {

	private static String fileSeparator = System.getProperty("file.separator"); 
	private int energy; 
	private final int max_energy; 

	/**
	 * Stelwart instantiates fields from super 
	 * @param x
	 * @param y
	 * @param surface
	 */
	public Stelwart(float x, float y, DrawingSurface surface) {
		super(x, y, 50, 50, 250f, 0.8f, 5); 
		
		left = surface.loadImage("img/Stelwart_facing_left.png"); 
		right = surface.loadImage("img/Stelwart_facing_right.png"); 

		currentImage = left; 
		energy = 500; 
		max_energy = 500; 

	}

	/**
	 * Gets maximum amount of energy the stelwart has
	 * @return the max energy the stelwart has
	 */
	public int getMaxEnergyValue() {
		return max_energy; 
	}

	@Override
	/**
	 * <code>Stelwart</code> does not fire, this <code>Mech</code> sprays fire in a 200 range around him. 
	 * as a result, this method should not be used. 
	 */
	public Projectile performFire(Point mouseLocation) {
		return null;
	}

	/**
	 * Gets current energy value of the stelwart
	 * @return the current energy value
	 */
	public int getEnergyValue() {
		return energy; 
	}

	/**
	 * Alternate fire method
	 * @param allObjects the list of all objects on screen
	 * @param surface the game surface
	 * @param screenX the x-coordinate
	 * @param screenY the y-coordinate
	 */
	public void alternateFire(ArrayList<FieldObject> allObjects, DrawingSurface surface, float screenX, float screenY) {
		surface.noFill();
		surface.stroke(255, 0, 0);
		surface.circle(screenX, screenY, 400); 
		energy--; 

		for (FieldObject unit : allObjects) {
			if (unit instanceof Enemy) {
				Point position = new Point((int)getX(), (int)getY()); 

				if (position.distance(new Point((int)unit.getX(), (int)unit.getY())) < 400) {
					// inflict dmg. 
					Enemy e = (Enemy)unit; 
					e.inflictDamage(getDamage());
				}
			}
		}
	}







	@Override
	public void refill() {
		energy = max_energy; 
		setCurrentHealth(getMaxHealth());
	}

	
	

}
