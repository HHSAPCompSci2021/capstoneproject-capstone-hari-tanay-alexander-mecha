package utility.field.enemy;

import core.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;

public class Enemy {
	private float xpos, ypos;
	private int health, movementSpeed;
	protected PImage img;
	
	
	public Enemy(float xCord, float yCord,int h,int mS, PImage img) {
		xpos = xCord;
		ypos = yCord;
		h = health;
		movementSpeed = mS;
		this.img = img;
	}
	public void draw(DrawingSurface surface, int x, int y) {
		surface.imageMode(PConstants.CENTER);
		surface.image(img, x, y, 100, 100); 
	}
}
