package screens;

/**
 * The superclass for all the different screens featured in the game
 * @author alexyue
 *
 */
public abstract class Screen {

	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	/**
	 * setup
	 */
	public void setup() {
		
	}
	
	/**
	 * Draws what is initially on the screen and updates the screen conditionally
	 */
	public void draw() {
	
	}
	
	/**
	 * Handles mouse interactions when any button 1/2 are pressed
	 */
	public void mousePressed() {
		
	}
	
	/**
	 * Handles movement on the screen when the mouse is moved
	 */
	public void mouseMoved() {
		
	}
	
	/**
	 * Handles movement on the screen when the mouse is dragged
	 */
	public void mouseDragged() {
		
	}
	
	/**
	 * Handles any action that occurs after a mouse button is released
	 */
	public void mouseReleased() {
		
	}
	
	/**
	 * Handles screen actions when a key is pressed
	 */
	public void keyPressed() {
		
	}
	
}
