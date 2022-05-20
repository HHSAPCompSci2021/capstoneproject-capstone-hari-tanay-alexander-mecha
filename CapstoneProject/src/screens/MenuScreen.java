package screens;



import java.awt.Point;
import java.awt.Rectangle;

import core.DrawingSurface;
import processing.core.PConstants;


public class MenuScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle startButton;
	private Rectangle selectScreenButton; 
	
	public MenuScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
 
		
		
		startButton = new Rectangle(800/2-100,600/2-50,200,100);
		selectScreenButton = new Rectangle(800/2-100,600/2+100,200,100); 
	}

	/** 
	 * constructor for draw method of the <code>MeduScreen</code>. 
	 */
	public void draw() {
		Point mouseLocation = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY)); 

		surface.background(255,255,255);
		
		if (startButton.contains(mouseLocation)) {
			surface.fill(200);
		} else {
			surface.fill(230); 
		}
		surface.rect(startButton.x, startButton.y, startButton.width, startButton.height, 10, 10, 10, 10);
		
		
		if (selectScreenButton.contains(mouseLocation)) {
			surface.fill(200);
		} else {
			surface.fill(230);
		}
		surface.rect(selectScreenButton.x, selectScreenButton.y, selectScreenButton.width, selectScreenButton.height, 10, 10, 10, 10);

		surface.fill(0);
		String str = "Preview!";
		surface.textAlign(PConstants.CENTER, PConstants.CENTER);
		surface.text(str, (float)startButton.getCenterX(), (float)startButton.getCenterY()); 
		surface.text("Start!", (float)selectScreenButton.getCenterX(), (float)selectScreenButton.getCenterY());
		
	}



	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (startButton.contains(p)) {
			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
		} else if (selectScreenButton.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SELECT_SCREEN);
		}
	}
	

}

