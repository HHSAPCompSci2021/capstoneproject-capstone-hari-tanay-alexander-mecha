package utility.field.friendly;


public class MobileUnit extends Allied {

	private float moveSpeed; 
	private float damage; 
	
	public MobileUnit(float x, float y, float health, float width, float height, float moveSpeed, float damage) {
		super(x, y, health, width, height); 
		this.moveSpeed = moveSpeed; 
		this.damage = damage; 
	}

		
    public float getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(float moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public float getDamage() {
		return damage; 
	}

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
