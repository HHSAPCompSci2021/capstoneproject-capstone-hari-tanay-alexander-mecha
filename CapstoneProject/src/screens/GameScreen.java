package screens;


import core.DrawingSurface;
import enemies.Barbarian;
import processing.core.PConstants;
import screens.integration.PauseHandler;
import screens.integration.ShopHandler;
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
	
	private float homeX, homeY;
	private HomeBase base;
	private HomeBase homeBase; 

	private PauseHandler pauseSystem; 
	private ShopHandler shopSystem; 

	private Map gameMap; 
	private Mech player; 
	
	/**
	 * <p>recommended use of <code>GameScreen</code> constructor since it correctly initializes 
	 * the Game with the <code>Mech</code> of the player's preference. </p>
	 * @param surface PApplet surface being used to draw the game. 
	 * @param selection integer value indicating which <code>Mech</code> the player selected. 
	 * @throws IllegalArgumentException 
	 */
	public GameScreen(DrawingSurface surface, int selection) throws IllegalArgumentException {
		this(surface); 
		gameOver = false; 
		
		if (selection == 0) {
			player = new Melner(200,200);
			System.out.println("Created new Melner"); 
		} else if (selection == 1) {
			player = new Stelwart(300,300);
			System.out.println("Created new Stelwart");
		} else if (selection == 2) {
			player = new Vanguard(100,100);
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
		pauseSystem = new PauseHandler(DRAWING_WIDTH, DRAWING_HEIGHT); 
		shopSystem = new ShopHandler(DRAWING_WIDTH, DRAWING_HEIGHT); 

		waveLevel = 0; 
		
		this.surface = surface; 
		onPause = false; 
		prepClock = 60 * 60;  
		waveClock = 0; 
		
		base = new HomeBase(DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2, 100);
		
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
			// Display Pause menu. 
			pauseSystem.pauseButtonInPause(surface, mouseLocation);
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
			
			pauseSystem.pauseButtonInGameplay(surface, mouseLocation);
			
			if (inShop) {
				// Display shop. 
				shopSystem.shopShopPanel(surface, mouseLocation);
			} else {
				shopSystem.shopShopPanel(surface, mouseLocation); 
			}
		}
		

	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));


		if (!onPause) {
			// place all buttons and interactions when no pause exists here: 
			if (pauseSystem.getPauseButton().contains(p))
			onPause = true; 
		} else {
			// !Do not change, all buttons for pause menu interactions are here: 
			if (pauseSystem.getMenuButton(0).contains(p)) {
				// Do 0. RESUME 
				onPause = false; 
			} else if (pauseSystem.getMenuButton(1).contains(p)) {
				// Do 1. QUIT GAME
				surface.switchScreen(0);
			} else if (pauseSystem.getMenuButton(2).contains(p)) {
				// Do 2. 
				// TODO ? How
			} else if (pauseSystem.getMenuButton(3).contains(p)) {
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