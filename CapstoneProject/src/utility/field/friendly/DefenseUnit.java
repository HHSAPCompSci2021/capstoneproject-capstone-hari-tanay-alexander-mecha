package utility.field.friendly;

import utility.field.friendly.unit.mecha.Controllable;
/**
 * A DefenseUnit is a type of Ally which protects the Base 
 * @author tbartwal666
 *
 */
public class DefenseUnit extends Allied {

	private float posX, posY;
    private int health, moveSpeed;
    /**
     * DefenseUnit instantiates its fields and the fields from the super 
     * @param x - x coordinate 
     * @param y - y coordinate 
     */
	public DefenseUnit(float x, float y) {
		super(x,y);
	}
	
	public void draw() {
		
	}
	
	public void changePos(float xChange, float yChange) {
		
	}

}
