package utility.field.friendly.unit.mecha;
import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;
import utility.field.projectiles.Bullet;
import utility.field.projectiles.Projectile;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList; 

/**
 * Class represents Melner a type of Mech 
 *
 */
public class Melner extends Mech { 

	private static String fileSeperator = System.getProperty("file.separator"); 
	private int ammo; 
	private final int max_ammo; 
		
	public Melner(float x, float y, DrawingSurface surface) {
		// super(x, y, 1200, 3, surface.loadImage("img/Melner.png"));
		super(x, y, 50, 50, 210, 1, 100); 

		left = surface.loadImage("CapstoneProject" + fileSeperator + "img" + fileSeperator + "melner_facing_left.png"); 
		right = surface.loadImage("CapstoneProject" + fileSeperator + "img" + fileSeperator + "melner_facing_right.png"); 

		currentImage = left; 
		ammo = 300; 
		max_ammo = 300; 
	}

	public int getMaxAmmoValue() {
		return max_ammo; 
	}

	public int getAmmoValue() {
		return ammo; 
	}

	/**
	 * should be called to perform a fire of the specified unit. 
	 * @param mouseLocation where the nullet is fired off to 
	 * @return a bullet object that is shot out of this Mech. 
	 */
	@Override
	public Projectile performFire(Point mouseLocation) {
		
		return null;
	}

	@Override
	public void refill() {
		// TODO Auto-generated method stub
		ammo = max_ammo; 
		setCurrentHealth(getMaxHealth());
	}
	
}
