package utility.field.friendly;

import java.util.logging.Handler;

import utility.field.friendly.unit.mecha.Controllable;
/**
 * A DefenseUnit is a type of Ally which protects the Base 
 * @author tbartwal666
 *
 */
public class DefenseUnit extends Allied {

    /**
     * DefenseUnit instantiates its fields and the fields from the super 
     * @param x - x coordinate 
     * @param y - y coordinate 
     */
	public DefenseUnit(float x, float y, float health, float width, float height) {
		super(x, y, health, width, height); 

	}
	
	public void draw() {
		
	}
	
	/**
	 * final changePos for <code>DefenseUnit</code>. 
	 * should not change the position at all
	 */
	public void changePos(float xChange, float yChange) {
		
	}

}
