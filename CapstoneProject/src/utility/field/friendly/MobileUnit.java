package utility.field.friendly;

import processing.core.PImage;

public class MobileUnit extends Allied {
	
    private float moveSpeed;
	
	public MobileUnit(float x, float y, float health, float width, float height, float moveSpeed) {
		super(x, y, health, width, height); 
		this.moveSpeed = moveSpeed; 
	}
	
	public void draw() {
		
	}
	
	/**
	 * defined to move the object based on the movement speed of the objects. 
	 * TODO make this overhead method work. 
	 */
	public void changePos(float xChange, float yChange) {
		
	}
}
