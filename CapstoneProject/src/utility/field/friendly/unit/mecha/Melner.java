package utility.field.friendly.unit.mecha;
import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;
import utility.field.projectiles.Bullet;
import java.awt.Point; 

/**
 * Class represents Melner a type of Mech 
 *
 */
public class Melner extends Mech {
	
	public Melner(float x, float y, DrawingSurface surface) {
		super(x, y, 1200, 3, surface.loadImage("img/Melner.png"));

	}
	
	public void performFire(Point mouseLocation) {
		
	}
	
	
}
