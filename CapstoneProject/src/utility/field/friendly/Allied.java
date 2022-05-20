package utility.field.friendly;

import utility.field.GameUnit;

/**
 * class representing an Ally. 
 * - this is to ensure no Ally can damage another ally. 
 * - class is made abstract to avoid any Ally classes made. 
 */
public abstract class Allied extends GameUnit {
	

    /**
     * Creates a class representing a Allied Unit, will be used to mark targets attackable or not based on whether they are an ally or a enemy. 
     * @param x map center x coordinate. 
     * @param y map center y coordinate. 
     * @param health initialized health 
     * @param width width of bounding rect. 
     * @param height height of bounding rect. 
     */
	public Allied(float x, float y, float health, float width, float height) {
        super(x, y, health, width, height); 
    }
	
}
