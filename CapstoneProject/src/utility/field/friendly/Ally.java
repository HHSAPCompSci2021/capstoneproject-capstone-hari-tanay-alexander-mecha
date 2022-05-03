package utility.field.friendly;

import utility.field.GameUnit;

/**
 * class representing an Ally. 
 * - this is to ensure no Ally can damage another ally. 
 * - class is made abstract to avoid any Ally classes made. 
 */
public abstract class Ally extends GameUnit {
    
    public Ally(float x, float y) {
        super(x, y); 
    }
}
