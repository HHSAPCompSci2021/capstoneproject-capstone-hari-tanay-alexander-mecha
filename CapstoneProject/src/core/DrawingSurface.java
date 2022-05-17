package core;


import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import screens.MenuScreen;
import screens.Screen;
import screens.ScreenSwitcher;
import screens.SelectScreen;
import utility.field.friendly.unit.mecha.Vanguard;
import screens.EndGame;
import screens.GameScreen;

public class DrawingSurface extends PApplet implements ScreenSwitcher {

	public float ratioX, ratioY;
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;

	
	public DrawingSurface() {
		
		screens = new ArrayList<Screen>();
		
		keys = new ArrayList<Integer>();
		
		
		MenuScreen screen1 = new MenuScreen(this);
		screens.add(screen1);
		
		GameScreen screen2 = new GameScreen(this);
		screens.add(screen2);

		SelectScreen selectScreen = new SelectScreen(this); 
		screens.add(selectScreen); 

		EndGame gameOverScreen = new EndGame(this); 
		screens.add(gameOverScreen); 
		
		activeScreen = screens.get(0); 
		
	}
	
	public void setup() {
		for (Screen s : screens)
			s.setup();
	}
	
	public void draw() {
		
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		push();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		pop();
	}
	
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC)  // This prevents a processing program from closing on escape key
			key = 0; 

		activeScreen.keyPressed(); 
	}

	@SuppressWarnings("deprecation")
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code); 
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved(); 
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged(); 
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}

	
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

	@Override
	public void switchScreen(int i) {
		if (screens.get(i) instanceof GameScreen) {
			// this is for game restart functionality. 
			screens.set(i, new screens.GameScreen(this)); 
		} else if (screens.get(i) instanceof SelectScreen) {
			// replace the instance of the SelectScreen with a fresh one, so select preferences won't get carried over. 
			screens.set(i, new SelectScreen(this)); 
		}
		activeScreen = screens.get(i);
	}

	public void switchScreen(int i, int selectionKey) {
		if (screens.get(i) instanceof GameScreen) {
			// this is for game restart functionality. 
			screens.set(i, new screens.GameScreen(this, selectionKey)); 
		} else if (screens.get(i) instanceof SelectScreen) {
			// replace the instance of the SelectScreen with a fresh one, so select preferences won't get carried over. 
			screens.set(i, new SelectScreen(this)); 
		}
		activeScreen = screens.get(i);
	}

}
