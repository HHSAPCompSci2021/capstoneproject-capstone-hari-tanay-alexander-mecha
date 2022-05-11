package screens;


import core.DrawingSurface;
import processing.core.PConstants;
import utility.Map;

import java.awt.Rectangle; 
import java.awt.Point; 

/**
* class for GameScreen. 
* 
* 		established class to control actual game session. 
* 
* @author @AwesomenessReborn Harinandan Kotamsetti 
* @version 5.6.2022 
*/
public class GameScreen extends Screen {
	
	private DrawingSurface surface; 
	
	private int waveLevel; 
	
	// Will be used to keep track of time when in game. 
	private int gameClock, waveClock, prepClock; 
	private boolean onPause; 	
	
	private float pauseButtonX, pauseButtonY; 
	private Rectangle pauseButton; 
	
	private Rectangle[] pauseMenuButtonsRectangles; 
	private String[] pauseButtonStrings; 

	private Map gameMap; 
	
	public GameScreen(DrawingSurface surface) {
		super(800,600);
		gameClock = 0; 
		
		waveLevel = 1; 
		
		this.surface = surface; 
		onPause = false; 
		prepClock = 60 * 60;  
		waveClock = 0; 
		
		pauseButtonX = DRAWING_WIDTH - 20; 
		pauseButtonY = 20; 
		pauseButton = new Rectangle((int)pauseButtonX - 20, (int)pauseButtonY - 20, 30, 30); 
		
		// 0 - resume game 
		// 1 - quit game (go back to home screen) 
		// 2 - restart (restart game - at select screen) 
		// 3 - close 
		pauseMenuButtonsRectangles = new Rectangle[] {
			new Rectangle((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.30), 300, 42), 
			new Rectangle((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.42), 300, 42), 
			new Rectangle((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.54), 300, 42), 
			new Rectangle((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.66), 300, 42)
		}; 
		
		//TODO implement: 
		pauseButtonStrings = new String[] {
			"RESUME", 
			"QUIT GAME", 
			"RESTART", 
			"CLOSE"
		}; 
	}
	
	
	
	/**
	 * setup utility given by <code>DrawingSurface</code>. 
	 * this setup method will have methods that establish the base functionality of the game, 
	 * - including initialization of game player characters, 
	 * - addition of money. 
	 * 
	 * TODO to be finished. 
	 */
	public void setup() {
		
	}
	
	public void keyPressed() {
		if (surface.key == PConstants.ESC) {
			onPause = !onPause; 
		}
	}
	
	/**
	* use <code>surface</code> to access graphics. 
	* <ul> 
	* 		<li>complete all actions first. </li>
	* 		<li>next draw background objects. </li>
	* 		<li>finally draw actors, sprites and other such objects. </li>
	* </ul>
	*/
	public void draw() {
		Point mouseLocation = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY)); 
		
		if (onPause) {
			surface.fill(0, 0, 153); 
			surface.stroke(204, 153, 0);
			surface.rect(DRAWING_WIDTH * 0.25f, DRAWING_HEIGHT * 0.20f, DRAWING_WIDTH * 0.50f, DRAWING_HEIGHT * 0.60f, 2); 
			
			for (Rectangle rect : pauseMenuButtonsRectangles) {
				surface.fill(240, 240, 240); 
				surface.rect((float)rect.getMinX(), (float)rect.getMinY(), (float)rect.getWidth(), (float)rect.getHeight()); 
				
				// 0 - resume game 
				// 1 - quit game (go back to home screen) 
				// 2 - restart (restart game - at select screen) 
				// 3 - close 
				// surface.text("str", x, y); 
			}
			
			for (int i = 0; i < 4; i++) {
				float topLeftX = (float)pauseMenuButtonsRectangles[i].getMinX(); 
				float topLeftY = (float)pauseMenuButtonsRectangles[i].getMinY(); 
				float boxWidth = (float)pauseMenuButtonsRectangles[i].getWidth(); 
				float boxHeight = (float)pauseMenuButtonsRectangles[i].getHeight(); 
				
				if (pauseMenuButtonsRectangles[i].contains(mouseLocation)) {
					surface.fill(255, 255, 255);
				} else {
					surface.fill(200, 200, 200); 
				}
				
				surface.rect(topLeftX, topLeftY, boxWidth, boxHeight);
				surface.textAlign(surface.CENTER, surface.CENTER);
				surface.fill(0); 
				
				surface.text(pauseButtonStrings[i], (float)pauseMenuButtonsRectangles[i].getCenterX(), (float)pauseMenuButtonsRectangles[i].getCenterY());
			}
			
		} else {
			gameClock += 1; 
			
			// NOTE Draw runs 60 times per second 
			// TODO finish actions, called on Map class. 
			
			// TODO finish better background. 
			surface.background(191, 255, 187); 
			
			// !clock and escape section. 
			float clockSectionWidth = (float)(DRAWING_WIDTH * 0.30); 
			float clockSectionHeight = (float)(DRAWING_HEIGHT * 0.15); 
			
			surface.rect(DRAWING_WIDTH - clockSectionWidth - 1, 0, clockSectionWidth, clockSectionHeight); 
			surface.textSize(14); 
			surface.fill(0, 0, 0);
			
			surface.text("WAVE " + waveLevel, (float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.50f);
			surface.text("Time elapsed: " + timeCounterToClockDisplay(gameClock), (float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.70f); 
			if (prepClock > 0) {
				prepClock -= 1; 
				surface.text("Preperation time remaining: " + timeCounterToClockDisplay(prepClock),(float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.90f);
			} else {
				waveClock += 1; 
				surface.text("Time in current wave: " + timeCounterToClockDisplay(waveClock), (float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.90f);
			}
			
			// !pause button 
			if (pauseButton.contains(mouseLocation)) {
				surface.fill(255, 30, 30); 
			} else {
				surface.fill(0, 0, 0); 
			}
			surface.rect(pauseButtonX - 4, pauseButtonY - 10, 2, 15); 
			surface.rect(pauseButtonX + 3, pauseButtonY - 10, 2, 15);
			
			
		}
		
		
		
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));

		if (!onPause) {
			if (pauseButton.contains(p))
			onPause = true; 
		} else {
			if (pauseMenuButtonsRectangles[0].contains(p)) {
				// Do 0. RESUME 
				onPause = false; 
			} else if (pauseMenuButtonsRectangles[1].contains(p)) {
				// Do 1. QUIT GAME
				surface.switchScreen(0);
			} else if (pauseMenuButtonsRectangles[2].contains(p)) {
				// Do 2. 
				// TODO ? How
			} else if (pauseMenuButtonsRectangles[3].contains(p)) {
				// Do 3. CLOSE GAME. 
				
			} 
		}
		
	}
	
	private String timeCounterToClockDisplay(int t) {
		int seconds = (t / 60) % 60; 
		int minutes = t / 3600; 
		
		if (seconds < 10) {
			return minutes + ":0" + seconds; 			
		} else {
			return minutes + ":" + seconds;
		}
	}
	
	
}