package utility.field.friendly.unit.mecha;

import javax.xml.namespace.QName;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Class represents Stelwart a type of Mech 
 * @author tbartwal666
 *
 */
public class Stelwart extends Mech{

	
	/**
	 * Stelwart instantiates fields from super 
	 * @param x
	 * @param y
	 * @param surface
	 */
	public Stelwart(float x, float y, DrawingSurface surface) {
		super(x, y, 1500, 1, surface.loadImage("img/mech3.png")); 
	}
	

}
