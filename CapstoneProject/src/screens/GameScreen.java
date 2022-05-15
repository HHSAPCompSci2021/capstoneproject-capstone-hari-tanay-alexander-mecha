package screens;


import core.DrawingSurface;
import enemies.Barbarian;
import processing.core.PConstants;
import utility.HomeBase;
import utility.Map;
import utility.field.friendly.unit.mecha.Controllable;
import utility.field.friendly.unit.mecha.Mech;
import utility.field.friendly.unit.mecha.Melner;
import utility.field.friendly.unit.mecha.Stelwart;
import utility.field.friendly.unit.mecha.Vanguard;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point; 
import java.awt.geom.Rectangle2D;

/**
* class for GameScreen. 
* 
* 		established class to control actual game session. 
* 
* @author @AwesomenessReborn Harinandan Kotamsetti 
* @version 5.6.2022 
*/
public class GameScreen extends Screen {
	
	private boolean gameOver; 
	private DrawingSurface surface; 
	
	private int waveLevel; 
	
	// Will be used to keep track of time when in game. 
	private int gameClock, waveClock, prepClock; 
	private boolean onPause, inShop; 	
	
	private int seconds, minutes;
	
	private float pauseButtonX, pauseButtonY, shopButtonX, shopButtonY; 

	private float homeX, homeY;
	private HomeBase base;
	private Rectangle2D.Float pauseButton, shopButton;
	private HomeBase homeBase;
	
	private Rectangle[] shopMenuButtonsRectangles; 
	private String[] pauseButtonStrings, shopButtonStrings; 

	// TODO, finish conversion from Rectangle to Rectangle2D.Float 

	private Rectangle2D.Float[] pauseMenuButtons; 

	private Map gameMap; 
	private Mech player; 
	
	// private Vanguard v = new Vanguard(100,100);
	// private Melner m = new Melner(200,200);
	// private Stelwart s = new Stelwart(300,300);
	
	// private Barbarian b = new Barbarian((float) 10, (float) 10, 150, (float) 3);
	
	/**
	 * <p>true recommended use of <code>GameScreen</code> constructor since it correctly initializes 
	 * the Game with the <code>Mech</code> of the player's preference. </p>
	 * @param surface PApplet surface being used to draw the game. 
	 * @param selection integer value indicating which <code>Mech</code> the player selected. 
	 * @throws IllegalArgumentException 
	 */
	public GameScreen(DrawingSurface surface, int selection) throws IllegalArgumentException {
		this(surface); 
		gameOver = false; 
		// b.draw(surface);
		
		if (selection == 0) {
			player = new Melner(200,200);
			System.out.println("Created new Melner"); 
		} else if (selection == 1) {
			player = new Stelwart(300,300);
			System.out.println("Created new Stelwart");
		} else if (selection == 2) {
			
			player = new Vanguard(100,100);
			
			//v.draw(surface); 
			System.out.println("Created new Vanguard");
		} else {
			throw new IllegalArgumentException("invalid mech choice integer key"); 
		}
	}

