package screens;

import core.DrawingSurface;
import java.awt.Rectangle;
import java.awt.Point;

public class SelectScreen extends Screen {

    private DrawingSurface surface; 
    private int selection; 

    private Rectangle[] selectionsRectangles; 
    private String[] selectionStrings; 

    public SelectScreen(DrawingSurface surface) {
        super(800, 600);
        this.surface = surface; 

        /**
         * selection 0 indicates no selecction made. 
         * selection 1 indicates option 1. 
         * selection 2 indicates option 2. 
         * selection 3 indicates option 3. 
         */
        selection = 0; 

        selectionsRectangles = new Rectangle[] {
            new Rectangle((int)(DRAWING_WIDTH * 0.10), (int)(DRAWING_HEIGHT * 0.20), (int)(DRAWING_WIDTH * 0.20), (int)(DRAWING_HEIGHT * 0.70)), 
            new Rectangle((int)(DRAWING_WIDTH * 0.40), (int)(DRAWING_HEIGHT * 0.20), (int)(DRAWING_WIDTH * 0.20), (int)(DRAWING_HEIGHT * 0.70)), 
            new Rectangle((int)(DRAWING_WIDTH * 0.70), (int)(DRAWING_HEIGHT * 0.20), (int)(DRAWING_WIDTH * 0.20), (int)(DRAWING_HEIGHT * 0.70))
        }; 

        selectionStrings = new String[] {
            "Melner", 
            "Stelwart", 
            "Vanguard"
        }; 


    }


    public void mousePressed() {
        Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY)); 

        if (selectionsRectangles[0].contains(p)) {
            // Select Melner. 

        } else if (selectionsRectangles[1].contains(p)) {
            // Select Stelwart. 

        } else if (selectionsRectangles[2].contains(p)) {
            // Select Vangaurd. 
            
        }
    }
}
