package utility.field.friendly;


public class MobileUnit extends Allied {

	private float moveSpeed; 
	private float damage; 
	
	public MobileUnit(float x, float y, float health, float width, float height, float moveSpeed, float damage) {
		super(x, y, health, width, height); 
		this.moveSpeed = moveSpeed; 
		this.damage = damage; 
	}

	/**
	 * get <code>moveSpeed</code> value, value is permanant. 
	 * @return moveSpeed 
	 */	
    public float getMoveSpeed() {
		return moveSpeed;
	}

	/**
	 * get <code>damage</code> value. 
	 * @return damage 
	 */
	public float getDamage() {
		return damage; 
	}

	/**
	 * set a new value for <code>damage</code>
	 * @param damage new <code>damage</code> value. 
	 */
	public void setDamage(float damage) {
		this.damage = damage;
	}
	
	public void draw() {
		
	}
	
	/**
	 * defined to move the object based on the movement speed of the objects. 
	 * TODO make this overhead method work. 
	 */
	public void changePos(float xChange, float yChange) {
		
	}
}
