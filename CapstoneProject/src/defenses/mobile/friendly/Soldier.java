package defenses.mobile.friendly;
import processing.core.PApplet;
import utility.field.friendly.MobileUnit;

public class Soldier extends MobileUnit {

	private float posX, posY;
    private int health, moveSpeed;
	
	public Soldier(float x, float y) {
		super(x, y);
	}
	
	public float getX() {
		return posX;
	}
	
	public float getY() {
		return posY;
	}
	
	public void draw(PApplet drawer) {
		drawer.image(drawer.loadImage("img/barb.jpg"),getX(),getY(),100,100);
	}
	
	public void changePos(float xChange, float yChange) {
		
	}
}
