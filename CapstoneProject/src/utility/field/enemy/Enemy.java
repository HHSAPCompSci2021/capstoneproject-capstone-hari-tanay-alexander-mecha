package utility.field.enemy;

import java.lang.reflect.Field;
import java.util.ArrayList;

import core.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import screens.GameScreen;
import utility.field.FieldObject;
import utility.field.GameUnit;
import utility.field.friendly.Allied;
import utility.field.projectiles.Bullet;

/**
 * class to emulate the enemies that appear on-screen to fend off
 * @author alexyue
 *
 */
public class Enemy extends GameUnit {

	private PImage current, left, right; 
	private static String fileSeperator = System.getProperty("file.separator"); 
	private Allied target; 

	
	public Enemy(float x, float y, float health, float width, float height, DrawingSurface surface) {
		super(x, y, health, width, height);

		left = surface.loadImage("img/enemy_soldier_left.png"); 
		right = surface.loadImage("img/enemy_soldier_right.png"); 
		current = left; 
		
		
	}

	public void draw(DrawingSurface surface, int x, int y) {
		surface.imageMode(PConstants.CENTER);
		surface.image(current, x, y, getWidth(), getHeight()); 
	}

	/**
	 * gets the target of the enemy
	 * @return the object the enemy will be targeting
	 */
	public Allied getTarget() {
		return target; 
	}


	/**
	 * method that finds target and locks onto it
	 * @param fieldObjects list of objects on screen for the enemy to lock onto
	 */
	public void auto(ArrayList<FieldObject> fieldObjects) {
		

		int closest_index = 0; 
		int lowest_distance = 10000; 
		// Fine closest ally 
		for (int index = 0; index < fieldObjects.size(); index++) {
			if (fieldObjects.get(index) instanceof Allied) {
				if (fieldObjects.get(index).getPosition().distance(this.getPosition()) < lowest_distance) {
					lowest_distance = (int)fieldObjects.get(index).getPosition().distance(this.getPosition()); 
					closest_index = index; 
				}
				
			}
		}


		if (fieldObjects.get(closest_index).getPosition().distance(this.getPosition()) < 200) {
			// Close enough, fire it. 
			target = (Allied)fieldObjects.get(closest_index); 
		} else {
			target = null; 
			
			int xChange, yChange; 
			if (fieldObjects.get(closest_index).getX() > this.getX()) {
				xChange = 5; 
			} else {
				xChange = -5; 
			}

			if (fieldObjects.get(closest_index).getY() > this.getY()) {
				yChange = 5; 				
			} else {
				yChange = -5; 
			}

			changePos(xChange, yChange);
		}
	}

	/**
	 * fires at specified object with bullets
	 * @return bullet to be drawn on screen and fire at specified target
	 */
	public Bullet performFire() {
		System.out.println("this function is called");
		float yChange = this.getY() - target.getY(); 
		float xChange = this.getX() - target.getX(); 
		float angle = (float)Math.tan(yChange / xChange); 

		Bullet fired = new Bullet(getX(), getY(), 30, 4, 500, angle, "ENEMY"); 

		return fired; 
	}



}
