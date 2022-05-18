package screens.integration;

import java.util.ArrayList;

import core.DrawingSurface;
import utility.field.FieldObject;
import utility.field.enemy.Enemy;

import java.awt.geom.Rectangle2D; 
import utility.field.friendly.unit.mecha.Mech;

public class Map {
    private ArrayList<FieldObject> fieldObjects; 

    private Rectangle2D.Float mapRectangle; 
    private int DRAWING_WIDTH, DRAWING_HEIGHT; 

    private int mapWidth, mapHeight; 

    public Map() {
        fieldObjects = new ArrayList<FieldObject>(); 
    }

    /**
     * Recommended constructor, constructs map to specified dimentions, 
     * border will be initialized based on <code>length</code> and <code>width</code> specifications. 
     * @param x length of field. 
     * @param y width of field. 
     */
    public Map(int x, int y, int DRAWING_WIDTH, int DRAWING_HEIGHT) {
        super(); 
        mapWidth = x; 
        mapHeight = y; 

        this.DRAWING_WIDTH = DRAWING_WIDTH; 
        this.DRAWING_HEIGHT = DRAWING_HEIGHT; 
    }

    public void addFieldObject(FieldObject obj) {
        fieldObjects.add(obj); 
    }

    /**
     * To draw the objects in the map including the player. Everything should be drawn relative to player position. 
     * @param surface
     */
    public void draw(DrawingSurface surface, Mech player, Enemy e) {
        // * first draw borders. 
        // get total distance between border and player. 
        int screenCenterX = DRAWING_WIDTH / 2; 
        int screenCenterY = DRAWING_HEIGHT / 2; 

        surface.fill(0);
        surface.stroke(0);
        surface.rect(screenCenterX - player.getX(), screenCenterY - player.getY(), mapWidth, 50); 
        surface.rect(screenCenterX - player.getX(), screenCenterY - player.getY(), 50, mapHeight); 
        surface.rect(screenCenterX - player.getX(), screenCenterY - player.getY() + mapHeight, mapWidth, 50); 
        surface.rect(screenCenterX - player.getX() + mapWidth, screenCenterY - player.getY(), 50, mapHeight); 

        player.draw(surface, screenCenterX, screenCenterY); 
        e.draw(surface, 0, 15);
        
    }

    public void drawMiniMap(DrawingSurface surface) {
        
    }
}
