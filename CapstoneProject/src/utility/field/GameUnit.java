package utility.field;

import core.DrawingSurface; 
import java.awt.geom.Rectangle2D; 

/**
* class representing all the game relevant actors on the field, this will include enemies and allies with health. 
* @author alexyue
*/
public abstract class GameUnit extends FieldObject {
    private float currentHealth;
    private final float maxHealth;  
    
    private float width, height; 
    
    /**
     * gets the width of the object on screen
     * @return the width of the object on screen
     */
    public float getWidth() {
        return width;
    }
    
    /**
     * sets the width of the object on screen
     * @param width the new width of the object on screen
     */
    public void setWidth(float width) {
        this.width = width;
    }
    
    /**
     * gets the height of the object on screen
     * @return the height of the object on screen
     */
    public float getHeight() {
        return height;
    }
    
    /**
     * sets the height of the object on screen
     * @param height the new height of the object on screen
     */
    public void setHeight(float height) {
        this.height = height;
    }
    
    /**
    * Constructs a new <code>GameUnit</code> with specified health. 
    * @param x map x coordinate 
    * @param y map y coordinate 
    * @param health initial health of the specified unit. max health is also initialized final to this value. 
    * @param width width of bounding rect. 
    * @param height height of bounding rect. 
    */
    public GameUnit(float x, float y, float health, float width, float height) {
        super(x, y); 
        this.currentHealth = health; 
        this.width = width; 
        this.height = height; 
        maxHealth = this.currentHealth; 
    }
    
    /**
     * gets the current hitpoints of the object on screen
     * @return the width of the object on screen
     */
    public float getCurrentHealth() {
        return currentHealth; 
    }
    
    /**
     * sets the health of specified object on screen to custom amount
     * @param newHealthVal the custom health amount to be set to
     */
    public void setCurrentHealth(float newHealthVal) {
        currentHealth = newHealthVal; 
    }
    
    /**
     * gets the maximum hitpoints of the object on screen
     * @return the max potential health of the object on screen
     */
    public float getMaxHealth() {
        return maxHealth; 
    }
    
    @Override
    public void draw(DrawingSurface surface, float adjustedX, float adjustedY) {
        
    }
    
    /**
    * method that shows health bars for all game units, since they have a health property. 
    * @param surface game window. 
    * @param adjustedX adjusted x coordinate, should be calculated to the center x of this object. 
    * @param adjustedY adjusted y coordinate, should be calculated to the center y of this object. 
    */
    public void showHealthBar(DrawingSurface surface, float adjustedX, float adjustedY) {
        // Draw base rectangle above object. 
        surface.fill(140); 
        
        float newX = adjustedX - (width/2) - 10; 
        float newY = adjustedY - (height / 2) - 20; 
        
        Rectangle2D.Float healthBar = new Rectangle2D.Float(newX, newY, width * 1.3f, 10); 
        
        surface.rect(healthBar.x, healthBar.y, healthBar.width, healthBar.height); 
        
        // Calculate the current percent of health remaining. 
        float currentHealthPercent = currentHealth / maxHealth; 
        
        if (currentHealthPercent >= 0.50f) {
            surface.fill(0, 153, 51);
        } else if (currentHealthPercent >= 0.20f) {
            surface.fill(204, 153, 0); 
        } else {
            // current health is low! 
            surface.fill(204, 0, 0);
        }
        
        surface.rect(healthBar.x, healthBar.y, healthBar.width * currentHealthPercent, healthBar.height); 
    }

    
    /**
     * reduce the HP of this <code>GameUnit</code> by the specified amount of health. 
     * @param damage damage taken by specified unit. 
     */
    public void inflictDamage(float damage) {
        setCurrentHealth(getCurrentHealth() - damage); 
    }
    
}

