package utility.field.friendly.unit.mecha;
/**
 * Controllable is an interface used for all mech objects 
 *
 */
public interface Controllable {
    
	/**
	 * This method performs the movement of the different types of mechs
	 * @param changeX - allows to move x to the right or to the left 
	 * @param changeY- allows to move y to the right or to the left 
	 */
    public void performMovement(float changeX, float changeY); 
    
    /**
     * This method allows us to fire and aim weapon  
     * @param aim sensitivity 
     */
    public void performFire(float aim); 
}
