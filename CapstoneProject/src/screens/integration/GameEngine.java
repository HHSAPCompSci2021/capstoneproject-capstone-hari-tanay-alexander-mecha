package screens.integration;

import core.DrawingSurface;
import utility.HomeBase;
import utility.field.enemy.Enemy;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.Point; 

/**
* class designed to manage all game events, including wave and preperation management, 
*/
public class GameEngine {
    
    public int gameClock; 
    private int waveLevel; 
    
    //  Boolean to descibe phase when player is defending base actively, false if in preperation. 
    private boolean waveMode; 
    
    /**
    * preperationClock will manage time left in preperation, 1 min will be used for each wave preperation phase. 
    * waveClock will keep track of the time taken to finish each wave. 
    */
    private int preperationClock, waveClock; 
    private HomeBase base;
    
    private float clockSectionWidth, clockSectionHeight; 
    private int DRAWING_WIDTH, DRAWING_HEIGHT; 
    
    public GameEngine(HomeBase base, int DRAWING_WIDTH, int DRAWING_HEIGHT) {
        gameClock = 0; 
        waveLevel = 1; 
        this.base = base; 
        
        waveMode = false; 
        
        this.DRAWING_WIDTH = DRAWING_WIDTH; 
        this.DRAWING_HEIGHT = DRAWING_HEIGHT; 
        
        clockSectionWidth = DRAWING_WIDTH * 0.30f; 
        clockSectionHeight = DRAWING_HEIGHT * 0.15f; 
    }
    
    /**
    * Clock system incrementation. 
    * @param increment
    */
    public void runGame(int increment, DrawingSurface surface) {
        gameClock+=increment; 
        
        if (base.getHealth() <= 0) {
            endGame(surface);
        }
    }

    public void endGame(DrawingSurface surface) {
        surface.switchScreen(3);
    }
    
    public void displayClock(DrawingSurface surface, Point mouseLocation) {
        surface.rect(DRAWING_WIDTH - clockSectionWidth - 1, 0, clockSectionWidth, clockSectionHeight); 
        surface.textSize(14); 
        surface.fill(0, 0, 0);
        
        surface.text("WAVE " + waveLevel, (float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.50f);
        surface.text("Time elapsed: " + timeCounterToClockDisplay(gameClock), (float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.70f); 

        manageWave(surface);
    }
    
    private void manageWave(DrawingSurface surface) {
        
        if (preperationClock > 0) {
            preperationClock -= 1; 
            surface.text("Preperation time remaining: " + timeCounterToClockDisplay(preperationClock),(float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.90f);
        } else {
            waveMode = true; 

            waveClock += 1; 
            surface.text("Time in current wave: " + timeCounterToClockDisplay(waveClock), (float)(DRAWING_WIDTH - (clockSectionWidth * 0.98)), clockSectionHeight * 0.90f);
        }


        if (waveMode) {
            // TODO soon write a loop to check if there are no more characters left, if there are none, switch it back to preperation phase. 
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
    
    private boolean inSpawn(ArrayList<ArrayList<Enemy>> totalEnemies) {

        return false; 
    }
    
    /**
     * method to load the enemies given wave. Will hold all the enemeis, if the enemies are all finished, wave is completed. 
     *  - double array includes: 
     *      0 - enemies spawned from top left corner. [each of which contains an array each of the enemies from that spawn location]. 
     *      1 - enemies spawned from top right corner. 
     *      2 - enemies spawned from bottom left corner. 
     *      3 - enemies spawned from bottom right corner. 
     * @return array of enemies Loaded. 
     */
    private ArrayList<ArrayList<Enemy>> loadEnemies() {
        
        ArrayList<ArrayList<Enemy>> totalEnemies = new ArrayList<ArrayList<Enemy>>(); 

        for (int i = 0; i < 4; i++) {
            ArrayList<Enemy> temp = new ArrayList<>(); 


            totalEnemies.add(temp); 
        }

        return totalEnemies; 
    }
    
}
