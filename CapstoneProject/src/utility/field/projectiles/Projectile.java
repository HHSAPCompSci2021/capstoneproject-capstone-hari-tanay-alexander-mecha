package utility.field.projectiles;

import utility.field.FieldObject;

public abstract class Projectile extends FieldObject{
    
    private int damage; 

    // splash dmg is damage in an area. DOT is damage over time, like burn. 
    private boolean hasSplash, hasDOT; 
    private double velocity; 

    
    public Projectile(float x, float y, int damage, double v) {
        super(x, y);
        //TODO Auto-generated constructor stub
        this.damage = damage; 
        velocity = v;
    }
    
    public void setDamage(int damage) {
    	this.damage = damage;
    }
    
    public void setHasSplash(boolean splash) {
    	splash = hasSplash;
    }
    
    public void setHasDot(boolean dot) {
    	dot = hasDOT;
    }
    
    public int getDamage() {
        return damage; 
    }
    
    public boolean getHasSplash() {
    	return hasSplash;
    }
    
    public boolean getHasDot() {
    	return hasDOT;
    }
    
    public double getVelocity() {
    	return velocity;
    }
    @Override
    public void changePos(float xChange, float yChange) {

    }
}
