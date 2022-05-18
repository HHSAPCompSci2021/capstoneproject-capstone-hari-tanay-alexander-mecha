package enemies;
import core.DrawingSurface;
import processing.core.PApplet;
import utility.field.enemy.Enemy;
	public class Barbarian extends Enemy {
		
		private float x,y;
		private int health;
		private float movementSpeed;
		
		public Barbarian(float xCord, float yCord,DrawingSurface surface) {
			super(xCord, yCord, 1500, 1, surface.loadImage("img/barb.jpg"));
		}
		
		public float getX() {
			return x;
		}
		
		public float getY() {
			return y;
		}
		
		public void draw(PApplet drawer) {
			drawer.image(drawer.loadImage("img/barb.jpg"),getX(),getY(),100,100);
		}
	}
