package utility.field.projectiles;

import utility.field.FieldObject;

public abstract class Projectile extends FieldObject{
    
    protected int damage; 

    // splash dmg is damage in an area. DOT is damage over time, like burn. 
    protected boolean hasSplash, hasDOT; 
    protected double velocity; 

    public int getDamage() {
        return damage; 
    }


    public Projectile(float x, float y, int damage) {
        super(x, y);
        //TODO Auto-generated constructor stub
        this.damage = damage; 
    }


    @Override
    public void changePos(float xChange, float yChange) {

    }
}
