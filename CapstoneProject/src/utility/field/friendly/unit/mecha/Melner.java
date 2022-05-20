package utility.field.friendly.unit.mecha;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;
import utility.field.projectiles.Bullet;
/**
 * Class represents Melner a type of Mech 
 *
 */
public class Melner extends Mech {
	
	private static ArrayList bullets;
	
	public Melner(float x, float y, DrawingSurface surface) {
		super(x, y, 1200, 3, surface.loadImage("img/Melner.png"));
		bullets = new ArrayList();
	}
	
	public ArrayList getBullets() {
		return bullets;
	}
	
	
	
	public void performFire() {
		Bullet b = new Bullet(getX()+60, (getY()+154/2), 200, 2);
		bullets.add(b);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			performFire();
		}
	}
}
