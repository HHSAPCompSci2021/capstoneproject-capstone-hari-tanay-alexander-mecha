package utility.field;

public abstract class FieldObject {
    protected float xPosition, yPosition; 

    public FieldObject(float x, float y) {
        xPosition = x; 
        yPosition = y; 
    }

    public void changePos(float xChange, float yChange) {
        xPosition += xChange; 
        yPosition += yChange; 
    }


}
