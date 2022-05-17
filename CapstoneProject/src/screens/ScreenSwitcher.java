package screens;


public interface ScreenSwitcher {
	public static final int MENU_SCREEN = 0;
	public static final int GAME_SCREEN = 1;
	public static final int SELECT_SCREEN = 2; 
	public static final int END_SCREEN = 3; 
	
	public void switchScreen(int i);
}
