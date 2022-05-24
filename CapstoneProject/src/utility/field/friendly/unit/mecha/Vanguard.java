package utility.field.friendly.unit.mecha;

import java.awt.Point;

import core.DrawingSurface;
import utility.field.projectiles.Projectile;


public class Vanguard extends Mech {

	private static String fileSeperator = System.getProperty("file.separator"); 
	private int ammo; 
	private final int max_ammo; 
	
	public Vanguard(float x, float y, DrawingSurface surface) {
		// super(x,y, 1000, 5, surface.loadImage("img/Vanguard.png")); 
		super(x, y, 50, 50, 180f, 1.5f, 60); 
		
		left = surface.loadImage("img/vanguard_facing_left.png");  
		right = surface.loadImage("img/vanguard_facing_left.png"); 

		currentImage = left; 
		ammo = 600; 
		max_ammo = 600; 
	}

	public int getAmmoValue() {
		return ammo; 
	} 

	public int getMaxAmmoValue() {
		return max_ammo; 
	}

	@Override
	public Projectile performFire(Point mouseLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refill() {
		ammo = max_ammo; 
		setCurrentHealth(getMaxHealth()); 
		
	}

}
