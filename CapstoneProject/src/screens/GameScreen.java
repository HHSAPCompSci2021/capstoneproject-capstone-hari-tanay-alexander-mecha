package screens;


import core.DrawingSurface;
import processing.core.PConstants;
import processing.event.KeyEvent;
import screens.integration.Map;
import screens.integration.PauseHandler;
import screens.integration.ShopHandler;
import utility.HomeBase;
import utility.field.FieldObject;
import utility.field.GameUnit;
import utility.field.enemy.Enemy;
import utility.field.friendly.unit.mecha.Mech;
import utility.field.friendly.unit.mecha.Melner;
import utility.field.friendly.unit.mecha.Stelwart;
import utility.field.friendly.unit.mecha.Vanguard;
import utility.field.projectiles.Bullet;

import java.awt.Color;
import java.awt.Point; 
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

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

	private PauseHandler pauseSystem; 
	private ShopHandler shopSystem; 
	private Rectangle2D.Float HUDbox, ammunitionBar; 

	private Map gameMap; 
	private Mech player; 
	private Enemy e;
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
		prepClock = 30 * 60;  
		waveClock = 0; 
		
		HUDbox = new Rectangle2D.Float(DRAWING_WIDTH * 0.3f, DRAWING_HEIGHT - 40, DRAWING_WIDTH * 0.4F, 40); 
		ammunitionBar = new Rectangle2D.Float(
			DRAWING_WIDTH * 0.35f, 
			DRAWING_HEIGHT - 30, 
			DRAWING_WIDTH * 0.30F, 
			20
		); 
	}
	
	
	
	/**
	 * NOTE this method is useless due to the way how the program initializes GameScreen. 
	 */
	public void setup() {
		this.base = new HomeBase(gameMap.getMapWidth() / 2, gameMap.getMapHeight() / 2, 600, surface, 200, 200); 
		gameMap.addFieldObject(this.base);

	}

	/**
	 * Generates mechs on the screen depending on the value of the selection
	 */
	public void initialize() {
		if (selection == 0) {
			player = new Melner(gameMap.getMapWidth() / 2 + 200, gameMap.getMapHeight() / 2, surface);
			System.out.println("Created new Melner"); 
		} else if (selection == 1) {
			player = new Stelwart(gameMap.getMapWidth() / 2 + 200, gameMap.getMapHeight() / 2, surface);
			System.out.println("Created new Stelwart");
		} else if (selection == 2) {
			player = new Vanguard(gameMap.getMapWidth() / 2 + 200, gameMap.getMapHeight() / 2, surface); 
			System.out.println("Created new Vanguard");
		} else {
			throw new IllegalArgumentException("invalid mech choice integer key"); 
		}

		gameMap.addFieldObject(player); 
	}
	
	public void keyPressed() {
		if (surface.key == PConstants.ESC) {
			onPause = !onPause; 
		}

		// TODO, maybe make a velocity component instead. 
		if (surface.key == 'W' || surface.key == 'w') {
			player.performMovement(0, -5);
		} else if (surface.key == 'S' || surface.key == 's') {
			player.performMovement(0, 5); 
		}

		if (surface.key == 'A' || surface.key == 'a') {
			player.performMovement(-5, 0);
		} else if (surface.key == 'D' || surface.key == 'd') {
			player.performMovement(5, 0);
		}

		//	shooting system. 
		if (surface.key == java.awt.event.KeyEvent.VK_SPACE) {
			if (player instanceof Vanguard || player instanceof Melner) {
				// TODO Call the performFire method here, then add it into the FieldObject ArrayList. 

				gameMap.addFieldObject(player.performFire(surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY))));

				// gameMap.addFieldObject(obj); 
			} else if (player instanceof Stelwart) {
				Stelwart tempReference = (Stelwart)player; 
				if (tempReference.getEnergyValue() >= 10) {
					tempReference.alternateFire(gameMap.getObjects(), surface, DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2); 
				}

			}

			
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

			for (int i = 0; i < gameMap.getObjects().size(); i++) {
				if (gameMap.getObjects().get(i) instanceof GameUnit) {
					GameUnit unit = (GameUnit)gameMap.getObjects().get(i); 
					if (unit.getCurrentHealth() <= 0) {
						gameMap.getObjects().remove(i); 
						i--; 
					}
				}
			}
			
			// NOTE Draw runs 60 times per seconds. 			
			if (player instanceof Melner) {
				surface.background(204, 102, 0);
			} else {
				surface.background(191, 255, 187); 
			}

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
				if (waveClock == 0) {
					initializeWave(); 
				}

				waveClock += 1; 
				surface.text("Time in current wave: " + timeCounterToClockDisplay(waveClock), (float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.90f); 

				boolean enemyExists = false; 
				for (FieldObject mapComponent : gameMap.getObjects()) {
					if (mapComponent instanceof Enemy) {
						enemyExists = true; 

						Enemy unit = (Enemy)mapComponent; 
						unit.auto(gameMap.getObjects()); 
						if (unit.getTarget() != null) {
							unit.performFire(); 
						} 
					}
				}

				if (!enemyExists) {
					endWave(); 
				}
			}

			surface.fill(230); 
			surface.rect(HUDbox.x, HUDbox.y, HUDbox.width, HUDbox.height); 
			surface.fill(200);
			surface.rect(ammunitionBar.x, ammunitionBar.y, ammunitionBar.width, ammunitionBar.height);
			
			float currentSupply = 0; 

			if (player instanceof Stelwart) {
				Stelwart temporaryReference = (Stelwart)player; 
				currentSupply = (float)temporaryReference.getEnergyValue() / (float)temporaryReference.getMaxEnergyValue(); 
			} else if (player instanceof Melner) {
				Melner temporaryReference = (Melner)player; 
				currentSupply = (float)temporaryReference.getAmmoValue() / (float)temporaryReference.getMaxAmmoValue(); 
			} else if (player instanceof Vanguard) {
				Vanguard temporaryReference = (Vanguard)player; 
				currentSupply = (float)temporaryReference.getAmmoValue() / (float)temporaryReference.getMaxAmmoValue(); 
			}

			surface.fill(255, 153, 0); 
			surface.rect(ammunitionBar.x, ammunitionBar.y, ammunitionBar.width * currentSupply, ammunitionBar.height);

			pauseSystem.pauseButtonInGameplay(surface, mouseLocation);
			shopSystem.showShopPanel(surface, mouseLocation); 
			gameMap.drawMiniMap(surface);

			if (inShop) {
				// Display shop. 
				shopSystem.showShopDisplay(surface, mouseLocation);
			} 


		}
		
		
		
		
	}


	/**
	 * method that automatically adds new enemies on the map, once the preperation phase is over. 
	 */
	public void initializeWave() {
		for (int i = 0; i < 3; i++) {
			Enemy e = new Enemy((float)(100 + (15f * Math.random())), (float)(100 + (15f * Math.random())), 50 + (30 * waveLevel), 50, 50, surface); 
			gameMap.addFieldObject(e); 
		}
		for (int i = 0; i < 3; i++) {
			Enemy e = new Enemy((float)(3500 + (15f * Math.random())), (float)(100 + (15f * Math.random())), 50 + (30 * waveLevel), 50, 50, surface); 
			gameMap.addFieldObject(e); 
		}
		for (int i = 0; i < 3; i++) {
			Enemy e = new Enemy((float)(3500 + (15f * Math.random())), (float)(2500 + (15f * Math.random())), 50 + (30 * waveLevel), 50, 50, surface); 
			gameMap.addFieldObject(e); 
		}
		for (int i = 0; i < 3; i++) {
			Enemy e = new Enemy((float)(100 + (15f * Math.random())), (float)(2500 + (15f * Math.random())), 50 + (30 * waveLevel), 50, 50, surface); 
			gameMap.addFieldObject(e); 
		}
	}

	/**
	 * defaults for when the wave ends (is ended by the player)
	 */
	public void endWave() {
		prepClock = 30 * 60;  
		waveClock = 0;
		waveLevel++;  
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
				surface.exit();
				System.exit(0); 
				
			} 
			
		}

	}
	
	/**
	 * generates the time clock conditionally on screen
	 * @param t the value of time in seconds
	 * @return the timer that is seen on screen
	 */
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