package utility.field;

public abstract class GameUnit extends FieldObject {
    private int health; 

    public GameUnit(float x, float y) {
        super(x, y);
        //TODO Auto-generated constructor stub
        health = 0; 
    }
    
}
