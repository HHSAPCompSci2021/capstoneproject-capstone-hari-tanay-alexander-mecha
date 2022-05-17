package utility.field.friendly.unit.mecha;
import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

public class Melner extends Mech {
	
	private PImage melnerGraphic; 

	public Melner(float x, float y, DrawingSurface surface) {
		super(x, y, 1200, 3, surface.loadImage("img/mechaa.jpeg"));

	}
	

}
