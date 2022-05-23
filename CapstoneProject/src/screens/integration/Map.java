package screens.integration;

import java.util.ArrayList;

import core.DrawingSurface;
import utility.field.FieldObject;
import utility.field.Inanimate;
import utility.field.enemy.Enemy;

import java.awt.geom.Rectangle2D;

import utility.field.friendly.Allied;
import utility.field.friendly.unit.mecha.Mech;

public class Map {
    private ArrayList<FieldObject> fieldObjects; 

    private Rectangle2D.Float mapRectangle; 
    private int DRAWING_WIDTH, DRAWING_HEIGHT; 

    private float minimapWidth, minimapHeight; 

    private int mapWidth, mapHeight; 

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
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

        fieldObjects = new ArrayList<>(); 

        this.DRAWING_WIDTH = DRAWING_WIDTH; 
        this.DRAWING_HEIGHT = DRAWING_HEIGHT; 

        minimapWidth = 0.2f * DRAWING_WIDTH; 
        minimapHeight = 0.2F * DRAWING_HEIGHT; 
    }

    public void addFieldObject(FieldObject obj) {
        fieldObjects.add(obj); 
        System.out.println("An object was just added. ");
    }

    /**
     * To draw the objects in the map including the player. Everything should be drawn relative to player position. 
     * @param surface game window where the objects should be drawn. 
     * @param player Mech player with which the view is configured to. 
     */
    public void draw(DrawingSurface surface, Mech player) {
        // * first draw borders. 
        // get total distance between border and player. 
        int screenCenterX = DRAWING_WIDTH / 2; 
        int screenCenterY = DRAWING_HEIGHT / 2; 


        // map borders, may be needed to placed into its own class. 
        surface.fill(0);
        surface.stroke(0);
        surface.rect(screenCenterX - player.getX(), screenCenterY - player.getY(), mapWidth, 50); 
        surface.rect(screenCenterX - player.getX(), screenCenterY - player.getY(), 50, mapHeight); 
        surface.rect(screenCenterX - player.getX(), screenCenterY - player.getY() + mapHeight, mapWidth, 50); 
        surface.rect(screenCenterX - player.getX() + mapWidth, screenCenterY - player.getY(), 50, mapHeight); 

        // ! should be changed, each of the classes should be responsible for their own draw method. 
        player.draw(surface, screenCenterX, screenCenterY); 

        //  viewX and viewY will define the coordinates of the upper left corner of the current window view of the map. 
        float viewX = player.getX() - (DRAWING_WIDTH / 2); 
        float viewY = player.getY() - (DRAWING_HEIGHT / 2); 

        /**
         * cycle through all the items in the list, and create 
         */
        for (FieldObject mapComponent : fieldObjects) {
            // draw the object onto the map, using adjusted coordinates. 
            float perspectiveX = mapComponent.getX() - viewX; 
            float perspectiveY = mapComponent.getY() - viewY; 

            mapComponent.draw(surface, perspectiveX, perspectiveY); 
        }
        
        
    }

    public void drawMiniMap(DrawingSurface surface) {
        surface.fill(255);
        surface.stroke(0);


        surface.rect(0, 0, minimapWidth, minimapHeight);  

        for (FieldObject mapComponent : fieldObjects) {
            if (mapComponent instanceof Mech) {
                surface.fill(0, 0, 255);
            } else if (mapComponent instanceof Enemy) {
                surface.fill(255, 0, 0);
            } else if (mapComponent instanceof Allied) {
                surface.fill(0, 191, 255); 
            } else if (mapComponent instanceof Inanimate) {
                surface.fill(89);
            }

            float minimapRelativeX = (minimapWidth) * (mapComponent.getX() / this.mapWidth); 
            float minimapRelativeY = (minimapHeight) * (mapComponent.getY() / this.mapHeight); 

            surface.circle(minimapRelativeX, minimapRelativeY, 10);
        }
    }
}
