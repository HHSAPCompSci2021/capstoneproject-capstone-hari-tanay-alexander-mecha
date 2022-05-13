package utility;

import java.awt.Rectangle;

import processing.core.PApplet;
import utility.field.friendly.Allied;

public class HomeBase extends Allied {
    
	private Rectangle rect;
	
    public HomeBase(Rectangle r, float x, float y) {
        super(x, y); 
        rect = r;
    }
    
    public void draw(PApplet p) {
    //	p.draw(rect);
    }
}
