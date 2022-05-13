package utility.field.friendly.unit.mecha;

import processing.core.PApplet;

public class Stelwart extends Mech{

	public Stelwart(float x, float y) {
		super(x, y, 1500, 1);
	}
	
	public void draw(PApplet drawer) {
		
		drawer.image(drawer.loadImage("img/mech3.png"),getX(), getY(),100,100);
		
	}

}
