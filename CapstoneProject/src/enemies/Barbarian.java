package enemies;
import processing.core.PApplet;
	public class Barbarian {
		
		private float x,y;
		private int health;
		private float movementSpeed;
		
		public Barbarian(float xCord, float yCord,int h,float mS) {
			x = xCord;
			y = yCord;
			h = health;
			movementSpeed = mS;
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
