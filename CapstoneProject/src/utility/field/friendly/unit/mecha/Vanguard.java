package utility.field.friendly.unit.mecha;

import processing.core.PApplet;


public class Vanguard extends Mech{

	public Vanguard(float x, float y) {
		super(x,y, 1000, 5);
		
	}
	public void draw(PApplet drawer) {
		
		drawer.image(drawer.loadImage("img/mech1.png"),getX(), getY()+50,100,100);
	}
	
	
	

}
