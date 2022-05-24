package screens.integration;

import java.awt.geom.Rectangle2D;
import java.awt.Point; 

import core.DrawingSurface;
import processing.core.PConstants;

/**
 * Invoked whenever a pause is initiated in the game
 * @author alexyue
 *
 */
public class PauseHandler {
    
    //  Button exists in regular gameplay at top right corner. 
    private float pauseButtonX, pauseButtonY;
    private int DRAWING_WIDTH, DRAWING_HEIGHT; 
    
    private Rectangle2D.Float pauseButton; 
    private Rectangle2D.Float[] pauseMenuButtons; 
    
    private String[] pauseButtonStrings; 

    /**
     * Gets the menu button
     * @param index the index at which the desired menu button is located
     * @return the menu button at specified index
     */
    public Rectangle2D.Float getMenuButton(int index) {
        return pauseMenuButtons[index]; 
    }

    /**
     * Gets the pause button
     * @return the pause button
     */
    public Rectangle2D.Float getPauseButton() {
        return pauseButton; 
    }
    
    public PauseHandler(int DRAWING_WIDTH, int DRAWING_HEIGHT) {
        this.DRAWING_WIDTH = DRAWING_WIDTH; 
        this.DRAWING_HEIGHT = DRAWING_HEIGHT; 
        
        // * rectangles for pause menu functionality. 
        // 0 - resume game 
        // 1 - quit game (go back to home screen) 
        // 2 - restart (restart game - at select screen) 
        // 3 - close 
        pauseMenuButtons = new Rectangle2D.Float[] {
            new Rectangle2D.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.30), 300, 42), 
            new Rectangle2D.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.42), 300, 42), 
            new Rectangle2D.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.54), 300, 42), 
            new Rectangle2D.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.66), 300, 42)
        }; 
        
        // * rectangle for pause button during gameplay. 
        pauseButtonX = DRAWING_WIDTH - 20; 
        pauseButtonY = 20; 
        pauseButton = new Rectangle2D.Float(pauseButtonX - 20, pauseButtonY - 20, 30, 30); 
        
        // * Strings for pause menu options. 
        pauseButtonStrings = new String[] {
            "RESUME", 
            "QUIT GAME", 
            "RESTART", 
            "CLOSE"
        }; 
    }
    
    /**
     * Use this method to display a pause button in the top right corner of the screen. 
     * @param surface processing window that is used to draw. 
     * @param mouseLocation current mouse location in the form of a <code>Point</code> 
     */
    public void pauseButtonInGameplay(DrawingSurface surface, Point mouseLocation) {
        // !pause button 
        if (pauseButton.contains(mouseLocation)) {
            surface.fill(255, 30, 30); 
        } else {
            surface.fill(0, 0, 0); 
        }
        surface.rect(pauseButtonX - 4, pauseButtonY - 10, 2, 15); 
        surface.rect(pauseButtonX + 3, pauseButtonY - 10, 2, 15);
    } 
    
    /**
     * Use this method to display a pause menu when the game is paused. 
     * @param surface processing window that is used to draw. 
     * @param mouseLocation current mouse location in the form of a <code>Point</code> 
     */
    public void pauseButtonInPause(DrawingSurface surface, Point mouseLocation) {
        // draw pause window. 
        surface.fill(0, 0, 153); 
        surface.stroke(204, 153, 0);
        surface.rect(DRAWING_WIDTH * 0.25f, DRAWING_HEIGHT * 0.20f, DRAWING_WIDTH * 0.50f, DRAWING_HEIGHT * 0.60f, 2); 
        
        for (int i = 0; i < 4; i++) {		
            // values for each pause button. 		
            float topLeftX = pauseMenuButtons[i].x; 
            float topLeftY = pauseMenuButtons[i].y; 
            float boxWidth = pauseMenuButtons[i].width; 
            float boxHeight = pauseMenuButtons[i].height; 
            
            // create a hover animation. 
            if (pauseMenuButtons[i].contains(mouseLocation)) {
                surface.fill(255, 255, 255);
            } else {
                surface.fill(200, 200, 200); 
            }
            
            // base pause button draw. Add string in center of each box. 
            surface.rect(topLeftX, topLeftY, boxWidth, boxHeight);
            surface.textAlign(PConstants.CENTER, PConstants.CENTER);
            surface.fill(0); 
            surface.text(pauseButtonStrings[i], (float)pauseMenuButtons[i].getCenterX(), (float)pauseMenuButtons[i].getCenterY());
        }
    }
}
