package utility.field;

import core.DrawingSurface;

/**
 * class representing all the game relevant actors on the field, this will include enemies and allies with health. 
 */
public abstract class GameUnit extends FieldObject {
    private float currentHealth;
    private final float maxHealth;  

    private float width, height; 

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

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

    public float getCurrentHealth() {
        return currentHealth; 
    }

    public void setCurrentHealth(int newHealthVal) {
        currentHealth = newHealthVal; 
    }

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
        surface.rect(newX, newY, width * 1.1f, 20); 

        float currentHealthRatio = currentHealth / maxHealth; 

        if (currentHealthRatio >= 0.50f) {
            surface.fill(0, 153, 51);
        } else if (currentHealthRatio >= 0.20f) {
            surface.fill(204, 153, 0); 
        } else {
            // current health is low! 
            surface.fill(204, 0, 0);
        }

        
        surface.rect(newX + (1-(width * 1.1f * currentHealthRatio)), newY, width * 1.1f * currentHealthRatio, 20);
    }
    
}

