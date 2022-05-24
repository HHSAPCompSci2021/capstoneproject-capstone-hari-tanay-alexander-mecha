package screens;

/**
 * Screen switching documentation
 * @author alexyue
 *
 */
public interface ScreenSwitcher {
	public static final int MENU_SCREEN = 0;
	public static final int GAME_SCREEN = 1;
	public static final int SELECT_SCREEN = 2; 
	public static final int END_SCREEN = 3; 
	
	/**
	 * switches to the screen based on select value
	 * @param i the value of the screen you wish to switch to
	 */
	public void switchScreen(int i);
}
