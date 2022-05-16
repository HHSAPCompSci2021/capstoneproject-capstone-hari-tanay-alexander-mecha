package screens.integration;

import java.awt.geom.Rectangle2D; 
import java.awt.Point; 

import core.DrawingSurface;
import processing.core.PConstants; 

public class ShopHandler {
    
    private int DRAWING_WIDTH, DRAWING_HEIGHT; 

    // in game UI
    private Rectangle2D.Float launchShopButton; 

    // in shop UI
    private Rectangle2D.Float shopPanelBoundary; 
    private Rectangle2D.Float[] shopMenuButtonsRectangles; 
    private String[] shopButtonStrings; 
        

    public ShopHandler(int DRAWING_WIDTH, int DRAWING_HEIGHT) {
        this.DRAWING_WIDTH = DRAWING_WIDTH; 
        this.DRAWING_HEIGHT = DRAWING_HEIGHT; 

        // * rectangles for shop menu functionality. 
        // 0 - purchase a tank.  
        // 1 - purchase a soldier.  
        // 2 - upgrade the tank, damage and health increase.  
        // 3 - upgrade the solder, damage and health increase. 
		// TODO
		shopMenuButtonsRectangles = new Rectangle2D.Float[] {
			// new Rectangle2D.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.30), 300, 42), 
			// new Rectangle2D.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.42), 300, 42), 
			// new Rectangle2D.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.54), 300, 42), 
			// new Rectangle2D.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.66), 300, 42)
            new Rectangle2D.Float()
		};
		
		shopButtonStrings = new String[] {
			"BUY TANK", 
			"BUY SOLDIER", 
			"UPGRADE TANK", 
			"UPGRADE SOLDIER" 
		};

        shopPanelBoundary = new Rectangle2D.Float(0, 0.75f * DRAWING_HEIGHT, DRAWING_WIDTH * 0.24f, DRAWING_HEIGHT / 4f); 

    }

    /**
     * interface to be displayed when shop window is open. 
     * @param surface processing window that is used to draw. 
     * @param mouseLocation current mouse location in the form of a <code>Point</code> 
     */
    public void showShopDisplay(DrawingSurface surface, Point mouseLocation) {

    }

    /**
     * interface to be displayed during gameplay. 
     * @param surface processing window that is used to draw. 
     * @param mouseLocation current mouse location in the form of a <code>Point</code> 
     */
    public void shopShopPanel(DrawingSurface surface, Point mouseLocation) {
        surface.stroke(0); 
        surface.fill(255); 
        surface.rect(shopPanelBoundary.x, shopPanelBoundary.y, shopPanelBoundary.width, shopPanelBoundary.height);
    }
}
