package screens;

import core.DrawingSurface;
import processing.core.PConstants;

public class EndGame extends Screen {

    private DrawingSurface surface; 

    public EndGame(DrawingSurface surface) {
        super(800, 600);
        //TODO Auto-generated constructor stub

        this.surface = surface; 
    }
    
    public void draw() {
        surface.background(255);
        surface.fill(0);
        surface.textAlign(PConstants.CENTER, PConstants.CENTER);
        surface.text("To be finished [Gave Over]", DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2);
    }
}
