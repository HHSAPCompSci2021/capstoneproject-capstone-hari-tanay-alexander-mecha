package utility.field.friendly.unit.mecha;

import core.DrawingSurface;
import processing.core.PApplet;


public class Vanguard extends Mech{

	public Vanguard(float x, float y, DrawingSurface surface) {
		super(x,y, 1000, 5, surface.loadImage("img/mech1.png"));
		
	}
	public void draw(PApplet drawer) {
		
		drawer.image(drawer.loadImage("img/mech1.png"),getX(), getY()+50,100,100);
	}
	
	
	

}
