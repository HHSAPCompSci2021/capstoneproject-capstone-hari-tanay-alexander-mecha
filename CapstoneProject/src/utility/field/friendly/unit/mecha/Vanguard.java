package utility.field.friendly.unit.mecha;

import processing.core.PApplet;


public class Vanguard extends Mech{

	public Vanguard(float x, float y) {
		super(x,y, 1000, 5);
		
	}
	public void draw(PApplet drawer) {
		
		drawer.image(drawer.loadImage("img/javaspritefallguys.png"),getX(), getY(),30,30);
	}
	
	
	

}
