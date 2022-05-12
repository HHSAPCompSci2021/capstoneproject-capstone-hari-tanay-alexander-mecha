package screens;

import core.DrawingSurface;
import processing.core.PConstants;

import java.awt.Rectangle;
import java.awt.Point; 
//TODO generate fonts

public class SelectScreen extends Screen {

    private DrawingSurface surface; 
    private int selection; 

    private Rectangle[] selectionsRectangles; 
    private String[] selectionStrings; 
    private Rectangle confirmButton; 

    public SelectScreen(DrawingSurface surface) {
        super(800, 600);
        this.surface = surface; 

        /**
         * selection 0 indicates no selecction made. 
         * selection 1 indicates option 1. 
         * selection 2 indicates option 2. 
         * selection 3 indicates option 3. 
         */
        selection = -1; 

        selectionsRectangles = new Rectangle[] {
            new Rectangle((int)(DRAWING_WIDTH * 0.05), (int)(DRAWING_HEIGHT * 0.20), (int)(DRAWING_WIDTH * 0.28), (int)(DRAWING_HEIGHT * 0.60)), 
            new Rectangle((int)(DRAWING_WIDTH * 0.36), (int)(DRAWING_HEIGHT * 0.20), (int)(DRAWING_WIDTH * 0.28), (int)(DRAWING_HEIGHT * 0.60)), 
            new Rectangle((int)(DRAWING_WIDTH * 0.68), (int)(DRAWING_HEIGHT * 0.20), (int)(DRAWING_WIDTH * 0.28), (int)(DRAWING_HEIGHT * 0.60))
        }; 

        selectionStrings = new String[] {
            "Melner", 
            "Stelwart", 
            "Vanguard"
        }; 

        confirmButton = new Rectangle(
            (DRAWING_WIDTH / 2) - 60, 
            DRAWING_HEIGHT - 70, 
            120, 
            30
        ); 
    }


    public void mousePressed() {
        Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY)); 

        if (selectionsRectangles[0].contains(p)) {
            // Select Melner. 
            selection = 0; 
        } else if (selectionsRectangles[1].contains(p)) {
            // Select Stelwart. 
            selection = 1; 
        } else if (selectionsRectangles[2].contains(p)) {
            // Select Vangaurd. 
            selection = 2; 
        } else if (confirmButton.contains(p)) {
            System.out.println("woaaaaaaa");
        }
    }

    public void draw() {
        surface.background(255); 

        Point mouseLocation = new Point(surface.mouseX, surface.mouseY); 

        for (int i = 0; i < selectionsRectangles.length; i++) { 
            if (i == selection) {
                surface.fill(255);
                surface.rect((float)(selectionsRectangles[i].getMinX()) - 7, (float)(selectionsRectangles[i].getMinY()) - 7, (float)selectionsRectangles[i].getWidth() + 14, (float)selectionsRectangles[i].getHeight() + 14); 
            }
            
            if (selectionsRectangles[i].contains(mouseLocation)) {
                surface.fill(200);
            } else {
                surface.fill(230); 
            }
            surface.rect((float)(selectionsRectangles[i].getMinX()), (float)(selectionsRectangles[i].getMinY()), (float)selectionsRectangles[i].getWidth(), (float)selectionsRectangles[i].getHeight()); 

            surface.textAlign(PConstants.CENTER, PConstants.CENTER); 
            surface.fill(0);
            surface.text(selectionStrings[i], (float)selectionsRectangles[i].getCenterX(), (float)(selectionsRectangles[i].getMinY() + 30)); 
            
            
            


        }

        surface.fill(255);
        if (selection >= 0) {
            surface.rect((float)confirmButton.getMinX() - 7, (float)confirmButton.getMinY() - 7, (float)confirmButton.getWidth() + 14, (float)confirmButton.getHeight() + 14);
        } 

        if (confirmButton.contains(mouseLocation)) {
            surface.fill(200);
        } else {
            surface.fill(230);
        }
        surface.rect((float)confirmButton.getMinX(), (float)confirmButton.getMinY(), (float)confirmButton.getWidth(), (float)confirmButton.getHeight());

        surface.fill(0);
        surface.text("CONFIRM PICK", (float)confirmButton.getCenterX(), (float)confirmButton.getCenterY());


    }
}
