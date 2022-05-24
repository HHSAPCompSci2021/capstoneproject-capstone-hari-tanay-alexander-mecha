package utility.field.projectiles;

import java.util.ArrayList;

import core.DrawingSurface;
import utility.field.FieldObject;
import utility.field.GameUnit;
import utility.field.enemy.Enemy;
import utility.field.friendly.Allied;

/**
 * Bullet class represents the bullets in the different guns/projectiles
 *
 */
public class Bullet extends Projectile {
	
		
	/**
	 * Bullet class takes 4 parameters
	 * @param x current map position. 
	 * @param y current map position. 
	 * @param damage damage of the <code>Bullet</code>. 
	 * @param velocity speed of the <code>Bullet</code>. 
	 * @param range range of the <code>Bullet</code>. 
	 * @param angle angle at which the bullet travels. 
	 * @param source describes what object shot the <code>Bullet</code>. 
	 */
	public Bullet(float x, float y, float damage, float velocity, float range, float angle, String source) {
		super(x, y, damage, velocity, range, angle, source); 


	}

	@Override
	public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
		surface.fill(0);
		surface.stroke(0);
		surface.circle(adjustedX, adjustedY, 5); 

		
	}

	/**
	 * 
	 * @return true if the bullet is finished. 
	 */
	public boolean run(ArrayList<FieldObject> fieldObjects) {
		float x_increment = getVelocity() * (float)Math.cos(angle); 
		float y_increment = getVelocity() * (float)Math.sin(angle); 

		changePos(x_increment, y_increment); 

		if (source == "ENEMY") {
			for (FieldObject mapComponent : fieldObjects) {
				if (mapComponent instanceof Allied) {
					if (mapComponent.getBoundary().contains(this.getPosition())) {
						// Detected a collision, damage ally. 
						GameUnit unit = (GameUnit)mapComponent; 
						unit.inflictDamage(getDamage()); 
						return true; 
					}
				}
			}
		} else if (source == "ALLY") {
			for (FieldObject mapComponent : fieldObjects) {
				if (mapComponent instanceof Enemy) {
					if (mapComponent.getBoundary().contains(this.getPosition())) {
						// detected a collision, damage enemy. 
						GameUnit unit = (GameUnit)mapComponent; 
						unit.inflictDamage(getDamage()); 
						return true; 
					}
				}
			}
		}

		range--; 
		if (range <= 0) {
			return true; 
		}

		return false; 
	}
	

}
