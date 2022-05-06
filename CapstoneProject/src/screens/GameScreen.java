package screens;


import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import core.DrawingSurface;

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
	
	// Will be used to keep track of time when in game. 
	private int gameClock, waveClock, prepClock; 
	private boolean onPause; 

	
	
	private Rectangle screenRect;
	
	
	public GameScreen(DrawingSurface surface) {
		super(800,600);
		gameClock = 0; 
		this.surface = surface; 
		onPause = false; 
	}
	
	
	
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
	}
	
	public void keyPressed() {

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
		if (onPause) {
			
		} else {
			gameClock += 1; 

			// NOTE Draw runs 60 times per second 
			// TODO finish actions, called on Map class. 
			
			// TODO finish better background. 
			surface.background(191, 255, 187); 
			
			// clock and escape section. 
			// TODO create a proper clock functionality. 
			float clockSectionWidth = (float)(DRAWING_WIDTH * 0.30); 
			float clockSectionHeight = (float)(DRAWING_HEIGHT * 0.15); 


			surface.rect(DRAWING_WIDTH - clockSectionWidth - 1, 0, clockSectionWidth, clockSectionHeight); 
			surface.textSize(14); 
			surface.fill(0, 0, 0);
			surface.text(timeCounterToClockDisplay(gameClock), (float)(DRAWING_WIDTH - (clockSectionWidth * 0.80)), clockSectionHeight * 0.70f);

			

		}


		
	}

	private String timeCounterToClockDisplay(int t) {
		int seconds = t / 60; 
		int minutes = t / 3600; 

		if (seconds < 10) {
			return minutes + ":0" + seconds; 			
		} else {
			return minutes + ":" + seconds;
		}
	}
	
	
}