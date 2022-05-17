package screens;


import core.DrawingSurface;
import enemies.Barbarian;
import processing.core.PApplet;
import processing.core.PConstants;
import screens.integration.Map;
import screens.integration.PauseHandler;
import screens.integration.ShopHandler;
import utility.HomeBase;
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
	
	private int selection; 

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

		this.selection = selection; 
		
	}

	/**
	 * constuctor for <code>GameScreen</code>  
	 * * Unit Melner is created by default when calling the GameScreen constructor. 
	 * @param surface
	 */
	public GameScreen(DrawingSurface surface) {
		super(800,600);
		gameClock = 0; 
		
		gameMap = new Map(800 * 5, 600 * 5, DRAWING_WIDTH, DRAWING_HEIGHT); 
		pauseSystem = new PauseHandler(DRAWING_WIDTH, DRAWING_HEIGHT); 
		shopSystem = new ShopHandler(DRAWING_WIDTH, DRAWING_HEIGHT); 

		waveLevel = 0; 
		
		this.surface = surface; 
		onPause = false; 
		prepClock = 60 * 60;  
		waveClock = 0; 
		
		base = new HomeBase(DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2, 500); 
		
	}
	
	
	
	/**
	 * NOTE this method is useless due to the way how the program initializes GameScreen. 
	 */
	public void setup() {
		
	}

	public void initialize() {
		if (selection == 0) {
			player = new Melner(DRAWING_WIDTH / 2 + 200, DRAWING_WIDTH / 2, surface);
			System.out.println("Created new Melner"); 
		} else if (selection == 1) {
			player = new Stelwart(DRAWING_WIDTH / 2 + 200, DRAWING_WIDTH / 2, surface);
			System.out.println("Created new Stelwart");
		} else if (selection == 2) {
			player = new Vanguard(DRAWING_WIDTH / 2 + 200, DRAWING_WIDTH / 2, surface); 
			System.out.println("Created new Vanguard");
		} else {
			throw new IllegalArgumentException("invalid mech choice integer key"); 
		}
	}
	
	public void keyPressed() {
		if (surface.key == PConstants.ESC) {
			onPause = !onPause; 
		}

		// TODO, maybe make a velocity component instead. 
		if (surface.key == 'W' || surface.key == 'w') {
			player.changePos(0, -5);
		} else if (surface.key == 'S' || surface.key == 's') {
			player.changePos(0, 5);
		}

		if (surface.key == 'A' || surface.key == 'a') {
			player.changePos(-5, 0);
		} else if (surface.key == 'D' || surface.key == 'd') {
			player.changePos(5, 0);
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
			
			// NOTE Draw runs 60 times per seconds. 			
			surface.background(191, 255, 187); 

			// TODO finish all draw methods here. 
			if (player != null) {
				gameMap.draw(surface, player);				
			} else {
				initialize(); 
			}
			
			// !clock and escape section. 
			float clockSectionWidth = (float)(DRAWING_WIDTH * 0.30); 
			float clockSectionHeight = (float)(DRAWING_HEIGHT * 0.15); 
			
			surface.fill(255);
			surface.stroke(0);
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
			shopSystem.showShopPanel(surface, mouseLocation); 
			gameMap.drawMiniMap(surface);

			if (inShop) {
				// Display shop. 
				shopSystem.showShopDisplay(surface, mouseLocation);
			} 


		}
		

	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));


		if (!onPause) {
			// place all buttons and interactions when no pause exists here: 
			if (pauseSystem.getPauseButton().contains(p)) {
				onPause = true; 
			}
			if (shopSystem.getShopLaunchButton().contains(p)) {
				inShop = true; 
			}
			
		} 
		if (inShop) {

			if (shopSystem.getShopMenuButton(0).contains(p)) {
				// Buy Tank. 
			} else if (shopSystem.getShopMenuButton(1).contains(p)) {
				// Buy Soldier. 
			} else if (shopSystem.getShopMenuButton(2).contains(p)) {
				// Upgrade Tank. 
			} else if (shopSystem.getShopMenuButton(3).contains(p)) {
				// Upgrade Soldier. 
			} else if (shopSystem.getShopMenuButton(4).contains(p)) {
				inShop = false; 
			}

		} 
		if (onPause) {
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