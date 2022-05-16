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
    private Rectangle2D.Float shopPanelBoundary, shopWindowBoundary; 
    
    private Rectangle2D.Float[] shopMenuButtonsRectangles; 
    private String[] shopButtonStrings; 
    
    /**
    * get a specified rectangle which represents a button of the shop menu. 
    * @param index which rectangle is needed. 
    * @return the rectangle specified for which button is used. 
    */
    public Rectangle2D.Float getShopMenuButton(int index) {
        return shopMenuButtonsRectangles[index]; 
    }

    public Rectangle2D.Float getShopLaunchButton() {
        return launchShopButton; 
    }
    
    public ShopHandler(int DRAWING_WIDTH, int DRAWING_HEIGHT) {
        this.DRAWING_WIDTH = DRAWING_WIDTH; 
        this.DRAWING_HEIGHT = DRAWING_HEIGHT; 
        
        shopPanelBoundary = new Rectangle2D.Float(0, 0.75f * DRAWING_HEIGHT, DRAWING_WIDTH * 0.24f, DRAWING_HEIGHT / 4f); 
        shopWindowBoundary = new Rectangle2D.Float(DRAWING_WIDTH * 0.25f, DRAWING_HEIGHT * 0.20f, DRAWING_WIDTH * 0.75f, DRAWING_HEIGHT * 0.80F); 

        // * rectangles for shop menu functionality. 
        // 0 - purchase a tank.  
        // 1 - purchase a soldier.  
        // 2 - upgrade the tank, damage and health increase.  
        // 3 - upgrade the solder, damage and health increase. 
        // TODO make the buttons in the desired layout. 
        // ! running will cause exception, index-out-of-bounds error. 
        shopMenuButtonsRectangles = new Rectangle2D.Float[] {
            new Rectangle2D.Float(shopWindowBoundary.x + 40, shopWindowBoundary.y + 40, 100, 100), 
            new Rectangle2D.Float((float)shopWindowBoundary.getMaxX() - 140, shopWindowBoundary.y + 40, 100, 100), 
            new Rectangle2D.Float((float)shopWindowBoundary.getMaxX() - 140, (float)shopWindowBoundary.getMaxY() - 140, 100, 100), 
            new Rectangle2D.Float(shopWindowBoundary.x + 40, (float)shopWindowBoundary.getMaxY() - 140, 100, 100) 
        };
        
        shopButtonStrings = new String[] {
            "BUY TANK", 
            "BUY SOLDIER", 
            "UPGRADE TANK", 
            "UPGRADE SOLDIER"
        };
        
    }
    
    /**
    * interface to be displayed during gameplay. 
    * @param surface processing window that is used to draw. 
    * @param mouseLocation current mouse location in the form of a <code>Point</code> 
    */
    public void showShopPanel(DrawingSurface surface, Point mouseLocation) {
        surface.fill(0, 0, 133);
        surface.stroke(204, 153, 0); 
        surface.rect(shopPanelBoundary.x, shopPanelBoundary.y, shopPanelBoundary.width, shopPanelBoundary.height); 

        // TODO include text which properly includes the credit amount. 
        surface.textAlign(PConstants.CENTER, PConstants.CENTER); 
        surface.fill(0); 
        surface.text("TODO: [amount of points]", (float)shopPanelBoundary.getCenterX(), shopPanelBoundary.y + 50); 

        
    }
    
    /**
    * interface to be displayed when shop window is accesed. . 
    * @param surface processing window that is used to draw. 
    * @param mouseLocation current mouse location in the form of a <code>Point</code> 
    */
    public void showShopDisplay(DrawingSurface surface, Point mouseLocation) {
        //  Background. 
        surface.stroke(0); 
        surface.fill(255); 
        surface.rect(shopWindowBoundary.x, shopWindowBoundary.y, shopWindowBoundary.width, shopWindowBoundary.height); 

        // * display all buttons in a 'window' style layout, 2 on the top and 2 on the bottom. 
        for (int i = 0; i < 4; i++) {

            float topLeftX = shopMenuButtonsRectangles[i].x; 
            float topLeftY = shopMenuButtonsRectangles[i].y; 
            float boxWidth = shopMenuButtonsRectangles[i].width; 
            float boxHeight = shopMenuButtonsRectangles[i].height; 

            // create a hover animation for each of the buttons. 
            if (shopMenuButtonsRectangles[i].contains(mouseLocation)) {
                surface.fill(255, 255, 255);
            } else {
                surface.fill(200, 200, 200); 
            }

            // base shop button draw, Add string in center, but relativly above. 
            // TODO get icons for shop button puchase. 
            surface.rect(topLeftX, topLeftY, boxWidth, boxHeight); 
            surface.textAlign(PConstants.CENTER, PConstants.TOP); 
            surface.fill(0); 
            surface.text(shopButtonStrings[i], (float)shopMenuButtonsRectangles[i].getCenterX(), topLeftY + 40);
        }
    }
}
