package utility.field.friendly.unit.mecha;
import processing.core.PApplet;
import processing.core.PImage;

public class Melner extends Mech {
	
	public Melner(float x, float y) {
		super(x, y, 1200, 3);
	}
	
	public void draw(PApplet drawer) {
		
		drawer.image(drawer.loadImage("img/mechaa.jpeg"),getX(),getY(),100,100);
		
	}

}