	/**
	 * constuctor for <code>GameScreen</code> 
	 * * Unit Melner is created by default when calling the GameScreen constructor. 
	 * @param surface
	 */
	public GameScreen(DrawingSurface surface) {
		super(800,600);
		gameClock = 0; 
		
		gameMap = new Map(); 

		waveLevel = 0; 
		
		this.surface = surface; 
		onPause = false; 
		prepClock = 60 * 60;  
		waveClock = 0; 
		
		base = new HomeBase(DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2, 100);
		
		pauseButtonX = DRAWING_WIDTH - 20; 
		pauseButtonY = 20; 

		pauseButton = new Rectangle2D.Float(pauseButtonX - 20, pauseButtonY - 20, 30, 30); 
		
		// 0 - resume game 
		// 1 - quit game (go back to home screen) 
		// 2 - restart (restart game - at select screen) 
		// 3 - close 
		pauseMenuButtons = new Rectangle2D.Float[] {
			new Rectangle.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.30), 300, 42), 
			new Rectangle.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.42), 300, 42), 
			new Rectangle.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.54), 300, 42), 
			new Rectangle.Float((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.66), 300, 42)
		}; 
		
		pauseButtonStrings = new String[] {
			"RESUME", 
			"QUIT GAME", 
			"RESTART", 
			"CLOSE"
		};
		
		// ??
		// shopButtonX = 20;
		// shopButtonY = DRAWING_HEIGHT - 20;
		// shopButton = new Rectangle2D.Float((int)shopButtonX - 20, (int)shopButtonY - 20, 15, 15);
		
		// shopMenuButtonsRectangles = new Rectangle[] {
		// 	new Rectangle((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.30), 300, 42), 
		// 	new Rectangle((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.42), 300, 42), 
		// 	new Rectangle((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.54), 300, 42), 
		// 	new Rectangle((DRAWING_WIDTH / 2) - 150, (int)(DRAWING_HEIGHT * 0.66), 300, 42)
		// };
		
		// shopButtonStrings = new String[] {
		// 	"BUY TANK",
		// 	"DEPLOY SOLDIER",
		// 	"UPGRADE TANK",
		// 	"UPGRADE SOLDIER"
		// };
	}
	
	
	
	/**
	 * setup utility given by <code>DrawingSurface</code>. 
	 * this setup method will have methods that establish the base functionality of the game, 
	 * - including initialization of game player characters, 
	 * - addition of money. 
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
			
		} else {
			gameClock += 1; 
			
			// NOTE Draw runs 60 times per second 
			// TODO finish actions, called on Map class. 
			
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
		
		if (inShop) {
			for (Rectangle r : shopMenuButtonsRectangles) {
				surface.fill(240, 240, 240);
				surface.rect((float)r.getMinX(), (float)r.getMinY(), (float)r.getWidth(), (float)r.getHeight());
			}
			
			for(int j = 0; j < 4; j++) {
				float upperX = (float) shopMenuButtonsRectangles[j].getMinX();
				float upperY = (float) shopMenuButtonsRectangles[j].getMinY();
				float buttonWidth = (float) shopMenuButtonsRectangles[j].getWidth();
				float buttonHeight = (float) shopMenuButtonsRectangles[j].getHeight();
				
				if (shopMenuButtonsRectangles[j].contains(mouseLocation)) {
					surface.fill(255, 255, 255);
				} else {
					surface.fill(200, 200, 200); 
				}
				
				surface.rect(upperX, upperY, buttonWidth, buttonHeight);
				surface.textAlign(surface.CENTER, surface.CENTER);
				surface.fill(0); 
				
				surface.text(shopButtonStrings[j], (float)shopMenuButtonsRectangles[j].getCenterX(), (float)shopMenuButtonsRectangles[j].getCenterY());
			}
		} else {
			if (shopButton.contains(mouseLocation)) {
				surface.fill(255, 30, 30); 
			} else {
				surface.fill(255, 255, 255); 
			}
			surface.rect(shopButtonX - 4, shopButtonY - 10, 40, 20); 
			surface.fill(0);
			surface.text("SHOP", shopButtonX - 2, shopButtonY + 6);
		}

	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));

		if(!inShop) {
			if (shopButton.contains(p))
				inShop = true;
		} else {
			if (shopMenuButtonsRectangles[0].contains(p)) {
				inShop = false; 
			} else if (shopMenuButtonsRectangles[1].contains(p)) {
				inShop = false; 
			} else if (shopMenuButtonsRectangles[2].contains(p)) {
				inShop = false; 
			} else if (shopMenuButtonsRectangles[3].contains(p)) {
				inShop = false; 
			} 
		}
		
		if (!onPause) {
			// place all buttons and interactions when no pause exists here: 
			if (pauseButton.contains(p))
			onPause = true; 
		} else {
			// !Do not change, all buttons for pause menu interactions are here: 
			if (pauseMenuButtons[0].contains(p)) {
				// Do 0. RESUME 
				onPause = false; 
			} else if (pauseMenuButtons[1].contains(p)) {
				// Do 1. QUIT GAME
				surface.switchScreen(0);
			} else if (pauseMenuButtons[2].contains(p)) {
				// Do 2. 
				// TODO ? How
			} else if (pauseMenuButtons[3].contains(p)) {
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